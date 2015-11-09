public class Solution {
    HashSet<Integer> set = new HashSet<Integer>();
    public boolean isHappy(int n) {
        if(n == 1) return true;
        if(set.contains(n)) return false;
        set.add(n);
        int sum = 0;
        while(n!=0){
            int digit = n%10;
            n = n/10;
            sum+=digit*digit;
        }
        return isHappy(sum);
    }
}