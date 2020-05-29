package t009_变态跳台阶;

public class Solution1 {
    public int JumpFloorII(int target) {
        return 1<<(target-1);
        //return (int)Math.pow(2,target-1);
    }
}
