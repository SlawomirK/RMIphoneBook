/**
 *
 *  @author Kobyliński Sławomir
 *  */
package zad1;

import zad1.PlikiKlienta.GUI;
import zad1.PlikiKlienta.KlientRMI;
import zad1.PlikiKlienta.Kontroler;
import zad1.PlikiSerwera.ServerRMI;

public class Main {

	public static void main(String[] args) {
		new Thread(()->new ServerRMI()).start();
		System.out.println("Startuje serwer....");
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		new Thread(()->new Kontroler(new GUI(),new KlientRMI())).start();
		System.out.println("Startuje klienta");

	}

}
