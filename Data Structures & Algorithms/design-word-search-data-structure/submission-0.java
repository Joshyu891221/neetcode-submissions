class WordDictionary {
    private WordDictionary[] children;
    private boolean isEnd;
    public WordDictionary() {
        children = new WordDictionary[26];
        isEnd = false;
    }

    public void addWord(String word) {
        WordDictionary node = this;

        for (char c: word.toCharArray()){
            int index = c - 'a';
            if(node.children[index] == null){
                node.children[index] = new WordDictionary();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        WordDictionary node = this;
        return dfs(word, node, 0);
        

        // return true;
    }

    public boolean dfs(String word, WordDictionary node, int index){
        if (index == word.length()){
            return node.isEnd;
        }

        char c = word.charAt(index);

        if (c == '.'){
            for (int i = 0; i < 26; i++){
                if(node.children[i] != null && dfs(word, node.children[i], index + 1)){
                    return true;
                }
            }
        }else{
            int index2 = c - 'a';
            if(node.children[index2] != null && dfs(word, node.children[index2], index + 1)){
                return true;
            }
        }
        return false;
    }
}
