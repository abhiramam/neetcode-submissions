class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] trustIn = new int[n+1];
        int[] trustOut = new int[n+1];
        for(int[] truth : trust){
            trustIn[truth[1]]++;
            trustOut[truth[0]]++;
        }
        for(int i=0;i<n+1;i++){
            if(trustIn[i] == n-1 && trustOut[i] == 0){
                return i;
            }
        }
        return -1;
    }
}