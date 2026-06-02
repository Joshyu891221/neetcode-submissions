class Solution {
    public boolean isValid(String s) {
        Deque<Character> res = new ArrayDeque<>();
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        for (char c: s.toCharArray()){
            if (c == '('||c == '['||c == '{'){
                res.push(c);
            } else{
                if (!res.isEmpty()&&res.peek() == map.get(c)){
                    res.pop();
                }else{
                    return false;
                }
            }
        }
        return res.isEmpty();

    }
}
