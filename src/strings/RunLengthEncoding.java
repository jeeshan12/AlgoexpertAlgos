package strings;

public class RunLengthEncoding {


  public static void main(String[] args) {
    System.out.println(runLengthEncoding("AAAAAAAAAAAAABBCCCCDD"));
  }
  public static String runLengthEncoding(String string) {

    StringBuilder stringBuilder = new StringBuilder();
    char prevChar = string.charAt(0);
    int currentCount = 0;
    for (int i = 0; i < string.length(); i++) {
      char key = string.charAt(i);
      if (prevChar == key) {
        currentCount++;
      } else {
        int mod = currentCount > 9 ? currentCount % 9 : currentCount;
        while (currentCount > 9) {
          currentCount -= 9;
          stringBuilder.append(9 + String.valueOf(prevChar));
        }
        stringBuilder.append(mod + String.valueOf(prevChar));
        prevChar = key;
        currentCount = 1;
      }
    }
    int mod = currentCount > 9 ? currentCount % 9 : currentCount;
    while (currentCount > 9) {
      currentCount-= 9;
      stringBuilder.append(9 + String.valueOf(prevChar));
    }
    stringBuilder.append(mod + String.valueOf(prevChar));

    return stringBuilder.toString();
  }
}
