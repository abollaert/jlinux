package be.techniquez.linux.net;

import java.util.ArrayList;
import java.util.List;

import com.sun.jna.Memory;
import com.sun.jna.Structure;

/**
 * Corresponds to a sock_addr.
 * 
 * @author alex
 */
public final class SockAddr extends Structure {

	/** The address family. */
	private final short saFamilyT;
	
	/** The protocol address. */
	private final Memory saData = new Memory(14);
	
	/**
	 * Create a new {@link SockAddr}.
	 * 
	 * @param 	saFamilyT		The address family.
	 * @param 	saData			The socket address.
	 */
	public SockAddr(final short saFamilyT, final String saData) {
		this.saFamilyT = saFamilyT;
		this.saData.setString(0, saData, "US-ASCII");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected final List<String> getFieldOrder() {
		final List<String> order = new ArrayList<String>();
		order.add("saFamilyT");
		order.add("saData");
		
		return order;
	}
}
