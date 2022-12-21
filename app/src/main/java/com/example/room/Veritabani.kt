package com.example.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Kisiler::class], version = 1)
abstract class Veritabani:RoomDatabase() {
    abstract fun kisilerDao():KisilerDao

    companion object{
        var INSTANCE: Veritabani? = null

        fun veritabaniErisim(context: Context):Veritabani?{
            if (INSTANCE == null){
                synchronized(Veritabani::class){
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        Veritabani::class.java,
                        "rehber3.sqlite").createFromAsset("rehber3.sqlite").build()
                }
            }
            return INSTANCE
        }
    }
}