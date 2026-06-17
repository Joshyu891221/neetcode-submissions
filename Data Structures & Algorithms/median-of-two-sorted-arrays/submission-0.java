class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;
        int l = 0, r = m;
        int halflen = (m + n + 1) / 2;

        while(l <= r){
            int i = l + (r - l) / 2;
            int j = halflen - i;

            int aLeftmax = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
            int aRightmin = (i == m) ? Integer.MAX_VALUE : nums1[i];
            
            int bLeftmax = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
            int bRightmin = (j == n) ? Integer.MAX_VALUE : nums2[j];

            if(aLeftmax <= bRightmin && bLeftmax <= aRightmin){
                if((m + n) % 2 == 1){
                    return Math.max(aLeftmax, bLeftmax);
                }else{
                    return (double) (Math.max(aLeftmax, bLeftmax) + Math.min(aRightmin, bRightmin)) / 2;
                }
            }else if(aLeftmax > bRightmin){
                r = i - 1;
            }else{
                l = i + 1;
            }
        }

        return 0.0;

    }
}
