package c07_Graph_Basics.c03_Vertex_Adjacent_Iterator;
import java.util.Iterator;
//这里需要添加Random类
import java.util.Random;
public class Main {
	
	public static void main(String[] args) {
		int N = 20;
		int M = 100;
		 
		//创建一个对象
		Random df = new Random();
		 
		//Sparse Graph
		SparseGraph g1 = new SparseGraph(N, false);
		for (int e = 0; e < M; e ++) {
			int v = df.nextInt(N);
			int w = df.nextInt(N);
			g1.addEdge(v, w);
		}
		
		System.out.println("Sparse Graph 遍历  ......");
		for (int v = 0; v < N; v ++) {
			System.out.print(v + " : ");
			Iterable<Integer> adj = g1.adj(v);
			adj.forEach(e -> System.out.print(e + " "));
//			Iterator<Integer> iterator = adj.iterator();
//			while(iterator.hasNext()) {
//				System.out.print(iterator.next() + " ");
//			}
			System.out.println();
		}
		
		//创建一个对象
		
		//Dense Graph
		DenseGraph g2 = new DenseGraph(N, false);
		for (int e = 0; e < M; e ++) {
			int v = df.nextInt(N);
			int w = df.nextInt(N);
			g2.addEdge(v, w);
		}
		
		System.out.println("Dense Graph 遍历  .....");
		for (int v = 0; v < N; v ++) {
			System.out.print(v + " : ");
			Iterable<Integer> adj = g2.adj(v);
			adj.forEach(e -> System.out.print(e + " "));
//			Iterator<Integer> iterator = adj.iterator();
//			while(iterator.hasNext()) {
//				System.out.print(iterator.next() + " ");
//			}
			System.out.println();
		}
	}

}
