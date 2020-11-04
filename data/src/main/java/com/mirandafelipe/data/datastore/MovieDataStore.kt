package com.mirandafelipe.data.datastore

import android.annotation.SuppressLint
import com.mirandafelipe.data.ErrorException
import com.mirandafelipe.data.datasource.IMovieDataSource
import com.mirandafelipe.data.datasource.MovieData
import com.mirandafelipe.data.local.db.dao.IMovieDAO
import com.mirandafelipe.data.mapper.MovieDataToEntityMapper
import com.mirandafelipe.data.mapper.MovieEntityToDataMapper
import io.reactivex.Observable

class MovieDataStore(
    private val movieDataSource: IMovieDataSource,
    private val movieDAO: IMovieDAO
) : IMovieDataStore {

    private val dataToEntityMapper = MovieDataToEntityMapper()
    private val entityToDataMapper = MovieEntityToDataMapper()

    @SuppressLint("CheckResult")
    override fun getList(): Observable<List<MovieData>> {
        return movieDataSource.getList()
            .doOnNext {
                movieDAO.deleteAll()
                movieDAO.addAll(*dataToEntityMapper.transform(it).toTypedArray())
            }
            .onErrorResumeNext { error: Throwable ->
                if (error is ErrorException.BadException) {
                    Observable
                        .just(movieDAO.getAll())
                        .map { entityToDataMapper.transform(it) }
                } else {
                    Observable.error(error)
                }
            }
    }

}