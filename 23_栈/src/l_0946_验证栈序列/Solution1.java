package l_0946_验证栈序列;
/*
解法一：使用数组来实现栈的作用
解法一：
使用数组来实现栈的作用，模拟栈的出栈入栈操作。size表示栈的大小，size-1就是栈顶的位置了。

注意：用数组来实现栈，虽然存取更快，但多数情况下其实不推荐。
特别是数组pushed可能特别大的时候，那作为栈的数组stack也会特别大。
但实际上同时存在栈中的元素往往不是特别多，这就存在很大的浪费了。

作者：TuFeiBaBa
链接：https://leetcode-cn.com/problems/validate-stack-sequences/solution/jie-fa-yi-shi-yong-shu-zu-lai-shi-xian-zhan-de-zuo/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
*/
public class Solution1 {
/*	执行用时 :
		1 ms
		, 在所有 Java 提交中击败了
		99.03%
		的用户
		内存消耗 :
		39 MB
		, 在所有 Java 提交中击败了
		100.00%
		的用户*/
	public boolean validateStackSequences(int[] pushed, int[] popped) {
	    int[] stack = new int[pushed.length];
	    int size = 0;
	    for (int i = 0, j = 0; i < pushed.length; i++) {
	        stack[size++] = pushed[i];
	        while (size != 0 && stack[size - 1] == popped[j]) {
	            size--;j++;
	        }
	    }
	    return size == 0;
	}

/*	作者：TuFeiBaBa
	链接：https://leetcode-cn.com/problems/validate-stack-sequences/solution/jie-fa-yi-shi-yong-shu-zu-lai-shi-xian-zhan-de-zuo/
	来源：力扣（LeetCode）
	著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
}
