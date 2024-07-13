class Node{
    int h, p;
    char d;
    Node(){}
    Node(int p, int h, char d){
        this.p = p;
        this.h = h;
        this.d = d;
    }
    public String toString(){
        return "["+p+", "+h+", "+d+"]";
    }
}
class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        Node arr[] = new Node[n];
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            arr[i] = new Node(positions[i], healths[i], directions.charAt(i));
            map.put(positions[i], i);
        }
        Arrays.sort(arr, (a, b)-> a.p - b.p);
        
        Stack<Node> stack = new Stack<>();
        int i = 0;
        while(i < n){
            if(stack.isEmpty()){
                stack.push(arr[i]);
            }
            else if(arr[i].d == stack.peek().d){
                stack.push(arr[i]);
            }
            else if(arr[i].d == 'R' && stack.peek().d == 'L'){
                stack.push(arr[i]);
            }
            else{
                while(!stack.isEmpty()){
                    Node x = stack.peek();
                    if(x.d == 'R' && arr[i].d == 'L'){
                        if(x.h < arr[i].h){
                            healths[map.get(x.p)] = -1;
                            stack.pop();
                            arr[i].h -= 1;
                            healths[map.get(arr[i].p)] -= 1;
                            if(arr[i].h == 0){
                                healths[map.get(arr[i].p)] = -1;
                                break;
                            }
                        }else if(x.h > arr[i].h){
                            x.h -= 1;
                            healths[map.get(x.p)] -= 1;
                            healths[map.get(arr[i].p)] = -1;
                            if(x.h == 0){
                                healths[map.get(x.p)] = -1;;
                                stack.pop();
                            }
                            break;
                        }else{
                            healths[map.get(arr[i].p)] = -1;
                            healths[map.get(x.p)] = -1;
                            stack.pop();
                            break;
                        }
                    }else{
                        stack.push(arr[i]);
                        break;
                    }
                }
            }
            i++;
        }
        List<Integer> ans = new ArrayList<>();
        for(i = 0; i < n; i++){
            if(healths[i] > 0)ans.add(healths[i]);
        }
        return ans;

    }
}

/**
[17,24,18]
[1,39,30]
"LLR"
 */