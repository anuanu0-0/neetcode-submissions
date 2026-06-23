class TimeMap {
    HashMap<String, TreeMap<Integer, String>> store;
    public TimeMap() {
        store = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        store.putIfAbsent(key, new TreeMap<>());
        store.get(key).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        if(!store.containsKey(key)) return "";
        TreeMap<Integer, String> map = store.get(key);
        Integer fk = map.floorKey(timestamp);
        if(fk==null) return "";
        return map.get(fk);
    }
}
