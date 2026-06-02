class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int l = 0, r = 0;
        int res = 0;
        while (r < s.length()){
            char cr = s.charAt(r);
            
            map.put(cr, map.getOrDefault(cr, 0) + 1);

            while((r - l + 1) - Collections.max(map.values()) > k){
                map.put(s.charAt(l), map.get(s.charAt(l))- 1);
                l++;
            }

            res = Math.max(res, r - l + 1);
            r++;
        }

        // System.out.print();
        
        return res;
    }
}
