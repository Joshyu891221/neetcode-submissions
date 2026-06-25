class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        Map<Character, Character> map = new HashMap<>();
        map.put(']', '[');
        map.put('}', '{');
        map.put(')', '(');

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            if(c == '{' || c == '(' || c == '['){
                stack.offerLast(c);
            }else{
                if(stack.isEmpty()) return false;

                if(map.get(c) != stack.peekLast()){
                    return false;
                }else{
                    stack.pollLast();
                }
            }
        }

        return stack.isEmpty();
    }
}
