package com.math.calculations

import org.scalatest.funsuite.AnyFunSuite

class LogicFileTest extends AnyFunSuite {
  var LogicFile_Object = new LogicFile()

  //  test for divide logic

  test("To check division of zero"){
    val n1 = 0
    val n2 = 2
    val res = 0

    assert(LogicFile_Object.divisionOf(n1,n2)==res)
  }

  test("To check division by zero"){
    assertThrows[ArithmeticException](LogicFile_Object.divisionOf(132,0))
  }

  // test for Fibonacci

  test("Test to check fibonacci of zero"){
    val num = 0
    val res = 0
    assert(LogicFile_Object.fibonacciOf(num)==res)
  }

  test("To check fibonacci"){
    val num = 9
    val res = 34
    assert(LogicFile_Object.fibonacciOf(num)==res)
  }
}
