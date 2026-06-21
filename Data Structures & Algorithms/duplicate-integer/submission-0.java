class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        for(Integer num:nums) {
            if(hs.contains(num)) return true;
            hs.add(num);
        }

        return false;
    }
}