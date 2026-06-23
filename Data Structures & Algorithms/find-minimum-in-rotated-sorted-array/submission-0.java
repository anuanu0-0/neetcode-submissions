class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length-1;
        int result = Integer.MAX_VALUE;
        while(l<=r) {
            int mid = (l+r)/2;
            if(nums[l]<=nums[mid]) {
                result = Math.min(result, nums[l]);
                l = mid+1;
            } else {
                result = Math.min(result, nums[mid]);
                r = mid-1;
            }
        }

        return result;
    }
}
