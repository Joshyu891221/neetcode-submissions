class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for (char task: tasks){
            count[task - 'A']++;
        }

        PriorityQueue<Integer> maxheap = new PriorityQueue<>((a,b) -> b - a);

        for(int num :count){
            if(num != 0){maxheap.offer(num);}
            
        }

        int time = 0;
        Queue<int[]> waitList = new ArrayDeque<>();

        while(!maxheap.isEmpty() || !waitList.isEmpty()){
            time++;

            if(!waitList.isEmpty() && waitList.peek()[1] == time){
                maxheap.offer(waitList.poll()[0]);
            }

            if(!maxheap.isEmpty()){
                int cnt = maxheap.poll() - 1;
                if(cnt > 0){
                    waitList.offer(new int[]{cnt, time + n + 1});
                }
            }
            
        }
        return time;
    }
}
