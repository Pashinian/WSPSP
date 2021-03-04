
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
	
	public static final int PUERTO = 2017;
	public static final String IP_SERVER = "localhost";
	public static final int SUM = 1;
	public static final int REST = 2;
	public static final int MULTI = 3;
	public static final int DIVI = 4;
	
	public static void main(String[] args) throws InterruptedException {
		System.out.println("      APLICACIÓN DE SERVIDOR      ");
		System.out.println("----------------------------------");
		
		
		ServerSocket servidorSocket = null;
		Socket socketConexion = null;
		PrintStream salida = null;
		InputStreamReader entrada = null;		
		
		try {
			servidorSocket = new ServerSocket();
			InetSocketAddress direccion = new InetSocketAddress(IP_SERVER,PUERTO);
			servidorSocket.bind(direccion);
			
			while(true){
				System.out.println("SERVIDOR: Esperando peticion...");
				socketConexion = servidorSocket.accept();
				entrada = new InputStreamReader(socketConexion.getInputStream());
				BufferedReader bf = new BufferedReader(entrada);
				String stringRecibido = bf.readLine();
				System.out.println("SERVIDOR: Me ha llegado del cliente: " + stringRecibido);
				String[] operadores = stringRecibido.split("-");
				int iNumero1 = Integer.parseInt(operadores[0]);
				int iNumero2 = Integer.parseInt(operadores[1]);
				int opcion = Integer.parseInt(operadores[2]);
				int resultado = iNumero1 + iNumero2; 
				
				switch (opcion) {
				case SUM:
					resultado = iNumero1 + iNumero2;
					break;
				case REST:
					resultado = iNumero1 - iNumero2;
					break;
				case MULTI:
					resultado = iNumero1 * iNumero2;
					break;
				case DIVI:
					resultado = iNumero1 / iNumero2;
					break;
				}
				
				salida = new PrintStream(socketConexion.getOutputStream());
				salida.println(resultado);
				
			}
		} catch (IOException excepcion) {
			System.out.println(excepcion);
		}finally {
			try {
				if(salida != null && entrada != null){
					salida.close();
					entrada.close();
					socketConexion.close();
				}
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
	
	}
}