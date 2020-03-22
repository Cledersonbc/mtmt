package br.edu.mtmt.task.service;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.edu.mtmt.task.dto.NonPeriodicTaskOutputDTO;
import br.edu.mtmt.task.dto.PeriodicTaskOutputDTO;
import br.edu.mtmt.task.dto.TaskOutputDTO;
import br.edu.mtmt.task.entity.PeriodicType;
import br.edu.mtmt.task.entity.Task;
import br.edu.mtmt.task.repository.TaskRepository;

@Service
public class TaskService {

	@Autowired
	private TaskRepository repository;

	public ResponseEntity<TaskOutputDTO> createPeriodicTask(Task task) {

		task.setCreationTime(Instant.now());
		TaskOutputDTO createdTask = new PeriodicTaskOutputDTO(repository.save(task));

		return new ResponseEntity<>(createdTask, HttpStatus.CREATED);
	}
	
	public ResponseEntity<TaskOutputDTO> createNonPeriodicTask(Task task) {

		task.setPeriodicType(PeriodicType.NONE);
		task.setCreationTime(Instant.now());
		TaskOutputDTO createdTask = new NonPeriodicTaskOutputDTO(repository.save(task));

		return new ResponseEntity<>(createdTask, HttpStatus.CREATED);
	}

	public ResponseEntity<Task> find(Long id) {
		Task task = repository.findById(id).orElse(null);

		return new ResponseEntity<>(task, HttpStatus.OK);
	}
	
	public ResponseEntity<List<Task>> findAll() {
		List<Task> tasks = repository.findAll();

		return new ResponseEntity<>(tasks, HttpStatus.OK);
	}
	
	public ResponseEntity<List<TaskOutputDTO>> findPeriodicTasks() {
		List<TaskOutputDTO> tasks = repository.findPeriodicTasks()
				.stream()
				.map(t -> new PeriodicTaskOutputDTO(t))
				.collect(Collectors.toList());

		return new ResponseEntity<>(tasks, HttpStatus.OK);
	}

	public ResponseEntity<List<TaskOutputDTO>> findNonPeriodicTasks() {
		List<TaskOutputDTO> tasks = repository.findNonPeriodicTasks()
				.stream()
				.map(t -> new NonPeriodicTaskOutputDTO(t))
				.collect(Collectors.toList());

		return new ResponseEntity<>(tasks, HttpStatus.OK);
	}

}
