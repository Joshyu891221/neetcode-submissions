class Solution {
    public int evalRPN(String[] tokens) {
        Integer res = Integer.parseInt(tokens[0]);
        Deque<Integer> stack = new ArrayDeque<>();
        Set<String> set = new HashSet<>(Set.of("*", "/", "+", "-"));

        stack.push(Integer.parseInt(tokens[0]));

        for (int i = 1; i < tokens.length; i++){
            if(set.contains(tokens[i])){
                if(tokens[i].equals("+")){
                    int a = stack.pop();
                    int b = stack.pop();
                    res = b + a;
                } else if(tokens[i].equals("-")){
                    int a = stack.pop();
                    int b = stack.pop();
                    res = b - a;
                } else if(tokens[i].equals("*")){
                    int a = stack.pop();
                    int b = stack.pop();
                    res = a * b;
                } else{
                    int a = stack.pop();
                    int b = stack.pop();
                    res = b / a;
                }
                stack.push(res);
            } else {
                stack.push(Integer.parseInt(tokens[i]));
            }
        }

        return res;
    }
}
