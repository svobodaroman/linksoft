package cz.linksoft.hr.java.ip2location.model;

/**
 * IP address range as closed interval &lt;{@link #from}; {@link #to});.
 */
//TODO figure out how to make relationship to city
public class IPAddressRange {

	/**
	 * Left closed bound of the interval.
	 */
	//TODO please use any type which will fit your needs like java.net.InetAddress, any numeric type etc.
	Object from;

	/**
	 * Right open bound of the interval.
	 */
	//TODO please use any type which will fit your needs like java.net.InetAddress, any numeric type etc.
	Object to;

}
