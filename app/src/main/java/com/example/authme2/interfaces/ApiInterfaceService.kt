package com.example.authme2.interfaces


import com.example.authme2.model.ActiveUsersResponse
import com.example.authme2.model.GenerateCodeResponse
import com.example.authme2.model.NewJwtEntryRequest
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST


interface ApiInterfaceService {

    @POST("v1/authMe/insert-jwt")
    fun getCode(@Body() newJwtEntryRequest : NewJwtEntryRequest): Call<GenerateCodeResponse>

    @POST("v1/authMe/active-users")
    fun getActiveUsers(@Body() newJwtEntryRequest : NewJwtEntryRequest): Call<ActiveUsersResponse>
}

/*
@Body – Sends Java objects as a request body.
@Url – use dynamic URLs.
@Query – We can simply add a method parameter with @Query() and a query parameter name, describing the type. To URL encode a query use the form:
@Query(value = "auth_token",encoded = true) auth_token:String
@Field – send data as form-urlencoded. This requires an @FormUrlEncoded annotation attached with the method.
The @Field parameter works only with a POST*/
