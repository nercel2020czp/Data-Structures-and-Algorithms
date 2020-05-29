package l_0008_字符串转换整数_atoi;

/*
🙋🙋我来了~~ 最近这几天非常忙，leetcode和公众号的消息不能及时回复见谅！我会抽空一条条回复的！现在先来打卡啦~

这道题目其实出得有点恶心，需要比较仔细才可以通过。
当然比这题更恶心的是要需要识别科学计数法，识别二进制(0b01)，
八进制（012)，十六进制（0xab），不知道leetcode会不会丧心病狂出这样的题目（或者已经有了？）。。

这题的做法大概是这样：

去掉前导空格
再是处理正负号
识别数字，注意越界情况。
这道题目如果只是简单地字符串转整数的话，就是简单地 ans = ans * 10 + digit。
但是注意这道题目可能会超过integer的最大表示！
也就是说会在某一步 ans * 10 + digit > Integer.MAX_VALUE。
*10 和 +digit 都有可能越界，那么只要把这些都移到右边去就可以了。
ans > (Integer.MAX_VALUE - digit) / 10 就是越界。

不过我的忠告是，等真正工作以后，尽可能地调用jdk的方法，比如Character.isDigit。
如果没有你想要的api，也要尽量使用guava，apache common等常见的utils包，
尽量不要自己造轮子，一是这样减少出错的可能，二是比较无脑，保护脑细胞~


作者：sweetiee
链接：https://leetcode-cn.com/problems/string-to-integer-atoi/solution/java-zi-fu-chuan-zhuan-zheng-shu-hao-dong-by-sweet/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */

public class Solution1 {
    public int myAtoi(String str) {
        char[] chars = str.toCharArray();
        int n = chars.length;
        int idx = 0;
        while (idx < n && chars[idx] == ' ') {
            // 去掉前导空格
            idx++;
        }
        if (idx == n) {
            //去掉前导空格以后到了末尾了
            return 0;
        }
        boolean negative = false;
        if (chars[idx] == '-') {
            //遇到负号
            negative = true;
            idx++;
        } else if (chars[idx] == '+') {
            // 遇到正号
            idx++;
        } else if (!Character.isDigit(chars[idx])) {
            // 其他符号
            return 0;
        }
        int ans = 0;
        while (idx < n && Character.isDigit(chars[idx])) {
            int digit = chars[idx] - '0';
            if (ans > (Integer.MAX_VALUE - digit) / 10) {
                // 本来应该是 ans * 10 + digit > Integer.MAX_VALUE
                // 但是 *10 和 + digit 都有可能越界，所有都移动到右边去就可以了。
                return negative? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            ans = ans * 10 + digit;
            idx++;
        }
        return negative? -ans : ans;
    }
}

//作者：sweetiee
//链接：https://leetcode-cn.com/problems/string-to-integer-atoi/solution/java-zi-fu-chuan-zhuan-zheng-shu-hao-dong-by-sweet/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
