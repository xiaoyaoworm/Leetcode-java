/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
     
    char[] buffer = new char[4];
    int buffSize = 0;
    int offset = 0;
    
    public int read(char[] buf, int n) {
        int readBytes = 0;
        int bytes = 0;
        boolean eof = false;
        
        while(!eof && readBytes < n){
            if(buffSize == 0){
                buffSize = read4(buffer);
                if(buffSize < 4) eof = true;
            }
            
            bytes = Math.min(buffSize, n-readBytes);
            for(int i = 0; i < bytes; i++){
                buf[readBytes+i] = buffer[offset+i];
            }
            readBytes += bytes;
            offset = (offset+bytes)%4;
            buffSize -= bytes;
        }
        return readBytes;
        
    }
}