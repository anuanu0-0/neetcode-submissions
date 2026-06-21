class Solution {
    public int trap(int[] height) {
        int l=0, r=height.length-1;
        int lmax=height[l], rmax=height[r];

        int waterCollected=0;
        while(l<=r) {
            if(height[l]<height[r]) {
                if(lmax>height[l]) {
                    waterCollected += (lmax-height[l]);
                } else {
                    lmax=height[l];
                }
                
                l++;
            } else {
                if(rmax>height[r]) {
                    waterCollected += (rmax-height[r]);
                } else {
                    rmax=height[r];
                }
                r--;
            }
        }

        return waterCollected;
    }
}
