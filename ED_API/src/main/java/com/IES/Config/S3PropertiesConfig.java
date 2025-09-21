package com.IES.Config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component("s3Properties")
@ConfigurationProperties(prefix = "aws.s3")
public class S3PropertiesConfig 
{
	private static String bucketName;
	private String accessKey;
	private String secretKey;
	private static String region;

	// Getters and Setters
	public static String getBucketName() {
		return bucketName;
	}

	public void setBucketName(String bucketName) {
		this.bucketName = bucketName;
	}

	public String getAccessKey() {
		return accessKey;
	}

	public void setAccessKey(String accessKey) {
		this.accessKey = accessKey;
	}

	public String getSecretKey() {
		return secretKey;
	}

	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}

	public static String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}
}
