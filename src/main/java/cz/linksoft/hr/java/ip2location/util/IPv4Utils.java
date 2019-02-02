package cz.linksoft.hr.java.ip2location.util;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

import org.springframework.lang.NonNull;

/**
 * Utility class for translation {@link Inet4Address} to IP number (integer).
 */
public final class IPv4Utils {

	private IPv4Utils() {}

	/**
	 * Translated IP number to its bytes.
	 * @param ipNumber The IP number
	 * @return Bytes of the IPv4 address
	 */
	public static byte[] ipNumberToBytes(int ipNumber) {
		return new byte[] {
				(byte)(ipNumber >>> 24),
				(byte)(ipNumber >>> 16),
				(byte)(ipNumber >>> 8),
				(byte)(ipNumber)};
	}

	/**
	 * Translated IP number to {@link Inet4Address}.
	 * @param ipNumber The IP number
	 * @return IPv4 object representation
	 */
	public static Inet4Address ipNumberToInet4Address(int ipNumber) {
		try {
			return (Inet4Address)InetAddress.getByAddress(ipNumberToBytes(ipNumber));
		} catch (UnknownHostException e) {
			throw new IllegalArgumentException("Invalid IP number: " + ipNumber, e);
		}
	}

	/**
	 * Translated bytes to IP number.
	 * @param bytes The bytes of the IPv4 address which must have exacly 4 bytes
	 * @return The IP number
	 */
	public static int ipNumberFromBytes(@NonNull byte[] bytes) {
		if (bytes.length != 4) {
			throw new IllegalArgumentException("Unexpected bytes length of IPv4 address: " + Arrays.toString(bytes));
		}

		int ipNumber = 0;
		for (byte b : bytes) {
			ipNumber = ipNumber << 8 | (b & 0xFF);
		}
		return ipNumber;
	}

	/**
	 * Translated {@link Inet4Address} to its IP number.
	 * @param inet4Address The IPv4 address
	 * @return The IP number
	 */
	public static int ipNumberFromInet4Address(@NonNull Inet4Address inet4Address) {
		return ipNumberFromBytes(inet4Address.getAddress());
	}

}
