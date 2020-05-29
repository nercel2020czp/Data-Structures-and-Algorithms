package l_0785_判断二分图;

/*执行用时 :
0 ms
, 在所有 Java 提交中击败了
100.00%
的用户
内存消耗 :
40.6 MB
, 在所有 Java 提交中击败了
75.00%
的用户*/

public class Solution1 {
	/// Leetcode 785
	public class Solution {

	    private boolean[] visited;
	    private int[] colors;
	    private int[][] graph;

	    public boolean isBipartite(int[][] graph) {

	        this.graph = graph;

	        int V = graph.length;
	        visited = new boolean[V];
	        colors = new int[V];

	        for(int v = 0; v < V; v ++)
	            if(!visited[v])
	                if(!dfs(v, 0)) return false;
	        return true;
	    }

	    private boolean dfs(int v, int color){

	        visited[v] = true;
	        colors[v] = color;
	        for(int w: graph[v])
	            if(!visited[w]){
	                if(!dfs(w, 1 - color)) return false;
	            }
	            else if(colors[v] == colors[w])
	                return false;
	        return true;
	    }
	}

}
