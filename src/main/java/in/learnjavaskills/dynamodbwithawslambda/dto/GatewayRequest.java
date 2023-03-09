package in.learnjavaskills.dynamodbwithawslambda.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class GatewayRequest 
{
	private Long patientId;

	private String firstName;
	
	private String lastName;
	
	private String diesis;
	
	private String address; // address in pipe(|) seperated, line1 | line 2 | city | state | country
}
