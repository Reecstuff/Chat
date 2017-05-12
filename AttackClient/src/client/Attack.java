package client;

import java.io.IOException;

public interface Attack extends Runnable
{
	void execute() throws IOException;
}
