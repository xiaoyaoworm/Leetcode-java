public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<Integer>();
        for(int i = 0; i <= rowIndex; i++){
            for(int j = 1; j < result.size(); j++){
                result.set(j-1,result.get(j-1)+result.get(j));
            }
            result.add(0,1);
        }
        return result;
    }
}