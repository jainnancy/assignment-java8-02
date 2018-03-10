package edu.knoldus.TwitterApplication;

import twitter4j.Status;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CompletableFuture;

/**
 * main class for twitter application.
 */
public class Driver {

    /**
     * Driver class constructor.
     */
    protected Driver() {

    }

    /**
     *
     * @param args stringargs
     * @throws Exception exception
     */
    public static void main(final String[] args) throws Exception {

        Scanner scan = new Scanner(System.in);
        System.out.print("Enter Hashtag: #");
        String hashtag = "#" + scan.next();
        System.out.println("\nHashtag = " + hashtag + ":\n");

        //Print retrieved tweets
        CompletableFuture<List<Status>> tweets = new Hashtag()
                .getTweets(hashtag);
        tweets.thenAccept(System.out::println);

        //Tweet Count
        CompletableFuture<Integer> tweetCount = new TweetCount()
                .getTweetCount(tweets.get());
        tweetCount.thenApply(count -> "\n\nTweet count = " + count)
        .thenAccept(System.out::println);

        CompletableFuture<List<Status>> tweetsFor10Days = new Hashtag()
                .get10DaysTweets(hashtag);
        //Tweet Count for 10 days
        CompletableFuture<Integer> countFor10Days = new TweetCount()
                .getTweetCount(tweetsFor10Days.get());

        countFor10Days.thenApply(count -> "Tweet"
                + " count for 10 days = " + count)
                .thenAccept(System.out::println);

        //Average Tweet Count per day for last 10 days
        CompletableFuture<Float> averageCount = new AverageCount()
                .showAverageTweets(countFor10Days.get().floatValue());
        averageCount.thenApply(averageTweet -> "Average"
                + " tweets for 10 days = " + averageTweet)
        .thenAccept(System.out::println);

        //Average tweet like for last 10 days
        CompletableFuture<Float> averageLikes = new AverageCount()
                .showAverageLikes(tweetsFor10Days.get());
        averageLikes.thenApply(averageLike -> "Average"
                + " Likes for 10 days = " + averageLike)
                .thenAccept(System.out::println);

        //Average tweet retweets for last 10 days
        CompletableFuture<Float> averageRetweets = new AverageCount()
                .showAverageRetweets(tweetsFor10Days.get());
        averageRetweets.thenApply(averageRetweet -> "Average"
                + " retweets for 10 days = " + averageRetweet)
                .thenAccept(System.out::println);

    }

}
