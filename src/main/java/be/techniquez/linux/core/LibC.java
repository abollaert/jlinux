package be.techniquez.linux.core;

import com.sun.jna.Library;
import com.sun.jna.Native;

/**
 * Maps the LibC interface.
 * 
 * @author alex
 */
public interface LibC extends Library {
	
	/** File access mode, read only. */
	int	O_RDONLY = 0x0000;
	
	/** File access mode, write only. */
	int O_WRONLY = 0x0001;
	
	/** File access mode, read write. */
	int O_RDWR = 0x0002;
	
	/** All of the above. */
	int O_ACCMODE = 0x0003;
	
	/** The instance. */
	LibC INSTANCE = (LibC)Native.loadLibrary("c", LibC.class);
	
	/**
	 * Open a file.
	 * 
	 * @param 	fileName		The name of the file.
	 * @param 	mode			The mode to use.
	 * 
	 * @return	The file descriptor, a negative number if the open operation failed.
	 */
	int open(final String fileName, final int mode);
	
	/**
	 * Closes a file.
	 * 
	 * @param 	fd				The file descriptor.
	 * 
	 * @return	0 if the close was a success, negative if there was an error.
	 */
	int close(final int fd);
}
