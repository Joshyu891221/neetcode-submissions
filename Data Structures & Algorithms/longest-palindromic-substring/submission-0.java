class Solution {
    private int start = 0; 
    private int max_len = 0;
    public String longestPalindrome(String s) {
        if (s.length() == 1){ return s;}

        for (int i = 0; i < s.length(); i ++){
            expand(s, i, i);
            expand(s, i, i + 1);
        }
        return s.substring(start , start + max_len);
    }

    public void expand(String s, int begin, int end){
        while(begin >= 0 && end < s.length() && s.charAt(begin) == s.charAt(end)){
            begin--;
            end++;
        }
        if (end - begin - 1 > max_len){
            start = begin + 1;
            max_len = end - begin - 1;
        }
    }
}
