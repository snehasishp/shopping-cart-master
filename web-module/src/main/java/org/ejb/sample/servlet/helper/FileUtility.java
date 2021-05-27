package org.ejb.sample.servlet.helper;

import java.io.FileWriter;
import java.io.IOException;
import com.amazonaws.auth.*;
import com.amazonaws.services.s3.*;

public class FileUtility {

    void generateReportFile(String content) throws IOException {
        uploadS3ObjectAndGetUrl("bucketName", "/test/sample.txt", "keyName");
    }

    private AmazonS3 getS3Client() {
        AmazonS3 s3client;
        AWSCredentials credentials = new BasicAWSCredentials(System.getenv("AWS_S3_ACCESS_KEY"), System.getenv("AWS_S3_SECRET_KEY"));
    }

    private URL uploadS3ObjectAndGetUrl(String bucketName, String uploadContentPath, String keyName) {
        AmazonS3 s3client = getS3Client();
        s3client.putObject(new PutObjectRequest(bucketName, keyName, new File(uploadContentPath)));
        return s3client.getUrl(bucketName, keyName);
    }
}
