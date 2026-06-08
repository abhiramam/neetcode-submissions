class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(
                (b[0] * b[0] + b[1] * b[1]),
                (a[0] * a[0] + a[1] * a[1])
            )
        );
        for(int[] point : points){
            int dist = (int) Math.sqrt(Math.pow(point[0],2) + Math.pow(point[1],2));
            maxHeap.add(new int[]{point[0],point[1],dist});
            while(maxHeap.size()>k){
                maxHeap.poll();
            }
        }
        int[][] ans = new int[k][2];
        int size = maxHeap.size();
        for(int i=0;i<size;i++){
            int[] curr = maxHeap.poll();
            ans[i] = new int[]{curr[0],curr[1]};
        }
        return ans;

    }
}
