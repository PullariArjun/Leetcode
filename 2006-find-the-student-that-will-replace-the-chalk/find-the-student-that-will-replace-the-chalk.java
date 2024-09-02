class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        long sum = 0;
        int n = chalk.length;
        for(int i = 0; i < n; i++){
            sum += (long)(chalk[i]);
        }
        long x = (long)k;
        long mod = k%sum;
        if(mod == 0)return 0;
        sum = 0;
        for(int i = 0; i < n; i++){
            sum += (long)(chalk[i]);
            if(sum > mod)return i;
        }
        return 0;
    }
}