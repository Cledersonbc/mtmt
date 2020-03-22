package br.edu.mtmt.task.dto;

import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.edu.mtmt.task.entity.Task;
import lombok.Getter;

@Getter
final public class NonPeriodicTaskOutputDTO implements TaskOutputDTO {
	private String name;
	private String description;

	@JsonProperty("target_time")
	private Instant targetTime;
	
	@JsonProperty("creation_time")
	private Instant creationTime;
	
	@JsonProperty("logged_time")
	private Instant loggedTime;
	
	private boolean finished;
	
	public NonPeriodicTaskOutputDTO(Task task) {
		this.name = task.getName();
		this.description = task.getDescription();
		this.targetTime = task.getTargetTime();
		this.creationTime = task.getCreationTime();
		this.loggedTime = task.getLoggedTime();
		this.finished = task.isFinished();
	}
}
