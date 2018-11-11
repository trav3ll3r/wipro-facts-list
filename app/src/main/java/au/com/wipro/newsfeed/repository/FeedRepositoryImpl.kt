package au.com.wipro.newsfeed.repository

import au.com.wipro.newsfeed.domain.Feed
import au.com.wipro.newsfeed.domain.FeedEntry


class FeedRepositoryImpl : FeedRepository {

    override fun get(): Feed {
        //FIXME: RETURNS MOCK DATA UNTIL PROPER IMPLEMENTATION AVAILABLE
        return Feed(
            "Mock Feed", listOf(
                FeedEntry(
                    "Beavers",
                    "Beavers are second only to humans in their ability to manipulate and change their environment. They can measure up to 1.3 metres long. A group of beavers is called a colony",
                    "http://upload.wikimedia.org/wikipedia/commons/thumb/6/6b/American_Beaver.jpg/220px-American_Beaver.jpg"
                ),

                FeedEntry(
                    "Flag",
                    null,
                    "http://images.findicons.com/files/icons/662/world_flag/128/flag_of_canada.png"
                ),

                FeedEntry(
                    null,
                    null,
                    null
                ),

                FeedEntry(
                    "Transportation",
                    "It is a well known fact that polar bears are the main mode of transportation in Canada. They consume far less gas and have the added benefit of being difficult to steal.",
                    "http://1.bp.blogspot.com/_VZVOmYVm68Q/SMkzZzkGXKI/AAAAAAAAADQ/U89miaCkcyo/s400/the_golden_compass_still.jpg"
                )
            )
        )
    }
}