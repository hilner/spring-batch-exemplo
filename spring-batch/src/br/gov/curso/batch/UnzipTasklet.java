package br.gov.curso.batch;

import net.lingala.zip4j.core.ZipFile;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

public class UnzipTasklet implements Tasklet {

	private String inputFile;
	private String destPath;

	public RepeatStatus execute(StepContribution stepContribution,
			ChunkContext chunkContext) throws Exception {

		inputFile = (String) chunkContext.getStepContext().getJobParameters().get("arquivo");
		destPath = (String) chunkContext.getStepContext().getJobParameters().get("destino");
		
		ZipFile file = new ZipFile(inputFile);
		file.extractAll(destPath);

		return RepeatStatus.FINISHED;

	}

	public String getInputFile() {
		return inputFile;
	}

	public void setInputFile(String inputFile) {
		this.inputFile = inputFile;
	}

	public String getDestPath() {
		return destPath;
	}

	public void setDestPath(String destPath) {
		this.destPath = destPath;
	}

}
