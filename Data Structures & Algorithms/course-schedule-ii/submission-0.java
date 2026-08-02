class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] degree = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();
        int[] res = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] item : prerequisites){
            int first_course = item[1];
            int second_course = item[0];
            adj.get(first_course).add(second_course);
            degree[second_course]++;
        }

        Deque<Integer> queue = new ArrayDeque<>();

        for(int i = 0; i < numCourses; i++){
            if(degree[i] == 0){
                queue.offerLast(i);
            }
        }
        int count = 0;
        while(!queue.isEmpty()){
            int curr_course = queue.pollFirst();
            count++;
            res[count - 1] = curr_course;

            for(int next_course : adj.get(curr_course)){
                degree[next_course]--;
                
                if(degree[next_course] == 0){
                    queue.offerLast(next_course);
                }
            }
        }

        return count == numCourses ? res : new int[0];
    }
}
