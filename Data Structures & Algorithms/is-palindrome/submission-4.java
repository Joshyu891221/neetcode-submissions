class Solution {
    public boolean isPalindrome(String s) {
        String ls = s.toLowerCase();
        int left = 0;
        int right = s.length() - 1;
        while (left < right){
            while (left < right && !range(ls.charAt(left))){
                left++;
            }
            while (left < right && !range(ls.charAt(right))){
                right--;
            }
            if (ls.charAt(left) == ls.charAt(right)){ 
                left++;
                right--;
            }else{
                return false;
            }
        }
        return true;
    }
    public boolean range(char c){
        return (c >= 'a' && c <= 'z' ||
                c >= '0' && c <= '9');
    }
}
