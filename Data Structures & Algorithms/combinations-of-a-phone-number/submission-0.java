class Solution {
    private String[] digitToChar = {
        "", "", "abc", "def", "ghi", "jkl", "mno", "qprs", "tuv", "wxyz"
    };
    private List<String> res = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) return res;
        dfs(digits, 0, "");
        return res;
        
    }
    public void dfs(String digits, int index, String str){
        if(str.length() == digits.length()){
            res.add(str);
            return;
        }
        String charList = digitToChar[digits.charAt(index) - '0'];

        for(int i = 0; i < charList.length(); i++){
            char currStr = charList.charAt(i);
            dfs(digits, index + 1, str + currStr);
        }
    }
}
