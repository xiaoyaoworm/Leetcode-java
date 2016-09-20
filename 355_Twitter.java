public class Twitter {

    private static int time = 0;
    HashMap<Integer, List<Tweet>> tweets;
    HashMap<Integer, Set<Integer>> relation;

    public class Tweet {
        int id;
        int time;
        
        public Tweet(int id, int time){
            this.id = id;
            this.time = time;
        }
    }

    /**
     * Initialize your data structure here.
     */
    public Twitter() {
        time = 0;
        tweets = new HashMap<Integer, List<Tweet>>();
        relation = new HashMap<Integer, Set<Integer>>();
    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
        List<Tweet> list = new LinkedList<Tweet>();
        if (tweets.containsKey(userId)) {
            list = tweets.get(userId);
        }
        list.add(0, new Tweet(tweetId, time++));
        tweets.put(userId, list);
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        Set<Integer> following = relation.get(userId);
        List<Integer> newsFeed = mergeNewsFeed(userId, following);
        return newsFeed;
    }

    private List<Integer> mergeNewsFeed(int userId, Set<Integer> following) {
        Comparator<List<Tweet>> comparator = new Comparator<List<Tweet>>() {
            public int compare(List<Tweet> a, List<Tweet> b) {
                return b.get(0).time - a.get(0).time;
            }
        };
        PriorityQueue<List<Tweet>> pq = new PriorityQueue<List<Tweet>>(comparator);

        List<Tweet> currentNewsFeed = tweets.get(userId);
        if (currentNewsFeed!= null && currentNewsFeed.size()!=0) {
            List<Tweet> currentNewsFeedCopy = new LinkedList<Tweet>(currentNewsFeed);
            pq.offer(currentNewsFeedCopy);
        }
        if (following != null) {
            for (Integer followeeId : following) {
                if(followeeId == userId) continue;
                List<Tweet> followeeNewsFeed = tweets.get(followeeId);
                if (followeeNewsFeed!= null && followeeNewsFeed.size()!=0) {
                    List<Tweet> followeeNewsFeedCopy = new LinkedList<Tweet>(followeeNewsFeed);
                    pq.offer(followeeNewsFeedCopy);
                }
            }
        }

        List<Integer> res = new ArrayList<Integer>();
        int count = 10;
        while (!pq.isEmpty() && count > 0) {
            List<Tweet> temp = pq.poll();
            int tweetId = temp.remove(0).id;
            res.add(tweetId);
            if (temp.size() != 0) pq.offer(temp);
            count--;
        }

        return res;
    }


    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
        Set<Integer> following = new HashSet<Integer>();
        if (relation.containsKey(followerId)) {
            following = relation.get(followerId);
        }
        following.add(followeeId);
        relation.put(followerId, following);
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        if (relation.containsKey(followerId)) {
            Set<Integer> following = relation.get(followerId);
            following.remove(followeeId);
            relation.put(followerId, following);
        } else return;
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */