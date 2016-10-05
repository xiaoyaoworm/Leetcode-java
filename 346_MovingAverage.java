//只用存储一个window的值，n表示目前window的大小。
public class MovingAverage {
    int[] window;
    int n;
    int pos;
    long sum;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.window = new int[size];
        this.pos = 0;
        this.sum = 0;
        this.n = 0;
    }
    
    public double next(int val) {
        if(n < window.length) n++;
        sum-=window[pos];
        sum+=val;
        window[pos] = val;
        pos = (pos+1)%window.length;
        return (double)sum/(double)n;
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */




//Naive solution. Be careful for the index!!!!! 
//One problem is this is data stream!!! you cannot save all of them!!!!
//getMedian may have the overflow problem.

public class MovingAverage {
    List<Integer> list;
    int pos = 0;
    int size = 0;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        list = new ArrayList<Integer>();
        pos = 0;
        this.size = size;
    }
    
    public double next(int val) {
        list.add(val);
        double res = 0;
        if(pos <= size-1){
            res = getMedian(list, 0, pos);
        } else{
            res = getMedian(list, pos+1-size, pos);
        }
        pos++;
        return res;
    }

    // public double getMedian(List<Integer> list, int i, int j){
    //     int sum = 0;
    //     for(int k = i; k <= j; k++){
    //         sum+=list.get(k);
    //     }
    //     return (double)sum/(double)(j+1-i);
    // }
    
    public double getMedian(List<Integer> list, int i, int j){
        double res = 0.0;
        double num = (double)(j+1-i);
        for(int k = i; k <= j; k++){
            res+=((double)(list.get(k))/num;
        }
        return res;
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */