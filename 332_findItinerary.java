public class Solution {
    public List<String> findItinerary(String[][] tickets) {
        List<String> curr = new ArrayList<String>();
        curr.add("JFK");
        boolean[] used = new boolean[tickets.length];
        
        Comparator<String[]> comparator = new Comparator<String[]>(){
            public int compare(String[] a, String[] b){
                if(!a[0].equals(b[0])) return a[0].compareTo(b[0]);
                else return a[1].compareTo(b[1]);
            }
        };
        Arrays.sort(tickets, comparator); // we need this sort to make it as lexical order
        
        if(dfs(tickets, 0, curr, used)){
            return curr;
        } else{
            return new ArrayList<String>();
        }
    }
    
    public boolean dfs(String[][] tickets, int count, List<String> curr, boolean[] used){
        if(count == tickets.length){
            return true;
        }
        for(int i = 0; i < tickets.length; i++){
            if(used[i]) continue;
            String start = curr.get(curr.size()-1);
            if(tickets[i][0].equals(start)){
                used[i] = true;
                curr.add(tickets[i][1]);
                //here if I find it already then return true, no need to coninue, because we sort it already.
                if(dfs(tickets, count+1, curr, used)) return true; 
                
                used[i] = false;
                curr.remove(curr.size()-1);//backtracking.
            } else continue;
        }
        return false;
    }
}