package principal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class Test {

	public static void main(String[] args) {
		try {
			Socket sc = new Socket("www.oracle.com", 80);
			InputStream is = sc.getInputStream();
			BufferedReader bf = new BufferedReader(new InputStreamReader(is));
			String linea;
			
			while((linea = bf.readLine()) != null) {
				System.out.println(linea);
			}
			
			sc.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
