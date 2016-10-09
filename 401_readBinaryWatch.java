//注意如果dfs里面在for循环里面用+=或++这种，要backtracking回来，否则，就用 sum+arr[i]在dfs里面传递，这样不会改变原始值。！！！！

public class Solution {
    public List<String> readBinaryWatch(int num) {
        int[] hourArr = new int[]{8,4,2,1};
        int[] minArr = new int[]{32,16,8,4,2,1};
        
        List<String> res = new ArrayList<String>();
        for(int i = 0; i <= num; i++){
            List<Integer> hList = generate(hourArr, i);
            List<Integer> mList = generate(minArr, num-i);
            for(int h: hList){
                if(h >= 12) continue;
                for(int m: mList){
                    if(m>= 60) continue;
                    res.add(h+":"+ (m<10? "0"+m: m));//注意这里要括弧！！！(m<10? "0"+m: m)
                }
            }
        }
        return res;
    }
    
    public List<Integer> generate(int[] arr, int i){
        List<Integer> res = new ArrayList<Integer>();
        dfs(arr, i, 0, 0, res);
        return res;
    }
    
    public void dfs(int[] arr, int count, int pos, int sum, List<Integer> res){
        if(count == 0){
            res.add(sum);
            return;
        }
        for(int i = pos; i < arr.length; i++){
            dfs(arr, count-1, i+1, sum+arr[i], res);//!!看这里，比对下面的！！！
        }
    }
}


//稍微复杂点的解法。但很清晰。注意backtracking！！！
public class Solution {
    public List<String> readBinaryWatch(int num) {
        int[] hourArr = new int[]{8,4,2,1};
        int[] minArr = new int[]{32,16,8,4,2,1};
        
        List<String> res = new ArrayList<String>();
        
        for(int i = 0; i <= num; i++){
            List<Integer> hList = generate(hourArr, i);
            List<Integer> mList = generate(minArr, num-i);
            for(int h: hList){
                if(h >= 12) continue;
                for(int m: mList){
                    if(m >= 60) continue;
                    StringBuffer sb = new StringBuffer();
                    sb.append(h).append(":");
                    if(m < 10) sb.append("0");
                    sb.append(m);
                    res.add(sb.toString());
                }
            }
        }
        return res;
        
    }
    
    public List<Integer> generate(int[] arr, int count){
        List<Integer> list = new ArrayList<Integer>();
        dfs(arr, count, 0, 0, list);
        return list;
    }
    
    public void dfs(int[] arr, int count, int pos, int res, List<Integer> list){
        if(count == 0){
            list.add(res);
            return;
        }
        for(int i = pos; i < arr.length; i++){
            res+=arr[i];
            count--;
            dfs(arr, count, i+1, res, list);
            res-=arr[i];
            count++;//Attention!!! dont forget backtracking!!!
        }
    }
}