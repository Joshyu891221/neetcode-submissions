class Solution {
    public int largestRectangleArea(int[] heights) {
        int res = 0;
        Deque<int[]> stack = new ArrayDeque<>();
        // (index, height)
        for(int i = 0; i < heights.length; i++){
            int start = i;
            while(!stack.isEmpty() && stack.peek()[1] > heights[i]){
                int index = stack.peek()[0];
                int h = stack.pop()[1];
                res = Math.max(res, (i - index) * h);
                start = index;
            }
            stack.push(new int[]{start, heights[i]});

        }

        while(!stack.isEmpty()){
            int index = stack.peek()[0];
            int height = stack.pop()[1];
            res = Math.max(res, ((heights.length - index) * height));
        }
        return res;
    }
}
