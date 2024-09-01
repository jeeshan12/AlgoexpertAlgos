package arrays;

import java.util.Arrays;

public class SortedSquaredArray {

  public static void main(String[] args) {
    int[] array = {1, 2, 3, 5, 6, 8, 9};
    System.out.println(Arrays.toString(sortedSquaredArray(array)));
  }
  public static int[] sortedSquaredArray(int[] array) {
    if (array.length == 0) return new int[]{};

    int[] nums = new int[array.length];

    int start = 0;

    int k = nums.length -1;

    int end = array.length -1;


    while (start <= end) {
      if (Math.abs(array[start]) >= Math.abs(array[end])) {
        nums[k--] = array[start]*array[start];
        start++;
      } else  {
        nums[k--] = array[end]*array[end];
        end--;
      }
    }
    return nums;
  }
}
