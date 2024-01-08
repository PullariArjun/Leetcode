class Solution {
    public boolean isPalindrome(int x) {
        int r,temp=x,sum=0;
        if(x<0)
            return false;
        else
        {
            while(x!=0)
            {
                r=x%10;
                sum=sum*10+r;
                x=x/10;
            }
            if(sum==temp)
                return true;
            else
                return false;
        }
    }
}