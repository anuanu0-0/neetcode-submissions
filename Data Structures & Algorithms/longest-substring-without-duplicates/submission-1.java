class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;

        HashSet<Character> hs = new HashSet<>();
        int l = 0;
        for(int r=0; r<s.length(); r++) {
            while(hs.contains(s.charAt(r))) {
                hs.remove(s.charAt(l));
                l++;
            }

            maxLen = Math.max(maxLen, r-l+1);
            hs.add(s.charAt(r));
        }

        return maxLen;
    }
}
