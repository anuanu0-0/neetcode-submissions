class Solution {
    public String minWindow(String s, String t) {
        if(t.length()>s.length()) return "";

        HashMap<Character, Integer> tmap = new HashMap<>();
        HashMap<Character, Integer> smap = new HashMap<>();
        
        for(char c: t.toCharArray()) {
            tmap.put(c, tmap.getOrDefault(c, 0) + 1);
            smap.put(c, 0);
        }

        int have = 0, need = tmap.size();

        int minLen = Integer.MAX_VALUE;
        int minStart = 0;
        int l = 0;
        for(int r=0; r<s.length(); r++) {
            char c = s.charAt(r);
            smap.put(c, smap.getOrDefault(c,0) + 1);

            if(tmap.containsKey(c) && smap.get(c).equals(tmap.get(c))) {
                have++;
            }

            while(need==have) {
                if((r-l+1) < minLen) {
                    minLen = r - l + 1;
                    minStart = l;
                }

                char leftChar = s.charAt(l);
                smap.put(leftChar, smap.get(leftChar)-1);
                if(tmap.containsKey(leftChar) && smap.get(leftChar) < tmap.get(leftChar)) {
                    have--;
                }
                l++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}
