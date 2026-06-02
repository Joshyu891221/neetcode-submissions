class Solution {

    public String encode(List<String> strs) {
        String res =  "";
        for (String str : strs){
            res += str.length() + "|" + str;
        }
        return res;
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int index = 0;
        while (index < str.length()){
            int split_index = str.indexOf("|", index);
            int len = Integer.parseInt(str.substring(index, split_index));
            index = split_index + 1;
            res.add(str.substring(index, index + len));
            index += len;

        }
        return res;
    }
}