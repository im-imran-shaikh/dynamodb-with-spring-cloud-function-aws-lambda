package in.learnjavaskills.dynamodbwithawslambda.dto;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@ConfigurationProperties("dynamodb.credentials")
@Getter
@Setter
public class DynamoDBCredentials 
{
	private String accessKey;
	
	private String secretKey;
	
	private String region;
	
	private String serviceEndpoint;

}
