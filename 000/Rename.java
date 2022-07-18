import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Rename {

    private static class Employee{
        String name;
        int rating;
        List<String> children;

        public Employee(String name, int rating, List<String> children){
            this.name = name;
            this.rating = rating;
            this.children = children;
        }
    }

    private static double avg = 0.0;
    private static String name = null;

    public static void main(String[] args) {
        Rename re = new Rename();
        List<Employee> employees = new ArrayList<>();
        Employee A = new Employee("A", 5, new ArrayList<>(Arrays.asList(new String[]{"B", "C"})));
        Employee B = new Employee("B", 3, new ArrayList<>());
        Employee C = new Employee("C", 2, new ArrayList<>(Arrays.asList(new String[]{"D", "E"})));
        Employee D = new Employee("D", 4, new ArrayList<>());
        Employee E = new Employee("E", 10, new ArrayList<>());
        employees.add(A);
        employees.add(B);
        employees.add(C);
        employees.add(D);
        employees.add(E);
        re.getEmployeeWithHighestRatingAverage(employees);
    }

    public String getEmployeeWithHighestRatingAverage(List<Employee> employees) {
        HashMap<String, Employee> employeeMap = new HashMap<>();
        for (Employee e : employees) {
            employeeMap.put(e.name, e);
        }
        HashMap<Employee, int[]> mapRatingCount = new HashMap<>();
        for(Employee employee: employees){
            dfs(employees.get(0), employeeMap, mapRatingCount);
        }
        System.out.println("avg is "+avg);
        System.out.println("This root is "+ name);

        return name;
    }


    //Return rating: count pair.
    private int[] dfs(Employee root, HashMap<String, Employee> employeeMap, HashMap<Employee, int[]> mapRatingCount){
        if(mapRatingCount.containsKey(root)) return mapRatingCount.get(root);
        if(root.children == null){
            if(root.rating > avg){
                avg = root.rating;
                name = root.name;
            }
            int[] cur = new int[]{root.rating, 1};
            mapRatingCount.put(root, cur);
            return cur;
        }

        int[] together = new int[]{root.rating, 1};
        List<String> childrenNames = root.children;
        for(String childName: childrenNames){
            Employee child = employeeMap.get(childName);
            int[] childPair = dfs(child, employeeMap, mapRatingCount);
            together[0] += childPair[0];
            together[1] += childPair[1];
        }

        mapRatingCount.put(root, together);
        System.out.println("calculating: "+root.name + ", rating is" + (double)together[0]/together[1]);

        if((double)together[0]/together[1] > avg){
            avg = together[0]/together[1];
            name = root.name;
        }
        return together;
    }
}
