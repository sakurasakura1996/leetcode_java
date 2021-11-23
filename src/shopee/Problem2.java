package shopee;

import sun.awt.image.ImageWatched;

import java.util.*;

public class Problem2 {
    Set<String> retSet = new LinkedHashSet<>();  //竟然要求有序卧槽。。
//    public String[] permutation(String s) {
//        // write code here
//        List<String> ans = new LinkedList<>();
//        char[] chars = s.toCharArray();
//        boolean[] visited = new boolean[chars.length];
//        backtrace(ans, chars, visited, new StringBuilder());
//        String[] ret = new String[ans.size()];
//        for (int i = 0; i < ans.size(); i++) {
//            ret[i] = ans.get(i);
//        }
//        return ret;
//    }
//
//    public void backtrace(List<String> ans, char[] chars, boolean[] visited, StringBuilder sb ) {
//        if (sb.length() == chars.length) {
//            ans.add(sb.toString());
//            return;
//        }
//        for (int i = 0; i < chars.length; i++) {
//            if (visited[i]) {
//                continue;
//            }
//            visited[i] = true;
//            sb.append(chars[i]);
//            backtrace(ans, chars, visited, sb);
//            visited[i] = false;
//            sb.deleteCharAt(sb.length()-1);
//        }
//
//    }

    public String[] permutation(String s) {
        StringBuilder builder = new StringBuilder(s);
        dfs(builder, 0);
        return retSet.toArray(new String[0]);

    }

    public void dfs(StringBuilder stringBuilder, int index) {
        if (index >= stringBuilder.length()) {
            retSet.add(stringBuilder.toString());
            return;
        }
        for (int i = index; i < stringBuilder.length(); i++) {
            char temp = stringBuilder.charAt(index);
            stringBuilder.setCharAt(index, stringBuilder.charAt(i));
            stringBuilder.setCharAt(i, temp);

            dfs(stringBuilder, index+1);

            temp = stringBuilder.charAt(index);
            stringBuilder.setCharAt(index, stringBuilder.charAt(i));
            stringBuilder.setCharAt(i, temp);

        }

    }

    public static void main(String[] args) {
        String[] strings = new Problem2().permutation("a");
    }
}
