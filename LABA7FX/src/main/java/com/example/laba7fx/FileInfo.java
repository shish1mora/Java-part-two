package com.example.laba7fx;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class FileInfo {

    private  String fileName;
    private long size;
    private LocalDateTime lastModified;

    public FileInfo(Path path)  {
        this.fileName = path.getFileName().toString();
        try {
            this.size = Files.size(path);
            this.lastModified = LocalDateTime.ofInstant(Files.getLastModifiedTime(path).toInstant(), ZoneOffset.ofHours(3));
            this.type = Files.isDirectory(path) ? FileType.DIRECTORY : FileType.FILE;
            if(this.type == FileType.DIRECTORY){
                this.size = -1L;
            }
        } catch (IOException e) {
            throw new RuntimeException("Невозможно создать файл по заданному пути.");
        }
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public LocalDateTime getLastModified() {
        return lastModified;
    }

    public void setLastModified(LocalDateTime lastModified) {
        this.lastModified = lastModified;
    }

    public FileType getType() {
        return type;
    }

    public void setType(FileType type) {
        this.type = type;
    }

    private  FileType type;

    public enum FileType{
        FILE("F"), DIRECTORY("D");
        private  String name;

        FileType(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}
