## Requirements
1. post tweet.
   `{id, user_id, text, media_map, created_at, updated_at}`
2. user can follow other users.
3. view user's timeline (users post sorted in time manner)
4. view home timeline. view posts from other users, basis follow relationship
5. twitter search
6. trending topics

## component design

1. # write service
   1. will store all the writes like
      - add_tweet
      - user-add
      - user_follow
      - reactions/comments on tweet (or entity)
      - will persist in nosql store like cassandra for better write performance
      - raise events to be consumed by fan out service/ ranking service.
      - act as primary data store for tweets data/ reactions/comments data.

2. # fan-out service
     - responsible for performing fan-out activity like updating time lines for all followers
     - receives an add_tweet event
       `{tweet_id, text, user_id, created_at}`
     - sends to search service for processing.
     - identifies if user_id is hot/not (basis num followers > 1000 lets say)
     - fetch user followers
     - calls timeline service as many times to update time-lines for all followers.
# timeline service
     - stores objects in memory data store in highly AP setup. (copies)
     - returns post lists/timeline for a given userId.

# search service
     - mantains reverse index of words and tweetIds/documents
     - can user search engine like solr/es.
     - can shard index data basis the tweetId
     - aggregate service can collect results at runtime.
     - hash map can be used to rebuild if cluster fails
       `{shard_id : [tweetId list]}`

# ranking service
  - TODO

# popular topics
  - TODO




