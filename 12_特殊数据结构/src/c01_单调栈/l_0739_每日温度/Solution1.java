package c01_单调栈.l_0739_每日温度;

import java.util.Stack;

/*Java单调栈 逆序遍历
废物也听歌
发布于 10 个月前
5.2k
本题使用逆序遍历，为什么要使用逆序遍历。因为正常遍历思路，遍历到当前天，你无法知道后面几天的温度情况。

逆序遍历，后面几天的温度情况已经知晓，很容易得到经过几天后的温度比今天温度高。

思路： 逆序遍历，把每天温度保存下来，存放在一个单调递减的栈中(其实是非递增)，如果不满足这个要求，
则需要将栈顶元素依次弹出，直至重新满足要求为止。不满足要求的情况即为，当前天的温度比栈顶的温度要高，
重新满足要求后，栈顶元素即为后面比当前天温度高的一天，如果栈空了，然么说明后面几天没有比当前天温度还要高的。


代码
上面讲栈中存放的是当前天的温度，实际上存放的当前天温度对应的数组下标，有了数组下标就也有了当前天的温度。因为要计算隔了几天后温度比当前天温度高，存放数组下标更合适。

作者：hanyuhuang
链接：https://leetcode-cn.com/problems/daily-temperatures/solution/javadan-diao-zhan-ni-xu-bian-li-by-hyh-2/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

        T = [73,74,75,71,69,72,76,73]

第一次遍历: i = 7, T[i] = 73, stack = []
        最后一天，后面没有比今天温度高的 res[7] = 0 ,stack = [7]

第二次遍历: i = 6, T[i] = 76, stack = [7]
        栈顶对应的温度T[7]=73,76>73,出栈,此时栈为空,加入6,res[6] = 0, stack = [6]

第三次遍历: i = 5, T[i] = 72, stack = [6]
        栈顶对应的温度T[6]=76,满足要求,计算结果后入栈。res[5] = 6-5, stack = [6,5]

第四次遍历: i = 4, T[i] = 69, stack = [6,5]
        栈顶对应的温度T[5]=72,满足要求,计算结果后入栈。res[4] = 5-4, stack = [6,5,4]

第五次遍历: i = 3, T[i] = 71, stack = [6,5,4]
        栈顶对应的温度T[4]=69,71>69,出栈。stack = [6,5]
        栈顶对应的温度T[5]=72,满足要求,计算结果后入栈。res[3] = 5-3, stack = [6,5,3]

第六次遍历: i = 2, T[i] = 75, stack = [6,5,3]
        栈顶对应的温度T[3]=71,75>71,出栈。stack = [6,5]
        栈顶对应的温度T[5]=72,75>72,出栈。stack = [6]
        栈顶对应的温度T[6]=76,满足要求,计算结果后入栈。res[2] = 6-2, stack = [6,2]

第七次遍历: i = 1, T[i] = 74, stack = [6,2]
        栈顶对应的温度T[2]=75,满足要求,计算结果后入栈。res[1] = 2-1, stack = [6,2,1]

第八次遍历: i = 0, T[i] = 73, stack = [6,2,1]
        栈顶对应的温度T[1]=74,满足要求,计算结果后入栈。res[0] = 1-0, stack = [6,2,1,0]

遍历结束: res = [1,1,4,2,1,1,0,0]

作者：hanyuhuang
链接：https://leetcode-cn.com/problems/daily-temperatures/solution/javadan-diao-zhan-ni-xu-bian-li-by-hyh-2/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
*/
public class Solution1 {
	class Solution {
	    public int[] dailyTemperatures(int[] T) {
	        int[] res = new int[T.length];
	        // 单调栈 里面的数 非递增排序 
	        Stack<Integer> stack = new Stack<>();
	        // 从后往前遍历
	        for(int i = T.length-1; i >= 0; i--){
	            // 当前元素比栈顶元素大 出栈 重新调整栈直至满足要求
	            while(!stack.isEmpty() && T[i] >= T[stack.peek()]){
	                stack.pop();
	            }
	            // 栈为空 即后面没有比当前天温度高的
	            // 不为空 栈顶元素对应的下标减去当前下标即为经过几天后温度比当前天温度高
	            res[i] = stack.isEmpty()? 0 :stack.peek()-i;
	            // 当前元素进栈
	            stack.push(i);
	        }
	        return res;
	    }
	}

/*	作者：hanyuhuang
	链接：https://leetcode-cn.com/problems/daily-temperatures/solution/javadan-diao-zhan-ni-xu-bian-li-by-hyh-2/
	来源：力扣（LeetCode）
	著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
}
