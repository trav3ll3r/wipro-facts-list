package au.com.wipro.newsfeed.networking

import au.com.wipro.newsfeed.networking.model.Facts
import kotlinx.coroutines.coroutineScope
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object DropBoxDataImpl : DropBoxData {

    private const val BASE_URL = "https://dl.dropboxusercontent.com"

    private var dropBoxData: DropBoxService

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        dropBoxData = retrofit.create(DropBoxService::class.java)
    }

    override suspend fun facts(): Facts? = coroutineScope {
        val call: Call<Facts> = dropBoxData.facts()
        val r = call.execute()
        r.body()
    }
}