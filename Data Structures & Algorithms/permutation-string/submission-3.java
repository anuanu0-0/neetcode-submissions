class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;

        HashMap<Character, Integer> s1map = new HashMap<>();
        HashMap<Character, Integer> s2map = new HashMap<>();

        for(char c: s1.toCharArray()) {
            s1map.put(c, s1map.getOrDefault(c, 0) + 1);
            s2map.put(c,0);
        }

        int required = s1map.size();
        int have = 0;

        for(int i=0; i<s1.length(); i++) {
            char cur = s2.charAt(i);
            if(s2map.containsKey(cur)) {
                s2map.put(cur, s2map.getOrDefault(cur, 0)+1);

                if(s1map.get(cur).equals(s2map.get(cur))) have++;
                else if(s2map.get(cur) == s1map.get(cur) + 1)  have--;

            }
        }

        if(have==required) return true;
        int j = 0;
        for(int i=s1.length(); i<s2.length(); i++) {
            char cur = s2.charAt(i);

            // add
            if(s2map.containsKey(cur)) {
                s2map.put(cur, s2map.getOrDefault(cur, 0)+1);

                if(s1map.get(cur).equals(s2map.get(cur))) have++;
                else if (s2map.get(cur) == s1map.get(cur) + 1) have--;
            }

            // remove

            char prev = s2.charAt(j);
            if(s2map.containsKey(prev)) {
                s2map.put(prev, s2map.getOrDefault(prev, 0)-1);

                if(s1map.get(prev).equals(s2map.get(prev))) have++;
                else if (s2map.get(prev) == s1map.get(prev) - 1) have--;
            }
            j++;

            // track 
            if(required==have) return true;
        }

        return false;
    }
}
