class Solution {
    public boolean checkValidString(String s) {
        Deque<Integer> leftStack = new ArrayDeque<>();
        Deque<Integer> starStack = new ArrayDeque<>();

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '('){
                leftStack.offerLast(i);
            }else if(c == '*'){
                starStack.offerLast(i);
            }else{
                if(!leftStack.isEmpty()){
                    leftStack.pollLast();
                }else if(!starStack.isEmpty()){
                    starStack.pollLast();
                }else{
                    return false;
                }
            }
        }

        while(!starStack.isEmpty()){
            if(leftStack.isEmpty()) return true;

            if(leftStack.peekFirst() < starStack.peekFirst()){
                leftStack.pollFirst();
            }
            
            starStack.pollFirst();
        }

        return leftStack.isEmpty();
    }
}
