package com.wanglei.business.myfile;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

public class MyWatchFile {

    public static void main(String[] args) throws IOException, InterruptedException {
        Path path = Paths.get("/Users/wanglei/Documents/");
        WatchService watchService = FileSystems.getDefault().newWatchService();
        WatchKey key = path.register(watchService,
                StandardWatchEventKinds.ENTRY_MODIFY,
                StandardWatchEventKinds.ENTRY_CREATE,
                StandardWatchEventKinds.ENTRY_DELETE,
                StandardWatchEventKinds.OVERFLOW);
        while (true) {
            WatchKey watchKey = watchService.take();
            System.out.println(watchKey);
            for (WatchEvent<?> event : watchKey.pollEvents()) {
                WatchEvent.Kind<?> kind = event.kind();
                Path pathName = (Path) event.context();
                System.out.println(kind);
                System.out.println(pathName);
                key.reset();
                System.out.println("跳出来了");
            }
        }
//        watchService.close();
    }
}
