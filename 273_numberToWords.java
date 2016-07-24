public class Solution {
	public static String[] LESS_THAN_20 = new String[]{"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten",
	"Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};

	public static String[] TENS = new String[]{"","","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};

	public static String[] THOUS = new String[]{"Billion","Million","Thousand",""};
	public static int[] radix = new int[]{1000000000,1000000,1000,1};


	public String numberToWords(int num) {
		StringBuffer sb = new StringBuffer();
		if(num == 0) return "Zero";
		for(int i = 0; i < radix.length; i++){
			if(num/radix[i] == 0) continue;
			sb.append(trans(num/radix[i])).append(THOUS[i]).append(" ");
			num = num%radix[i];
		}
		return sb.toString().trim();
	}

	public String trans(int n){
		if(n == 0) return "";
		StringBuffer sb = new StringBuffer();
		if(n < 20) sb.append(LESS_THAN_20[n]).append(" ");
		else if(n < 100) sb.append(TENS[n/10]).append(" ").append(trans(n%10));
		else sb.append(trans(n/100)).append("Hundred ").append(trans(n%100));
		return sb.toString();
	}
}