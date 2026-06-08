class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> queue = new ArrayDeque<>();
        for(int r =0;r<grid.length;r++){
            for(int c=0;c<grid[0].length;c++){
                if(grid[r][c] == 0){
                    queue.add(new int[]{r,c,1});
                }
            }
        }
        int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            for(int[] dir : dirs){
                int r = curr[0]+dir[0];
                int c = curr[1]+dir[1];
                if(r>=0 && c>=0 && r<grid.length && c< grid[0].length && grid[r][c] == Integer.MAX_VALUE){
                    grid[r][c] = curr[2];
                    queue.add(new int[]{r,c,curr[2] + 1});
                }
            }
        }
    }
}