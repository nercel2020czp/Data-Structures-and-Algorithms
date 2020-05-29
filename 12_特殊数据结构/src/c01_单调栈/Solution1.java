package c01_单调栈;

import java.util.Arrays;
import java.util.Stack;

public class Solution1 {
	public static void main(String[] args) {
		int[] src = {6,10,3,7,4,12};
		Solution1 solution1 = new Solution1();
		int[] leftMinNum = solution1.getLeftMinNum(src);
		System.out.println(Arrays.toString(leftMinNum));
	}
	////获取左边第一个小于自己的数，构造一个单调递减栈
	private int[] getLeftMinNum(int[] src) {
	    int[] result = new int[src.length];
	    Stack<Integer> monotoneStack = new Stack<>();
	    for (int i = 0; i < src.length; i++) {
	        if (monotoneStack.isEmpty()) {
//	            monotoneStack.push(src[i]);
	            monotoneStack.push(i);
	            result[i] = 0;
	        } else {
	            while (!monotoneStack.isEmpty() && src[i] < monotoneStack.peek()) {
	                monotoneStack.pop();
	            }
	            if (!monotoneStack.isEmpty()) {
	                result[i] = monotoneStack.peek();
	            } else {
	                result[i] = -1;
	            }
//	            monotoneStack.push(src[i]);
	            monotoneStack.push(i);
	        }
	    }
	    return result;
	}
}
