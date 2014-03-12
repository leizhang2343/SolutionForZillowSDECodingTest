package codingTestAtZillow;

public class StringToLong {
	static long stringToLong(String s)
	{	
	/* code goes here to convert a string to a long */
	if(s == null || s.length() < 1){
		throw new IllegalArgumentException("s is not a valid in put");
	}
	boolean negative = false;
	if(s.charAt(0) == '-'){
		negative = true;
		s = s.substring(1);
		if(s.length() < 1) 
			throw new IllegalArgumentException("s is not a valid in put");
	}
	
	for(int i = 0; i < s.length(); i++){			//check number format 
		if(s.charAt(i) > '9' || s.charAt(i) < '0'){
			throw new  NumberFormatException("s contains illegal character");
		}
		if(i == 0 && s.charAt(i) == '0'){
			throw new NumberFormatException("s is not a valid number: 0 at the beginning");
		}
	}
	
	Long maxValue = Long.MAX_VALUE;
	String maxVlueString = maxValue.toString();
	int maxLenght = maxVlueString.length();
	if(s.length() > maxLenght){                   //check the rang of long
		throw new IllegalArgumentException("s is out of range of long");
	}
	
	if(s.length() == maxLenght){
		for(int i = 0; i < s.length(); i++){
			if(i == s.length() - 1 && negative){			//negative have one more rang
				if(s.charAt(i) - maxVlueString.charAt(i) > 1){
					throw new IllegalArgumentException("s is out of range of long");
				}else if(s.charAt(i) - maxVlueString.charAt(i) == 1){
					return Long.MIN_VALUE;
				}
			}
			if(s.charAt(i) - maxVlueString.charAt(i) > 0){
				throw new IllegalArgumentException("s is out of range of long");
			} else if(s.charAt(i) - maxVlueString.charAt(i) < 0) {
				break;
			}
		}
	}
	
	long result = 0;
	for(int i = 0; i < s.length(); i++){
		if(result != 0) result *= 10;
		result += s.charAt(i) - '0';
	}
	
	return negative? -result:result;
	}
	
	
	void test()
	{
	long i = stringToLong("123");
	if (i == 123)
	// success 
		i = 0;
	else
	 i = 0;// failure
	}
	
	public static void main(String[] args){
		Long max = Long.MAX_VALUE;
		Long min = Long.MIN_VALUE;
		System.out.print(stringToLong(min.toString()));
	}
}
