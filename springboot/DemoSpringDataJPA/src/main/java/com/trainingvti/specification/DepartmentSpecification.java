package com.trainingvti.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.trainingvti.entity.Department.Department;



public class DepartmentSpecification implements Specification<Department> {

	private static final long serialVersionUID = 1L;

	private String key;
	private String operator;
	private Object value;

	public DepartmentSpecification(String key, String operator, Object value) {
		this.key = key;
		this.operator = operator;
		this.value = value;
	}
	
//	public DepartmentSpecification(String key, String operator, Object value, Object value2) {
//		this.key = key;
//		this.operator = operator;
//		this.value = value;
//	}

	@Override
	public Predicate toPredicate(Root<Department> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
		if (operator.equalsIgnoreCase("=")) {
			return builder.equal(root.<String>get(key), value.toString());
		}

		if (operator.equalsIgnoreCase(">=")) {
			return builder.greaterThanOrEqualTo(root.<String>get(key), value.toString());
		}
		
		if (operator.equalsIgnoreCase("<=")) {
			return builder.lessThanOrEqualTo(root.<String>get(key), value.toString());
		}
		
		if (operator.equalsIgnoreCase("LIKE")) {
			return builder.like(root.<String>get(key), "%" + value.toString() + "%");
		}
		
//		if (operator.equalsIgnoreCase("BETWEEN")) {
//			return builder.between(root.<String>get(key), value.toString(), value2.toString());
//		}
		return null;
	}

}

