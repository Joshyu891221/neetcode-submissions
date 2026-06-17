class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sumgas = Arrays.stream(gas).sum();
        int sumcost = Arrays.stream(cost).sum();

        if(sumgas - sumcost < 0) return -1;

        for(int i = 0; i < gas.length; i++){
            gas[i] -= cost[i];
        }

        int total = 0;
        int index = 0;

        for(int i = 0; i < gas.length; i++){
            total += gas[i];
            if(total < 0){
                total = 0;
                index = i + 1;
            }
        }
        return index;
    }
}
