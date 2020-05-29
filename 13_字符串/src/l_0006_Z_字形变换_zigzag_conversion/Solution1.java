package l_0006_Z_字形变换_zigzag_conversion;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
/*	执行用时 :
		9 ms
		, 在所有 Java 提交中击败了
		55.12%
		的用户
		内存消耗 :
		40.4 MB
		, 在所有 Java 提交中击败了
		8.33%
		的用户*/
	public String convert(String s, int numRows) {
        if(numRows < 2) return s;
        List<StringBuilder> rows = new ArrayList<StringBuilder>();
        for(int i = 0; i < numRows; i++) 
        	rows.add(new StringBuilder());
        int i = 0, flag = -1;
        for(char c : s.toCharArray()) {
            rows.get(i).append(c);
            if(i == 0 || i == numRows -1) 
            	flag = - flag;
            i += flag;
        }
        StringBuilder res = new StringBuilder();
        for(StringBuilder row : rows) res.append(row);
        return res.toString();
    }
/*
作者：jyd
链接：https://leetcode-cn.com/problems/zigzag-conversion/solution/zzi-xing-bian-huan-by-jyd/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
}
