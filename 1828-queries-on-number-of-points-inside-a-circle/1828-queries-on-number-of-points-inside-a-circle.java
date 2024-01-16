class Solution {
    public double getDistance(int x1, int y1, int x2, int y2){
        int a = ((x2-x1)*(x2-x1)) + ((y2-y1)*(y2-y1));
        return Math.sqrt(a);
    }
    public int[] countPoints(int[][] points, int[][] queries) {
        int x = 0;
        int ans[] = new int[queries.length];
        for(int[] i: queries){
            for(int[] j: points){
                double dist = getDistance(j[0], j[1], i[0], i[1]);
                // System.out.print(dist+" ");
                if(dist <= i[2])ans[x]++;
            }
            x++;
        }
        return ans;
    }
}