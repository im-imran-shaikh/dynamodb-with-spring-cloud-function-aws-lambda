package in.learnjavaskills.dynamodbwithawslambda.handler;

import org.springframework.cloud.function.adapter.aws.SpringBootRequestHandler;

import in.learnjavaskills.dynamodbwithawslambda.dto.GatewayRequest;
import in.learnjavaskills.dynamodbwithawslambda.dto.GatewayResponse;

@SuppressWarnings("deprecation")
public class RequestHandler extends SpringBootRequestHandler<GatewayRequest, GatewayResponse>
{

}
