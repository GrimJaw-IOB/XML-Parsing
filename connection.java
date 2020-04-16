
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.SecureRandom;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.Base64;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

class RhapsodyLookup{
	
	private String usr = "administrator";
	private String pwd = "1";
	
	
	RhapsodyLookup(String rhapsodyUsername, String rhapsodyPassword){
		
		usr = rhapsodyUsername;
		pwd= rhapsodyPassword;
	}
	
	
	public String Auth(){
		
		String auth = this.usr + ":" + this.pwd;
		System.out.println(auth);
		
		auth = Base64.getEncoder().encodeToString(auth.getBytes());
		System.out.println("Authorization " + auth);
		return auth;
	}
	
	public TrustManager[] getTrustManager(){
		TrustManager[] certs = new TrustManager[]{
			new X509TrustManager(){
				public X509Certificate[] getAcceptedIssuers(){
					return null;
				}
				public void checkClientTrusted(X509Certificate[] certs, String t){}
				public void checkServerTrusted(X509Certificate[] certs, String t) { }
			}
		};
		return certs;
	}
	
	public String RESTcall(String urlName){
		
		String temp = new String();
		StringBuffer output = new StringBuffer();
		
		String auth = Auth();
		auth = "Basic " + auth;
		//System.out.println("New auth: " + auth);
		try{
			//get SSL context first
			SSLContext sc = SSLContext.getInstance("SSL");
			TrustManager[] tm = getTrustManager();
			sc.init(null, tm, new SecureRandom());
			HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
			
			URL url = new URL(urlName);		
			HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
			
			
			
			con.setSSLSocketFactory(sc.getSocketFactory());
			con.setDoOutput(true);
			con.setDoInput(true);
			con.setRequestMethod("GET");
			con.setHostnameVerifier(new HostnameVerifier(){
				public boolean verify(String host, SSLSession SSLSession){
					return true;
				}
			});
			
			//setting headers
			con.setRequestProperty("Authorization",auth);
			con.setRequestProperty("Accept", "application/json");
			
			con.connect();
			
			
			if(con.getResponseCode() != 200){
				throw new RuntimeException("Failed: HTTP error!" + con.getResponseCode());
			}
			
			//System.out.println(con.getInputStream().toString());
			
			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			
			while((temp = br.readLine())!=null){
				output.append(temp);
			}
			//System.out.println(temp);
			
			con.disconnect();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		String abc = output.toString();
		
		return abc;
	}
	
	public static void main(String[] args) {
		
		RhapsodyLookup obj = new RhapsodyLookup("administrator","1");
		String url ="https://127.0.0.1:8444/admin/lookuptables/info";
		
		String str = obj.RESTcall(url);
		
		System.out.println(str);
		
		
	}
	
}