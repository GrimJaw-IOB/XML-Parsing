import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

class HMAC{
	private static final char[] hexArray = "0123456789abcdef".toCharArray();
    private static final String MEDIUM_HASH_FUNCTION ="SHA-512";
	
    private static String generateSaltValue(String uniqueIdentifier) throws NoSuchAlgorithmException {
        MessageDigest md = null;
        md = MessageDigest.getInstance(MEDIUM_HASH_FUNCTION);
        md.update(uniqueIdentifier.getBytes());
        return bytesToHex(md.digest());
  }

  private static String bytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
              int v = bytes[j] & 0xFF;
              hexChars[j * 2] = hexArray[v >>> 4];
              hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);
  }

  public static String sha256Hash(String idValue, String uniqueIdentifier)
              throws NoSuchAlgorithmException, UnsupportedEncodingException {
        if (idValue != null) {
              MessageDigest m = MessageDigest.getInstance("SHA-256");
              //m.update(idValue.getBytes());
              m.update(generateSaltValue(idValue+uniqueIdentifier).getBytes("UTF-8"));

              return bytesToHex(m.digest());
        }
        return "";

  }
	public static void main(String[] args) {
		
		String str = "";
		String privateKey = "3488F6E2049FC79F";
		
		try {
			System.out.println(sha256Hash(str,privateKey)); //c577cb3e96812045c93d82da94642741a301cf672457d72247afa0cc3e7eb809
															//22538d0c6191e0a264744bc98b3ef9d1396e23466ffe5917b19ca5c1fe984825
															//22538d0c6191e0a264744bc98b3ef9d1396e23466ffe5917b19ca5c1fe984825
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}