class Solution {
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length()-1;

        while(left<=right) {
            while(left < right && !Character.isLetterOrDigit(s.charAt(left))) left++;
            while(left < right && !Character.isLetterOrDigit(s.charAt(right))) right--;

            char start = Character.toLowerCase(s.charAt(left));
            char end = Character.toLowerCase(s.charAt(right));

            if(start!=end)  {
                System.out.println(start + ", " + end);
                return false; 
            }
            left++;
            right--;
        }

        return true;
    }
}
