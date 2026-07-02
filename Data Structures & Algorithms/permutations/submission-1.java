class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(0, nums, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int mask, int[] nums, List<Integer> perm, List<List<Integer>> res) {
        if(perm.size()==nums.length) {
            res.add(new ArrayList<>(perm));
            return;
        }

        for(int i=0; i<nums.length; i++) {
            if((mask & (1<<i))==0) {
                perm.add(nums[i]);
                backtrack(mask|(1<<i), nums, perm, res);
                perm.remove(perm.size()-1);
            }
        }
    }
}
