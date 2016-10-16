public class Solution {
    public int lastRemaining(int n) {
        boolean left = true;
        int step = 1; //be careful initial is 1, head will become from 1 to 2 later. 1+1
        int remain = n;
        int head = 1;
        while(remain>1){
            //Two situation head will move to next, 1)it is from left, 2) coming from right but right has odd numbers.
            if(left || remain%2 == 1) head = head+step; 
            //for every cycle, step doubled, remain become half, change direction.
            step*=2; 
            remain/=2; 
            left = !left;
        }
        return head;
    }
}