package br.edu.mtmt.task.dto;

import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.edu.mtmt.task.entity.Task;
import lombok.Getter;

@Getter
final public class NonPeriodicTaskInputDTO implements TaskInputDTO {
	private String name;
	private String description;

	@JsonProperty("target_time")
	private Instant targetTime;

	@Override
	public Task toTask() {
		Task task = new Task();

		task.setName(name);
		task.setDescription(description);
		task.setTargetTime(targetTime);
		task.setPeriodic(false);

		return task;
	}
}
