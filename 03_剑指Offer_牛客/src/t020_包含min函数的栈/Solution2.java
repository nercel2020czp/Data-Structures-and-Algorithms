package t020_包含min函数的栈;

import java.util.Stack;

/*
方法二：压缩还原法
链接：https://www.nowcoder.com/questionTerminal/4c776177d2c04c2494f2555c9fcc1e49?answerType=1&f=discussion
来源：牛客网

我们发现其实最小值min它本身就是一种冗余信息。为什么呢？
因为每个元素在数值上都包含了min值，举个例子，假设入栈序列为：4、5、6、3、2、1，
那么各轮次对应的min值就是：4、4、4、3、2、1，发现有：
	4=4+0，5=4+1，6=4+2，3=4+(-1)，2=3+(-1)，1=2+(-1)；
	各个元素在数值上已经包含了在它之前的最小值的值；
	
那么，我们是不是只要在数据栈中存储0、1、2、-1、-1、-1，
然后再使用一个辅助变量min=1就可以了呢？

这样，根据单个辅助变量和栈中存储的值就能够推理出top值和min值了，具体规则如下：
	入栈：
		压缩：将要入栈的元素node减去当前最小值min，得到一个差值diff，只存储该差值；
		更新：如果入栈的元素node比当前最小值min小，则要更新最小值：min=node；
		初始：第一次入栈比较特殊，因为此时的min变量并没有值，所以令：min=node；
	出栈：
		更新：如果栈中存储的差值diff是负数，说明出栈的元素是当前最小值min，需要把min值更
				新为上一个最小值min = min - diff，
			否则，出栈的元素不是最小值，则不对min变量做任何操作；
		还原：如果栈中存储的差值diff是正数，说明 top = min + diff，否则，说明top元素
			本身是最小值 top = min；
*/

class Solution2 {
    Stack<Integer> stack_ = new Stack<Integer>();
    int top_, min_;
    void push(int node) {
        if (stack_.empty()) // 第一次入栈需要额外考虑
            min_ = node;
        stack_.push(node - min_); // 存储入栈元素与最小值的差值
        if (node < min_) // 如果入栈元素比最小值要小则更新最小值
            min_ = node;
        top_ = node; //.......更新最新元素(top)的值
    }
    void pop() {
/*    	
    出栈：
		更新：如果栈中存储的差值diff是负数，说明出栈的元素是当前最小值min，需要把min值更
				新为上一个最小值min = min - diff，
			否则，出栈的元素不是最小值，则不对min变量做任何操作；
		还原：如果栈中存储的差值diff是正数，说明 top = min + diff，否则，说明top元素
			本身是最小值 top = min；
   */ 	
        if (!stack_.empty()) {
            // 如果出栈的是最小值(体现为存储值为负)，则需要更新最小值
            if (stack_.peek() < 0)
                min_ -= stack_.peek();
            stack_.pop();
 
//    		还原：如果栈中存储的差值diff是正数，说明 top = min + diff，否则，说明top元素
//    				本身是最小值 top = min；
            if (!stack_.empty()) // 出栈需要更新 top 的值
                top_ = min_ + (stack_.peek()>0 ? stack_.peek() : 0);
        }
    }
    int top() {
        return top_;
    }
    int min() {
        return min_;
    }
}
