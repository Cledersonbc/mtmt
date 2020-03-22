package br.edu.mtmt.task.entity;

import org.springframework.util.StringUtils;

public enum PeriodicType {
	NONE,
	MINUTE,
	HOUR,
	DAILY,
	WEEKLY,
	MONTHLY,
	ANNUALY;

	@Override
	public String toString() {
		return StringUtils.capitalize(
				super.toString().toLowerCase()
		);
	}
}