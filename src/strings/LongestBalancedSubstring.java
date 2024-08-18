package strings;

import java.util.Stack;

public class LongestBalancedSubstring {
  public int longestBalancedSubstring(String string) {
    int max = 0;
    Stack<Integer> st = new Stack<>();
    st.push(-1);
    for (int i = 0; i < string.length(); i++) {
      char ch = string.charAt(i);
      if (ch == '(') {
        st.push(i);
      }else {
        if (st.size() != 1) {
          st.pop();
          max = Math.max(max, i - st.peek());
        } else {
          st.pop();
          st.push(i);
        }
      }
    }
    return max;
  }

  public int longestBalancedSubstring2(String string) {
    int openParentheses = 0;
    int closedParentheses = 0;
    int max = 0;
    for (int i = 0; i < string.length(); i++) {
      char ch = string.charAt(i);
      if (ch == '(') openParentheses++;
      else if (ch == ')') closedParentheses++;
      if (openParentheses == closedParentheses) max = Math.max(max, closedParentheses*2);
      if (closedParentheses > openParentheses) {
        openParentheses = closedParentheses = 0;
      }
    }

    openParentheses = closedParentheses = 0;
    for (int i = string.length()-1; i >=0; i--) {
      char ch = string.charAt(i);
      if (ch == '(') openParentheses++;
      else if (ch == ')') closedParentheses++;
      if (openParentheses == closedParentheses) max = Math.max(max, closedParentheses*2);
      if (closedParentheses < openParentheses) {
        openParentheses = closedParentheses = 0;
      }
    }

    return max;
  }
}
