package au.com.wipro.newsfeed.repository

import au.com.wipro.newsfeed.domain.Feed


interface FeedRepository {

    /**
     * Gets data for Feed
     */
    suspend fun get(): Feed
}