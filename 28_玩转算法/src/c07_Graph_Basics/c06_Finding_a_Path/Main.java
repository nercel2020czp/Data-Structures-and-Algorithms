package c07_Graph_Basics.c06_Finding_a_Path;

public class Main {

    // 测试寻路算法
    public static void main(String[] args) {

        String filename = "src/c07_Graph_Basics/c06_Finding_a_Path/testG.txt";
        SparseGraph g = new SparseGraph(7, false);
        ReadGraph readGraph = new ReadGraph(g, filename);
        g.show();
        System.out.println();

        Path path = new Path(g,0);
        System.out.println("Path from 0 to 6 : ");
        path.showPath(6);
    }
}
