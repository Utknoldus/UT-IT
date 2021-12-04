package com.knoldus.request

import com.knoldus.models.Employee
import com.knoldus.validator.EmployeeValidator
import org.mockito.MockitoSugar.{mock, when}
import org.scalatest.funsuite.AnyFunSuite

class EmployeeImplTest extends AnyFunSuite{
  val employeeValidator: EmployeeValidator = mock[EmployeeValidator]
  val Utkarsh:Employee = new Employee("Utkarsh","Paliwal",22,15000,"Intern","Knoldus","utkarsh.paliwal@gmailcom")
  val userImpl = new EmployeeImpl(employeeValidator)

  test("User can be ceated"){
    when(employeeValidator.employeeIsValid(Utkarsh)) thenReturn(true)
    val result = userImpl.createEmployee(Utkarsh)
    assert(result.isDefined)
  }
  test("User can not be created"){
    when(employeeValidator.employeeIsValid(Utkarsh)) thenReturn(false)
    val result = userImpl.createEmployee(Utkarsh)
    assert(result.isEmpty)
  }
}
