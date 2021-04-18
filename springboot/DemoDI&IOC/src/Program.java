import java.util.List;

import Controller.DepartmentController;

public class Program {
	public static void main(String[] args) {
		DIcontainer container = new DIcontainer();
		DepartmentController controller = container.initDepartmentController();

		List<String> departments = controller.getAllDepartments();
		for (String string : departments) {
			System.out.println(string);
		}

	}
}
