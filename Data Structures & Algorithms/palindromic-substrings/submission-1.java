class Solution {
    public int countSubstrings(String s) {
        int res = 0;

        for (int i = 0; i < s.length(); i++){
            int odd_ans = expand(s, i, i);
            int even_ans = expand(s, i, i + 1);
            res = res + odd_ans + even_ans;
        }            
            
        return res;
    }

    public int expand(String s, int l, int r){
        int count = 0;
        while(r < s.length() && l >= 0) {
            if(s.charAt(r) == s.charAt(l)){
                count++;
                r++;
                l--;
            }else{
                break;
            }
        }
        return count;
    }
}
