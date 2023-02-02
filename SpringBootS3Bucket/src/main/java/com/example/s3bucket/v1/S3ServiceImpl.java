package com.example.s3bucket.v1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ListObjectsV2Result;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.util.IOUtils;

@Service
public class S3ServiceImpl implements S3Service {

	@Value("${bucketName}")
	private String bucketName;

	private final AmazonS3 amazonS3;

	public S3ServiceImpl(AmazonS3 amazonS3) {
		super();
		this.amazonS3 = amazonS3;
	}

	@Override
	public String saveFile(MultipartFile file) {

		String filename = file.getOriginalFilename();
		try {
			File newFile=convertMultiPartToFile(file);
			amazonS3.putObject(bucketName,filename,newFile);
		} 
		catch (IOException e) {
			e.printStackTrace();;
		}
		return "File uploaded Successfully";
	}

	@Override
	public byte[] downloadFile(String filename) {
		S3Object object = amazonS3.getObject(bucketName,filename);
		S3ObjectInputStream objectContent = object.getObjectContent();
		try {
			return IOUtils.toByteArray(objectContent);
		} 
		catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public String deleteFile(String filename) {
		amazonS3.deleteObject(bucketName, filename);
		return "File deleted successfully";
	}

	@Override
	public List<String> displayAllFiles() {
		ListObjectsV2Result listObjectsV2 = amazonS3.listObjectsV2(bucketName);
		//listObjectsV2.getObjectSummaries().stream().map(S3ObjectSummary::getKey).collect(Collectors.toList());
		return listObjectsV2.getObjectSummaries().stream().map(o->o.getKey()).collect(Collectors.toList());
	}

	public static File convertMultiPartToFile(MultipartFile file) throws IOException {
		File convFile = new File(file.getOriginalFilename());
		FileOutputStream fileOutputStream=new FileOutputStream(convFile);
		fileOutputStream.write(file.getBytes());
		fileOutputStream.close();
		return convFile;
	}

}
