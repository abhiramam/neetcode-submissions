class Solution {
    public int[] findBuildings(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0;i< heights.length;i++){
            while(!stack.isEmpty() && heights[stack.peek()] <= heights[i]){
                stack.pop();
            }
            stack.push(i);
        }
        int[] ans = new int[stack.size()];
        int index = stack.size()-1;
        while(!stack.isEmpty()){
            ans[index--] = stack.pop();
        }
        return ans;
    }
}