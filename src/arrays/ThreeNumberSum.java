package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeNumberSum {
  public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
    if(array.length < 3) return new ArrayList<>();
    Arrays.sort(array);
    List<Integer[]> li = new ArrayList<>();
    for (int i = 0; i < array.length - 2; i++) {
      int start = i + 1;
      int end = array.length - 1;
      while (start < end) {
        int sum = array[i] + array[start] + array[end];
        if (sum == targetSum) {
          li.add(new Integer[]{array[i], array[start], array[end]});
          start++;
          end--;
        } else if (sum > targetSum) {
          end--;
        } else {
          start++;
        }
      }
    }
    return li;
  }
}
