import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    static class Solution {
        public boolean isValid(String s) {
            Deque<Character> stack = new ArrayDeque<>();

            for (char c : s.toCharArray()) {
                switch (c) {
                    case '(':
                    case '{':
                    case '[':
                        stack.push(c);
                        break;
                    case ')':
                        if (stack.isEmpty() || stack.pop() != '(') return false;
                        break;
                    case '}':
                        if (stack.isEmpty() || stack.pop() != '{') return false;
                        break;
                    case ']':
                        if (stack.isEmpty() || stack.pop() != '[') return false;
                        break;
                }
            }
            return stack.isEmpty();
        }
    }
