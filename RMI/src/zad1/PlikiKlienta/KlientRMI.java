package zad1.PlikiKlienta;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import zad1.PlikiSerwera.TelefonicznaKsiazkaInterfejsRMI;
import zad1.PlikiSerwera.Zmienna;

public class KlientRMI {
	TelefonicznaKsiazkaInterfejsRMI c;
	GUI gui;

	public KlientRMI() {
		try {
			c = (TelefonicznaKsiazkaInterfejsRMI) LocateRegistry.getRegistry("localhost", Zmienna.NR_PORTU)
					.lookup("ktel");

		} catch (RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

	}

	public String pobierzTelefon(String imie) throws RemoteException {
		return c.getImie(imie);
	}

	public boolean zmienTelefon(String imie, String numer) throws RemoteException {
		return c.replacePhoneNumber(imie, numer);
	}

	public Boolean dodajTelefon(String imie, String numer) throws RemoteException {
		return c.addPhoneNumber(imie, numer);
	}

	public void bye() throws RemoteException {
		c.bye();
	}

}
