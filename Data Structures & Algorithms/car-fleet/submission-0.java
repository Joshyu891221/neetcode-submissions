class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] pair = new int[position.length][2];
        Deque<Double> stack = new ArrayDeque<>();
        for (int i = 0; i < position.length; i ++){
            pair[i][0] = position[i];
            pair[i][1] = speed[i];
        }

        Arrays.sort(pair, (a, b) -> Integer.compare(b[0], a[0]));

        for (int[] item : pair){
            double time = (double)(target - item[0]) / item[1];
            if(stack.isEmpty()||stack.peek() < time){
                stack.push(time);
            }
        }
        // for(int i = 0; i < pair.length; i ++){
        //     System.out.print(pair[i][0]);
        //     System.out.println(pair[i][1]);
        // }
        return stack.size();
    }
}
