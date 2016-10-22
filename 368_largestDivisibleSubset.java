//Sort
//Find the maximum length of all subsets
//locate the largest one, find all subsets element
//O(n^2)
public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);//dont forget!!!!
        List<Integer> res = new ArrayList<Integer>();
        if(nums == null || nums.length == 0) return res;

        //dp is used to save this number's subset length;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for(int i = 1; i < nums.length; i++){
        	for(int j = 0; j < i; j++){
        		if(nums[i] % nums[j] == 0) dp[i] = Math.max(dp[i], dp[j]+1);
        	}
        }

        //find the maximum length of all subsets
        int maxIndex = 0;
        for(int i = 1; i < nums.length; i++){
        	if(dp[i] > dp[maxIndex]) maxIndex = i;
        }

        //find nums[maxIndex]'s subsets element
        int number = dp[maxIndex];
        int temp = nums[maxIndex];
        for(int i = maxIndex; i >= 0; i--){ // must use DESC, so that we can use dp[maxIndex] and -- everytime to find all
            if(temp % nums[i] == 0 && dp[i] == number){
                res.add(nums[i]);
                temp = nums[i];
                number--;
            }
        }
        return res;
    }
}