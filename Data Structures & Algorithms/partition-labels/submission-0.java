class Solution {
    public List<Integer> partitionLabels(String s) {
        // Map<Character, Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        int[] last = new int[26];

        for(int i = s.length() - 1; i >= 0; i--){
            char c = s.charAt(i);
            if(last[c - 'a'] == 0) last[c - 'a'] = i;
        }
        int left = 0;
        int boundary = 0;

        for(int right = 0; right < s.length(); right++) {
            boundary = Math.max(boundary, last[s.charAt(right) - 'a']);

            if(right == boundary){
                res.add(right - left + 1);
                left = right + 1;
            } 
            
        }
        return res;


    }
}
