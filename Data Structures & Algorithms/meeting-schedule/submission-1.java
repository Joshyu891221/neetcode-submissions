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
        intervals.sort((a, b) -> Integer.compare(a.start, b.start));

        for(int i = 1; i < intervals.size(); i++){
            int first_end = intervals.get(i - 1).end;
            int second_start = intervals.get(i).start;

            if(first_end > second_start){
                return false;
            }
        }
        return true;
    }
}
