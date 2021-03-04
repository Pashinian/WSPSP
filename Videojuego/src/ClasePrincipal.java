import java.util.Arrays;
import java.util.Random;

public class ClasePrincipal {

	public static void main(String[] args) {
		Personaje guerrero = new Guerrero();
		Personaje mago = new Mago();
		Personaje curandero = new Curandero();

		Arma espada = new Espada();
		Arma arco = new Arco();
		Arma hechizo = new Hechizo();
		Arma rezo = new Rezo();

		guerrero.setVida(100);
		guerrero.setArma(espada);
		guerrero.getArma().setRestapuntos(10 + (int) Math.random() * 10);
		guerrero.getArma().setTipoarma("Espada");

		guerrero.setVida(100);
		guerrero.setArma(arco);
		guerrero.getArma().setRestapuntos(10 + (int) Math.random() * 10);
		guerrero.getArma().setTipoarma("Arco");

		mago.setVida(90);
		mago.setArma(hechizo);
		mago.getArma().setRestapuntos(15 + (int) Math.random() * 10);
		mago.getArma().setTipoarma("Hechizos");

		curandero.setVida(70);
		curandero.setArma(rezo);
		curandero.getArma().setRestapuntos(20 + (int) Math.random() * 10);
		curandero.getArma().setTipoarma("Rezo");

		Random azar = new Random();

		while (guerrero.getVida() > 0 || mago.getVida() > 0 || curandero.getVida() > 0) {

			Personaje[] lista = { guerrero, curandero, mago };

			Personaje atacado = lista[azar.nextInt(3)];
			guerrero.atacar(atacado);
			System.out.println("Vida de " + atacado.getNombre() + " es: " + atacado.getVida());
			System.out.println("----------------------------------------------------");

			atacado = lista[azar.nextInt(3)];
			mago.atacar(atacado);
			System.out.println("Vida de " + atacado.getNombre() + " es: " + atacado.getVida());
			System.out.println("----------------------------------------------------");

			atacado = lista[azar.nextInt(3)];
			curandero.atacar(atacado);
			System.out.println("Vida de " + atacado.getNombre() + " es: " + atacado.getVida());
			System.out.println("----------------------------------------------------");

			int[] vidaTotal = { guerrero.getVida(), mago.getVida(), curandero.getVida() };

			Arrays.sort(vidaTotal);

			System.out.println("----------------------------------------------------");
			System.out.println("Vida total del guerrero: " + guerrero.getVida());
			System.out.println("Vida total del mago: " + mago.getVida());
			System.out.println("Vida total del curandero: " + curandero.getVida());
			System.out.println("****************************************************");

			if (vidaTotal[2] == guerrero.getVida()) {
				System.out.println("Ha ganado el guerrero!!");
				System.out.println("****************************************************");

			} else if (vidaTotal[2] == mago.getVida()) {
				System.out.println("Ha ganado el mago!!");
				System.out.println("****************************************************");

			} else if (vidaTotal[2] == curandero.getVida()) {
				System.out.println("Ha ganado el curandero!!");
				System.out.println("****************************************************");
			}

		}
	}

}
