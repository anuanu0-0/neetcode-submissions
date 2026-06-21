class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();

        if(strs.length==0) return result;
        HashMap<String, List<String>> hm = new HashMap<>();

        for(String s: strs) {
            char []chars = s.toCharArray();
            Arrays.sort(chars);
            String sortedStr = new String(chars);
            hm.computeIfAbsent(sortedStr, k->new ArrayList<>()).add(s);
        }

        for(List<String> value : hm.values()) {
            result.add(value);
        }

        return result;
    }
}
