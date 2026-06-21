class Solution {
    public int longestConsecutive(int[] nums) {
        int maxLen = 0;
        HashSet<Integer> hs = new HashSet<>();
        for(int num:nums) hs.add(num);

        for(int i=0; i<nums.length; i++) {
            int search = nums[i]-1;
            int curLen = 1;

            while(hs.contains(search)) {
                search = search-1;
                curLen++;
            }

            maxLen = Math.max(curLen, maxLen);
        }

        return maxLen;
    }
}
