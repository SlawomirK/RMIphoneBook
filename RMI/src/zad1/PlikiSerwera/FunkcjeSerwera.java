package zad1.PlikiSerwera;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class FunkcjeSerwera extends UnicastRemoteObject implements TelefonicznaKsiazkaInterfejsRMI {
	private static Map<String, String> ksiazkaTelefoniczna;// zadanie nie wymaga zakładania bazy
															// danych

	protected FunkcjeSerwera() throws RemoteException {
		super();
		ksiazkaTelefoniczna = new HashMap<>();
		wczytajDaneZPliku("phoneBook.txt");
	}

	public void zapiszDaneDoPliku() {
		PrintWriter zapis = null;
		try {
			zapis = new PrintWriter("phoneBook.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			zapis.close();
		}

	}

	private void wczytajDaneZPliku(String fileName) {
		BufferedReader br = null;
		// Inicjalna zawartość książki telefonicznej
		// jest wczytywana z pliku o formacie
		// imię numer_telefonu
		try {
			br = new BufferedReader(new FileReader(fileName));
			String line;
			while ((line = br.readLine()) != null) {
				String[] info = line.split(" +", 2);
				ksiazkaTelefoniczna.put(info[0], info[1]);
				System.out.println("wczytuje " + info[0] + " " + info[1]);
			}
		} catch (Exception exc) {
			exc.printStackTrace();
			System.exit(1);
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	/*
	 * @return: Zwraca nr telefonu po imieniu
	 * 
	 * @param: imie klucz dla którego szukamy nr telefonu
	 * 
	 **/

	public String getImie(String imie) throws RemoteException {
		if (!ksiazkaTelefoniczna.containsKey(imie))
			return null;
		String nrTelefonu = ksiazkaTelefoniczna.get(imie);
		if (nrTelefonu.isEmpty())
			return null;
		else
			return ksiazkaTelefoniczna.get(imie);
	}
	/*
	 * Dodaje nowe nr
	 * 
	 * @param imie-klucz
	 * 
	 * @param numer-wartosc
	 **/

	public boolean addPhoneNumber(String imie, String numer) throws RemoteException {
		if (ksiazkaTelefoniczna.containsKey(imie))
			return false;
		ksiazkaTelefoniczna.put(imie, numer);
		// zapiszDaneDoPliku();
		System.out.println("zapisuje nowy kontakt");
		return true;
	}

	/*
	 * // Zastępuje numer podanej osoby nowym // Wynik: // - true (numer zastąpiony)
	 * // - false (nie - próba podania nowegu numeru nieistniejącej osoby)
	 **/

	public boolean replacePhoneNumber(String name, String num) throws RemoteException {
		if (!ksiazkaTelefoniczna.containsKey(name))
			return false;
		ksiazkaTelefoniczna.put(name, num);
		// zapiszDaneDoPliku();
		return true;
	}

	public void bye() throws RemoteException {
		zapiszDaneDoPliku();
		System.out.println("Zapisano nowe kontakty");
	}

}
