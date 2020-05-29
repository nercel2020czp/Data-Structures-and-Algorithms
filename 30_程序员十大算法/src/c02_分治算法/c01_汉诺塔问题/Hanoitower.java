package c02_分治算法.c01_汉诺塔问题;


public class Hanoitower {

	public static void main(String[] args) {
		hanoiTower(10, 'A', 'B', 'C');
	}
	
	//汉诺塔的移动的方法
	//使用分治算法
//	 汉诺塔游戏的演示和思路分析:
//		
//	1) 如果是有一个盘， A->C
//		如果我们有 n >= 2 情况， 我们总是可以看做是两个盘 
//			1.最下边的盘 
//			2.上面的盘
//	2) 先把 最上面的盘 A->B
//	3) 把最下边的盘 A->C
//	4) 把 B 塔的所有盘 从 B->C
	public static void hanoiTower(int num, char a, char b, char c) {
		//如果只有一个盘
		if(num == 1) {
			System.out.println("第1个盘从 " + a + "->" + c);
		} else {
			//如果我们有 n >= 2 情况，我们总是可以看做是两个盘 1.最下边的一个盘 2. 上面的所有盘
			//1. 先把 最上面的所有盘 A->B， 移动过程会使用到 c
			hanoiTower(num - 1, a, c, b);
			//2. 把最下边的盘 A->C
			System.out.println("第" + num + "个盘从 " + a + "->" + c);
			//3. 把B塔的所有盘 从 B->C , 移动过程使用到 a塔  
			hanoiTower(num - 1, b, a, c);
			
		}
	}

}
