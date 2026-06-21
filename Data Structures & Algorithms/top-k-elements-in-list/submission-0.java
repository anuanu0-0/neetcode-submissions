class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            hm.put(nums[i], hm.getOrDefault(nums[i], 0)+1);
        }

        // Buckets
        List<Integer>[] freq = new List[nums.length + 1];
        for(int i=0; i<freq.length; i++) {
            freq[i] = new ArrayList<>();
        }

        for(Map.Entry<Integer, Integer> entry: hm.entrySet()) {
            freq[entry.getValue()].add(entry.getKey());
        }

        int[] result = new int[k];
        int index = 0;
        for(int i=freq.length-1; i>=0; i--) {
            for(int n: freq[i]) {
                result[index++] = n;
                if(index==k) return result;
            }
        }

        return result;
    }
}
