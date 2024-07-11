class Solution {
    Queue<Character> que;

    public void reverse(Stack<Character> stack){
        while(stack.peek() != '(')que.offer(stack.pop());
        stack.pop();
        while(!que.isEmpty())
            stack.push(que.poll());
    }
    public String reverseParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        que = new LinkedList<>();
        int n = s.length();
        for(int i = 0; i < n; i++){
            if(s.charAt(i) == ')')reverse(stack);
            else{
                stack.push(s.charAt(i));
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}