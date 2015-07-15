package com.cloudwick.java.ParseFiles;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
// Reference: http://stackoverflow.com/questions/17732819/parallel-version-of-files-walkfiletree-java-or-scala

public class ParseCSVFilesThreaded {
    private static class RecursiveWalk extends RecursiveAction {
        private static final long serialVersionUID = 6913234076030245489L;
        private final Path dir;

        public RecursiveWalk(Path dir) {
            this.dir = dir;
        }

        @Override
        protected void compute() {
            final List<RecursiveWalk> walks = new ArrayList<>();
            try {
                Files.walkFileTree(dir, new SimpleFileVisitor<Path>() {
                    @Override
                    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                        if (!dir.equals(RecursiveWalk.this.dir)) {
                            RecursiveWalk w = new RecursiveWalk(dir);
                            w.fork();
                            walks.add(w);

                            return FileVisitResult.SKIP_SUBTREE;
                        } else {
                            return FileVisitResult.CONTINUE;
                        }
                    }

                    @Override
                    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                        System.out.println(file + "\t" + Thread.currentThread());
                        if(file.toString().endsWith(".csv")){
                			System.out.println(file.getFileName());
                			
                			
                			//Read and append that CSV File
                			ReadandAppend obj = new ReadandAppend();
                			//obj.read();
                			String output = obj.write( file);
                        }
                        return FileVisitResult.CONTINUE;
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
            }

            for (RecursiveWalk w : walks) {
                w.join();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        RecursiveWalk w = new RecursiveWalk(Paths.get("D:/ExcelDirectory/").toRealPath());
        ForkJoinPool p = new ForkJoinPool();
        p.invoke(w);
    }
}