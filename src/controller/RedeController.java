package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RedeController {
	public RedeController() {
		super();
	}
	public String os() {
		String os = System.getProperty("os.name");
		return os ;
	}
	public void ip(String os) {
		//compara para ver em qual sistema esta operando
		if(os.contains("windows")) {
			readProcess("ifconfig");
		}else {
			readProcess("ipconfig");
		}
	}
	public void readProcess(String process) {
		if(process == "ipconfig") {
		try {
			Process p = Runtime.getRuntime().exec(process);
			InputStream fluxo = p.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine(); 
			while(linha != null) {
				if(linha.contains("IPv4")) {
					System.out.println(linha);
				}
				linha = buffer.readLine();
			}
			buffer.close();
			leitor.close();
			fluxo.close();
		} catch (IOException e) {
			e.printStackTrace();
		}}else if(process == "ifconfig"){
			try {
			Process p = Runtime.getRuntime().exec(process);
			InputStream fluxo = p.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine(); 
			while(linha != null) {
				if(linha.contains("inet")) {
					System.out.println(linha);
				}
				linha = buffer.readLine();
			}
			buffer.close();
			leitor.close();
			fluxo.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
			
		}else {
			try {
				Process p = Runtime.getRuntime().exec(process);
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine(); 
				while(linha != null) {
					if(linha.contains("M")) {
						String array[] = new String[4];
						array = linha.split("=");
						String media = array[3];
						System.out.println("Media =" + media);
					}
					linha = buffer.readLine();
				}
				buffer.close();
				leitor.close();
				fluxo.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	public void ping(String os) {
		if(os.contains("windows")) {
			readProcess("ping -4 -c 10 www.google.com.br");
		}else {
			readProcess("ping -4 -n 10 www.google.com.br");
		}
	}
}
