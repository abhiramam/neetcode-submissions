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
    public int minMeetingRooms(List<Interval> intervals) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b) -> Integer.compare(a,b));
        intervals.sort((a, b) -> a.start - b.start);

        for(Interval interval : intervals){
            if(!minHeap.isEmpty() && interval.start >= minHeap.peek()){
                minHeap.poll();
            }
            minHeap.add(interval.end);
        }
        return minHeap.size();
    }
}
