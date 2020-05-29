package 答题标准.c02_音乐研究;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n, m, di = 0, sum = 0;
		Scanner in = new Scanner(System.in);
		//输入第一段音符的长度
		n = in.nextInt();
		int a[] = new int[n];
		//输入第一段音符中，每个音符的大小
		for (int i = 0; i < n; i++) {
			a[i] = in.nextInt();
		}
		//输入第二段音符的长度
		m = in.nextInt();
		int b[] = new int[m];
		//输入第二段音符中，每个音符的大小
		for (int i = 0; i < m; i++) {
			b[i] = in.nextInt();
		}
		for (int i = 0; i < m - n + 1; i++) {
			sum = 0;
			for (int k = 0, c = i; k < n; k++, c++) {
				sum = sum + (a[k] - b[c]) * (a[k] - b[c]);
			}
			if (i == 0) {
				di = sum;
			}
			if (sum < di) {
				di = sum;
			}
		}
		System.out.print(di);
		in.close();
	}
}
