class TimeMap {
    HashMap<String, TreeMap<Integer, String>> store;

    // Use List<Pair<Integer, String>> or  List<int[]> for O(1) set 
    // latter case -> store.get(key).add(new int[]{timestamp, value.hashCode()}); // or store value separately
    public TimeMap() {
        store = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        store.putIfAbsent(key, new TreeMap<>());
        store.get(key).put(timestamp, value);

        // OR USE THIS
        // store.computeIfAbsent(key, k->new TreeMap<>().put(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if(!store.containsKey(key)) return "";
        TreeMap<Integer, String> map = store.get(key);
        Integer fk = map.floorKey(timestamp);
        if(fk==null) return "";
        return map.get(fk);
    }
}



// Other solution -> More optimal
class TimeMap2 {
    HashMap<String, List<int[]>> store;

    public TimeMap2() {
        store = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        store.putIfAbsent(key, new ArrayList<>());
        store.get(key).add(new int[]{timestamp, value.hashCode()}); // or store value separately
    }

    public String get(String key, int timestamp) {
        if (!store.containsKey(key)) return "";

        List<int[]> list = store.get(key);

        int l = 0, r = list.size() - 1;
        String res = "";

        while (l <= r) {
            int mid = (l + r) / 2;

            if (list.get(mid)[0] <= timestamp) {
                res = list.get(mid)[1] + ""; // adjust for actual storage
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return res;
    }
}
