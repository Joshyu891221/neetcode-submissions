class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Deque<int[]> stack = new ArrayDeque<>();

        for (int i = 0; i < temperatures.length; i++){
            // if (stack.isEmpty() || temperatures[i] <= stack.peek()[0]){
            //     stack.push(new int[]{temperatures[i], i});
            // } else{ 
            //     while (!stack.isEmpty() && temperatures[i] > stack.peek()[0]){
            //         int[] temper_list= stack.pop();
            //         res[temper_list[1]] = i - temper_list[1];
            //     }
            //     stack.push(new int[]{temperatures[i], i});
            // }
            // if (stack.isEmpty() || temperatures[i] <= stack.peek()[0]){
            //     stack.push(new int[]{temperatures[i], i});
            // } else{ 
            while (!stack.isEmpty() && temperatures[i] > stack.peek()[0]){
                int[] temper_list= stack.pop();
                res[temper_list[1]] = i - temper_list[1];
            }
            stack.push(new int[]{temperatures[i], i});
            
        }
        
        return res;
    }
}
