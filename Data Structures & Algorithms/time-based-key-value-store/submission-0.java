class TimeMap {
    Map<String,List<Pair>> map;
    public TimeMap() {
        this.map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)){
            map.put(key,new ArrayList<>());
        }
        map.get(key).add(new Pair(value,timestamp));

    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }

        List<Pair> list = map.get(key);
        int low = 0;
        int high = list.size() - 1;
        String res = "";

        // 2. Binary search to find the largest timestamp <= given timestamp
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (list.get(mid).timeStamp <= timestamp) {
                // This is a potential candidate, save it and look for something even closer
                res = list.get(mid).value;
                low = mid + 1;
            } else {
                // Current timestamp is too large, look to the left
                high = mid - 1;
            }
        }

        return res;
    }
    
    class Pair{
        String value;
        int timeStamp;

        public Pair(String value,int timeStamp){
            this.value = value;
            this.timeStamp = timeStamp;
        }
    }
}
