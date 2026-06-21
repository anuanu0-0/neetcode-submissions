class Solution {
    public int[] productExceptSelf(int[] nums) {
        int mul = 1;
        int[] result = new int[nums.length];
        Arrays.fill(result, 1);

        for(int i=0; i<nums.length; i++) {
            result[i]*=mul;
            mul*=nums[i];
        }

        mul = 1;
        for(int i=nums.length-1; i>=0; i--) {
            result[i]*=mul;
            mul*=nums[i];
        }

        return result;
    }
}  
