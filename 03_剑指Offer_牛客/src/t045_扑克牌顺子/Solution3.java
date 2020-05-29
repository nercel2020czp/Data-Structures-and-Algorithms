package t045_扑克牌顺子;
/*
 * 可以这么理解，简单来说就是要是5个数字，最大和最小差值在5以内，
没有重复数值。用一个set来填充数据，0不要放进去。set的大小加上0的个数必须为5个。
此外set中数值差值在5以内。代码如下：
 */

import java.util.TreeSet;
public class Solution3 {
    public boolean isContinuous(int [] n) {
        if (n.length < 5 || n.length > 5) {
            return false;
        }
        int num = 0;
        TreeSet<Integer> set = new TreeSet<> ();
        for (int i=0; i<n.length;i++) {
            if (n[i]==0) {
                num ++;
            } else {
                set.add(n[i]);
            }
        }
        if ((num + set.size()) != 5) {
            return false;
        }
        if ((set.last() - set.first()) < 5) {
            return true;
        }
        return false;
    }
}
