package in.learnjavaskills.dynamodbwithawslambda.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GatewayResponse 
{
	private String patientId;
	private String message;
	private boolean isSuccess;
}
