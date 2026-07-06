class Solution {
    private String[] digitMap = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    private void backtrack(int index, String s, String digits, List<String> res) {
        if(index==digits.length()) {
            res.add(s);
            return;
        }

        String chars = digitMap[digits.charAt(index)-'0'];
        for(char c: chars.toCharArray()) {
            backtrack(index+1, s+c, digits, res);
        }
    }

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits.isEmpty()) return res;
        backtrack(0, "", digits, res);
        return res;
    }
}
