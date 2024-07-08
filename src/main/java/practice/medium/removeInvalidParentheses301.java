package practice.medium;

import java.util.*;

public class removeInvalidParentheses301 {

    public List<String> removeInvalidParentheses(String s) {
        // 当前层的
        Set<String> level = new HashSet<>();
        level.add(s);
        while (true) {
            // 过滤不合法的
            List<String> valid  = new LinkedList<>();
            for(String item : level) {
                if (isValid(item)) {
                    valid.add(item);
                }
            }
            if (valid.size() > 0) return valid;
            // 下一层
            Set<String> nextLevel = new HashSet<>();
            for (String item : level) {
                // 每次移除一个括号
                for (int i = 0; i < item.length(); i++) {
                    if (item.charAt(i) == '(' || item.charAt(i) == ')') {
                        nextLevel.add(item.substring(0, i) + item.substring(i + 1));
                    }
                }
            }
            level = nextLevel;
            // 全部括号都被移除依然不符合，跳出循环
            if (level.size() == 0) return new ArrayList<>();
        }
    }

    /**
     * 计数法判断括号是否合法
     *
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        int cnt = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                cnt++;
            } else if (c == ')') {
                cnt--;
            }
            // 右边括号比左括号多，不合法
            if (cnt < 0) return false;
        }
        // 最后左右括号不相等，也不合法
        return cnt == 0;
    }
}
