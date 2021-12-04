package com.knoldus.validator

import com.knoldus.db.CompanyReadDto
import com.knoldus.validator.EmailValidator
import com.knoldus.models.{Company,Employee}
import org.mockito.MockitoSugar.{mock, when}
import org.scalatest.funsuite.AnyFunSuite

class EmployeeValidatorTest extends AnyFunSuite {

  val employee = new Employee("Utkarsh","Paliwal",22,15000,"intern","knoldus","utkarsh.paliwal@knoldus.com")
  val knoldusCompany: Company = Company("Knoldus","knoldus@gmail.com","Noida")
  val companyRead = mock[CompanyReadDto]
  val emailValidator = mock[EmailValidator]
  val employeeValidator = new EmployeeValidator(companyRead,emailValidator)

  test("Employee should be valid"){
    when(companyRead.getCompanyByName(employee.companyName)).thenReturn(Option(knoldusCompany))
    when(emailValidator.emailIdIsValid(employee.emailId)).thenReturn(true)

    val result = employeeValidator.employeeIsValid(employee)

    assert(result)
  }

  test("Employee is not valid because of the invalid email"){
    when(companyRead.getCompanyByName(employee.companyName)).thenReturn(Option(knoldusCompany))
    when(emailValidator.emailIdIsValid(employee.emailId)).thenReturn(false)

    val result = employeeValidator.employeeIsValid(employee)

    assert(!result)
  }

  test("Employee is note valid because its company does not exists in Database"){
    when(companyRead.getCompanyByName(employee.companyName)).thenReturn(None)
    when(emailValidator.emailIdIsValid(employee.emailId)).thenReturn(true)

    val result = employeeValidator.employeeIsValid(employee)
    assert(!result)
  }

  test("Employee is not valid its company not exist in DB and email is not valid"){
    when(companyRead.getCompanyByName(employee.companyName)).thenReturn(None)
    when(emailValidator.emailIdIsValid(employee.emailId)).thenReturn(false)
    val result = employeeValidator.employeeIsValid(employee)
    assert(!result)
  }
}
