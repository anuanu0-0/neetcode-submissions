class Solution {

    // TODO: TRY WITH DP
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Stack<Integer> s = new Stack<>();
        int[] result = new int[n];

        for(int i=n-1; i>=0; i--) {
            while(!s.empty() && temperatures[s.peek()] <= temperatures[i]) {
                s.pop();
            }

            result[i] = s.empty() ? 0 : s.peek()-i;
            s.push(i);
        }

        return result;
    }
}
