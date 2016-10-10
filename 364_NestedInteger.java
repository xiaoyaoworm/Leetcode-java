/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class Solution {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        return dfs(nestedList, 0);
    }
    
    public int dfs(List<NestedInteger> nestedList, int sum){
        List<NestedInteger> nextList = new ArrayList<NestedInteger>();
        int nextSum = 0;
        for(NestedInteger nestedInteger: nestedList){
            if(nestedInteger.isInteger()){
                sum+=nestedInteger.getInteger(); // we notice that the previous add will add in all level later, which is same as add one time this value * level.
            } else{
                nextList.addAll(nestedInteger.getList());
            }
        }
        if(!nextList.isEmpty()) nextSum = dfs(nextList, sum);
        else nextSum = 0;
        return sum+nextSum;
    }
}