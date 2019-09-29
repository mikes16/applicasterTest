package com.mikelop.applicastertest.feed.data.net

import com.mikelop.applicastertest.feed.data.entities.FeedData
import retrofit2.Response
import retrofit2.http.GET

internal interface FeedApi{
    companion object {
        private const val GET_LINKS_JSON = "link_json.json"
        private const val GET_VIDEOS_JSON = ""
    }

    /**
     * Get the links json to fill the feed
     * @return Response<FeedData>
     * @see FeedData
     */
    @GET(GET_LINKS_JSON)
    suspend fun getLinksJson(): Response<FeedData>

}