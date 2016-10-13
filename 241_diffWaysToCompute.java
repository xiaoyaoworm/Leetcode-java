public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new LinkedList<Integer>();
        for(int i = 0; i < input.length(); i++){
            char c = input.charAt(i);
            if(c == '+' || c=='-'|| c=='*'){
                String part1 = input.substring(0,i);
                String part2 = input.substring(i+1);
                List<Integer> list1 = diffWaysToCompute(part1);
                List<Integer> list2 = diffWaysToCompute(part2);
                for(int n1: list1){
                    for(int n2: list2){
                        if(c == '+') res.add(n1+n2);
                        else if(c == '-') res.add(n1-n2);
                        else if(c == '*') res.add(n1*n2);
                    }
                }
            } 
        }
        if(res.size() ==0) res.add(Integer.valueOf(input));//dont forget!!!!!!!!
        return res;
    }
}