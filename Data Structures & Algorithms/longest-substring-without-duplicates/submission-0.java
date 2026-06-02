class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() < 2){ return s.length(); }
        char[] ca = s.toCharArray();
        int l = 0, r = 0;
        Map<Character, Integer> map = new HashMap<>();
        int res = 0;
        while (r < s.length()){

            map.put(ca[r], map.getOrDefault(ca[r], 0) + 1);
            System.out.println(ca[r] + " = " + String.valueOf(map.get(ca[r])));
            while(map.get(ca[r]) > 1){
                map.put(ca[l], map.get(ca[l]) - 1);
                System.out.println(ca[l] + " change to " + String.valueOf(map.get(ca[l])));
                l++;
            }
            res = Math.max(res, r - l + 1);
            System.out.println("res is " + String.valueOf(res));
            r++;
        }
        res = Math.max(res, r - l);
        return res;
    }
}
