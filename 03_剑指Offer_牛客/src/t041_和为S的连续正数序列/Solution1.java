package t041_和为S的连续正数序列;
//数学问题，数学解决【见图1.png】
/*	class Solution:
def findContinuousSequence(self, target: int) -> List[List[int]]:
    res = []
    for n in range(2, target+1):
        temp = target - n*(n-1)//2
        if temp <= 0:
            break
        if not temp % n:
            a_1 = temp // n
            res.append([a_1 + i for i in range(n)])
    return res[::-1]*/
public class Solution1 {

}
