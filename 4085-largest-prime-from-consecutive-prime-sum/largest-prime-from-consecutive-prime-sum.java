class Solution {
    public boolean[] primes(int n){
        boolean arr[] = new boolean[n+1];
        Arrays.fill(arr,true);
        for(int i = 2; i < n+1; i++)
            if(arr[i]) 
                for(int j = i*i; j <= n && j >= 0; j+=i)
                    arr[j] = false;
        return arr;
    }
    public int largestPrime(int n) {
        int ans = 0, sum = 0;
        boolean primes[] = primes(n);
        for(int i = 2; i <= n; i++){
            if(primes[i])sum += i;
            if(sum > n)return ans;
            if(primes[sum])ans = sum;
        }
        return ans;
    }
}