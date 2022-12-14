import java.util.*;

public class LeaderBoard {

    static Set<String> leader = new HashSet<String>();
    public static Map<String, Integer> sortByValue(Map<String, Integer> unsortMap) {

        // 1. Convert Map to List of Map
        List<Map.Entry<String, Integer>> list =
                new LinkedList<Map.Entry<String, Integer>>(unsortMap.entrySet());

        // 2. Sort list with Collections.sort(), provide a custom Comparator
        //    Try switch the o1 o2 position for a different order
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2) {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        // 3. Loop the sorted list and put it into a new insertion order Map LinkedHashMap
        Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

    /*
    //classic iterator example
    for (Iterator<Map.Entry<String, Integer>> it = list.iterator(); it.hasNext(); ) {
        Map.Entry<String, Integer> entry = it.next();
        sortedMap.put(entry.getKey(), entry.getValue());
    }*/


        return sortedMap;
    }

    public static <K, V> String printMap(Map<K, V> map) {
        StringBuilder sb = new StringBuilder();
        int i=1;
        for (Map.Entry<K, V> entry : map.entrySet()) {
            sb.append(i+". " + "User : " + entry.getKey() + " Score : " + entry.getValue());
            sb.append(System.getProperty("line.separator"));
            i++;
        }
        return sb.toString();
    }
}
