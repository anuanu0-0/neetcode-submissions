class Solution {
    private void generate(StringBuilder sb, int open, int close, int n, List<String> res) {
        if(close==n && open==n) {
            res.add(sb.toString());
        }
        if(open>n || close>open) return;

        sb.append("(");
        generate(sb, open+1, close, n, res);
        sb.deleteCharAt(sb.length()-1);
        sb.append(")");
        generate(sb, open, close+1, n, res);
        sb.deleteCharAt(sb.length()-1);
    }
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        generate(sb, 0, 0, n, res);
        return res;
    }
}
