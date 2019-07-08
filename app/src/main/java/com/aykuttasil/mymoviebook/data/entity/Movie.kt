package com.aykuttasil.mymoviebook.data.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Movie(
    @SerializedName("adult")
    @Expose
    var adult: Boolean?,
    @SerializedName("backdrop_path")
    @Expose
    var backdropPath: String?,
    @SerializedName("belongs_to_collection")
    @Expose
    var belongsToCollection: Any?,
    @SerializedName("budget")
    @Expose
    var budget: Int?,
    @SerializedName("genres")
    @Expose
    var genres: List<Genre?>?,
    @SerializedName("homepage")
    @Expose
    var homepage: String?,
    @SerializedName("id")
    @Expose
    var id: Int?,
    @SerializedName("imdb_id")
    @Expose
    var imdbId: String?,
    @SerializedName("original_language")
    @Expose
    var originalLanguage: String?,
    @SerializedName("original_title")
    @Expose
    var originalTitle: String?,
    @SerializedName("overview")
    @Expose
    var overview: String?,
    @SerializedName("popularity")
    @Expose
    var popularity: Double?,
    @SerializedName("poster_path")
    @Expose
    var posterPath: String?,
    @SerializedName("production_companies")
    @Expose
    var productionCompanies: List<ProductionCompany?>?,
    @SerializedName("production_countries")
    @Expose
    var productionCountries: List<ProductionCountry?>?,
    @SerializedName("release_date")
    @Expose
    var releaseDate: String?,
    @SerializedName("revenue")
    @Expose
    var revenue: Int?,
    @SerializedName("runtime")
    @Expose
    var runtime: Int?,
    @SerializedName("spoken_languages")
    @Expose
    var spokenLanguages: List<SpokenLanguage?>?,
    @SerializedName("status")
    @Expose
    var status: String?,
    @SerializedName("tagline")
    @Expose
    var tagline: String?,
    @SerializedName("title")
    @Expose
    var title: String?,
    @SerializedName("video")
    @Expose
    var video: Boolean?,
    @SerializedName("vote_average")
    @Expose
    var voteAverage: Double?,
    @SerializedName("vote_count")
    @Expose
    var voteCount: Int?
)

data class ProductionCompany(
    @SerializedName("id")
    @Expose
    var id: Int?,
    @SerializedName("logo_path")
    @Expose
    var logoPath: String?,
    @SerializedName("name")
    @Expose
    var name: String?,
    @SerializedName("origin_country")
    @Expose
    var originCountry: String?
)

data class Genre(
    @SerializedName("id")
    @Expose
    var id: Int?,
    @SerializedName("name")
    @Expose
    var name: String?
)

data class ProductionCountry(
    @SerializedName("iso_3166_1")
    @Expose
    var iso31661: String?,
    @SerializedName("name")
    @Expose
    var name: String?
)

data class SpokenLanguage(
    @SerializedName("iso_639_1")
    @Expose
    var iso6391: String?,
    @SerializedName("name")
    @Expose
    var name: String?
)