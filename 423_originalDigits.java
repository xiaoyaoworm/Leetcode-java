//cheating solution because we know that all input are valid. so we find all unique characters to count how many that number there.
//then append everything.
public class Solution {
    public String originalDigits(String s) {
        int[] count = new int[10];
        for(char c: s.toCharArray()){
            if(c == 'z') count[0]++;
            if(c == 'w') count[2]++;
            if(c == 'u') count[4]++;
            if(c == 'x') count[6]++;
            if(c == 'g') count[8]++;
            if(c == 'o') count[1]++;
            if(c == 'r') count[3]++;
            if(c == 'v') count[5]++;
            if(c == 's') count[7]++;
            if(c == 'i') count[9]++;
        }
        count[1] -= (count[0]+count[2]+count[4]);
        count[3] -= (count[4]+count[0]);
        count[7] -= count[6];
        count[5] -= count[7];
        count[9] -= (count[5]+count[6]+count[8]);
        
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < 10; i++){
            while(count[i]>0){
                sb.append(i);
                count[i]--;
            }
        }
        return sb.toString();
    }
}


//Stackoverflow error: when doing the copy if the string is huge, this will show the error.!!!
//General solution.
public class Solution {
    public String originalDigits(String s) {
        String[] nums = new String[]{"zero","one","two","three","four","five","six","seven","eight","nine"};
        int[] digits = new int[]{0,1,2,3,4,5,6,7,8,9};
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(char c: s.toCharArray()){
            if(map.containsKey(c)) map.put(c, map.get(c)+1);
            else map.put(c,1);
        }

        String[] res = new String[1];
        dfs(map, "", 0, nums, digits, res);
        return res[0];
    }


    public boolean dfs(HashMap<Character, Integer> map, String current, int index, String[] nums, int[] digits, String[] res){
        if(map.size() == 0){
            res[0] = current;
            return true;
        }
        if(index > 10) return false;


        for(int i = index; i < 10; i++){
            String num = nums[i];
            HashMap<Character, Integer> copy = (HashMap)map.clone();
            int j = 0;
            while(j < num.length()){
                char c = num.charAt(j);
                if(!copy.containsKey(c) || copy.get(c) == 0) break;
                if(copy.get(c) == 1) copy.remove(c);
                else copy.put(c,copy.get(c)-1);
                j++;
            }
            if(j == num.length()){
                if(dfs(copy, current+digits[i], i, nums,digits, res)) return true;
            }
        }
        return false;
    }
}