package edu.knoldus.TwitterApplication;

import twitter4j.Status;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Average count class.
 */
public class AverageCount {

    /**
     * totaldays.
     */
    private final Integer totaldays = 10;

    /**
     *
     * @param totalTweets total tweets
     * @return average tweets
     */
    public final CompletableFuture<Float>
    showAverageTweets(final Float totalTweets) {

        return CompletableFuture.supplyAsync(() -> {
            return totalTweets / totaldays;
        });
    }

    /**
     *
     * @param tweets tweet list
     * @return average likes
     */
    public final CompletableFuture<Float>
    showAverageLikes(final List<Status> tweets) {

        return CompletableFuture.supplyAsync(() -> {
            float totalLikes = new TweetCount().showLikeCount(tweets);
            return totalLikes / totaldays;
        });
    }

    /**
     *
     * @param tweets tweet list
     * @return average retweets
     */
    public final CompletableFuture<Float>
    showAverageRetweets(final List<Status> tweets) {

        return CompletableFuture.supplyAsync(() -> {
            float totalRetweets = new TweetCount().showRetweetCount(tweets);
            return totalRetweets / totaldays;
        });
    }
}
