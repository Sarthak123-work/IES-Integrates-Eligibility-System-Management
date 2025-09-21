package com.IES.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.IES.Config.S3PropertiesConfig;

import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

@Service
public class S3Service 
{
//	private final S3Client s3Client;
//    private final S3PropertiesConfig s3Properties;
//
//    @Autowired
//    public S3Service(S3PropertiesConfig s3Properties) {
//        this.s3Properties = s3Properties;
//
//        AwsBasicCredentials credentials = AwsBasicCredentials.create(
//                s3Properties.getAccessKey(),
//                s3Properties.getSecretKey()
//        );
//
//        this.s3Client = S3Client.builder()
//                .region(Region.of(s3Properties.getRegion()))
//                .credentialsProvider(StaticCredentialsProvider.create(credentials))
//                .build();
//    }
//
//    public String uploadToS3(ByteArrayOutputStream outputStream, String fileName) {
//        // Convert ByteArrayOutputStream to InputStream
//        InputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());
//
//        // S3 PutObject request
//        PutObjectRequest request = PutObjectRequest.builder()
//                .bucket(s3Properties.getBucketName())
//                .key(fileName)
//                .build();
//
//        // Upload
//        s3Client.putObject(
//                request,
//                software.amazon.awssdk.core.sync.RequestBody.fromInputStream(inputStream, outputStream.size())
//        );
//
//        // Build public URL
//        return "https://" + s3Properties.getBucketName() + 
//               ".s3." + s3Properties.getRegion() + 
//               ".amazonaws.com/" + fileName;
//    }
}
