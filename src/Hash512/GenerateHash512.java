package Hash512;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.binary.Base64;

public class GenerateHash512 {
	public static String embedCodeFile = "/home/sohel/userid.txt";

	public static String getSHA512(String input) {
		String retval = "";
		try {
			MessageDigest m = MessageDigest.getInstance("SHA-512");
			byte[] out = m.digest(input.getBytes());
			// encode data on your side using BASE64
			byte[] bytesEncoded = Base64.encodeBase64(out);
			//System.out.println("ecncoded value is " + new String(bytesEncoded));
			// // Decode data on other side, by processing encoded data
			// byte[] valueDecoded = Base64.decodeBase64(bytesEncoded);
			// System.out.println("Decoded value is " + new
			// String(valueDecoded));			
			retval = new String(bytesEncoded);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		return retval;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FileInputStream fstream;
		try {
			fstream = new FileInputStream(embedCodeFile);
			BufferedReader br = new BufferedReader(new InputStreamReader(
					fstream));
			String strLine;
			// Read File Line By Line
			try {
				while ((strLine = br.readLine()) != null) {
					System.out.println("Generating hash 512 codes userid: "
							+ strLine + " ,password: " + getSHA512(strLine));
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// Close the input stream
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

}
