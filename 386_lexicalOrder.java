//好巧妙的一道题。三种情况：
//for example current = 45为例，n=600, next should be 1) 450 (45*10, if 45*10<= 600) or 2) 46(45+1, if last number is not 9) 
//After 1) and 2) it will reach (end is 9) or n, we need to divide by 10, then check how many 9 there. remove those 9, making left +1.
//For example, 499, next should be 4(remove 9 and 9) then add one become 5.
public class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<Integer>();
        int current = 1; //starting from 1
        for(int i = 1; i <= n; i++){ //need to add n numbers
            res.add(current);
            if(current*10 <= n){
                current*=10; //will add in next for loop
            }
            else if(current%10!= 9 && current+1 <= n){
                current+=1;
            } else{
                current = current/10; //iwe cannot add any more due to last is 9 now, we won't add but divide by 10, then add.
                while(current%10 == 9){ //if multiple 9 is in the end, go ahead to divide, then add.
                    current/=10;
                }
                current++;
            }
        }
        return res;
    }
}