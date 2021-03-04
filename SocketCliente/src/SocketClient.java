import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class SocketClient {
	
	
	public static final int PUERTO = 2017;
	public static final String IP_SERVER = "localhost";
	public static final int SUM = 1;
	public static final int REST = 2;
	public static final int MULTI = 3;
	public static final int DIVI = 4;
	static Scanner sc;
	
	public static void main(String[] args) {
		System.out.println("        APLICACIÓN CLIENTE");
		System.out.println("-----------------------------------");
		
		Socket socketCliente = null;
		InputStreamReader entrada = null;
		PrintStream salida = null;

		InetSocketAddress direccionServidor = new InetSocketAddress(IP_SERVER, PUERTO);

		Scanner sc = new Scanner(System.in);
		try {
			socketCliente = new Socket();
			socketCliente.connect(direccionServidor);
			System.out.println("Conexion establecida... a " + IP_SERVER + " por el puerto "
					+ PUERTO);
			
			entrada = new InputStreamReader(socketCliente.getInputStream());
			salida = new PrintStream(socketCliente.getOutputStream());
			
			
			System.out.println("CLIENTE: Introduzca Numero 1: ");
			String numero1 = sc.nextLine();
			System.out.println("CLIENTE: Introduzca Numero 2: ");
			String numero2 = sc.nextLine();
			System.out.println("CLIENTE: ¿Que operacion quiere hacer?");
			String opera = opera();
			String operandos = numero1 + "-" + numero2;
			salida.println(operandos);
			
			
			BufferedReader bf = new BufferedReader(entrada);
			String resultado = bf.readLine();
			
			switch (Integer.parseInt(opera)) {
			case SUM:
				System.out.println("CLIENTE: El resultado de la suma entre el numero " + numero1 + " y el numero "
						+ numero2 + " es: " + resultado);
				break;
			case REST:
				System.out.println("CLIENTE: El resultado de la resta entre el numero " + numero1 + " y el numero "
						+ numero2 + " es: " + resultado);
				break;
			case MULTI:
				System.out.println("CLIENTE: El resultado de la multiplicacion entre el numero " + numero1
						+ " y el numero " + numero2 + " es: " + resultado);
				break;
			case DIVI:
				System.out.println("CLIENTE: El resultado de la division entre el numero " + numero1
						+ " y el numero " + numero2 + " es: " + resultado);
				break;
			}

			
			System.out.println("CLIENTE: " + resultado);
		} catch (Exception e) {
			System.err.println("Error: " + e);
			e.printStackTrace();
		}finally {			
			try {
				salida.close();
				entrada.close();
				socketCliente.close();
				sc.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private static String opera() {
		System.out.println(SUM + " Sumar");
		System.out.println(REST + " Restar");
		System.out.println(MULTI + " Multiplicar");
		System.out.println(DIVI + " Dividir");
		String opera = sc.nextLine();
		return opera;
	}

}