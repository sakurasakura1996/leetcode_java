package 剑指offer.剑指offer5_替换空格;

public class Solution {
    public String replaceSpace(String s){
        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' '){
                ans += "%20";   //这里执行效率慢的原因是每执行一次 += 的话，我都要重新创建一个StringBuilder对象来append，这样太慢了啊。
            }else{
                ans += s.charAt(i);
            }
        }
        return ans;
    }
    public String replaceSpace2(String s){
        int length = s.length();
        char[] ans = new char[length * 3];
        int cur = 0;
        for (int i = 0; i < length; i++) {
            if(s.charAt(i) == ' '){
                ans[cur++] = '%';
                ans[cur++] = '2';
                ans[cur++] = '0';
            }else{
                ans[cur++] = s.charAt(i);
            }
        }
        String ret = new String(ans, 0, cur);
        String ret2 = String.valueOf(ans);
        ret.toString();
        // ans.toString();  //
        System.out.println(ret);
        System.out.println(ret2);
//        for (int i = 0; i < ret2.length(); i++) {
//            System.out.println(ret2.charAt(i));
//        }
        return ret;

    }
    String stringTest(){
        //这里主要理解下，java中， s += "hello"的实际逻辑是怎样的。
        String ans = "";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("hello");
        ans = stringBuilder.toString();
        System.out.println(ans);
        return ans;
    }
    void toStringTest(){
        //上面定义一个 char类型数组时，然后想把它变成 string，python里面是直接 "".join(ans)就可以了，这里我以为可以用 ans.toString()就可以了，结果不对啊
        char[] ans = {'a', 'b', 'c'};
        String ret = ans.toString();
        System.out.println(ret);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "We are happy.";
        String ans = solution.replaceSpace2(s);
        System.out.println(ans);
//        solution.toStringTest();
    }
}
