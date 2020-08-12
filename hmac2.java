
import org.apache.commons.codec.*;
import org.apache.commons.codec.digest.DigestUtils;


class HMAC2{
	
	public static void main(String[] args) {
		
		String str = "";
		System.out.println(str);
		String privateKey = "3488F6E2049FC79F";
		
		System.out.println(DigestUtils.sha256Hex(DigestUtils.sha512Hex(str+privateKey)));
		
	}
}