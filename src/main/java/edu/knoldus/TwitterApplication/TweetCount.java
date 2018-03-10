package edu.knoldus.TwitterApplication;

import twitter4j.Status;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * tweet count class.
 */
public class TweetCount {

    /**
     *
     * @param tweets tweetlist
     * @return tweet size
     */
    public final CompletableFuture<Integer>
    getTweetCount(final List<Status> tweets) {
        return CompletableFuture.supplyAsync(() -> {
                    return tweets.size();
                }
        );
    }

    /**
     *
     * @param tweets tweet list
     * @return like count
     */
    public final float showLikeCount(final List<Status> tweets) {

        Integer totalLikes = 0;
        for (Status tweet: tweets) {
            totalLikes = totalLikes + tweet.getFavoriteCount();
        }
        return totalLikes;
    }

    /**
     *
     * @param tweets tweet list
     * @return retweet count
     */
    public final float showRetweetCount(final List<Status> tweets) {

        Integer totalRetweets = 0;
        for (Status tweet: tweets) {
            totalRetweets = totalRetweets + tweet.getRetweetCount();
        }
        return totalRetweets;
    }
}
