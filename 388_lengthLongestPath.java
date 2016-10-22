public class Solution {
    public int lengthLongestPath(String input) {
        if(input == null || input.length() == 0) return 0;
        String[] arr = input.split("\n");

        Stack<Integer> stack = new Stack<Integer>();
        int curLen = 0;
        int res = 0;

        for(String str: arr){
        	int level = getLevel(str);

        	while(level < stack.size()){ //This is while!!!!! not if, if can only remove one layer
        		curLen -= stack.pop();
        	} 

        	int len = str.replaceAll("\t","").length()+1; //everything start from \, so +1
        	curLen += len;
        	if(str.contains(".")){
        		res = Math.max(curLen-1, res); //-1 is removing the first root's \
        	}
        	
        	stack.push(len);
        }

        return res;
    }

    public int getLevel(String str){
    	String newStr = str.replaceAll("\t", ""); //replaceAll!!!! dont make mistake.
    	return str.length()- newStr.length();
    }
}