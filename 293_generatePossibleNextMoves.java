public class Solution {
    public List<String> generatePossibleNextMoves(String s) {
    	List<String> res = new ArrayList<String>();
        if(s == null || s.length()<= 1) return res;

        int i = 0;
        while(i < s.length()-1){
        	char[] arr = s.toCharArray();
        	char first = s.charAt(i);
        	char second = s.charAt(i+1);
        	if(first == '+' && second == '+') {
        		arr[i] = '-';
        		arr[i+1] = '-';
        		res.add(new String(arr));
        	}
        	i++;
        }
        return res;
    }
}