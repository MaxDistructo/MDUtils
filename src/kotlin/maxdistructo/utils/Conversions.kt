package maxdistructio.utils

import org.json.JSONArray

object Conversions{

    fun jsonArrayToList(jsonArray: JSONArray) : List<Any>{
        var i = 0
        var outList = listOf<Any>()
        while(i < jsonArray.count()){
            outList += jsonArray[i]
            i++
        }
        return outList
    }
    fun arrayToList(array : Array<String>) : List<String> {
        var output : List<String> = listOf()
        for(value in array){
            output += value
        }
        return output
    }
    fun listToArray(list : List<String>) : Array<String>{
        val output : ArrayList<String> = arrayListOf()
        for(value in list){
            output.add(value)
        }
        return output.toTypedArray()
    }
    
    private val currentRelativePath = Paths.get("")
    val s = currentRelativePath.toAbsolutePath().toString()
    
    /**
    *   Creates a new String using the provided Array and a position to start at. This start position is based on the number in the array.
    *   Ex. To cut out the first value in an array and make it into a string, input 1 for startAt
    *   @param input The array to draw from
    *   @param startAt The value to start from
    *   @return A string built off of all the values the array after the specified value.
    */
    fun makeNewString(input: Array<Any>, startAt: Int): String {
        val stringBuilder = StringBuilder()
        var i = startAt
        while (i < input.size) {
            if (i - 1 == input.size) {
                stringBuilder.append(input[i])
            } else {
                stringBuilder.append(input[i])
                stringBuilder.append(" ")
            }
            i++
        }
        return stringBuilder.toString()
    }
    
    /**
    *   Converts the input to a Long value. Returns null if the convert fails.
    *   @param o The object to try and convert to Long
    *   @return The long value of the input or null if it is unable to be converted
    */

    fun convertToLong(o: Any): Long? {
        return try {
            java.lang.Long.valueOf(o.toString())
        }
        catch(e : Exception){
            null
        }
    }

    /**
    *   Converts the input to an Int value. Returns null if the convert fails or is impossible.
    *   @param in The object to convert
    *   @return The converted object or null
    */
    
    fun convertToInt(`in`: Any): Int {
        return Integer.valueOf(`in`.toString())
    }
    
    /**
    *   Converts the inputed {@link org.json.JSONArray} to an Array of Strings 
    *   @param array The JSON array to convert to String
    *   @return The string array or null if the convert is impossible or fails
    */
    
    fun toStringArray(array: JSONArray?): Array<String?>? {
        if (array == null)
            return null

        val arr = arrayOfNulls<String>(array.length())
        for (i in arr.indices) {
            arr[i] = array.optString(i)
        }
        return arr
    }
    
    /**
    *   Similar to #makeNewString but puts new lines between the values instead of spaces
    *   @param input The array to convert
    *   @param startAt The spot in the array to start reading at
    *   @return The String with new lines
    */

    fun makeNewLineString(input: Array<String?>, startAt: Int): String {
        val stringBuilder = StringBuilder()
        var i = startAt
        while (i < input.size) {
            stringBuilder.append(input[i])
            stringBuilder.append("\n")
            i++
        }
        return stringBuilder.toString()
    }
    
    /**
    *   Reads the JSON from the specified file
    *   @param fileName The path to the file in relation to the location of the running directory
    *   @return The JSON object from the file.
    */

    fun readJSONFromFile(fileName: String): JSONObject {

        val file = File(s + fileName)

        val uri = file.toURI()
        var tokener: JSONTokener? = null
        try {
            tokener = JSONTokener(uri.toURL().openStream())
        } catch (e: IOException) {
            Message.sendDM(Client.client!!.applicationOwner, e.toString())
            e.printStackTrace()
        }

        return if (tokener != null) {
            JSONObject(tokener)
        } else {
            throw NullPointerException()
        }
    }

    /**
     * Writes the provided JSONObject to file
     * @param path The relative location to the running directory
     * @param jsonObject The object to write to File
     */

    fun writeJSONToFile(path: String, jsonObject: JSONObject) {
        val file = File(s + path)
            try {
                file.createNewFile()
            } catch (e: IOException) {
                Message.throwError(e)
            }

        try {
            FileWriter(s + path).use { fileWriter ->
                fileWriter.write(jsonObject.toString())
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }

    }
    
     fun readFileAsList(file: File): List<String>? {
        var lines: List<String>? = null
        try {
            lines = Files.readAllLines(Paths.get(file.toURI()))
        } catch (e: Exception) {
            Message.throwError(e)
        }

        return lines
    }


}
