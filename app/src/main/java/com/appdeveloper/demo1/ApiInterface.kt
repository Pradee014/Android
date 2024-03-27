package com.appdeveloper.demo1

import com.appdeveloper.demo1.model.reqres.ListResourceResponse
import com.appdeveloper.demo1.model.user.allusers
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("/api/unknown")
    fun getAllUsers(): Call<ListResourceResponse>

    @GET("api/users")
    fun getusers(@Query("page") page:Int): Call<allusers>
}