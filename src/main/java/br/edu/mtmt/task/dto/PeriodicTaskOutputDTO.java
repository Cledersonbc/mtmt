package br.edu.mtmt.task.dto;

import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.edu.mtmt.task.entity.PeriodicType;
import br.edu.mtmt.task.entity.Task;
import lombok.Getter;

@Getter
final public class PeriodicTaskOutputDTO implements TaskOutputDTO {
	private String name;
	private String description;

	@JsonProperty("creation_time")
	private Instant creationTime;
	
	@JsonProperty("logged_time")
	private Instant loggedTime;
	
	@JsonProperty("periodic_type")
	private PeriodicType periodicType;
	
	private boolean finished;
	
	public PeriodicTaskOutputDTO(Task task) {
		this.name = task.getName();
		this.description = task.getDescription();
		this.creationTime = task.getCreationTime();
		this.loggedTime = task.getLoggedTime();
		this.periodicType = task.getPeriodicType();
		this.finished = task.isFinished();
	}
}
