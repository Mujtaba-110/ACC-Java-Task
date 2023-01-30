package com.example.files.v1;

import java.io.IOException;
import java.util.stream.Stream;

import org.springframework.web.multipart.MultipartFile;

public interface FileDBService {
	FileDB store(MultipartFile file) throws IOException;
	FileDB getFile(String id);
	Stream<FileDB> getAllFiles();
}
