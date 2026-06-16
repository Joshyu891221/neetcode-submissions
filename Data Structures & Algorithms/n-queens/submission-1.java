class Solution {
    // private 
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        Set<Integer> col = new HashSet<>();
        Set<Integer> diag1 = new HashSet<>();
        Set<Integer> diag2 = new HashSet<>();
        List<String> ans = new ArrayList<>();

        dfs(n, col, diag1, diag2, ans, 0, res);
        return res;


    }

    public void dfs(int n, Set<Integer> col,Set<Integer> diag1, Set<Integer> diag2, List<String> ans, int startRow, List<List<String>> res){
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

            dfs(n, col, diag1, diag2, ans, startRow + 1, res);

            ans.remove(ans.size() - 1);
            col.remove(i);
            diag1.remove(startRow + i);
            diag2.remove(startRow - i);
            

        }


    }

    public String ms(int i, int n){
        // StringBuilder s = new StringBuilder();
        char[] cs = new char[n];
        Arrays.fill(cs, '.');
        cs[i] = 'Q';
        return new String(cs);
    }
}
