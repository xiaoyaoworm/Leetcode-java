import java.util.HashMap;

public class CustomMap {

    public void makeDiff(HashMap<String, String> first, HashMap<String, String> second){
        HashMap<String, String> firstCopy = new HashMap<>(first);
        HashMap<String, String> secondCopy = new HashMap<>(second);
        for(String firstKey: firstCopy.keySet()){
            if(second.containsKey(firstKey)){
                first.put(firstKey, second.get(firstKey));
            } else{
                first.remove(firstKey);
            }
        }
        for(String secondKey: secondCopy.keySet()){
            if(!first.containsKey(secondKey)){
                first.put(secondKey, secondCopy.get(secondKey));
            }
        }
    }

    public static void main(String[] args) {
        CustomMap cm = new CustomMap();
        HashMap<String, String> first = new HashMap<>();
        first.put("a", "1");
        first.put("b", "2");
        first.put("c", "3");
        HashMap<String, String> second = new HashMap<>();
        second.put("d", "1");
        second.put("e", "2");
        second.put("a", "4");

        cm.makeDiff(first, second);
        System.out.println("Print out first.");
        for(String key: first.keySet()){
            System.out.println(key +" : "+first.get(key));
        }
        System.out.println("Print out second.");
        for(String key: second.keySet()){
            System.out.println(key +" : "+second.get(key));
        }
    }
}
