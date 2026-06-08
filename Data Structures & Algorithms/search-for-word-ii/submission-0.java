class TrieNode {
    TrieNode[] children = new TrieNode[26];
    int index = -1;
    int refs = 0;

    public void addWord(String word, int i){
        TrieNode node = this;
        node.refs++;
        for(char c : word.toCharArray()){
            int index = c - 'a';
            if(node.children[index] == null){
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
            node.refs++;
        }
        node.index = i;
    }
}
class Solution {   
    private List<String> res = new ArrayList<>();

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        for (int i = 0; i < words.length; i++){
            root.addWord(words[i], i);
        }

        for(int r = 0; r < board.length; r++){
            for (int c = 0; c < board[0].length; c++){
                dfs(board, r, c, root, words);
            }
        }
        return res;
    }

    public void dfs(char[][] board, int r, int c, TrieNode node, String[] words){
        if(r < 0 || c < 0 || r >= board.length || c >= board[0].length || board[r][c] == '.' || node.children[board[r][c] - 'a'] == null){
            return;
        }

        char temp = board[r][c];
        board[r][c] = '.';
        TrieNode prev = node;
        node = node.children[temp - 'a'];

        if(node.index != -1){
            res.add(words[node.index]);
            node.index = -1;
            node.refs--;
            if(node.refs == 0){
                prev.children[temp - 'a'] = null;
                board[r][c] = temp;
                return;
            }
        }

        dfs(board, r + 1, c, node, words);
        dfs(board, r - 1, c, node, words);
        dfs(board, r, c + 1, node, words);
        dfs(board, r, c - 1, node, words);

        board[r][c] = temp;
    }
}
