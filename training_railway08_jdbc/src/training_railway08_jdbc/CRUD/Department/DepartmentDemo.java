package training_railway08_jdbc.CRUD.Department;

import java.util.List;

public class DepartmentDemo {
public static void main(String[] args) throws Exception {
	DepartmentProgram program = new DepartmentProgram();
	
	List<Department> getListDepartment = program.getListDepartment();
	
	for (Department department : getListDepartment) {
		System.out.println(department.toString());
	}
}
}
