package JianZhiOffer.剑指offer05_替换空格;

public class Solution {
    private static final String REPLACESTRING = "%20";
    public String replaceSpace(String s) {

        int length = s.length();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == ' ') {
                stringBuilder.append(REPLACESTRING);
            } else {
                stringBuilder.append(s.charAt(i));
            }
        }
        return stringBuilder.toString();
    }
}
