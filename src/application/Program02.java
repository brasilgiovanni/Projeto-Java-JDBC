package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program02 {

	public static void main(String[] args) {
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		/*
		System.out.println("=== TEST 1: Department insert ===");
		Department newDepartment = new Department(null, "Engineeres");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted! New id = " + newDepartment.getId());
		*/
		
		System.out.println("\n=== TEST 2: Department findById ===");
		Department department = departmentDao.findById(3);
		System.out.println("The Department with id = 3 is: " + department);
		
		
		System.out.println("\n=== TEST 3: Department Update ===");
		Department modifyDepartment = departmentDao.findById(6);
		modifyDepartment.setName("Administration");
		departmentDao.update(modifyDepartment);
		System.out.println("Update Completed!");
		
		System.out.println("\n=== TEST 4: Department delete ===");
		departmentDao.deleteById(13);
		System.out.println("The reference Department was deleted.");
		
		System.out.println("\n=== TEST 5: Department findAll ===");
		List<Department> list = departmentDao.findAll();
		int k = 1;
		for (Department dep : list) {
			System.out.println("Department nº " + k + ": " +  dep);
			k++;
		}
		
	}

}
