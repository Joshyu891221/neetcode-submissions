class Solution {
    public int trap(int[] height) {
        int l  = 0, r = height.length - 1;
        int maxl = height[l], maxr = height[r];
        int res = 0;
        while( l < r){
            if (maxl < maxr){
                if (maxl - height[l] > 0){
                    res += maxl - height[l];
                }
                l++;
                maxl = Math.max(maxl, height[l]);
            } else{
                if (maxr - height[r] > 0){
                    res += maxr - height[r];
                }
                r--;
                maxr = Math.max(maxr, height[r]);
            }
        }
        return res;
    }
}
