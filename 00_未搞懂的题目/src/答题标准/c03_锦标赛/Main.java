package 答题标准.c03_锦标赛;

import java.util.Scanner;
public class Main{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		//输入参加人数
		int n = input.nextInt();
		int[] m = new int[n];
		//输入每个人的分数
		for (int i = 0; i < n; i++) {
			m[i] = input.nextInt();
		}
		int res = 0;

		for (int i = 0; i < n; i++) {
			if (m[i] <= m[0]) {
				res++;
			}
		}
		int sum = -1;
		while (res > 0) {
			res /= 2;
			sum++;
		}
		System.out.println(sum);
		input.close();
	}
}