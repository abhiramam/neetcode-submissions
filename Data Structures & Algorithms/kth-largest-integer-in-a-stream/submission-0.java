class KthLargest {

    PriorityQueue<Integer> minHeap;
    int k;
    public KthLargest(int k, int[] nums) {
        this.minHeap = new PriorityQueue<>((a,b) -> Integer.compare(a,b));
        this.k = k;
        for(int i = 0;i<nums.length;i++){
            minHeap.add(nums[i]);
        }
    }
    
    public int add(int val) {
        minHeap.add(val);
        while(minHeap.size() >k){
            minHeap.poll();
        }
        return minHeap.peek();
    }
}
