package zad1.PlikiSerwera;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServerRMI {

	public ServerRMI() {
		
		try {
			Registry reg=LocateRegistry.createRegistry(Zmienna.NR_PORTU);
			reg.rebind("ktel", new FunkcjeSerwera());
			System.out.println("Serwer pracuje........");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
