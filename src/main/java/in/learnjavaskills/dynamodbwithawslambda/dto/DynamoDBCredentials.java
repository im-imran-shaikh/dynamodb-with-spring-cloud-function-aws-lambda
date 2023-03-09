package in.learnjavaskills.dynamodbwithawslambda.dto;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Getter;
import lombok.Setter;

@ConfigurationProperties("dynamodb.credential")
@Getter
@Setter
public class DynamoDBCredentials 
{
	private String accessKey;
	
	private String secretKey;
	
	private String region;
	
	private String serviceEndpoint;

}
