public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(numRows == 0) return result;
        if(numRows>=1){
            List<Integer> list = new ArrayList<Integer>();
            list.add(1);
            result.add(list);
        }
        
        for(int i = 1; i < numRows; i++){
            List<Integer> previous = result.get(i-1);
            List<Integer> list = new ArrayList<Integer>();
            list.add(1);
            for(int j = 0; j < previous.size()-1;j++){
                list.add(previous.get(j)+previous.get(j+1));
            }
            list.add(1);
            result.add(list);
        }
        return result;
    }
}