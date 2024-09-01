package arrays;

import java.util.Arrays;

public class TwoNumberSum {

  public static void main(String[] args) {
      int[] array = {3, 5, -4, 8, 11, 1, -1, 6};

    System.out.println(Arrays.toString(twoNumberSum(array, 10)));
  }

  public static int[] twoNumberSum(int[] array, int targetSum) {
    if(array.length == 0 || array.length == 1 ) return new int[]{};
    Arrays.sort(array);
    int start = 0;
    int end = array.length-1;
    while(start < end) {
      int target = array[start] + array[end];
      if(target == targetSum) {
        int[] result = new int[2];
        result[0] = array[start];
        result[1] = array[end];
        return result;
      } else if(target > targetSum) {
        end--;
      } else {
        start++;
      }
    }
    return new int[]{};
  }
}
