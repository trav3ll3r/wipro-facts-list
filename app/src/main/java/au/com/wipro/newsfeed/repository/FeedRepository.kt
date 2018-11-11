package au.com.wipro.newsfeed.repository

import au.com.wipro.newsfeed.domain.Feed


interface FeedRepository {

    fun get(): Feed
}