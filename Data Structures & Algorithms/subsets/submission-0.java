class Solution {
    private void getSubsets(int[] nums, int index, List<Integer> temp, List<List<Integer>> res) {
        if(index==nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }

        getSubsets(nums, index+1, temp, res);
        temp.add(nums[index]);
        getSubsets(nums, index+1, temp, res);
        temp.remove(temp.size()-1);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        getSubsets(nums, 0, temp, res);
        return res;
    }
}
