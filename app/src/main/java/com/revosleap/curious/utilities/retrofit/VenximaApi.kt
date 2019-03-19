package com.revosleap.curious.utilities.retrofit

class VenximaApi {
    companion object {
        private val BASE_URL= "https://venxima.com/wp-json/wp/v2/"
        fun getUrl():VenximaUrls{
            return RetrofitClient.getClient(BASE_URL)?.create(VenximaUrls::class.java)!!

        }
    }
}