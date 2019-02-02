package cz.linksoft.hr.java.ip2location.util;

import static org.junit.Assert.*;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

import org.hamcrest.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class IPv4UtilsTest {

	@Parameters(name = "{index}: {0} = {1}")
	public static Iterable<Object[]> data() {
		return Arrays.asList(new Object[][] {
				{"0.0.0.0",			0b00000000_00000000_00000000_00000000},
				{"0.0.0.1",			0b00000000_00000000_00000000_00000001},
				{"0.0.0.255",		0b00000000_00000000_00000000_11111111},
				{"0.0.1.0",			0b00000000_00000000_00000001_00000000},
				{"0.0.255.0",		0b00000000_00000000_11111111_00000000},
				{"0.255.0.0",		0b00000000_11111111_00000000_00000000},
				{"255.0.0.0",		0b11111111_00000000_00000000_00000000},
				{"255.255.255.255",	0b11111111_11111111_11111111_11111111},
				{"240.15.170.85",	0b11110000_00001111_10101010_01010101}
		});
	}

	private final String addressName;
	private final int ipNumber;

	public IPv4UtilsTest(String addressName, int ipNumber) {
		this.addressName = addressName;
		this.ipNumber = ipNumber;
	}

	@Test
	public void testConvertFromIPNumber() throws Exception {
		assertEquals(InetAddress.getByName(addressName), IPv4Utils.ipNumberToInet4Address(ipNumber));
	}

	@Test
	public void testConvertToIPNumber() throws Exception {
		assertEquals(ipNumber, ipNumberFromAddressName(addressName));
	}

	private static int ipNumberFromAddressName(String addressName) throws UnknownHostException {
		final InetAddress ipAddress = InetAddress.getByName(addressName);
		assertThat(ipAddress, Matchers.instanceOf(Inet4Address.class));
		return IPv4Utils.ipNumberFromInet4Address((Inet4Address) ipAddress);
	}

}