class Solution {
    private boolean matches(char open, char close) {
        if((open=='(' && close==')') ||
            (open=='[' && close==']') ||
            (open=='{' && close=='}')
        ) return true;
    
        return false;
    }

    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for(char c: s.toCharArray()) {
            if(c=='(' || c=='{' || c=='[') st.push(c);
            else {
                if(st.isEmpty()) return false;
                char top = st.pop();
                if(!matches(top, c)) return false;
            }
        }

        return st.isEmpty();
    }
}
