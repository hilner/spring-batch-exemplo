package br.gov.curso.batch;

import java.io.File;

import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.job.DefaultJobParametersValidator;

public class Validator extends DefaultJobParametersValidator {

	@Override
	public void validate(JobParameters parameters)
			throws JobParametersInvalidException {
		String arquivo = (String) parameters.getParameters().get("arquivo")
				.getValue();
		if (!new File(arquivo).exists()) {
			throw new JobParametersInvalidException("Arquivo inexistente!");
		}
		super.validate(parameters);
	}

}
