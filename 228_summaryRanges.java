public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<String>();
        if(nums == null || nums.length == 0) return result;
        
        int i = 0;
        while(i < nums.length){
            int j = i+1;
            int start = i;
            int end = i;
            while(j < nums.length){
                if(nums[j] == nums[i]+1){
                    i++;
                    j++;
                    end++;
                } else{
                    break;
                }
            }
            if(start == end){
                result.add(String.valueOf(nums[start]));
            } else{
                StringBuffer sb = new StringBuffer();
                sb.append(String.valueOf(nums[start]));
                sb.append("->");
                sb.append(String.valueOf(nums[end]));
                result.add(sb.toString());
            }
            i++;
        }
        return result;
    }
}