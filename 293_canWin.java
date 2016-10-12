//Ref: https://discuss.leetcode.com/topic/27282/theory-matters-from-backtracking-128ms-to-dp-0ms
//时间复杂度很高 但很好理解的backtracking,我们把一个++变--，那么下一个用户没有找到解法，我们就return true。backtracking还回来继续。
//T(N) = (N-2) * T(N-2) = (N-2) * (N-4) * T(N-4) ... = (N-2) * (N-4) * (N-6) * ... ~ O(N!!)


public class Solution {
    public boolean canWin(String s) {
        return win(s.toCharArray());
    }
    
    public boolean win(char[] arr){
        int len = arr.length;
        for(int i = 0; i < len-1; i++){
            if(arr[i] == '+' && arr[i+1] == '+'){
                arr[i] = '-';
                arr[i+1] = '-';
                boolean nextResult = win(arr); 
                arr[i] = '+';
                arr[i+1] = '+';
                if(!nextResult) return true;
            }
        }
        return false;
    }
}


//to bo continued!!!!!后面还需要研究下优化解。