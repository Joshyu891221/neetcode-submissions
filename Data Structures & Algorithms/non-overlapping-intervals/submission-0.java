class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int prev_end = Integer.MIN_VALUE;
        int count = 0;
        for (int[] interval : intervals){
            if (interval[0] >= prev_end){
                prev_end = interval[1];
            }else{
                prev_end = Math.min(prev_end, interval[1]);
                count++;
            }
        }
        return count;
    }
}
