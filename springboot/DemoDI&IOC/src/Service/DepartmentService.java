package Service;
import java.util.List;

import Repository.AccountRepository;
import Repository.DepartmentRepository;

public class DepartmentService {
	private AccountRepository accountRepository;
	private DepartmentRepository departmentRepository;

	public DepartmentService(DepartmentRepository departmentRepository, AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
		this.departmentRepository = departmentRepository;
	}

	public List<String> getAllDepartments() {
		return departmentRepository.getAllDepartments();
	}
}
