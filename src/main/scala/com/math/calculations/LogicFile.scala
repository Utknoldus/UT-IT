package com.math.calculations

class LogicFile extends divide with fibonacci {
  override def divisionOf(num1: Int, num2: Int): Int = {
    var res:Int = 0
    res = num1/num2
    res
  }


  override def fibonacciOf(num: Int):Int = {
    if(num <= 1){
      num
    } else{
      fibonacciOf(num-1) + fibonacciOf(num-2)
    }
  }

}
