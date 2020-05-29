package c_2020_5_11;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class Main1 {
	public static void main(String[] args) {
		int size = 10000;
		HashSet<Integer> hs = new HashSet<>(size);		//创建集合对象
		Random r = new Random();					//创建随机数对象
		int count = 0;
		while(count < size) {
			int num = r.nextInt(300) + 1;			//生成1到20的随机数
			hs.add(num);
			count++;
		}
		
		
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		String inputIns = sc.next();
		byte[] isFirst_neg = new byte[n * k + 1];//标记x负半轴
		byte[] isFirst_pos = new byte[n * k + 1];//标记x正半轴
		int x = 0;
		int res = 0;
		while (k > 0) {
			for (int i = 0; i < n; i++) {
				if (inputIns.charAt(i) == 'R') x++;
				else if (inputIns.charAt(i) == 'L') x--;
				//判断x在正负半轴
				if(x <= 0 && isFirst_neg[-x] == 0) {
					res += (-x);
					isFirst_neg[-x] = 1;
				}
				if(x > 0 && isFirst_pos[x] == 0) {
					res += x;
					isFirst_pos[x] = 1;
				}
			}
			k--;
		}
		System.out.println(res);
		sc.close();
	}
	
	
}
