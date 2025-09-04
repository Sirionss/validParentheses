# Valid Parentheses

## Problem Description
Given a string `s` containing just the characters `'('`, `')'`, `'{'`, `'}'`, `'['` and `']'`, determine if the input string is valid.

An input string is valid if:
1. Open brackets must be closed by the same type of brackets.
2. Open brackets must be closed in the correct order.
3. Every close bracket has a corresponding open bracket of the same type.

**Example 1:**
```
Input: s = "()"
Output: true
```

**Example 2:**
```
Input: s = "()[]{}"
Output: true
```

**Example 3:**
```
Input: s = "(]"
Output: false
```

**Example 4:**
```
Input: s = "([])"
Output: true
```

**Example 5:**
```
Input: s = "([)]"
Output: false
```

**Constraints:**
- `1 <= s.length <= 10^4`
- `s` consists of parentheses only `'()[]{}'`.

## Solution Approach
This solution uses the **Stack data structure** with **unified switch-case pattern**:

1. **Stack (LIFO) Strategy**: Use ArrayDeque as a stack to track opening brackets in Last-In-First-Out order
2. **Unified Switch Pattern**: Handle both opening and closing brackets in a single switch statement for better performance
3. **Enhanced For Loop**: Use `toCharArray()` to avoid multiple `charAt()` calls and improve efficiency
4. **Immediate Validation**: Check stack conditions and bracket matching in one operation for closing brackets
5. **Final Stack Check**: Ensure all opening brackets have been matched by checking if stack is empty

### Algorithm Steps:
1. Initialize an ArrayDeque as a stack to store opening brackets
2. Iterate through each character in the string using enhanced for loop
3. For opening brackets `(`, `{`, `[`: push them onto the stack
4. For closing brackets `)`, `}`, `]`: 
   - Check if stack is empty (no matching opening bracket) → return false
   - Pop the top element and verify it matches the current closing bracket → return false if mismatch
5. After processing all characters, return true if stack is empty (all brackets matched)

## Code Implementation
```java
import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        
        for (char c : s.toCharArray()) { // Enhanced for loop for better performance
            switch (c) {
                case '(':    // Opening brackets
                case '{':   
                case '[':
                    stack.push(c);
                    break;
                case ')':    // Closing brackets with immediate validation
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
        return stack.isEmpty(); // All brackets must be matched
    }
}
```

## Complexity Analysis
- **Time Complexity**: O(n) where n is the length of the input string
- **Space Complexity**: O(n) in the worst case when all characters are opening brackets

## Performance Results
![LeetCode Performance](https://img.shields.io/badge/Runtime-2ms-brightgreen) ![LeetCode Performance](https://img.shields.io/badge/Beats-96.61%25-brightgreen)

![LeetCode Performance](https://img.shields.io/badge/Memory-41.75MB-green) ![LeetCode Performance](https://img.shields.io/badge/Beats-69.96%25-green)

- **Runtime**: 2 ms - Beats 96.61% of Java submissions
- **Memory Usage**: 41.75 MB - Beats 69.96% of Java submissions

## Key Optimizations
1. **ArrayDeque over Stack**: Using modern `ArrayDeque` instead of legacy `Stack` class for better performance (no synchronization overhead)
2. **Unified Switch Statement**: Single switch handles all bracket types, reducing branching and improving readability
3. **Enhanced For Loop**: Using `toCharArray()` eliminates repeated `charAt()` method calls
4. **Immediate Return Strategy**: Early exit on first invalid condition prevents unnecessary processing
5. **Combined Condition Checking**: Stack emptiness and bracket matching verified in single expressions

## Alternative Approaches
1. **Separate If-Else Logic**: Use separate if statements for opening and closing brackets (more verbose but easier to understand)
2. **HashMap Approach**: Use HashMap to store bracket pairs for more extensible solution
3. **Character Array Stack**: Use primitive char array instead of ArrayDeque for maximum performance
4. **String Replacement**: Repeatedly remove valid bracket pairs until string is empty (less efficient)

## Why Stack is Perfect for This Problem
- **LIFO Nature**: Last opened bracket must be first to close - exactly how stack works
- **Nested Structure**: Brackets can be nested, and stack naturally handles this hierarchy
- **Order Validation**: Stack ensures correct opening/closing order automatically
- **Memory Efficiency**: Only stores unmatched opening brackets

## LeetCode Links
- **Problem**: [20. Valid Parentheses](https://leetcode.com/problems/valid-parentheses/)
- **Solution**: [My Submission](https://leetcode.com/problems/valid-parentheses/submissions/)

## Tags
`Stack` `String` `Data Structure` `Bracket Matching` `LIFO` `ArrayDeque`
