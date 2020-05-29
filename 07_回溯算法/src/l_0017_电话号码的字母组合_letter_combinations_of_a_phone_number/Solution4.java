package l_0017_电话号码的字母组合_letter_combinations_of_a_phone_number;

import java.util.ArrayList;
import java.util.List;

class Solution4 {
    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<String>();
        if (null == digits || digits.length() == 0) {
            return combinations;
        }
        int size = digits.length();
        char[] word = new char[size];
        char[][] allChars = new char[size][];
        int[] curValue = new int[size];
        // initialize all characters and word
        int total = 1;
        for (int i = 0; i < size; i++) {
            allChars[i] = getDigitCharArray(digits.charAt(i));
            word[i] = allChars[i][0];
            curValue[i] = 0;
            total = total * allChars[i].length;
        }
        for (int i = 0; i < total; i++) {
            combinations.add(new String(word));
            int curPos = size - 1;
            boolean hasCarry = true;
            while (hasCarry) {
                hasCarry = false;
                curValue[curPos]++;
                if (curValue[curPos] == allChars[curPos].length) {
                    curValue[curPos] = 0;
                    hasCarry = true;
                }
                word[curPos] = allChars[curPos][curValue[curPos]];
                if (hasCarry && curPos > 0) {
                    curPos--;
                }
            }
        }
        return combinations;
    }

    public char[] getDigitCharArray(char digit) {
        switch (digit) {
            case '2':
                return new char[]{'a', 'b', 'c'};
            case '3':
                return new char[]{'d', 'e', 'f'};
            case '4':
                return new char[]{'g', 'h', 'i'};
            case '5':
                return new char[]{'j', 'k', 'l'};
            case '6':
                return new char[]{'m', 'n', 'o'};
            case '7':
                return new char[]{'p', 'q', 'r', 's'};
            case '8':
                return new char[]{'t', 'u', 'v'};
            case '9':
                return new char[]{'w', 'x', 'y', 'z'};
            default:
                return new char[0];
        }
    }
    
/*    执行用时 :
    	0 ms
    	, 在所有 Java 提交中击败了
    	100.00%
    	的用户
    	内存消耗 :
    	38 MB
    	, 在所有 Java 提交中击败了
    	5.16%
    	的用户*/
    
}
