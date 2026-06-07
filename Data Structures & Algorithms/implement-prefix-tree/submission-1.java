class TrieNode {
    TrieNode[] child = new TrieNode[26];
    boolean isEnd = false;
}
class PrefixTree {
    private PrefixTree[] child;
    private boolean isEnd;

    public PrefixTree() {
        child = new PrefixTree[26];
        isEnd = false;
    }

    public void insert(String word) {
        PrefixTree curr = this;
        for(char c: word.toCharArray()){
            int index = c - 'a';
            if(curr.child[index] == null){
                curr.child[index] = new PrefixTree();
            }
            // curr.child[index].val
            curr = curr.child[index];
        }
        curr.isEnd = true;
    }

    public boolean search(String word) {
        PrefixTree curr = this;
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
        PrefixTree curr = this;
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
