package com.knoldus.request

import com.knoldus.db.CompanyReadDto
import com.knoldus.models.Employee
import com.knoldus.validator.{EmailValidator, EmployeeValidator}
import org.scalatest.funsuite.AnyFunSuite


class EmployeeImplIntegrationTest extends AnyFunSuite {
  val companyName = new CompanyReadDto
  val validateEmail = new EmailValidator
  val employeeValidator = new EmployeeValidator(companyName, validateEmail)

  val employeeImpl = new EmployeeImpl(employeeValidator)

  test("User cannot be created because company does not exist"){
    val Yeshu: Employee = new Employee("Yeshu", "Sharma", 25, 100000, "Senior Consultant", "Wipro", "yeshu.sharma@gmail.com")
    val result = employeeImpl.createEmployee(Yeshu)
    assert(result.isEmpty)
  }

  test("User not created because email is invalid"){
    val Utkarsh: Employee = new Employee("Utkarsh", "Paliwal", 21, 15000, "Intern", "Knoldus", "utkarsh.paliwal@gmail.com")
    val result = employeeImpl.createEmployee(Utkarsh)
    assert(result.isEmpty)
  }

  test("User cannot be created because email is invalid and company does not exist in DB"){
    val Athak: Employee = new Employee("Athak", "Tiwari", 23, 100000, "Developer", "Facebook", "tiwari.athak@gmail.com")
    val result = employeeImpl.createEmployee(Athak)
    assert(result.isEmpty)
  }

  test("User can be created"){
    val Utkarsh: Employee = new Employee("Utkarsh", "Paliwal", 21, 15000, "Intern", "Knoldus", "utkarsh.paliwal@knoldus.com")
    val result = employeeImpl.createEmployee(Utkarsh)
    assert(result.isDefined)
  }

}