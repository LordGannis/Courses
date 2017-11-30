package com.oracle.java.seven.features;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MultiCatch {

	public void oldMultiCatch() {
		FileOutputStream fos = null;
		DataOutputStream dos = null;

		try {
			fos = new FileOutputStream("movies.txt");
			dos = new DataOutputStream(fos);
			// do something
		} catch (IOException e) {
			// do something
		} catch (NullPointerException e) {
			// do something
		} finally {
			try {
				if (fos != null) {
					fos.close();
				}

				if (dos != null) {
					dos.close();
				}
			} catch (IOException e) {
				// do something
			}

		}
	}

	public void newMultiCatch() {
		try (FileOutputStream fos = new FileOutputStream("movies.txt");
				DataOutputStream dos = new DataOutputStream(fos);) {
			// do something
		} catch (IOException | NullPointerException e) {
			// do something
		}
	}

}
