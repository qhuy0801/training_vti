import Controller.DepartmentController;
import Repository.AccountRepository;
import Repository.DepartmentRepository;
import Service.DepartmentService;

public class DIcontainer {

	public DepartmentController initDepartmentController() {
		DepartmentService departmentService = initDepartmentService();
		return new DepartmentController(departmentService);
	}

	public DepartmentService initDepartmentService() {
		DepartmentRepository departmentRepository = initDepartmentRepository();
		AccountRepository accountRepository = initAccountRepository();
		return new DepartmentService(departmentRepository, accountRepository);
	}

	public DepartmentRepository initDepartmentRepository() {
		return new DepartmentRepository();
	}

	public AccountRepository initAccountRepository() {
		return new AccountRepository();
	}
}
