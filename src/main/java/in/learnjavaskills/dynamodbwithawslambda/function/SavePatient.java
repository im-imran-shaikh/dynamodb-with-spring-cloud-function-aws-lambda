package in.learnjavaskills.dynamodbwithawslambda.function;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;
import java.util.stream.IntStream;

import org.springframework.stereotype.Service;

import in.learnjavaskills.dynamodbwithawslambda.dto.GatewayRequest;
import in.learnjavaskills.dynamodbwithawslambda.dto.GatewayResponse;
import in.learnjavaskills.dynamodbwithawslambda.entity.Address;
import in.learnjavaskills.dynamodbwithawslambda.entity.PatientDetails;
import in.learnjavaskills.dynamodbwithawslambda.exception.PatientException;
import in.learnjavaskills.dynamodbwithawslambda.repository.PatientDetailsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RequiredArgsConstructor
@Service
@Log4j2
public class SavePatient implements Function<GatewayRequest, GatewayResponse> 
{
	private final PatientDetailsRepository patientDetailsRepository;
	

	@Override
	public GatewayResponse apply(GatewayRequest gatewayRequest)
	{
		return savePatient(gatewayRequest);
	}
	
	private GatewayResponse savePatient(GatewayRequest gatewayRequest)
	{
		try
		{
			if (Objects.isNull(gatewayRequest) ||  Objects.isNull(gatewayRequest.getFirstName()))
				throw new PatientException("first name must be non null");
			
			PatientDetails patientDetails = patientDetailsMapper(gatewayRequest);
			PatientDetails save = patientDetailsRepository.save(patientDetails);
			
			return GatewayResponse.builder()
				.patientId(save.getPatientId().toString())
				.message("SUCCESS")
				.isSuccess(true)
				.build();
		}
		catch (Exception exception)
		{
			log.error("SOMETHING WENT WRONG IN PERSISTING PATIENT DETAILS, INSPECT MANUALLY", exception);
			return GatewayResponse.builder()
					.message("FAILED")
					.isSuccess(false)
					.build();
		}
	}
	
	private PatientDetails patientDetailsMapper(GatewayRequest gatewayRequest)
	{
		String addressInPipeSeparated = gatewayRequest.getAddress();
		AtomicReference<Address> addressAtomicReference = new AtomicReference<>();
		Address address = new Address();
		addressAtomicReference.set(address);
		
		
		if (Objects.nonNull(addressInPipeSeparated) && addressInPipeSeparated.contains("|"))
		{
			String[] addressParameters = addressInPipeSeparated.split("\\|");
			IntStream.iterate(0, increment -> increment + 1)
				.limit(addressParameters.length)
				.forEach(index -> {
					Address patientAddress = addressAtomicReference.get();
					if (index == 0)
						patientAddress.setLine1(addressParameters[index].trim());
					else if (index == 1)
						patientAddress.setLine2(addressParameters[index].trim());
					else if (index == 2)
						patientAddress.setCity(addressParameters[index].trim());
					else if (index == 3)
						patientAddress.setState(addressParameters[index].trim());
					else if (index == 4)
						patientAddress.setCountry(addressParameters[index].trim());
					addressAtomicReference.set(patientAddress);
				});
		}
		
		return PatientDetails.builder()
				.firstName(gatewayRequest.getFirstName())
				.lastName(gatewayRequest.getLastName())
				.diesis(gatewayRequest.getDiesis())
				.address(addressAtomicReference.get())
				.build();
		
	}

}
