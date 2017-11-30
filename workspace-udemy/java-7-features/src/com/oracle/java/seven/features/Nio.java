package com.oracle.java.seven.features;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Nio {

	public static void main(String[] args) throws IOException {

		Path path = Paths.get("C:\\Desenv\\Grid\\Queries-grid.txt");

		System.out.println("Number of Nodes:" + path.getNameCount());

		System.out.println("File Name:" + path.getFileName());

		System.out.println("File Root:" + path.getRoot());

		System.out.println("File Parent:" + path.getParent());

		Files.deleteIfExists(Paths.get("C:\\Desenv\\GridABC\\"));

		Files.delete(Paths.get("C:\\Desenv\\GridABC\\"));
	}

}
