/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        return calWeight(nestedList, 1);        
    }
    
    public int calWeight(List<NestedInteger> nestedList, int depth){
        int res = 0;
        for(NestedInteger nestedInteger: nestedList){
            if(nestedInteger.isInteger()){
                res+=nestedInteger.getInteger() * depth;
            } else{
                res+= calWeight(nestedInteger.getList(), depth+1);
            }
        }
        return res;
    }
    
}