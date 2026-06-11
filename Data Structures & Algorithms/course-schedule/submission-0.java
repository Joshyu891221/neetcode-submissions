class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] degree = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] req: prerequisites){
            int first = req[1];
            int second = req[0];
            adj.get(first).add(second);
            degree[second]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++){
            if(degree[i] == 0){
                queue.offer(i);
            }
        }
        int count = 0;
        while(!queue.isEmpty()){
            count++;
            int pre = queue.poll();

            for(int c: adj.get(pre)){
                degree[c]--;

                if(degree[c] == 0){
                    queue.offer(c);
                }
            }
        }

        return count == numCourses;
    }
}
