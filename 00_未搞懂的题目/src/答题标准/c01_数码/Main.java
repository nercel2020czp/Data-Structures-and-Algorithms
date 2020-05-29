package 答题标准.c01_数码;

import java.util.Scanner;

public class Main {
	public static long YS(long r, int i) {
		long x = r / i;
		long st = i * 10, en = Math.min(r, i * 10 + 9);
		for (; st <= r; st *= 10, en = en * 10 + 9) {
			long k = Math.min(en, r);
			for (long j = st; j <= k;) {
				long sum = r / j;
				long mx = Math.min(r / sum, k);
				x += sum * (mx - j + 1);
				j = mx + 1;

			}
		}
		return x;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		long l = in.nextLong();
		long r = in.nextLong();
		for (int i = 1; i <= 9; i++) {
			System.out.println(YS(r, i) - YS(l - 1, i));
		}
		in.close();
	}

}
