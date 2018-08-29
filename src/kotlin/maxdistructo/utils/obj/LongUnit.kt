package maxdistructo.utils.obj

class LongUnit : Unit{
  override var value : Long
  override val unit : String
  
  constructor(valueIn : Long, unitIn : String){
    value = valueIn
    unit = unitIn
  }
  
}
