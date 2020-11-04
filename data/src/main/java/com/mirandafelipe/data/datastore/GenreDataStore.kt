package com.mirandafelipe.data.datastore

import android.annotation.SuppressLint
import com.mirandafelipe.data.ErrorException
import com.mirandafelipe.data.datasource.GenreData
import com.mirandafelipe.data.datasource.IGenreDataSource
import com.mirandafelipe.data.local.db.dao.IGenreDAO
import com.mirandafelipe.data.mapper.GenreDataToEntityMapper
import com.mirandafelipe.data.mapper.GenreEntityToDataMapper
import io.reactivex.Observable

class GenreDataStore(
    private val genreDataSource: IGenreDataSource,
    private val genreDAO: IGenreDAO
) : IGenreDataStore {

    private val dataToEntityMapper = GenreDataToEntityMapper()
    private val entityToDataMapper = GenreEntityToDataMapper()

    @SuppressLint("CheckResult")
    override fun getList(): Observable<List<GenreData>> {
        return genreDataSource.getList()
            .doOnNext {
                genreDAO.deleteAll()
                genreDAO.addAll(*dataToEntityMapper.transform(it).toTypedArray())
            }
            .onErrorResumeNext { error: Throwable ->
                if (error is ErrorException.BadException) {
                    Observable
                        .just(genreDAO.getAll())
                        .map { entityToDataMapper.transform(it) }
                } else {
                    Observable.error(error)
                }
            }
    }

}