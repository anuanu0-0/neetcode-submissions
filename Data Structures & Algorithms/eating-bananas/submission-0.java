class Solution {
    private boolean canEat(int mid, int h, int[] piles) {
        int time = 0;
        for(int p: piles) {
            time+=Math.ceil((double)p/mid);
        }

        return time<=h;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = Integer.MIN_VALUE;

        for(int i=0; i<piles.length; i++) {
            r = Math.max(r, piles[i]);
        }

        int result = 0;
        while(l<=r) {
            int mid = (l+r)/2;
            if(canEat(mid, h, piles)) {
                result = mid;
                r = mid-1;
            } else l = mid + 1;
        }

        return result;
    }
}
