package com.oracle.java.seven.features;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchEvent.Kind;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

public class WatchServiceImpl {

	public static void main(String[] args) throws IOException, InterruptedException {

		WatchService watchService = FileSystems.getDefault().newWatchService();

		Path path = Paths.get("C:\\Desenv\\Grid\\");

		path.register(watchService, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_MODIFY,
				StandardWatchEventKinds.ENTRY_DELETE);

		while (true) {
			WatchKey key = watchService.take(); // this would return you keys

			for (WatchEvent<?> event : key.pollEvents()) {
				Kind<?> kind = event.kind();

				System.out.println("Event on " + event.context().toString() + " is " + kind);
			}
		}
	}

}
