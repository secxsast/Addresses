package com.amazonaws.samples2;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.ListObjectsRequest;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectSummary;


public class S3Sdk2 {

        @Value("${app.awsServices.buckName1}")
        private String bucket1;

        @Value("${app.awsServices.buckName2}")
        private String bucket2;

	public void Foo() {
                AmazonS3.completeMultipartUpload(bucket1);
//                AmazonS3EncryptionClient.download(bucket2);
	}


	public void Foo2() {
                String inpData = (String)AmazonS3Client.getObject(bucket2,"Key");
		
                java.sql.ResultSet rsLookUp = openrs( stat1, "SELECT " + fName + " FROM " + table + " WHERE " + inpData 
	}

        public  java.sql.ResultSet openrs(java.sql.Statement stat, String sql) throws java.sql.SQLException  {
                java.sql.ResultSet rs = stat.executeQuery(sql);
                return (rs);
        }
}