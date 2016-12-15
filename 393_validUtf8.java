public class Solution {
    public boolean validUtf8(int[] data) {
        //All & or | needs this ()!!!
        if(data == null || data.length == 0) return false;
        int numOfBytes = 0;
        int i = 0;
        while(i < data.length){
            if(data[i] > 255) return false; //256: 100000000(one 1 and eight 0)
            else if((data[i] & 128) == 0) numOfBytes = 1; //128: 10000000 (one 1 and seven 0) 
            else if((data[i] & 224) == 192) numOfBytes = 2; //224: 11100000, 192: 11000000
            else if((data[i] & 240) == 224) numOfBytes = 3; //240: 11110000, 224: 11100000
            else if((data[i] & 248) == 240) numOfBytes = 4; //248: 11111000, 240: 11110000
            else return false; //dont forget!!!
            
            // j start from 1 to < because the first is counted already. the rest is numOfBytes-1.
            for(int j = 1; j < numOfBytes; j++){ 
                if(i + j >= data.length) return false;
                if((data[i+j] & 192) != 128) return false; //check whether it is 10XXXXXXX
            }
            i = i+numOfBytes; //dont forget move i.
        }
        return true;
        
    }
}