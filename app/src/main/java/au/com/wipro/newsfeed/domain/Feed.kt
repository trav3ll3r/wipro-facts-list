package au.com.wipro.newsfeed.domain

data class Feed(val title: String?, val rows: List<FeedEntry> = emptyList())