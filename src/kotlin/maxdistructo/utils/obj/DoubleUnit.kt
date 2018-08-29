package maxdistructo.utils.obj

class DoubletUnit : Unit{
  override var value : Double
  override val unit : String
  
  constructor(valueIn : Double, unitIn : String){
    value = valueIn
    unit = unitIn
  }
  
}
