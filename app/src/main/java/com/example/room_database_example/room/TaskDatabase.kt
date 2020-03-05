package com.example.room_database_example.room

import android.content.Context
import androidx.room.RoomDatabase

abstract class TaskDatabase private constructor(): RoomDatabase() {

    public class SingletonDemo private constructor() {
        init {
            // define in constructor
        }

        private object Holder { val INSTANCE = SingletonDemo() }

        companion object {
            @JvmStatic
            fun getInstance(): SingletonDemo{
                return Holder.INSTANCE
            }
        }


    }
}