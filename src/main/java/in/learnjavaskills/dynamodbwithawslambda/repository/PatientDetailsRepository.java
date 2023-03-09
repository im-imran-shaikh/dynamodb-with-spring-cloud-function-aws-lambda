package in.learnjavaskills.dynamodbwithawslambda.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import in.learnjavaskills.dynamodbwithawslambda.entity.PatientDetails;

@Repository
public interface PatientDetailsRepository extends CrudRepository<PatientDetails, Long>
{

}
