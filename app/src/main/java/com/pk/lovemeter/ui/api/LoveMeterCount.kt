class LoveMeterCount {
    fun getLoveCount(name1:String,name2:String):Long{
        val fullname = name1.lowercase() +"loves"+name2.lowercase()
        val arr = fullname.toCharArray()
        val uniqueSet = getUniqueCharSequence(arr)
        var genratedNumber:String = ""

        for (i in uniqueSet)
        {
            val num = getFreq(i,arr)
            genratedNumber += num
        }
        val final =  getNumber(genratedNumber)
        return final
    }
    private fun getNumber(num:String):Long
    {
        var number = num
        val n = num.toLong()
        return if (n<100)
            n
        else
        {
            val num1 = Character.getNumericValue(number.first())
            val num2 = Character.getNumericValue(number.first())

            number = number.drop(0)
            number = number.drop(number.length)

            val final = num1.toString()+num2.toString()+number
            getNumber(final)
        }
    }
    private fun getFreq(char:Char,arr:CharArray):Int{
        var freq = 0
        for (i in arr)
            if (i.equals(char))
                freq+=1

        return freq
    }

    private fun getUniqueCharSequence(arr:CharArray): LinkedHashSet<Char> {
        val uniqueChar = linkedSetOf<Char>()
        for (i in arr) uniqueChar.add(i)
        return uniqueChar
    }
}