package gui;

import java.io.Serializable;

public class Target implements Serializable
{
	private static final long serialVersionUID = 300394768094920940L;

	public Target(String name, String host)
	{
		this.Name = name;
		this.Host = host;
	}
	
	public final String Name;
	public final String Host;
	
	@Override
	public String toString()
	{
		// TODO Auto-generated method stub
		return Name;
	}
}
