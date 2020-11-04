package com.mirandafelipe.data.datasource

import com.mirandafelipe.data.ErrorException
import com.mirandafelipe.data.mapper.MovieResponseToDataMapper
import com.mirandafelipe.data.remote.api.TheMovieDBApi
import io.reactivex.Observable
import retrofit2.HttpException
import java.net.UnknownHostException

class MovieDataSource(
    private val theMovieDBApi: TheMovieDBApi
) : IMovieDataSource {

    private val responseToDataMapper = MovieResponseToDataMapper()

    override fun getList(): Observable<List<MovieData>> {
        return theMovieDBApi.getMovieList()
            .map { responseToDataMapper.transform(it.results) }
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