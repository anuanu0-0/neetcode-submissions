class MinStack {
    // Use int[] to store [val, minVal] at each step in stack (no need of 2 stacks)
    Stack<Integer> st;
    Stack<Integer> minSt;

    public MinStack() {
        st = new Stack<>();
        minSt = new Stack<>();
    }
    
    public void push(int val) {
        st.push(val);
        if(minSt.empty() || minSt.peek() > val) {
            minSt.push(val);
        } else {
            minSt.push(minSt.peek());
        }
    }
    
    public void pop() {
        st.pop();
        minSt.pop();
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return minSt.peek();
    }
}
