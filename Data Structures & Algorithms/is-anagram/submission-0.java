class Solution {
    public boolean isAnagram(String s, String t) {
        int[] tmap = new int[26];
        int[] smap = new int[26];

        for(char c: s.toCharArray() ) {
            smap[c-'a']++;
        }

        for(char c: t.toCharArray() ) {
            tmap[c-'a']++;
        }


        for(int i=0; i<26; i++) {
            if(smap[i]!=tmap[i]) return false;
        }

        return true;
    }
}
