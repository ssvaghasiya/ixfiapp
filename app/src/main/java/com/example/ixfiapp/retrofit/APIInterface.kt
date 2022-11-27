package com.example.ixfiapp.retrofit

import com.example.ixfiapp.pojo.ExampleData
import retrofit2.Response
import retrofit2.http.POST

interface APIInterface {

    @POST("market-pairs")
    suspend fun getExamples(): Response<ExampleData?>


}