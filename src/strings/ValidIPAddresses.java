package strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class ValidIPAddresses {

  public ArrayList<String> validIPAddresses(String string) {

    ArrayList<String> li = new ArrayList<>();

    for (int i = 1; i < Math.min(string.length(), 4); i++) {
      String[] strings = {"", "", "", ""};

      String firstPart = string.substring(0, i);
      if (!isValidIPAddress(firstPart)) continue;

      for (int j = i + 1; j < Math.min(string.length(), i + 4); j++) {
        String secondPart = string.substring(i, j);

        if (!isValidIPAddress(secondPart)) continue;

        for (int k = j + 1; k < Math.min(string.length(), j + 4); k++) {
          String thirdPart = string.substring(j, k);
          String fourthPart = string.substring(k);

          if (!isValidIPAddress(thirdPart) || !isValidIPAddress(fourthPart)) continue;

          strings[0] = firstPart;
          strings[1] = secondPart;
          strings[2] = thirdPart;
          strings[3] = fourthPart;
          li.add(String.join(".", strings));

        }
      }

    }
    return li;
  }

  private static boolean isValidIPAddress(String parts) {
    int ipPartInt = Integer.parseInt(parts);

    if (ipPartInt > 255) return false;
    return parts.length() == String.valueOf(ipPartInt).length();
  }

}
