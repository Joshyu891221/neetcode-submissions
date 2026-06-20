class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0) return false;
        Arrays.sort(hand);

        Map<Integer, Integer> map = new HashMap<>();

        for(int num : hand){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for(int num : hand){
            if(map.get(num) > 0){
                for(int curr = num; curr < num + groupSize; curr++){
                    if(map.getOrDefault(curr, 0) == 0) return false;
                    map.computeIfPresent(curr, (k, v) -> v - 1);
                }
            }
        }
        return true;
    }
}
