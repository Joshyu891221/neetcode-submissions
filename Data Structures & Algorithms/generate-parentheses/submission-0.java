class Solution {
    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        int l = n, r = n;
        StringBuilder s = new StringBuilder();
        dfs(n, l, r, s);
        return res;
    }

    public void dfs(int n, int l, int r, StringBuilder s){
        if(s.length() == n * 2){
            res.add(s.toString());
            return;
        }

        if(l > 0){
            s.append('(');
            dfs(n, l - 1, r, s);
            s.deleteCharAt(s.length() - 1);
        }
        if(l < r){
            s.append(')');
            dfs(n, l, r - 1, s);
            s.deleteCharAt(s.length() - 1);
        }

    }
}

