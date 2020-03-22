package br.edu.mtmt.task.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.edu.mtmt.task.entity.PeriodicType;
import br.edu.mtmt.task.entity.Task;
import lombok.Getter;

@Getter
final public class PeriodicTaskInputDTO implements TaskInputDTO {
	private String name;
	private String description;
	
	@JsonProperty("periodic_type")
	private PeriodicType periodicType;
	
	@Override
	public Task toTask() {
		Task task = new Task();

		task.setName(name);
		task.setDescription(description);
		task.setPeriodic(true);
		task.setPeriodicType(periodicType);

		return task;
	}
}
