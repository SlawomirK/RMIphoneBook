 package zad1.PlikiSerwera;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface TelefonicznaKsiazkaInterfejsRMI extends Remote{
String getImie(String imie) throws RemoteException;//zwraca nr po imieniu
boolean addPhoneNumber(String imie,String numer) throws RemoteException;//dodaje nowy nr
boolean replacePhoneNumber(String name,String num) throws RemoteException;//zastepuje nr nowym num
void bye() throws RemoteException;//zakonczenie komunikacji;
}
