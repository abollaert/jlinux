package be.techniquez.linux.net;

import java.util.ArrayList;
import java.util.List;

import com.sun.jna.Memory;
import com.sun.jna.Structure;

/**
 * Corresponds to an ifreq struct.
 * 
 * @author alex
 */
public final class IfReq extends Structure {
	
	/** Length of the name. */
	private static final int IFNAMSIZ = 16;

	/** The name. */
	private final Memory ifrnName = new Memory(IFNAMSIZ);
	
	/** The address. */
	private final SockAddr address;
	
	/** The destination address. */
	private final SockAddr destAddress;
	
	/** The broadcast address. */
	private final SockAddr broadcastAddress;

	/**
	 * Create a new if_req.
	 * 
	 * @param 	name				The name.
	 * @param 	address				The address.
	 * @param 	destAddress			The destination address.
	 * @param 	broadcastAddress	The broadcast address.
	 */
	public IfReq(final String name, final SockAddr address, final SockAddr destAddress, final SockAddr broadcastAddress) {
		this.ifrnName.setString(0, name, "US-ASCII");
		this.address = address;
		this.destAddress = destAddress;
		this.broadcastAddress = broadcastAddress;
	}
	
	/**
	 * {@inheritDoc}
	 */
	protected final List<String> getFieldOrder() {
		final List<String> order = new ArrayList<>();
		order.add("ifrnName");
		order.add("address");
		order.add("destAddress");
		order.add("broadcastAddress");
		
		return order;
	}
}
