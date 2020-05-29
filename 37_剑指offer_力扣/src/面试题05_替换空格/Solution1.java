package 面试题05_替换空格;
/*
解题思路：
在 Python 和 Java 等语言中，字符串都被设计成不可变的类型，
即无法直接修改字符串的某一位字符，需要新建一个字符串实现。

Java 解法流程：
	1.初始化一个 StringBuilder ，记为 res ；
	2.遍历字符串 s 中的每个字符 c ：
		当 c 为空格时：向 res 后添加字符串 "%20"；
		当 c 不为空格时：向 res 后添加字符 c ；
	3.将 res 转化为 String 类型并返回。
复杂度分析：
	时间复杂度 O(N) ： 遍历使用 O(N) ，每轮添加（修改）字符操作使用 O(1) ；
	空间复杂度 O(N) ： Python 新建的 list 和 Java 新建的 
	StringBuilder 都使用了线性大小的额外空间。

作者：jyd
链接：https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/solution/mian-shi-ti-05-ti-huan-kong-ge-ji-jian-qing-xi-tu-/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

*/
public class Solution1 {
    public String replaceSpace(String s) {
        StringBuilder res = new StringBuilder();
        for(Character c : s.toCharArray())
        {
            if(c == ' ') res.append("%20");
            else res.append(c);
        }
        return res.toString();
    }
}
