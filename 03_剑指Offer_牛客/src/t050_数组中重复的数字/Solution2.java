package t050_数组中重复的数字;
/*链接：https://www.nowcoder.com/questionTerminal/623a5ac0ea5b4e5f95552655361ae0a8?answerType=1&f=discussion
来源：牛客网
1. 分析
利用 HashSet 解决，从头到尾扫描数组，每次扫描到一个数，判断当前数是否存在 HashSet 中，如果存在，则重复，对 duplication 赋值返回，否则将该数加入到 HashSet 中*/

import java.util.*;
public class Solution2 {
    public boolean duplicate(int numbers[], int length, int [] duplication) {
        Set<Integer> set = new HashSet<>();
        for(int i =0 ;i<length;i++){
            if(set.contains(numbers[i])){
                duplication[0] = numbers[i];
                return true;
            }else{
                set.add(numbers[i]);
            }
        }
        return false;
    }
}
/*3. 复杂度
时间复杂度：O(n)
空间复杂度：O(n)*/