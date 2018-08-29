package maxdistructo.utils.obj

class IntUnit : Unit{
  override var value : Int
  override val unit : String
  
  constructor(valueIn : Int, unitIn : String){
    value = valueIn
    unit = unitIn
  }
  
}
