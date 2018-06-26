package zad1.PlikiKlienta;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javafx.scene.control.RadioButton;

public class Kontroler {
	GUI gui;
	KlientRMI klient;

	public Kontroler(GUI gui, KlientRMI klient) {
		this.gui = gui;
		this.klient = klient;
		gui.inputData(new ServiceLis());
	}

	class ServiceLis implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String opcje = gui.getRadio(), imie = gui.getImie(), numer = gui.getNr();
			if (opcje.isEmpty())
				gui.setOdpowiedz("Muisz zaznaczyć co chcesz zrobić");
			else
				switch (opcje) {
				case "Znajdz nr telefonu":
					wyszukajNumer(imie);
					break;
				case "Zmień nr telefonu":
					zmienNr(imie, numer);
					break;
				case "Dodaj nowy rekord":
					dodajNowego(imie, numer);
					break;
				default:
					gui.setOdpowiedz("Błąd");
				}
		}

		private void dodajNowego(String imie, String numer) {
			try {
				gui.setOdpowiedz(imie.isEmpty() || numer.isEmpty() ? 
						"Aby wstawić nową osobę musisz wstawić obie dane": 
							!klient.dodajTelefon(imie, numer) ? "Uzytkownik juz istnieje w bazie"
								: "Dodano nowego uzytkownia \n" + imie + " " + numer);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			gui.setImie("");
			gui.setTelefon("");
		}

		private void zmienNr(String imie, String numer) {
			try {
				gui.setOdpowiedz(imie.isEmpty() && numer.isEmpty() ? "Musisz wstawić imię oraz nr nowego telefonu"
						: klient.zmienTelefon(imie, numer) ? "zmieniono dane klienta " + imie
								: "nie zminiono danych klienta " + imie + " na " + numer);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			gui.setImie("");
			gui.setTelefon("");
		}

		private void wyszukajNumer(String imie) {
			try {
				gui.setOdpowiedz(imie.isEmpty() ? "Musisz wstawić imie"
						: klient.pobierzTelefon(imie) == null ? "Brak uzytkownika o takim imieniu"
								: imie + " ma telefon nr " + klient.pobierzTelefon(imie));
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			gui.setImie("");
			gui.setTelefon("");
		}
	}
}
