class Solution {
    public boolean isValid(String s) {
        Deque<Character> res = new ArrayDeque<>();
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        for (char c: s.toCharArray()){
            if (c == '('||c == '['||c == '{'||res.isEmpty()){
                res.push(c);
                continue;
            }
            if (c == ')'||c == ']'||c == '}'){
                if (res.peek() == map.get(c)){
                    res.pop();
                }else{
                    return false;
                }
            }
        }
        return res.isEmpty();

    }
}
