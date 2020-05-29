package t047_求1_plus_2_plus_3_plus__plus_n;

public class Solution2 {
	public int Sum_Solution(int n) {
		int sum = (int) Math.pow(n, 2) + n;
		return sum >> 1;
	}
}
