class Solution {
    public int getSum(int a, int b) {
        while (b != 0){
            int curr1 = a ^ b;
            int curr2 = (a & b) << 1;
            a = curr1;
            b = curr2;
        }
        
        return a;
    }
}
