package maxdistructo.utils

object CollectionUtils{

    fun jsonArrayToList(jsonArray: JSONArray) : List<Any>{
        var i = 0
        var outList = listOf<Any>()
        while(i < jsonArray.count()){
            outList += jsonArray[i]
            i++
        }
        return outList
    }
    fun jsonArrayToArray(jsonArray : JSONArray) : Array<Any>{ //JSONArray returns only objects and because this code does not know what the values are specifically, it returns an array with Any/Object values
      var output = arrayOf<Any>(jsonArray.length)
      for(value in jsonArray){
        output.add(value)
      }
      return output
    }
    fun collectionToJsonArray(input : Collection<*>) : JSONArray{
        return JSONArray(input)
    }
    fun arrayToList(array : Array<String>) : List<String> { //Legacy & Convenience
        return collectionToList(array)
    }
    fun listToArray(list : List<String>) : Array<String>{ //Legacy & Convenience
        return collectionToArray(list)
    }
    fun collectionToArray(input : Collection<T>) : Array<T>{
      var output : Array<T> = arrayOf<T>(input.size)
      for (value in input){
        output.add(value)
      }
      return output
    }
    fun collectionToList(input : Collection<T>) : List<T>{
      var output : List<T> = listOf<T>()
      for(value in input){
        output += value
      }
      return output
    }
}
