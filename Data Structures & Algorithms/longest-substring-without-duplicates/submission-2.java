class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() < 2){ return s.length(); }
        char[] ca = s.toCharArray();
        int l = 0, r = 0;
        Set<Character> set = new HashSet<>();
        int res = 0;
        while (r < s.length()){
            char c = s.charAt(r);
            if(!set.contains(c)){
                set.add(c);
                r++;
            }else{
                while (set.contains(c)){
                    set.remove(s.charAt(l));
                    l++;
                }
            }
            res = Math.max(res, r - l);
        }
        res = Math.max(res, r - l);
        return res;
    }
}
