class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int maxArea = 0;
        // Goal is to find nse and pse for every element
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<=n; i++) {
            while(!stack.isEmpty() && (i==n || heights[i] <= heights[stack.peek()])) {
                int height = heights[stack.pop()];
                // when stack is empty nse is i, pse is 0
                // when stack has elements nse is i and pse is stack.peek()+1
                int width = stack.isEmpty()?i:i-stack.peek()-1;
                maxArea = Math.max(maxArea, height*width);
            }

            stack.push(i);
        }

        return maxArea;
    }
}
