package l_0049_字母异位词分组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
解法二
我们将每个字符串按照字母顺序排序，这样的话就可以把 eat，tea，ate 都映射到 aet。其他的类似。 

图2.png

时间复杂度：排序的话算作 O（K log（K））O（Klog（K））,最外层的 for 循环，所以就是 O（n K log（K））O（nKlog（K））。

空间复杂度：O（NK）O（NK），用来存储结果。



作者：windliang
链接：https://leetcode-cn.com/problems/group-anagrams/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by--16/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Solution2 {
	public List<List<String>> groupAnagrams(String[] strs) {
	    HashMap<String, List<String>> hash = new HashMap<>();
	    for (int i = 0; i < strs.length; i++) {
	        char[] s_arr = strs[i].toCharArray();
	        //排序
	        Arrays.sort(s_arr);
	        //映射到 key
	        String key = String.valueOf(s_arr); 
	        //添加到对应的类中
	        if (hash.containsKey(key)) {
	            hash.get(key).add(strs[i]);
	        } else {
	            List<String> temp = new ArrayList<String>();
	            temp.add(strs[i]);
	            hash.put(key, temp);
	        }

	    }
	    return new ArrayList<List<String>>(hash.values()); 
	}
}
