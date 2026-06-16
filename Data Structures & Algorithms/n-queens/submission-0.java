class Solution {
    private List<List<String>> res = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        Set<Integer> col = new HashSet<>();
        Set<Integer> diag1 = new HashSet<>();
        Set<Integer> diag2 = new HashSet<>();
        List<String> ans = new ArrayList<>();
        dfs(n, col, diag1, diag2, ans, 0);
        return res;


    }

    public void dfs(int n, Set<Integer> col,Set<Integer> diag1, Set<Integer> diag2, List<String> ans, int startRow){
        if(startRow == n){
            res.add(new ArrayList<>(ans));
            return;
        }

        for(int i = 0; i < n; i++){
            if(col.contains(i) || diag1.contains(startRow + i) || diag2.contains(startRow - i)) continue;
            String s = ms(i, n);
            ans.add(s);
            col.add(i);
            diag1.add(startRow + i);
            diag2.add(startRow - i);
            dfs(n, col, diag1, diag2, ans, startRow + 1);
            ans.remove(ans.size() - 1);
            col.remove(i);
            diag1.remove(startRow + i);
            diag2.remove(startRow - i);
            

        }


    }

    public String ms(int i, int n){
        StringBuilder s = new StringBuilder();
        for(int j = 0; j < i; j++){
            s.append('.');
        }
        s.append('Q');
        for(int j = i + 1; j < n; j++){
            s.append('.');
        }
        return s.toString();
    }
}
