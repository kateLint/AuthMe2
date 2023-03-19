package com.example.authme2.interfaces


import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface ApiInterfaceService {

    @GET("search/{name}")
    fun getHeroByName(@Path("name") name: String): Call<Any>
}

/*
@Body – Sends Java objects as a request body.
@Url – use dynamic URLs.
@Query – We can simply add a method parameter with @Query() and a query parameter name, describing the type. To URL encode a query use the form:
@Query(value = "auth_token",encoded = true) auth_token:String
@Field – send data as form-urlencoded. This requires an @FormUrlEncoded annotation attached with the method.
The @Field parameter works only with a POST*/
