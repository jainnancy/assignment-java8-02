package edu.knoldus.TwitterApplication;

import twitter4j.Query;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.QueryResult;
import twitter4j.TwitterException;
import twitter4j.auth.AccessToken;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.CompletableFuture;

/**
 *  hashtag class.
 */
public class Hashtag {

    /**
     * totaldays.
     */
    private final Integer totaldays = 10;

    /**
     * hundres value.
     */
    private final Integer hunded = 100;

    /**
     * twitter class object.
     */
    private static Twitter twitter = TwitterFactory.getSingleton();
    /**
     * query class oject.
     */
    private static Query query;
    static {
        InputStream input = null;
        try {
            input = new FileInputStream("/home/knoldus/IdeaProjects/"
                    + "assignment-java8-02/src/"
                    + "main/resources/application.config");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Properties properties = new Properties();
        try {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        twitter.setOAuthConsumer(properties.getProperty("consumerKey"),
                properties.getProperty("consumerSecret"));
        twitter.setOAuthAccessToken(new AccessToken(properties
                .getProperty("accessToken"),
                properties.getProperty("accessTokenSecret")));

    }

    /**
     *
     * @param hashtag hashtag name
     * @return tweet list
     * @throws Exception exception
     */
    public final CompletableFuture<List<Status>>
    getTweets(final String hashtag) throws Exception {

        return CompletableFuture.supplyAsync(() ->
        {
            query = new Query(hashtag);
            query.setCount(hunded);
            QueryResult result = null;
            try {
                result = twitter.search(query);
            } catch (TwitterException e) {
                e.printStackTrace();
            }
            return result.getTweets();
        });

    }

    /**
     *
     * @param hashtag hashtag name
     * @return 10 days tweets
     * @throws Exception exception
     */
    public final CompletableFuture<List<Status>>
    get10DaysTweets(final String hashtag) throws Exception {

        return CompletableFuture.supplyAsync(() ->
        {
            query = new Query(hashtag);
            query.setCount(hunded);
            query.setSince(java.time.LocalDate.now()
                    .minusDays(totaldays).toString());
            query.setUntil(java.time.LocalDate.now().toString());
            QueryResult result = null;
            try {
                result = twitter.search(query);
            } catch (TwitterException e) {
                e.printStackTrace();
            }
            return result.getTweets();
        });

    }
}
