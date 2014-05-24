package be.techniquez.linux.core;

public final class Main {

	public static void main(String[] args) {
		final int fd = LibC.INSTANCE.open("/dev/net/tun", LibC.O_RDWR);
		
		System.out.println(fd);
	}
}
