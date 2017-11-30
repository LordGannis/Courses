package com.oracle.java.seven.features;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TryWithResources {

	public void oldResourceManager() {
		FileOutputStream fos = null;
		DataOutputStream dos = null;

		try {
			fos = new FileOutputStream("movies.txt");// Open a file
			dos = new DataOutputStream(fos);// Open a data to right the file
			// do something
		} catch (IOException e) {
			// do something
		} finally {// need to close the files
			try {
				if (fos != null) {
					fos.close();// close fos
				}

				if (dos != null) {
					dos.close();// close dos
				}
			} catch (IOException e) {
				// do something
			}

		}
	}

	public void newTryWithResources() {
		try (FileOutputStream fos = new FileOutputStream("movies.txt");// Open a file
				DataOutputStream dos = new DataOutputStream(fos);)// Open a data to right the file
				//Java 7 will garante that try-catch close the files when it's completed, you don't need Finally anymore
		{
			// do something
		} catch (IOException e) {
			// do something
		}
	}

}
