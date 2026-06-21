class Solution {
    public int maxArea(int[] heights) {
        int l = 0, r = heights.length-1;

        int maxArea = 0, curArea = 0;
        while(l<r) {
            curArea = (r-l)*Math.min(heights[l], heights[r]);
            if(heights[l] < heights[r]) l++;
            else r--;

            maxArea = Math.max(maxArea, curArea);
        }

        return maxArea;
    }
}
