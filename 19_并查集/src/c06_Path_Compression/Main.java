package c06_Path_Compression;

import java.util.ArrayList;
import java.util.Random;

public class Main {
	static Random random = new Random();
	//UnionFind1 慢于 UnionFind2
//	static int m = 10000;
//	static int size = 1000000;
	
	// UnionFind2 慢于 UnionFind1, 但UnionFind3最快
	static int size = 10000000;
	static int m = 10000000;
	static ArrayList<Integer> aList = new ArrayList<>(m);
	static ArrayList<Integer> bList = new ArrayList<>(m);
	static ArrayList<Integer> aList1 = new ArrayList<>(m);
	static ArrayList<Integer> bList1 = new ArrayList<>(m);
	static {
		long startTime = System.currentTimeMillis();
		System.out.println("loading data....");
		for(int i = 0; i < m; i++) {
			aList.add(random.nextInt(size));
			bList.add(random.nextInt(size));
			aList1.add(random.nextInt(size));
			bList1.add(random.nextInt(size));
		}
		long endTime = System.currentTimeMillis();
		System.out.println("loaded data !");
		System.out.println((endTime - startTime) / 1000 + " s");
	}

    private static double testUF(UF uf){

        long startTime = System.nanoTime();


        //执行m次的合并操作
        for(int i = 0 ; i < m ; i ++){
            int a = aList.get(i);
            int b = bList.get(i);
            uf.unionElements(a, b);
        }

        //执行m次的判断操作
        for(int i = 0 ; i < m ; i ++){
            int a = aList1.get(i);
            int b = bList1.get(i);
            uf.isConnected(a, b);
        }

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {

//        UnionFind1 uf1 = new UnionFind1(size);
//        System.out.println("UnionFind1 : " + testUF(uf1) + " s");
//
//        UnionFind2 uf2 = new UnionFind2(size);
//        System.out.println("UnionFind2 : " + testUF(uf2) + " s");

//        UnionFind3 uf3 = new UnionFind3(size);
//        System.out.println("UnionFind3 : " + testUF(uf3) + " s");
        
        UnionFind4 uf4 = new UnionFind4(size);
        System.out.println("UnionFind4 : " + testUF(uf4) + " s");
        
        
        UnionFind5 uf5 = new UnionFind5(size);
        System.out.println("UnionFind5 : " + testUF(uf5) + " s");
    }
}
