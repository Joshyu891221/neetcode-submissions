class TimeMap {
    private static class Pair {
        int timestamp;
        String value;
        
        Pair(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }
    private Map<String, List<Pair>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(new Pair(timestamp, value));        
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) return "";

        List<Pair> pairs = map.get(key);
        int left = 0;
        int right = pairs.size() - 1;
        String res = "";

        while(left <= right){
            int mid = left + (right - left) / 2;
            Pair currP = pairs.get(mid);

            if(currP.timestamp == timestamp){
                return currP.value;  
            } 
            else if(currP.timestamp < timestamp){
                left = mid + 1;
                res = currP.value;
            }else{
                right = mid - 1;
            }
        }
        return res;
    }
}
