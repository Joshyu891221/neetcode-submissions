class Solution {
    public int getSum(int a, int b) {
        while (b != 0){
            int curr1 = a ^ b;
            b = (a & b) << 1;
            a = curr1;
        }
        
        return a;
    }
}
