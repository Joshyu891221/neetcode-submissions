class Solution {
    public String minWindow(String s, String t) {
        int[] container = new int[58];
        for (int i = 0; i < t.length(); i ++) {
            container[t.charAt(i) - 'A']++;
        }

        int requirecount = t.length();
        int l = 0, bestl = 0;
        int minlen = Integer.MAX_VALUE;

        for (int r = 0; r < s.length(); r++){
            char cr = s.charAt(r);

            if( container[cr - 'A'] > 0) {
                requirecount--;
            }

            container[cr - 'A']--;

            while (requirecount == 0){
                int curr_window = r - l + 1;
                if (curr_window < minlen){
                    minlen = curr_window;
                    bestl = l;
                }
                char cl = s.charAt(l);
                container[cl - 'A']++;

                if (container[cl - 'A'] > 0){
                    requirecount ++;
                }
                l++;
            }
        }
        System.out.println(bestl);
        System.out.print(minlen);
        
        return minlen == Integer.MAX_VALUE ? "" : s.substring(bestl, bestl + minlen);
        
    }
}
