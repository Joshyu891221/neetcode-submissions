class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()){return false;}
        int r = 0, l = 0;
        int l1 = s1.length(), l2 = s2.length();
        int[] container = new int[26];

        for (int i = 0; i < l1; i ++){
            container[s1.charAt(i) - 'a']++;
            container[s2.charAt(i) - 'a']--;
        }
        if(match(container)){
            return true;
        }
        for (int i = l1; i < l2; i ++) {
            container[s2.charAt(i) - 'a']--;
            container[s2.charAt(i - l1) - 'a']++;

            if(match(container)){
                return true;
            }
        }

        return false;
    }
    public boolean match(int[] nums) {
        for(int num: nums) {
            if(num != 0) { return false;}
        }
        return true;
    }
}
