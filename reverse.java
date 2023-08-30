import java.net.*;

/**
 * reverse class
 *
 * Obtains DNS names of corresponding IP addresses
 *
 * Jesse O'Connor
 * 1534760
 */
class reverse {

    // static global int variable that can be used in catch blocks
    static int i;

    static public void main(String[] args) {

	// checks whether there are IP addresses to resolve
	if(args.length < 1) {
	    System.err.println("Usage: resolve <ip1> <ip2> ... <ipN>");
	    return;
	}

	// loops through IP addresses
	for (i = 0; i < args.length; i++) {

	    InetAddress ia;

	    // gets InetAddess object by IP addresses and grabs correspnding
	    // DNS name and prints
	    try {
		ia = InetAddress.getByName(args[i]);
		String name = ia.getHostName();

		// checks whether DNS name is the same as IP
		if (args[i].compareTo(name) == 0) {
		    System.out.println(args[i] + " : no name");
		} else {
		    System.out.println(args[i] + " : " + name);
		}
		
	    } catch (UnknownHostException E) {
		System.out.println(args[i] + " : no name");
	    }

	}
    }
}





