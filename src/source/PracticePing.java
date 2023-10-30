package source;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PracticePing {

	public static void main(String[] args) {
	
		String command = "ping";
		String modifier1 = "-n";
		int num_calls = 3;
		String url = "google.com";
		
		ProcessBuilder pb = new ProcessBuilder(command, modifier1, String.valueOf(num_calls), url);
		
		try {
			Process p = pb.start();
			BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String linea = ""; 
			while ((linea = br.readLine()) != null)
				System.out.println(linea);
			System.out.println(command + " completado con código " + p.waitFor());
			br.close();
		} catch (IOException | InterruptedException e) {
			System.err.println(e.getMessage());
		}
	}
}
