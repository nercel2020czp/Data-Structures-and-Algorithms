package c_2020_5_11;

import java.util.HashSet;
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		String inputIns = sc.next();
		HashSet<Integer> isFirst = new HashSet<Integer>(n * k);
		int x = 0;
		int res = 0;
		while (k > 0) {
			for (int i = 0; i < n; i++) {
				if (inputIns.charAt(i) == 'R') x++;
				else if (inputIns.charAt(i) == 'L') x--;
				if(!isFirst.contains(x)) {
					isFirst.add(x);
					res += Math.abs(x);
				}
			}
			k--;
		}
		System.out.println(res);
		sc.close();
	}
    
}
