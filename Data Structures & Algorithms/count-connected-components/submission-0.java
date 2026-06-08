class Solution {
    public int countComponents(int n, int[][] edges) {
        Map<Integer,List<Integer>> adjList = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        int ans = 0;
        for(int i =0 ; i<n;i++){
            adjList.put(i,new ArrayList<>());
        }
        for(int[] edge : edges){
            int a = edge[0];
            int b = edge[1];
            adjList.get(a).add(b);
            adjList.get(b).add(a);
        }
        for(Map.Entry<Integer,List<Integer>> entry : adjList.entrySet()){
            if(!visited.contains(entry.getKey())){
                ans += dfs(entry.getKey(),visited,adjList);
            }
        }
        return ans;
    }
    private int dfs(int node,Set<Integer> visited,Map<Integer,List<Integer>> adjList){
        visited.add(node);
        for(int neighbourNode : adjList.get(node)){
            if(!visited.contains(neighbourNode)){
                dfs(neighbourNode,visited,adjList);
            }
        }
        return 1;
    }
}
