package com.example.task.room

import androidx.room.TypeConverter

class Converter {

//    @TypeConverter
//    fun fromOriginal(original: Original): String{
//        return original.original
//    }
//
//    @TypeConverter
//    fun toOriginal(s: String): Original {
//        return Original(s, s)
//    }
//
//
    @TypeConverter
    fun fromList(l: MutableList<String>): String{
        var string = ""
        for(s in l){
            string += "$s,"
        }

    return string.substring(0, string.length-1)
    }

    @TypeConverter
    fun toList(s: String): MutableList<String>{

        val mList: MutableList<String> = mutableListOf()

        for(string in s.split(",")){

//            if(string.isNotEmpty()) {
//                mList.add(string)
//            }


            mList.add(string)
        }

        return mList
    }
//
//
//
//    @TypeConverter
//    fun fromLonlat(lonlat: Coordinates): ArrayList<Double> {
//        val list: ArrayList<Double> = ArrayList()
//
//        list.add(lonlat.lon)
//        list.add(lonlat.lat)
//        return list
//    }
//
//    @TypeConverter
//    fun toLonLat(l: ArrayList<Double>): Coordinates{
//        return Coordinates(l[0], l[1])
//    }


//    @TypeConverter
//    fun fromLoc(loc: Location): ArrayList<Double>{
//        return fromLonlat(Coordinates(loc.coordinates.lon, loc.coordinates.lat))
//    }
//
//    @TypeConverter
//    fun toLoc(l: ArrayList<Double>): Location{
//        return Location()
//    }


//    @TypeConverter
//    fun listToJson(value: List<Experience>?): String {
//
//        return Gson().toJson(value)
//    }
//
//    @TypeConverter
//    fun jsonToList(value: String): List<Experience> {
//
//        return Gson().fromJson(value, Array<Experience>::class.java).toList()
//    }



}