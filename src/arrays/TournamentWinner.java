package arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TournamentWinner {
  public static String tournamentWinner(
      ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {
    int maxScore = -1;
    String team = "";
    Map<String, Integer> map = new HashMap<>();

    for (int i = 0; i < results.size(); i++) {
      ArrayList<String> strings = competitions.get(i);
      int num = results.get(i) == 0 ? 1 : 0;
      String lang = strings.get(num);
      if (map.containsKey(lang)) {
        map.put(lang, map.get(lang) + 3);
      }else {
        map.put(lang, 3);

      }

      if (map.get(lang) > maxScore) {
        maxScore = map.get(lang);
        team = lang;
      }

    }
    return team;
  }
}
