class Solution {
    public String foreignDictionary(String[] words) {
        int[] indegree = new int[26];
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < 26; i++){
            adj.add(new ArrayList<>());
        }

        Arrays.fill(indegree, -1);
        int count = 0;
        for (String word : words) {
            for (char c : word.toCharArray()) {
                if (indegree[c - 'a'] == -1) {
                    indegree[c - 'a'] = 0;
                    count++;
                }
            }
        }


        for(int i = 0; i < words.length - 1; i++){
            String word1 = words[i];
            String word2 = words[i + 1];

            int minlen = Math.min(word1.length(), word2.length());
            boolean hasdiff = false;

            for(int j = 0; j < minlen; j++){
                int char1 = word1.charAt(j) - 'a';
                int char2 = word2.charAt(j) - 'a';

                if(char1 != char2){
                    if (!adj.get(char1).contains(char2)) {
                        adj.get(char1).add(char2);
                        indegree[char2]++;
                    }
                    hasdiff = true;
                    break;
                }
            }
            if(!hasdiff && word1.length() > word2.length()) return "";
        }

        Queue<Integer> queue= new ArrayDeque<>();

        for(int i = 0; i < 26; i++){
            if(indegree[i] == 0){
                queue.offer(i);
            }
        }

        char[] result = new char[count];
        int writeIndex = 0;
        while(!queue.isEmpty()){
            int c = queue.poll();

            result[writeIndex] = (char) (c + 'a');
            writeIndex++;

            for(int neighbor : adj.get(c)){
                indegree[neighbor]--;
                if(indegree[neighbor] == 0){
                    queue.offer(neighbor);
                }
            }            
        }

        if(writeIndex != count){
            return "";
        }

        return new String(result);
      
    }
}
