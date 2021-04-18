package com.trainingvti.entity.Salary;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import java.util.stream.Stream;

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
				.filter(s -> s.getValue().equals(dbData)).findFirst()
				.orElseThrow(IllegalArgumentException::new);
	}
}