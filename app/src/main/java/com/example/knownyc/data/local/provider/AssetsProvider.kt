package com.example.knownyc.data.local.provider

interface AssetsProvider {

    // Gives JSON as string for a file name
    suspend fun getJsonData(fileName: String): String

    //Gives ID for any drawable
    suspend fun  getDrawableResourceID(name:String): Int
}