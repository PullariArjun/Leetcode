class Solution {
    public String simplifyPath(String path) {
        String arr[] = path.split("/");
        System.out.println(Arrays.toString(arr));
        Stack<String> st = new Stack<>();
        int n = arr.length;
        for(String s: arr){
            if(s.isEmpty())continue;
            else if(s.equals("."))continue;
            else if(s.equals("..")){
                if(!st.isEmpty())st.pop();
            }
            else{
                st.push(s);
            }
        }
        System.out.println(st);
        StringBuilder sb = new StringBuilder();
        if(st.isEmpty())return "/";
        while(!st.isEmpty()){
            sb.insert(0, "/"+st.pop());
        }
        return sb.toString();

    }
}