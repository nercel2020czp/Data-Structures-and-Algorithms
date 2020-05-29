package l_0394_字符串解码;

import java.util.LinkedList;

/*
解法一：辅助栈法

本题难点在于括号内嵌套括号，需要从内向外生成与拼接字符串，这与栈的先入后出特性对应。

算法流程：
	
	1.构建辅助栈 stack， 遍历字符串 s 中每个字符 c；
		1.1 当 c 为数字时，将数字字符转化为数字 multi，用于后续倍数计算；
		1.2 当 c 为字母时，在 res 尾部添加 c；
		1.3 当 c 为 [ 时，将当前 multi 和 res 入栈，并分别置空置 00：
			1.3.1 记录此 [ 前的临时结果 res 至栈，用于发现对应 ] 后的拼接操作；
			1.3.2 记录此 [ 前的倍数 multi 至栈，用于发现对应 ] 后，获取 multi × [...] 字符串。
			1.3.2 进入到新 [ 后，res 和 multi 重新记录。
		1.4 当 c 为 ] 时，stack 出栈，拼接字符串 res = last_res + cur_multi * res，其中:
			1.4.1 last_res是上个 [ 到当前 [ 的字符串，例如 "3[a2[c]]" 中的 a；
			1.4.2 cur_multi是当前 [ 到 ] 内字符串的重复倍数，例如 "3[a2[c]]" 中的 2。
			
	2.返回字符串 res。
	
	复杂度分析：

时间复杂度 O(N)O(N)，一次遍历 s；
空间复杂度 O(N)O(N)，辅助栈在极端情况下需要线性空间，例如 2[2[2[a]]]。
*/
public class Solution1 {
	class Solution {
	    public String decodeString(String s) {
	        StringBuilder res = new StringBuilder();
	        int multi = 0;
	        LinkedList<Integer> stack_multi = new LinkedList<>();
	        LinkedList<String> stack_res = new LinkedList<>();
	        for(Character c : s.toCharArray()) {
	            if(c == '[') {
	                stack_multi.addLast(multi);
	                stack_res.addLast(res.toString());
	                multi = 0;
	                res = new StringBuilder();
	            }
	            else if(c == ']') {
	                StringBuilder tmp = new StringBuilder();
	                int cur_multi = stack_multi.removeLast();
	                for(int i = 0; i < cur_multi; i++) tmp.append(res);
	                res = new StringBuilder(stack_res.removeLast() + tmp);
	            }
	            else if(c >= '0' && c <= '9') 
	            	//1.1 当 c 为数字时，将数字字符转化为数字 multi，用于后续倍数计算；
	            	multi = multi * 10 + Integer.parseInt(c + "");
	            else 
	            	//1.2 当 c 为字母时，在 res 尾部添加 c；
	            	res.append(c);
	        }
	        return res.toString();
	    }
	}
	
/*	执行用时 :
		2 ms
		, 在所有 Java 提交中击败了
		57.74%
		的用户
		内存消耗 :
		37.8 MB
		, 在所有 Java 提交中击败了
		7.69%
		的用户*/

}
