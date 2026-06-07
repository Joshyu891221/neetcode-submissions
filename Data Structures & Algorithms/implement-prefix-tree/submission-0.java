class TrieNode {
    TrieNode[] child = new TrieNode[26];
    boolean isEnd = false;
}
class PrefixTree {
    private TrieNode root;

    public PrefixTree() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = root;
        for(char c: word.toCharArray()){
            int index = c - 'a';
            if(curr.child[index] == null){
                curr.child[index] = new TrieNode();
            }
            // curr.child[index].val
            curr = curr.child[index];
        }
        curr.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode curr = root;
        for(char c: word.toCharArray()){
            int index = c - 'a';
            if(curr.child[index] == null){
                return false;
            }
            curr = curr.child[index];
        }
        return curr.isEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(char c: prefix.toCharArray()){
            int index = c - 'a';
            if(curr.child[index] == null){
                return false;
            }
            curr = curr.child[index];
        }
        return true;
    }
}
