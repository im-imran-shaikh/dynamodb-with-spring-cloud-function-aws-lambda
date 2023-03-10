package in.learnjavaskills.dynamodbwithawslambda;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

@ExtendWith(MockitoExtension.class)
class DynamoDbWithAwsLambdaApplicationTests {

	@Test
	void contextLoads() {
		String value = "line number1 | line number2 | city | state | country";
		String[] split = value.split("\\|");
		System.out.println(split[1]);
	}

}
