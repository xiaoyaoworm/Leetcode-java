public class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Comparator<int[]> comparator = new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                if(a[0] == b[0]) return a[1]-b[1];
                return b[0]-a[0];
            }
        };
        Arrays.sort(people, comparator); //Sort the tallest at first(DESC) if same height, sort based on k(ASC)
        
        List<int[]> list = new LinkedList<int[]>();
        for(int[] p: people){
            list.add(p[1], p);//Very smart, p[1] is the index position of linkedlist.
        }
        int[][] res = new int[people.length][2];
        return list.toArray(res); // Attention here!! how to convert List of int[] to int[][]
    }
}