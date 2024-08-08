package strings;

public class LongestPalindromicSubstring {

  public static void main(String[] args) {
    System.out.println(longestPalindromicSubstring("abaxyzzyxf"));
  }

  public static String longestPalindromicSubstring(String str) {

    if(str.length() == 1 || str.isEmpty()) return str;

    int[] stringIndexes = {0, 1};

    for (int index = 1; index < str.length(); index++) {
      //aba
      int[] odd = findPalindromeBetween(str, index - 1, index + 1);
      int[] even = findPalindromeBetween(str, index - 1, index);

      int[] greaterBetweenTwo = odd[1] - odd[0] > even[1] - even[0] ? odd : even;
      stringIndexes = stringIndexes[1] - stringIndexes[0] > greaterBetweenTwo[1] - greaterBetweenTwo[0] ? stringIndexes : greaterBetweenTwo;

    }
    return  str.substring(stringIndexes[0], stringIndexes[1] + 1);

  }

  public static int[] findPalindromeBetween(String str, int left, int right) {
    while (left >= 0 && right < str.length()) {
      if (str.charAt(left) != str.charAt(right)) break;
      left--;
      right++;
    }

    return new int[]{
        left + 1,
        right - 1
    };
  }

}
