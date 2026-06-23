class Solution {

    private int calculate(int f, int s, String op) {
        if(op.equals("+")) return f+s;
        else if(op.equals("-")) return f-s;
        else if(op.equals("/")) return f/s;
        else return f*s;
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<>();

        for(String t: tokens) {
            if("+-/*".contains(t)) {
                if(s.empty()) return 0;
                int second = s.pop();
                int first = s.pop();

                s.push(calculate(first, second, t));
            } else {
                s.push(Integer.parseInt(t));
            }
        }

        return s.pop();
    }
}
