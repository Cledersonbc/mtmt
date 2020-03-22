package br.edu.mtmt.task.entity;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Task {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String name;
	
	private String description;
	
	private boolean periodic;

	@Column(name = "periodic_type")
	@Enumerated(EnumType.STRING)
	private PeriodicType periodicType;
	
	@Column(columnDefinition = "boolean default false")
	private boolean finished;

	@Column(name = "logged_time")
	private Instant loggedTime;
	
	@Column(name = "target_time")
	private Instant targetTime;
	
	@Column(name = "creation_time")
	private Instant creationTime;
	
	@Column(columnDefinition = "boolean default false")
	private boolean deleted;
	
	@Override
	public String toString() {
		return "Task [id=" + id + ", name=" + name + "]";
	}	
}
