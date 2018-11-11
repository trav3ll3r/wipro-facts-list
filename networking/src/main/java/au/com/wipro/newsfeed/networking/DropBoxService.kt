package au.com.wipro.newsfeed.networking

import au.com.wipro.newsfeed.networking.model.Facts
import retrofit2.Call
import retrofit2.http.GET


interface DropBoxService {

    @GET("/s/2iodh4vg0eortkl/facts.json")
    fun facts(): Call<Facts>
}