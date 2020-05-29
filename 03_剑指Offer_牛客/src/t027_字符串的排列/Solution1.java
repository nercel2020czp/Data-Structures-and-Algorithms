package t027_字符串的排列;
/*链接：https://www.nowcoder.com/questionTerminal/fe6b651b66ae47d7acce78ffdd9a96c7?answerType=1&f=discussion
来源：牛客网

没想到按照自己的思路又攻克下了一道题目，在这道题目书写的过程中又进一步复习了java中String以及StringBuilder的用法
总体的解决思路是：
假设输入为a、b、c
那么其实排序的总数：
fun（a，b，c）=a（fun（b，c））+ a和b交换（fun（a，c））+a和c交换（fun（b，a））
fun（b，c） = b+fun（c）+b和c交换（fun（b））
fun（c）=1
所以用递归的方法就可以了，并且在这个递归的过程中，并没有做出一些浪费运行时间的事情，每一个递归都会产生新的结果，
因此用递归来解决被称为动态规划的此题，是合理的。
另外题目中说明可能存在重复的字符，因此在进行交换的时候需要判断进行交换的字符是否相等，如果相等就没有必要交换了。*/

import java.util.HashMap;

public class Solution1 {

/*	public ArrayList<String> PermutationHelp(StringBuilder str) {
		ArrayList<String> result = new ArrayList<String>();
		if (str.length() == 1)
			result.add(str.toString());
		else {
			for (int i = 0; i < str.length(); i++) {
				if (i == 0 || str.charAt(i) != str.charAt(0)) {
					char temp = str.charAt(i);
					str.setCharAt(i, str.charAt(0));
					str.setCharAt(0, temp);
					ArrayList<String> newResult = 
							PermutationHelp(new StringBuilder(str.substring(1)));
					for (int j = 0; j < newResult.size(); j++)
						result.add(str.substring(0, 1) + newResult.get(j));
					// 用完还是要放回去的
					temp = str.charAt(0);
					str.setCharAt(0, str.charAt(i));
					str.setCharAt(i, temp);
				}
			}
			// 需要在做一个排序操作

		}
		return result;
	}

	public ArrayList<String> Permutation(String str) {
		StringBuilder strBuilder = new StringBuilder(str);
		ArrayList<String> result = PermutationHelp(strBuilder);
		return result;
	}*/
	
//为了便于获取map的key，从而生成字符串数组，所以没有采用无法获取key的set
    public HashMap<String, Integer> map = new HashMap<>();
    public String[] permutation(String s) {
        help(new StringBuilder().append(s), 0);
        String[] res = new String[map.size()];
        int index = 0;
        for (String key:map.keySet()){
            res[index] = key;
            index++;
        }
        return res;
    }

	public void help(StringBuilder s, int k) {
		// 递归返回条件，当k刚好等于字符串长度，说明所有元素都遍历完毕
		if (k == s.length()) {
			map.put(s.toString(), 1);
		}
		for (int i = k; i < s.length(); i++) {
			// 先固定某一个元素
			swap(s, i, k);
			// 再去递归后面的元素
			help(s, k + 1);
			// 回溯，需把之前换过的元素换回原来的位置
			swap(s, i, k);
		}
	}

	// 交换StringBuilder类型的字符串中任意位置的两个字符
	public void swap(StringBuilder s, int i, int j) {
		String cur = String.valueOf(s.charAt(i));
		s.replace(i, i + 1, String.valueOf(s.charAt(j)));
		s.replace(j, j + 1, cur);
	}
	 
}

/*链接：https://www.nowcoder.com/questionTerminal/fe6b651b66ae47d7acce78ffdd9a96c7?answerType=1&f=discussion
来源：牛客网

//String的用法：
//java中String是只读的，没有办法进行变换，因此需要使用StringBuilder。
String.length() //获取字符串的长度
String.charAt(i) //获取第i个字符的内容
String.subString(start)   //获取[start,）的字符串
String.subString(start,end) //获取[start,end）中的字符串
char[] c = iniString.toCharArray() //将字符串转为char数组来进行改变字符内容
String.equal() //判断两个字符串是否相等
 
//StringBuilder的用法：
除了String中支持的方法外，StringBuilder支持字符的增、删、改。
stringBuilder.append("we");  //添加we在词尾
stringBuilder.insert(0,"we");//在0的位置加入后面的内容
stringBuilder.delete(0,1);  //删除[0,1)的数据
stringBuilder.deleteCharAt(0);
stringBuilder.setCharAt(0,'p'); //在某一个独特位置设置字符
char c = stringBuilder.charAt(i);//查询某个位置上的字符
System.out.println(stringBuilder);
new String(stringBuilder);//用stringBuilder来初始化String
*/