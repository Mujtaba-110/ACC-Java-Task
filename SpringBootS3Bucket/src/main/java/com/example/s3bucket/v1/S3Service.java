package com.example.s3bucket.v1;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface S3Service {
	String saveFile(MultipartFile file);
	byte[] downloadFile(String filename);
	String deleteFile(String filename);
	List<String> displayAllFiles();
}
