package in.learnjavaskills.dynamodbwithawslambda.config;

import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.client.builder.AwsClientBuilder.EndpointConfiguration;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;

import in.learnjavaskills.dynamodbwithawslambda.dto.DynamoDBCredentials;
import lombok.RequiredArgsConstructor;

@Configuration
@EnableDynamoDBRepositories(basePackages = "in.learnjavaskills.dynamodbwithawslambda.repository")
@RequiredArgsConstructor
public class DynamoDBConfiguration
{
	private final DynamoDBCredentials dynamoDBCredentials;
	
	@Bean
	public AmazonDynamoDB amazonDynamoDB()
	{
		return AmazonDynamoDBClientBuilder.standard()
				.withEndpointConfiguration(endPointConfiguration())
				.withCredentials(awsCredentialsProvider())
				.build();
	}
	
	private EndpointConfiguration endPointConfiguration()
	{
		return new AwsClientBuilder.EndpointConfiguration(dynamoDBCredentials.getServiceEndpoint(), dynamoDBCredentials.getRegion()); 
	}
	
	private AWSCredentialsProvider awsCredentialsProvider()
	{
		final BasicAWSCredentials basicAWSCredentials = new BasicAWSCredentials(dynamoDBCredentials.getAccessKey(), dynamoDBCredentials.getSecretKey());
		return new AWSStaticCredentialsProvider(basicAWSCredentials);
	}
}
