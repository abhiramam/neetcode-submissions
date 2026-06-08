class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ans = new ArrayList<>();
        ans.add(newInterval);
        for(int[] interval : intervals){
            ans.add(interval);
        }
        ans.sort((a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> res = new ArrayList<>();
        int[] currentInterval = ans.get(0);
        res.add(currentInterval);
        for(int[] interval : ans){
            if(currentInterval[1] >= interval[0]){
                currentInterval[1] = Math.max(currentInterval[1],interval[1]);
            }else{
                currentInterval = interval;
                res.add(interval);
            }
        }
        int[][] result = new int[res.size()][2];
        int i = 0;
        for(int[] re : res){
            result[i++] = re;
        }
        return result;
        
    }
}
