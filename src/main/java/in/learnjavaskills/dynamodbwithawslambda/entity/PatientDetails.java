package in.learnjavaskills.dynamodbwithawslambda.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import in.learnjavaskills.dynamodbwithawslambda.enums.Diesis;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@DynamoDBTable(tableName = "patient_details")
@Builder
public class PatientDetails 
{
	@DynamoDBHashKey(attributeName = "id")
	private Long patientId;

	@DynamoDBAttribute(attributeName = "first_name")
	private String firstName;
	
	@DynamoDBAttribute
	private String lastName;
	
	@DynamoDBAttribute
	private String diesis;
	
	@DynamoDBAttribute
	private Address address;
}
