package au.com.wipro.newsfeed.networking

import au.com.wipro.newsfeed.networking.model.Facts


interface DropBoxData {

    suspend fun facts(): Facts?
}