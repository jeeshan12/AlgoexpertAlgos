package arrays;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ValidSubsequence {


  public static void main(String[] args) {
    System.out.println(isValidSubsequence(Arrays.asList(5, 1, 22, 25, 6, -1, 8, 10), Arrays.asList(1, 6, -1, 10)));
  }

  public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
    int arrayLength = array.size();
    int seqLength = sequence.size();
    int i = 0;
    int j = 0;
    while (i < arrayLength && j < seqLength) {
      if (Objects.equals(array.get(i), sequence.get(j))) {
        j++;
      }
      i++;
    }
    return j == seqLength;
  }
}
