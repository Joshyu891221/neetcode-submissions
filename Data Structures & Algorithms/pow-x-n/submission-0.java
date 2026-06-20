class Solution {
    public double myPow(double x, int n) {
        boolean isNeg = false;
        double res = 1.0;
        if(n < 0){
            isNeg = true;
            n *= -1;
        }

        while(n > 0){
            res *= x;
            n --;
        }

        return isNeg ? 1 / res : res;


    }
}
