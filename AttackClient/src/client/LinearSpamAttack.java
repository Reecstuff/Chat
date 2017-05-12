package client;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class LinearSpamAttack extends BaseAttack
{
	public LinearSpamAttack(String host, int port, String message, String user)
	{
		super(host, port);
		this.message = message;
		this.user = user;
	}

	private final String message;
	private final String user;
	
	@Override
	public void execute() throws IOException
	{
		Socket socket = new Socket(host, port);
		DataOutputStream data = new DataOutputStream(socket.getOutputStream());
		
		data.writeUTF(user);
		
		while(!Thread.interrupted())
		{
			data.writeUTF(Protocol.Message(message));
		}
		
		socket.close();
	}
	
}
