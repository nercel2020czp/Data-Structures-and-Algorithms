package c14_Hash_Table.c01_Hash_Table_Basics;

class Solution {
	
/*	执行用时 :
		8 ms
		, 在所有 Java 提交中击败了
		75.84%
		的用户
		内存消耗 :
		40 MB
		, 在所有 Java 提交中击败了
		6.12%
		的用户*/
	
    public int firstUniqChar(String s) {

        int[] freq = new int[26];
        for(int i = 0 ; i < s.length() ; i ++)
            freq[s.charAt(i) - 'a'] ++;

        for(int i = 0 ; i < s.length() ; i ++)
            if(freq[s.charAt(i) - 'a'] == 1)
                return i;

        return -1;
    }
}
