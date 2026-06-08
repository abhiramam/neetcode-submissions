class FreqStack {
    Map<Integer,Integer> freq;
    Map<Integer,Stack<Integer>> stacks;
    int maxCount;
    public FreqStack() {
        freq = new HashMap<>();
        stacks = new HashMap<>();
        maxCount = 0;
    }
    
    public void push(int val) {
        int count = freq.getOrDefault(val,0) + 1;
        freq.put(val,count);
        if(count > maxCount){
            maxCount = count;
            stacks.putIfAbsent(count,new Stack<>());
        }
        stacks.get(count).push(val);
    }
    
    public int pop() {
        int value = stacks.get(maxCount).pop();
        freq.put(value,freq.getOrDefault(value,0)-1);
        if(stacks.get(maxCount).isEmpty()){
            maxCount--;
        }
        return value;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */