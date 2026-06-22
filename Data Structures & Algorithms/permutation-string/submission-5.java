class Solution {
    public boolean __checkInclusion(String s1, String s2) {
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





        public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] count = new int[26];

        // Build the count to say what we have
        for (char c : s1.toCharArray()) {
            count[c - 'a']++;
        }

        int left = 0;

        for (int right = 0; right < s2.length(); right++) {
            // We use the current character
            count[s2.charAt(right) - 'a']--;

            // When we have exceeded the characters we were
            // suppose to use, we take it back from the left end
            while (count[s2.charAt(right) - 'a'] < 0) {
                count[s2.charAt(left) - 'a']++;
                left++;
            }

            // Whenever we have length matching the current window size
            // we have an answer
            if (right - left + 1 == s1.length()) return true;
        }

        return false;
    }
}

