class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
       
        HashMap<String, List<String>> hm = new HashMap<>();

        for(String s: strs) {
            // Sorting : nlogn
            // char []chars = s.toCharArray();
            // Arrays.sort(chars);
            // String sortedStr = new String(chars);
            // hm.computeIfAbsent(sortedStr, k->new ArrayList<>()).add(s);

            // Hash table : n
            int []count = new int[26];
            for(char c:s.toCharArray()) {
                count[c-'a']++;
            }
            String key = Arrays.toString(count);
            hm.computeIfAbsent(key, k->new ArrayList<>()).add(s);
        }

        return new ArrayList<>(hm.values());
    }
}
