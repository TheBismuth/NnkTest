import java.util.*;
/*
Тестовое задание АО «ННК»
@author Токаренко Давид
@version 1.0
*/

public class NnkTest {

    private final static String sourse = "Своенравная принцесса считает что по ее велению в зимнюю стужу могут расцвести" +
            " подснежники поэтому она издает указ щедро наградить любого кто пpинесет ей заветные цветы";
    private static Map<String, List<String>> dictionary = new TreeMap<>();

    private void SortText(String str) {
        Arrays.stream(str.trim().split(" "))
                .map(String::toLowerCase)
                .distinct()
                .forEach(s -> {
                    String letter = s.substring(0, 1);
                    List<String> list = new ArrayList<>();
                    if (!dictionary.containsKey(letter)) {
                        list.add(s);
                        dictionary.put(letter, list);
                    } else {
                        dictionary.get(letter).add(s);
                    }
                });
        for (Map.Entry<String, List<String>> entry : dictionary.entrySet()) {
            entry.getValue().sort((o1, o2) -> Integer.compare(o2.length(), o1.length()));
        }
        System.out.println(dictionary);
    }

    public static void main(String[] args) {
        NnkTest test = new NnkTest();
        test.SortText(sourse);
    }
}

