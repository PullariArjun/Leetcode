class Solution {
    public int[][] merge(int[][] intervals) {

        int len = intervals.length;
        if(len < 2)return intervals;
        Arrays.sort(intervals, (a, b) ->{
            if(a[0] == b[0])return a[1] - b[1];
            return a[0] - b[0];
        });
        int cnt = 1;
        int ind = 0;
        int start = intervals[0][0];
        int end = intervals[0][1];
        for(int i = 1; i < len; i++){
            if(end >= intervals[i][0]){
                intervals[ind][1] = Math.max(end, intervals[i][1]);
                end = intervals[ind][1];
                intervals[i][0] = -1;
                intervals[i][1] = -1;
            }else{
                start = intervals[i][0];
                end = intervals[i][1];
                ind = i;
                cnt++;
            }
        }
        int res[][] = new int[cnt][];
        ind = 0;
        for(int i[]: intervals){
            if(i[0] != -1){
                res[ind] = i;
                ind++;
            }
        }
        return res;

    }
}