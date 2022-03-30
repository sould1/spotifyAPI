package utils.converters


trait Converter[In, Out] {
  def convert(input: In): Out
//  def convert(input: In, input2: In): Out
  
}

