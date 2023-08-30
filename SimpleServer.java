import java.net.*;
import java.io.*;

/**
 * SimpleServer class
 *
 * Server that allows sockets to connect to it, sends information of
 * connected socket back to it
 *
 * Jesse O'Connor
 * 1534760
 */
class SimpleServer {

    public static void main(String[] args) {
	
	InetAddress ia;
	try {

	    // creates server socket on any port that is available
	    ServerSocket ss = new ServerSocket(0);

	    // prints out what port the server socket is connected to
	    System.out.print("Listening on port " + ss.getLocalPort() + "\n");

	    // infinite loop
	    while(true) {

		// accepts connection of a socket
		Socket s = ss.accept();

		// creates a PrintWriter object
		PrintWriter write = new PrintWriter(s.getOutputStream(), true);

		// gets address of socket
		ia = s.getLocalAddress();

		// gets name and IP of socket
		String name = ia.getHostName();
		String ip = ia.getHostAddress();

		// writes name and IP to PrintWriter
		write.println("Hello, " + name);
		write.println("Your IP address is " + ip);

		// closes socket
		s.close();
	    }
	} catch(IOException  e) {
	    return;
	}	
    }   
}
