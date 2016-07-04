/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        if(n<=0) return 0;
        char[] buffer = new char[4];
        boolean eof = false;
        int total = 0;
        
        while(total < n && !eof){
            int currentRead = read4(buffer);
            if(currentRead < 4) eof = true;
            
            int len = Math.min(n-total, currentRead);
            for(int i = 0; i < len; i++){
                buf[total] = buffer[i];
                total++;
            }
        }
        return total;
    }
}