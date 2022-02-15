package com.ch.team.service;

import com.ch.team.domain.PC;
import com.ch.team.domain.*;

import static com.ch.team.service.Data.*;

/**
 * @Descrition 负责将Data中的数据封装到Employee[]数组中，同时提供相关操作Employee[]的方法
 * @author chenpi
 * 
 */
public class NameListService {
	private Employee[] employees;// 保存公司所有员工的对象

	/**
	 * 给empoyees及数组元素进行初始化
	 */
	public NameListService() {
		// 根据项目提供的Data类构建相应大小的employee数组
		// 再根据Data类中的数据构建不同的对象，包括Employee、Programmer、Designer、Architect对象，以及相关联Equipment实现类的对象
		// 将对象存在数组中
		employees = new Employee[EMPLOYEES.length];

		for (int i = 0; i < employees.length; i++) {

			int type = Integer.parseInt(EMPLOYEES[i][0]);
			// 获取Employee的4个基本信息
			int id = Integer.parseInt(EMPLOYEES[i][1]);
			String name = EMPLOYEES[i][2];
			int age = Integer.parseInt(EMPLOYEES[i][3]);
			double salary = Double.parseDouble(EMPLOYEES[i][4]);

			Equipment equipment;
			double bonus;
			int stock;

			switch (type) {
			case EMPLOYEE:
				employees[i] = new Employee(id, name, age, salary);
				break;
			case PROGRAMMER:
				equipment = createEquipment(i);
				employees[i] = new Programmer(id, name, age, salary, equipment);
				break;
			case DESIGNER:
				equipment = createEquipment(i);
				bonus = Double.parseDouble(EMPLOYEES[i][5]);
				employees[i] = new Designer(id, name, age, salary, equipment, bonus);
				break;
			case ARCHITECT:
				equipment = createEquipment(i);
				bonus = Double.parseDouble(EMPLOYEES[i][5]);
				stock = Integer.parseInt(EMPLOYEES[i][6]);
				employees[i] = new Architect(id, name, age, salary, equipment, bonus, stock);
				break;
			default:
				break;
			}
		}
	}

	/**
	 * @Descrition 获取指定index上的员工的设备
	 * @param index
	 * @return
	 */
	private Equipment createEquipment(int index) {
		int type = Integer.parseInt(EQUIPMENTS[index][0]);
		switch (type) {
		case PC:// 21
			return new PC(EQUIPMENTS[index][1], EQUIPMENTS[index][2]);
		case NOTEBOOK:// 22
			return new NoteBook(EQUIPMENTS[index][1], Double.parseDouble(EQUIPMENTS[index][2]));
		case PRINTER:// 23
			return new Printer(EQUIPMENTS[index][1], EQUIPMENTS[index][2]);
		default:
			return null;
		}
	}

	/**
	 * 
	 * @Descrition 获取当前所有员工
	 * @return 包含所有员工对象的数组
	 */
	public Employee[] getAllEmployees() {
		return employees;
	}

	/**
	 * 
	 * @Descrition 获取指定ID的员工对象
	 * @param id 指定员工ID
	 * @return 指定员工对象
	 * @throws TeamException 找不到指定的员工
	 */
	public Employee getEmploy(int id) throws TeamException {
		for (int i = 0; i < employees.length; i++) {
			if (employees[i].getId() == id) {
				return employees[i];
			}
		}

		throw new TeamException("找不到指定的员工");
	}
}
