@file:Suppress("UNCHECKED_CAST")

package com.example.todo

import android.content.Context
import android.util.Log
import java.io.FileInputStream
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.io.ObjectInputStream
import java.io.ObjectOutputStream

class FileHelper {
    val filename="listinfo.dat"
    fun writedata(item:ArrayList<String>,context: Context){
        var fos:FileOutputStream=context.openFileOutput(filename,Context.MODE_PRIVATE)
        var oas=ObjectOutputStream(fos)
        oas.writeObject(item)
        oas.close()

    }
    fun readdata(context: Context): ArrayList<String> {
        var itemlist = ArrayList<String>()
        try {
            val fis: FileInputStream = context.openFileInput(filename)
            val ois = ObjectInputStream(fis)
            itemlist = ois.readObject() as ArrayList<String>
            ois.close()
            fis.close()
        } catch (e: Exception) {
            Log.d("readdata", "File not found or error reading file: ${e.message}")
        }

        return itemlist
    }

}