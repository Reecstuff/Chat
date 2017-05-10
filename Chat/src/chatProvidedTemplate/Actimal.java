package chatProvidedTemplate;

import java.net.SocketPermission;
import java.security.Permission;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Hashtable;

public class Actimal extends SecurityManager
{
	Hashtable<String, LocalTime> ht = null;
	public Actimal ()
	{
		ht = new Hashtable<String, LocalTime>();		
	}

	@Override
	public void checkAccept(String arg0, int arg1)
	{
		System.out.println("Actimal works!");
		if(ht.isEmpty())
		{
			System.out.println("Actimal->Ht isEmpty");
			return;
		}
		if(ht.contains(arg0))
		{
			super.checkAccept(arg0, arg1);
		}
		else
		{
			LocalTime lt = LocalTime.now();
			Long number = ht.get(arg0).until(lt, ChronoUnit.MILLIS);
			if(number < 20)
			{
				ht.put(arg0, lt);
				super.checkAccept(arg0, arg1);
			}			
		}
	}

	@Override
	public void checkPermission(Permission perm) { }
	
}
