class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Deque<int[]> q = new ArrayDeque<>();

        int goodOrange = 0;
        for(int r = 0; r < m; r++){
            for(int c = 0; c < n; c++){
                if(grid[r][c] == 2){
                    q.offerLast(new int[] {r, c});
                }else if(grid[r][c] == 1){
                    goodOrange++;
                }
            }
        }
        

        if(goodOrange == 0) return 0;
            
        int minute = 0;
        while(!q.isEmpty()){
            int qSize = q.size();
            boolean rottedAny = false;

            for(int i = 0; i < qSize; i++){
                int[] curr = q.pollFirst();
                int r = curr[0];
                int c = curr[1];

                for(int[] dir : dirs){
                    int nextR = r + dir[0];
                    int nextC = c + dir[1];
                    
                    if(nextR < 0 || nextR >= m || nextC < 0 || nextC >= n) continue;

                    if(grid[nextR][nextC] != 1) continue;

                    grid[nextR][nextC] = 2;
                    q.offerLast(new int[]{nextR, nextC});

                    goodOrange--;
                    rottedAny = true;
                }
                
            }
            if(rottedAny){
                minute++;
            }

        }
        return goodOrange == 0 ? minute : -1;

    }
}
