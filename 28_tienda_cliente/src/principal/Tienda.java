package principal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class Tienda {

	public static void main(String[] args) {
		try(Socket sc=new Socket("localhost",8000);
			PrintStream out=new PrintStream(sc.getOutputStream());
			BufferedReader bf=new BufferedReader(new InputStreamReader(sc.getInputStream()));){
			out.println("tienda B");
			String linea;
			while((linea=bf.readLine())!=null) {
				System.out.println(linea);
			}
			
		}
		catch(IOException ex) {
			ex.printStackTrace();
		} 

	}

}