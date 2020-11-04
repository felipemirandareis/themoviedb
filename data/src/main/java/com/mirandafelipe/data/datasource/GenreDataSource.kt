package com.mirandafelipe.data.datasource

import com.mirandafelipe.data.ErrorException
import com.mirandafelipe.data.mapper.GenreResponseToDataMapper
import com.mirandafelipe.data.remote.api.TheMovieDBApi
import io.reactivex.Observable
import retrofit2.HttpException
import java.net.UnknownHostException

class GenreDataSource(
    private val theMovieDBApi: TheMovieDBApi
) : IGenreDataSource {

    private val responseToDataMapper = GenreResponseToDataMapper()

    override fun getList(): Observable<List<GenreData>> {
        return theMovieDBApi.getGenreList()
            .map { responseToDataMapper.transform(it.genres) }
            .onErrorResumeNext { error: Throwable ->
                if (error is HttpException && error.code() == 400) {
                    Observable.error(ErrorException.BadException)
                } else if (error is UnknownHostException) {
                    Observable.error(ErrorException.BadException)
                } else {
                    Observable.error(error)
                }
            }
    }
}