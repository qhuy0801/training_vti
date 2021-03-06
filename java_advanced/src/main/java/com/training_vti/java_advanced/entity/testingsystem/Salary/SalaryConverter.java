package com.training_vti.java_advanced.entity.testingsystem.Salary;

import java.util.stream.Stream;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class SalaryConverter implements AttributeConverter<SalaryName, String>{

	@Override
	public String convertToDatabaseColumn(SalaryName attribute) {
		if (attribute == null) {
			return null;
		}
		return attribute.getValue();
	}

	@Override
	public SalaryName convertToEntityAttribute(String dbData) {
		if (dbData == null) {
			return null;
		}
		
		return Stream.of(SalaryName.values())
				.filter(s -> s.getValue().equals(dbData))
				.findFirst()
				.orElseThrow(IllegalArgumentException::new);
	}
}
