class Solution {
    public int countSubstrings(String s) {
        int res = 0;

        for (int i = 0; i < s.length(); i++){            
            int r = i, l = i;
            while(r < s.length() && l >= 0){
                if(s.charAt(r) == s.charAt(l)){
                    res++;
                    r++;
                    l--;
                }else{
                    break;
                }
            }
            r = i + 1;
            l = i;
            while(r < s.length() && l >= 0) {
                if(s.charAt(r) == s.charAt(l)){
                    res++;
                    r++;
                    l--;
                }else{
                    break;
                }
            }
        }
        return res;
    }
}
