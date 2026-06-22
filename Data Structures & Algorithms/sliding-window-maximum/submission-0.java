class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        int n = nums.length;
        int max = Integer.MIN_VALUE;

        int[] res = new int[n-k+1];
        for(int i=0; i<n; i++) {
            if(!dq.isEmpty() && dq.peekFirst() <= i-k) dq.pollFirst();
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.removeLast();
            }

            dq.offerLast(i);

            if(i>=k-1) {
                res[i-k+1] = !dq.isEmpty() ? nums[dq.peekFirst()] : -1;
            }
        }

        return res;
    }
}
