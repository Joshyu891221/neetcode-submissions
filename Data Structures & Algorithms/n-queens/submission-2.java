class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        List<String> ans = new ArrayList<>();
        Set<Integer> verifyCol = new HashSet<>();
        Set<Integer> verifyDiag1 = new HashSet<>();
        Set<Integer> verifyDiag2 = new HashSet<>();

        dfs(n, res, ans, verifyCol, verifyDiag1, verifyDiag2, 0);
        return res;
    }

    public void dfs(int n, List<List<String>> res, List<String> ans, Set<Integer> verifyCol, Set<Integer> verifyDiag1, Set<Integer> verifyDiag2, int rIndex){
        if(ans.size() == n){
            res.add(new ArrayList<>(ans));
            return;
        }

        for(int col = 0; col < n; col++){
            if(verifyCol.contains(col) || verifyDiag1.contains(rIndex - col) || verifyDiag2.contains(rIndex + col)) continue;
            String s = makeString(n, col);
            ans.add(s);
            verifyCol.add(col);
            verifyDiag1.add(rIndex - col);
            verifyDiag2.add(rIndex + col);
            
            dfs(n, res, ans, verifyCol, verifyDiag1, verifyDiag2, rIndex + 1);

            ans.remove(ans.size() - 1);
            verifyCol.remove(col);
            verifyDiag1.remove(rIndex - col);
            verifyDiag2.remove(rIndex + col);

        }


    }

    public String makeString(int n, int c){
        char[] chars = new char[n];
        Arrays.fill(chars, '.');
        chars[c] = 'Q';
        return new String(chars);
    }
}
