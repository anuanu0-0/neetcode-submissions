class Solution {
    private boolean isPalindrome(int left, int right, String s) {
        while(left<=right) {
            if(s.charAt(left)!=s.charAt(right)) return false;
            left++;
            right--;
        }

        return true;
    }

    private void dfs(int index, String s, List<String> path, List<List<String>> res) {
        if(index==s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i=index; i<s.length(); i++) {
            if(isPalindrome(index, i, s)) {
                path.add(s.substring(index, i+1));
                dfs(i+1, s, path, res);
                path.remove(path.size()-1);
            }
        }
    }

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> path = new ArrayList<>();
        dfs(0, s, path, res);
        return res;
    }
}
