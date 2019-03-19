package com.revosleap.curious.utilities.retrofit

import com.revosleap.curious.models.categories.Category
import com.revosleap.curious.models.posts.Post
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface VenximaUrls {

    @GET("posts/")
    fun getPosts(): Call<MutableList<Post>>

    @GET("categories/")
    fun getCategories(): Call<MutableList<Category>>

    @GET("posts?")
    fun getPostsByCategory(
        @Query("categories") categoryNo: Int
    ): Call<MutableList<Post>>
}