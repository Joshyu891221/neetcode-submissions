class Twitter {
    private int count;
    private Map<Integer, List<int[]>> tweetMap;
    private Map<Integer, Set<Integer>> followMap;
    public Twitter() {
        count = 0;
        tweetMap = new HashMap<>();
        followMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        tweetMap.computeIfAbsent(userId, k -> new ArrayList<>()).add(new int[]{count--, tweetId});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        followMap.computeIfAbsent(userId, k -> new HashSet<>()).add(userId);

        for(int followId : followMap.get(userId)){
            if(tweetMap.containsKey(followId)){
                List<int[]> tweets = tweetMap.get(followId);
                int index = tweets.size() - 1;
                int[] tweet = tweets.get(index);
                heap.offer(new int[]{tweet[0], tweet[1], followId, index});
            }
        }

        while(!heap.isEmpty() && res.size() < 10){
            int[] curr = heap.poll();
            res.add(curr[1]);
            int index = curr[3];
            if(index > 0){
                int[] tweet = tweetMap.get(curr[2]).get(index - 1);
                heap.offer(new int[]{tweet[0], tweet[1], curr[2], index - 1});
            }
        }

         
        return res;
    }    
    public void follow(int followerId, int followeeId) {
        followMap.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }
    public void unfollow(int followerId, int followeeId) {
        if(followMap.containsKey(followerId)){
            if(followMap.get(followerId).contains(followeeId)){
                followMap.get(followerId).remove(followeeId);
            }
        }
    }
}
