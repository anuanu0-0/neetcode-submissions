class Solution {
    private Random r = new Random();

    private int randomIndex(int left, int right) {
        int len = right - left + 1;
        return r.nextInt(len) + left;
    }

    private int partitionAndReturnIndex(int[] nums, int pivotIndex, int left, int right) {
        int pivot = nums[pivotIndex];

        int temp = nums[left];
        nums[left] = nums[pivotIndex];
        nums[pivotIndex] = temp;

        int index = left+1;
        for(int i=left+1; i<=right; i++) {
            if(nums[i] > pivot) {
                temp = nums[index];
                nums[index] = nums[i];
                nums[i] = temp;
                index++;
            }
        }

        temp = nums[left];
        nums[left] = nums[index-1];
        nums[index-1] = temp;
        return index-1;
    }
    
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        int left = 0, right = n-1;
        while(true) {
            int pivotIndex = randomIndex(left, right);
            pivotIndex = partitionAndReturnIndex(nums, pivotIndex, left, right);
            if(pivotIndex == k-1) return nums[pivotIndex];
            else if(pivotIndex > k-1) right = pivotIndex - 1;
            else left = pivotIndex + 1;
        }
    }
}
