class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] degree = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] item : prerequisites){
            int first = item[1];
            int second = item[0];
            adj.get(first).add(second);
            degree[second]++;
        }

        Deque<Integer> queue = new ArrayDeque<>();
        for(int i = 0; i < numCourses; i++){
            if(degree[i] == 0){
                queue.offerLast(i);
            }
        }
        int count = 0;
        while(!queue.isEmpty()){
            int course = queue.pollFirst();
            count++;
            
            for(int c : adj.get(course)){
                degree[c]--;

                if(degree[c] == 0){
                    queue.offerLast(c);
                }
            }
        }
        return count == numCourses;
    }
}
