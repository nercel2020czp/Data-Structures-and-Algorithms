package l_0017_电话号码的字母组合_letter_combinations_of_a_phone_number;

import java.util.ArrayList;
import java.util.List;

/*
回溯解法：
	这道题的解法是用回溯的方式，在循环里面套了递归调用。本来递归就不好理解了，再加上循环的递归，就更难理解了。
	我们先不考虑递归，先看看下面这个问题怎么解决。
	
假设输入是2，只有一个字符，那么应该怎么解呢？
按照题目要求2="abc"，所以结果应该是["a","b","c"]
先不用想着怎么去写递归，只思考下怎么打印出这个结果。
这个太简单了，一个循环就搞定了：
		result = List()
		for(i=0;i<len("abc");i++) {
		    tmp = i
		    result.add(tmp)
		}
		return result
		上面是伪代码，一个循环就搞定了。
		
如果输入的是23，应该怎么做呢？
23的结果是["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]，
我们仍然不考虑怎么去写递归，只是考虑怎么把这个结果给弄出来。代码如下：
		result = List()
		for(i=0;i<len("abc");i++) {
		    for(j=0;j<len("def");j++)
		        tmp = i+j
		        result.add(tmp)
		}
		return result
		也就是说23这样的长度为2的字符串可以用两层循环搞定。
		
如果输入的是234呢，仍然不要考虑怎么去写递归，而是想怎么把结果打印出来。
		result = List()
		for(i=0;i<len("abc");i+=1) {
		    for(j=0;j<len("def");j+=1) {
		        for(k=0;k<len("ghi");k+=1) {
		            tmp = i+j+k
		            result.add(tmp)
		        }
		    }
		}
		return result
		这次用了三层循环。
		
如果输入的是2345，那么代码可以这么写：
		result = List()
		for(i=0;i<len("abc");i+=1) {
		    for(j=0;j<len("def");j+=1) {
		        for(k=0;k<len("ghi");k+=1) {
		            for(n=0;n<len("jkl");n+=1)
		                tmp = i+j+k+n
		                result.add(tmp)
		        }
		    }
		}
		return result
		这次是用了四层循环。
		
现在是不是能看出一些门道了？
对的。循环的嵌套层数，就是输入的字符串长度。
输入的字符串长度是1，循环只有1层。
输入的字符串长度是3，循环就是3层。
如果输入的字符串长度是10，那么循环就是10层。

可是输入的字符串长度是不固定的，对应的循环的嵌套层数也是不固定的，那这种情况怎么解决呢？
这时候递归就派上用场了。
【见图2.png】

对于打印"2345"这样的字符串：
	1.第一次递归就是上图中最下面的方格，然后处理完第一个字符2之后，将输入的字符改变成"345"并调用第二个递归函数
	2.第二次递归处理3，将字符串改变成"45"后再次递归
	3.第三次递归处理4，将字符串改变成"5"后继续递归
	4.第四次递归处理5，将字符串改变成""后继续递归
	5.最后发现字符串为空了，将结果放到列表中并返回
	
上面是从函数调用的角度去看的，而每次调用下一层递归时，都需要将本层的一些处理结果放到一个临时变量中，
再传递给下一层，从这个变量层层传递的变化看，就像一棵树一样，这个算法的时间复杂度很高，是O(3^n)这个级别的，
空间复杂度是O(n)
【见图3.jpg】


*/


public class Solution1 {
	// 一个映射表，第二个位置是"abc“,第三个位置是"def"。。。
	// 这里也可以用map，用数组可以更节省点内存
	String[] letter_map = { " ", "*", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

	public List<String> letterCombinations(String digits) {
		// 注意边界条件
		if (digits == null || digits.length() == 0) {
			return new ArrayList<>();
		}
		iterStr(digits, "", 0);
		return res;
	}

	// 最终输出结果的list
	List<String> res = new ArrayList<>();

	// 递归函数
	void iterStr(String str, String letter, int index) {
		// 递归的终止条件，注意这里的终止条件看上去跟动态演示图有些不同，主要是做了点优化
		// 动态图中是每次截取字符串的一部分，"234"，变成"23"，再变成"3"，最后变成""，这样性能不佳
		// 而用index记录每次遍历到字符串的位置，这样性能更好
		if (index == str.length()) {
			res.add(letter);
			return;
		}
		// 获取index位置的字符，假设输入的字符是"234"
		// 第一次递归时index为0所以c=2，第二次index为1所以c=3，第三次c=4
		// subString每次都会生成新的字符串，而index则是取当前的一个字符，所以效率更高一点
		char c = str.charAt(index);
		// map_string的下表是从0开始一直到9， c-'0'就可以取到相对的数组下标位置
		// 比如c=2时候，2-'0'，获取下标为2,letter_map[2]就是"abc"
		int pos = c - '0';
		String map_string = letter_map[pos];
		// 遍历字符串，比如第一次得到的是2，页就是遍历"abc"
		for (int i = 0; i < map_string.length(); i++) {
			// 调用下一层递归，用文字很难描述，请配合动态图理解
			iterStr(str, letter + map_string.charAt(i), index + 1);
		}
	}
/*	执行用时 :
		6 ms
		, 在所有 Java 提交中击败了
		21.94%
		的用户
		内存消耗 :
		38.2 MB
		, 在所有 Java 提交中击败了
		5.16%
		的用户*/
}
