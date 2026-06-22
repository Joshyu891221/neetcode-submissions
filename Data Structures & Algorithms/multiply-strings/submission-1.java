class Solution {
    public String multiply(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        if( num1.equals("0") || num2.equals("0")) return "0";
        int[] pos = new int[m + n];

        for(int i = m - 1; i >= 0; i--){
            for(int j = n - 1; j >= 0; j--){
                int multi = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');

                int singleDigit = i + j + 1;
                int doubleDigit = i + j;

                int sum = pos[singleDigit] + multi;

                pos[singleDigit] = sum % 10;
                pos[doubleDigit] += sum / 10;
            
            }
            
        }

        StringBuilder sb = new StringBuilder();
        for(int p : pos){
            if(sb.length() == 0 && p == 0) continue;
            sb.append(p);
        }
        return sb.toString();
    }
}
