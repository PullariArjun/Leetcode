class Solution {
    public boolean fun(char c){
        return (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U' || 
                c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
    }
    public boolean halvesAreAlike(String s) {
        char arr[] = s.toCharArray();
        int v1 = 0, v2 = 0, i = 0, j = arr.length/2;
        if(arr.length%2 != 0)return false;
        while(i < arr.length/2){
            if(fun(arr[i]))v1++;
            if(fun(arr[j]))v2++;
            i++;
            j++;
        }
        return v1 == v2;
    }
}