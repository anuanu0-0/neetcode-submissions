class Solution {
    public int __characterReplacement(String s, int k) {
        HashMap<Character, Integer> hm = new HashMap<>();

        int result = 0;
        int l = 0;
        int maxFreq = 0;
        for(int r=0; r<s.length(); r++) {
            hm.put(s.charAt(r), hm.getOrDefault(s.charAt(r), 0) + 1);
            maxFreq = Math.max(maxFreq, hm.get(s.charAt(r)));

            int windowSize = r-l+1;
            while(windowSize-maxFreq > k) {
                hm.put(s.charAt(l), hm.get(s.charAt(l)) - 1);
                l++;
                windowSize--;
            }

            result = Math.max(result, windowSize);
        }

        return result;
    }


       public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> hm = new HashMap<>();

        int result = 0;
        int l = 0;
        int maxFreq = 0;
        for(int r=0; r<s.length(); r++) {
            hm.put(s.charAt(r), hm.getOrDefault(s.charAt(r), 0) + 1);
            maxFreq = Math.max(maxFreq, hm.get(s.charAt(r)));

            int windowSize = r-l+1;
            if(windowSize-maxFreq > k) {
                hm.put(s.charAt(l), hm.get(s.charAt(l)) - 1);
                l++;
                windowSize--;
            }

            result = Math.max(result, windowSize);
        }

        return result;
    }

}
