class Solution {
    private void backtrack(int index, int target, int[] candidates, List<Integer> subset, List<List<Integer>> res) {
        if(target==0) {
            res.add(new ArrayList<>(subset));
            return;
        } 
        if(index>=candidates.length || target<0) return;


        subset.add(candidates[index]);
        backtrack(index+1, target-candidates[index], candidates, subset, res);
        subset.remove(subset.size()-1);

        while(index < candidates.length-1 && candidates[index]==candidates[index+1]) index++;
        backtrack(index+1, target, candidates, subset, res);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> subset = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();

        backtrack(0, target, candidates, subset, res);
        return res;
    }
}
