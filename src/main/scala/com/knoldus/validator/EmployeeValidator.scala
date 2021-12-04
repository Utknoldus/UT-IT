package com.knoldus.validator

import com.knoldus.db.CompanyReadDto
import com.knoldus.models.Employee

class EmployeeValidator(companyName: CompanyReadDto, validateEmail: EmailValidator) {

  def employeeIsValid(employee: Employee): Boolean = {

    if(companyName.getCompanyByName(employee.companyName).isDefined && validateEmail.emailIdIsValid(employee.emailId))
      true
    else
      false
  }
}
