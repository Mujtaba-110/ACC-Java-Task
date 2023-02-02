package com.example.s3bucket.v1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class S3Controller {
	
	@Autowired
	private S3ServiceImpl s3ServiceImpl;
	
	@PostMapping("/upload")
	public String upload(@RequestParam("file") MultipartFile file) {
		return s3ServiceImpl.saveFile(file);
	}
	
	@GetMapping("/download/{filename}")
	public ResponseEntity<byte[]> downloadFile(@PathVariable("filename") String filename) {
		HttpHeaders headers=new HttpHeaders();
        headers.add("Content-type", MediaType.ALL_VALUE);
        headers.add("Content-Disposition", "attachment; filename="+filename);
        byte[] bytes = s3ServiceImpl.downloadFile(filename);
        return  ResponseEntity.status(HttpStatus.OK).headers(headers).body(bytes);
	}
	
	@DeleteMapping("/delete/{filename}")
	public String deleteFile(@PathVariable("filename") String filename) {
		return s3ServiceImpl.deleteFile(filename);
	}
	
	@GetMapping("/files")
	public List<String> getAllFiles(){
		return s3ServiceImpl.displayAllFiles();
	}
	
}
