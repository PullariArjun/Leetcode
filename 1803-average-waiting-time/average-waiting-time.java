class Solution {
    public double averageWaitingTime(int[][] arr) {
        long cheffFreeTime = arr[0][1] + arr[0][0];
        long sum = cheffFreeTime - arr[0][0];
        for(int i = 1; i < arr.length; i++){
            if(cheffFreeTime <= arr[i][0])cheffFreeTime = (arr[i][0] + arr[i][1]);
            else cheffFreeTime += arr[i][1];
            sum += (cheffFreeTime - arr[i][0]);
        }
        System.out.println(sum);
        return (double)sum/arr.length;
        
    }
}