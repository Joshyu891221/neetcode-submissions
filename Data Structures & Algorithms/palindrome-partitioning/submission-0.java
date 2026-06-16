class Solution {
    private List<List<String>> res = new ArrayList<>();
    public List<List<String>> partition(String s) {
        List<String> ans = new ArrayList<>();
        dfs(s, 0, ans);
        return res;
    }
    public void dfs(String s, int start, List<String> ans){
        if(start == s.length()){
            res.add(new ArrayList<>(ans));
            return;
        }
        for(int i = start; i < s.length(); i++){
            String slice = s.substring(start, i + 1);
            if(isPalindrome(slice)){
                ans.add(slice);
                dfs(s, start + slice.length(), ans);
                ans.remove(ans.size() - 1);
            }
        }

    }
    public boolean isPalindrome(String s){
        int l = 0, r = s.length() - 1;
        while(l < r){
            if(s.charAt(l) != s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
            
    }
        
}
