class Solution {
    public int reverse(int x) {
        int res = 0;
        int m = Integer.MAX_VALUE;
        int n = Integer.MIN_VALUE;

        while(x != 0){
            int num = x % 10;
            if(res > m / 10 || (res == m && num > m % 10)){
                return 0;
            }
            if(res < n / 10 || (res == n && num < n % 10)){
                return 0;
            }

            res  = (res * 10) + num;
            x /= 10;
        }
        return res;
    }
}
