package c04_Graph_DFS_Applications.c09_Cycle_Detection;
public class CycleDetection {

    private Graph G;
    private boolean[] visited;
    private boolean hasCycle = false;

    public CycleDetection(Graph G){

        this.G = G;
        visited = new boolean[G.V()];
        for(int v = 0; v < G.V(); v ++)
            if(!visited[v])
                if(dfs(v, v)){
                    hasCycle = true;
                    break;
                }
    }

    // 从顶点 v 开始，判断图中是否有环
    private boolean dfs(int v, int parent){

        visited[v] = true;
        for(int w: G.adj(v))
            if(!visited[w]){
                if(dfs(w, v)) return true;
            }
            else if(w != parent)//如果这个节点已经被访问过了，并且还不是当前节点的上一个节点
                return true;
        return false;
    }

    public boolean hasCycle(){
        return hasCycle;
    }

    public static void main(String[] args){

        Graph g = new Graph("src/c04_Graph_DFS_Applications/c09_Cycle_Detection/g.txt");
        CycleDetection cycleDetection = new CycleDetection(g);
        System.out.println(cycleDetection.hasCycle());

        Graph g2 = new Graph("src/c04_Graph_DFS_Applications/c09_Cycle_Detection/g2.txt");
        CycleDetection cycleDetection2 = new CycleDetection(g2);
        System.out.println(cycleDetection2.hasCycle());
    }
}