class Pair{
    public char character;
    public int freq;
    public Pair(){}
    public Pair(char character, int freq){
        this.character = character;
        this.freq = freq;
    }
}
class Solution {
    public String removeSubstring(String s, int k) {
        Stack<Pair> stack = new Stack<>();
        for(char c: s.toCharArray()){
            if(stack.isEmpty()){
                stack.push(new Pair(c, 1));
            }else{
                if(stack.peek().character == c)
                    stack.peek().freq = stack.peek().freq + 1;
                else stack.push(new Pair(c, 1));
                if(stack.peek().character == ')' && stack.peek().freq == k && stack.size() > 1){
                    Pair closed = stack.pop();
                    Pair open  = stack.pop();
                    if(open.freq > k){
                        open.freq -= k;
                        stack.push(open);
                    }else if(open.freq < k){
                        stack.push(open);
                        stack.push(closed);
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            Pair pair = stack.pop();
            for(int i = 0; i < pair.freq; i++)sb.append(pair.character);
        }
        return sb.reverse().toString();
    }
}