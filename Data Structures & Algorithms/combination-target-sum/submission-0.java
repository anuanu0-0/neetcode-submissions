class Solution {
    private void getCS(int index, int target, int[] nums, List<Integer> subset, List<List<Integer>> res) {
        if(index>=nums.length || target<0) return; 
        if(target==0) {
            res.add(new ArrayList<>(subset));
            return;
        }

        if(target-nums[index]>=0) {
            subset.add(nums[index]);
            getCS(index, target-nums[index], nums, subset, res);
            subset.remove(subset.size()-1);
        } 

        getCS(index+1, target, nums, subset, res);
    }

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<Integer> subset = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        getCS(0, target, nums, subset, res);
        return res;
    }
}
