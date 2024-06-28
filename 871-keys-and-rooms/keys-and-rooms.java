class Solution {
    public void fun(List<List<Integer>> rooms, boolean arr[], int ind){
        List<Integer> lst = rooms.get(ind);
        for(int i = 0; i < lst.size(); i++){
            if(arr[lst.get(i)])continue;
            arr[lst.get(i)] = true;
            fun(rooms, arr, lst.get(i));
        }
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean arr[] = new boolean[n];
        arr[0] = true;
        fun(rooms, arr, 0);
        for(boolean b: arr){
            if(!b)return b;
        }
        return true;
    }
}