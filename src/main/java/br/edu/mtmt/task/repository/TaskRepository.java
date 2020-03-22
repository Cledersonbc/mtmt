package br.edu.mtmt.task.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.edu.mtmt.task.entity.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long>{

	@Query("FROM Task task WHERE task.periodic = true and task.deleted = false")
	List<Task> findPeriodicTasks();
	
	@Query("FROM Task task WHERE task.periodic = false and task.deleted = false")
	List<Task> findNonPeriodicTasks();
}
