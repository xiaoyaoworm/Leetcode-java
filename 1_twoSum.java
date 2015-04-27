//http://xiaoyaoworm.com/blog/2015/04/14/%E6%96%B0leetcode-hashtable-2-two-sum/

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        if(numbers == null || numbers.length < 2) return result;
        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
         
        for(int i = 0; i < numbers.length; i++){
            if(map.containsKey(target-numbers[i])){
                result[0] = map.get(target-numbers[i])+1;
                result[1] = i+1;
                break;
            } else {
                map.put(numbers[i], i);
            }
        }
        return result;
    }
}