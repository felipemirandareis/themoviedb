package com.mirandafelipe.data.remote.api

import com.mirandafelipe.data.remote.response.GenreResponse
import com.mirandafelipe.data.remote.response.MovieResponse
import io.reactivex.Observable
import retrofit2.http.GET

interface TheMovieDBApi {
    @GET("movie/upcoming?api_key=1f54bd990f1cdfb230adb312546d765d&language=pt-BR&page=1")
    fun getMovieList(): Observable<MovieResponse>

    @GET("genre/movie/list?api_key=1f54bd990f1cdfb230adb312546d765d&language=pt-BR")
    fun getGenreList(): Observable<GenreResponse>
}