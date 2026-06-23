class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length) return findMedianSortedArrays(nums2, nums1);

        int l = 0;
        int r = nums1.length;
        int total = nums1.length + nums2.length;
        int half = (total+1)/2;

        while(l<=r) {
            int m1 = (l+r)/2; // only operate on nums1
            int m2 = half-m1;

            int l1 = m1>0 ? nums1[m1-1]:Integer.MIN_VALUE;
            int r1 = m1<nums1.length ? nums1[m1]:Integer.MAX_VALUE;
            int l2 = m2>0 ? nums2[m2-1]:Integer.MIN_VALUE;
            int r2 = m2<nums2.length ? nums2[m2]:Integer.MAX_VALUE;

            if(l1<=r2 && l2<=r1) {
                if(total%2!=0) return Math.max(l1, l2);
                return (Math.max(l1, l2) + Math.min(r1, r2))/2.0;
            } else if(l1 > r2) r = m1-1;
            else l = m1+1;
        }

        return -1;
    }
}