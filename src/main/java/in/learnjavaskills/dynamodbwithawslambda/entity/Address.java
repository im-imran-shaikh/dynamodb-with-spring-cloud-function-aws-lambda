package in.learnjavaskills.dynamodbwithawslambda.entity;

import java.io.Serializable;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@DynamoDBDocument
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
public class Address implements Serializable
{
	private static final long serialVersionUID = 1L;

	@DynamoDBAttribute
	private String line1;
	
	@DynamoDBAttribute
	private String line2;
	
	@DynamoDBAttribute
	private String city;
	
	@DynamoDBAttribute
	private String state;
	
	@DynamoDBAttribute
	private String country;
}
