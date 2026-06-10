/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        if(intervals.size() < 2){return true;}
        Queue<Interval> queue = new PriorityQueue<>((a,b) -> a.start - b.start);
        for(Interval pair : intervals){
            queue.offer(pair);
        }
        int prev_end = queue.poll().end;
        while (!queue.isEmpty()){
            Interval curr = queue.poll();
            if(prev_end > curr.start){ return false;}
            prev_end = curr.end;
        }
        return true;
    }
}
