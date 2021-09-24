import java.util.*;
import java.util.stream.Collectors;

public class MainApp {

    public static void main(String[] args) {
        Map<Integer, Integer> resultsB = new HashMap<>();
        Map<Integer, Integer> resultsC = new HashMap<>();
        Map<Integer, ArrayList<String>> resultsA = new HashMap<>();
        String[] strings = new String[]{"Amir", "Hatef", "Mehran", "Mojtaba", "Mohammad", "Ali", "Davood", "Reza", "Mohsen"};

        Arrays.stream(strings).forEach((element) -> {
            int length = element.length();
            if (resultsA.containsKey(length)) {
                List<String> cat = resultsA.get(length);
                cat.add(element);

            } else {
                ArrayList<String> cat = new ArrayList<>();
                cat.add(element);
                resultsA.put(length, cat);

            }


        });


        System.out.println(resultsA);
        Arrays.stream(strings).forEach((element) -> {
            int length = element.length();
            if (resultsB.containsKey(length)) {
                Integer count = resultsB.get(length);
                resultsB.put(length, count + 1);

            } else {
                resultsB.put(length, 1);

            }


        });

        System.out.println(resultsB);

        resultsA.keySet().forEach((element) -> {
            ArrayList<String> arr = resultsA.get(element);
            arr.add("x" + arr.size() + " time(s)");////adds here
            resultsC.put(element, arr.size());

        });
        System.out.println(resultsC);



        System.out.println(resultsA);

        System.out.println();
        System.out.println();
        System.out.println();

        Arrays.stream(strings).collect(Collectors.groupingBy(String::length)).forEach((elementLength,groupedByLen)-> {
            System.out.println(elementLength+" letters frequency "+groupedByLen.size());
            System.out.println(groupedByLen);
        });


    }

}
