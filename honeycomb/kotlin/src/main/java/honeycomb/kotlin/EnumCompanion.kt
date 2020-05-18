package honeycomb.kotlin

//https://stackoverflow.com/questions/37794850/effective-enums-in-kotlin-with-reverse-lookup
open class EnumCompanion<TValue, TEnum>(private val valueMap: Map<TValue, TEnum>) {
    fun createStrictly(type: TValue) : TEnum = valueMap[type] ?: error("Value not found for enum")
}