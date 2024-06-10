class Solution {

    public long pow(long n, long m){return (long)Math.pow(n, m);}

    public int findNthDigit(int a) {
        if(a < 10)return a;
        long n = (long)a;
        long i = 1;
        while(n - (i*9*pow(10, i-1)) > 0){
            n -= (i*9*pow(10, i-1));
            i++;
        }
        long rem = n%i;
        long que = n/i;
        long num = 0;
        if(rem == 0){
            num = pow(10, i-1)+que-1;
            // System.out.println(num);
            return (int)num%10;
        }
        num = pow(10, i-1)+que;
        // System.out.println(num);
        return (int)((num/pow(10, i-rem))%10);
    }
}