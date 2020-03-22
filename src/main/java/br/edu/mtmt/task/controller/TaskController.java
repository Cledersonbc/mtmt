package br.edu.mtmt.task.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.mtmt.task.dto.PeriodicTaskInputDTO;
import br.edu.mtmt.task.dto.TaskOutputDTO;
import br.edu.mtmt.task.dto.NonPeriodicTaskInputDTO;
import br.edu.mtmt.task.entity.Task;
import br.edu.mtmt.task.service.TaskService;

@RequestMapping("/tasks/")
@RestController
public class TaskController {

	@Autowired
	private TaskService service;

	@PostMapping("periodic/new")
	public ResponseEntity<TaskOutputDTO> createPeriodicTask(@RequestBody PeriodicTaskInputDTO taskDTO) {
		ResponseEntity<TaskOutputDTO> response = service.createPeriodicTask(taskDTO.toTask());
		return response;
	}

	@PostMapping("nonperiodic/new")
	public ResponseEntity<TaskOutputDTO> createPunctualTask(@RequestBody NonPeriodicTaskInputDTO taskDTO) {
		ResponseEntity<TaskOutputDTO> response = service.createNonPeriodicTask(taskDTO.toTask());
		return response;
	}

	@GetMapping("{id}")
	public ResponseEntity<Task> getTask(@PathVariable("id") Long id) {
		ResponseEntity<Task> response = service.find(id);
		return response;
	}

	@GetMapping
	public ResponseEntity<List<Task>> getAllTasks() {
		ResponseEntity<List<Task>> response = service.findAll();
		return response;
	}
	
	@GetMapping("periodic")
	public ResponseEntity<List<TaskOutputDTO>> getPeriodicTasks() {
		ResponseEntity<List<TaskOutputDTO>> response = service.findPeriodicTasks();
		return response;
	}
	
	@GetMapping("nonperiodic")
	public ResponseEntity<List<TaskOutputDTO>> getNonPeriodicTasks() {
		ResponseEntity<List<TaskOutputDTO>> response = service.findNonPeriodicTasks();
		return response;
	}
}
