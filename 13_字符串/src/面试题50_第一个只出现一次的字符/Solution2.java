package 面试题50_第一个只出现一次的字符;

import java.util.HashMap;
import java.util.Map;

//java 使用哈希表，常规解法
class Solution {
    public char firstUniqChar(String s) {
        // 哈希表存储，<字符，出现次数>
        char ans=' ';
        Map<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                int count=map.get(s.charAt(i))+1;
                map.put(s.charAt(i),count);
            }else{
                map.put(s.charAt(i),1);
            }
        }
        //再次遍历字符串，只要找到第一个出现次数为1的就返回
        for(int i=0;i<s.length();i++){
            if(map.get(s.charAt(i))==1)
                return s.charAt(i);
        }
        return ans;
    }
//    执行用时 :
//    	47 ms
//    	, 在所有 Java 提交中击败了
//    	26.63%
//    	的用户
//    	内存消耗 :
//    	42.2 MB
//    	, 在所有 Java 提交中击败了
//    	100.00%
//    	的用户
}

/*作者：panc-2
链接：https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/solution/java-shi-yong-ha-xi-biao-chang-gui-jie-fa-by-panc-/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
