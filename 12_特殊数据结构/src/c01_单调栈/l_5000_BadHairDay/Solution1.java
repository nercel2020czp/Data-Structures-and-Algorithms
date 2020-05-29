package c01_单调栈.l_5000_BadHairDay;

import java.util.Stack;

public class Solution1 {
	 /**
     * 10，3，7，4，12，2
     * 3 ，0，1，0， 1，0
     * 结果为5
     *
     * @param cows 数组
     * @return 结果
     */
    private int badHair(int[] cows) {
        Stack<Integer> minIndexStack = new Stack<>();
        int result = 0;
        for (int i = cows.length - 1; i >= 0; i--) {
            while (!minIndexStack.isEmpty() && cows[i] > cows[minIndexStack.peek()]) {
                //当前元素大于栈顶元素，栈顶元素比自己小需要弹出顶部元素
                minIndexStack.pop();
            }
            int bigNumIndex;
            if (minIndexStack.isEmpty()) {
                bigNumIndex = cows.length;//如果栈里没有数据了，说明自己是最高的，可以看完整个队伍。
            } else {
                bigNumIndex = minIndexStack.peek();
            }
            minIndexStack.push(i);
            int current = bigNumIndex - i - 1;//-1是因为看不到最高的那个，所以需要把最高的刨除掉。
            result += current;
        }
        return result;
    }
}
