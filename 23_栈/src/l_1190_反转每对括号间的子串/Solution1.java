package l_1190_反转每对括号间的子串;

import java.util.Stack;

/*
执行用时 :
1 ms
, 在所有 Java 提交中击败了
99.30%
的用户
内存消耗 :
37.6 MB
, 在所有 Java 提交中击败了
50.00%
的用户
*/
public class Solution1 {
	class Solution{
	    public String reverseParentheses(String s) {
	        
	        StringBuilder sb = new StringBuilder();
	        char[] arr = s.toCharArray();
	        Stack<Integer> stack = new Stack<>();
	        
	        for (int i = 0; i < arr.length; i++) {
	            
	            if (arr[i] == '(')
	                stack.push(i);
	            
	            if (arr[i] == ')')
	                reverse(arr, stack.pop() + 1, i - 1);
	        }
	        
	        for (int i = 0; i < arr.length; i++)
	            if (arr[i] != ')' && arr[i] != '(')
	                sb.append(arr[i]);
	        
	        return sb.toString();
	    }
	    
	    public void reverse(char[] arr, int left, int right) {
	        
	        while (right > left) {
	            
	            char tmp = arr[left];
	            arr[left] = arr[right];
	            arr[right] = tmp;
	            right--;
	            left++;
	        }
	    }

	}
}
