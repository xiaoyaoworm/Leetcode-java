public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<Integer>();
        if(n == 0) {
            list.add(0);
            return list;
        }
        
        List<Integer> temp = grayCode(n-1);
        list = new ArrayList<Integer>(temp);
        for(int i = list.size()-1; i>=0; i--){
            list.add((int)Math.pow(2,n-1)+temp.get(i));
        }
        return list;
        
    }
}