package com.example.coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.yield

class MainActivity2 : AppCompatActivity() {

    private val TAG: String = "KOTLINFUN"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)


//        Topics covered -
//1. What are suspending functions in Hindi?
//2. How suspend works behind the scene.
//3. Learn how to use yield and delay in Kotlin

        CoroutineScope(Dispatchers.Main).launch {

            task1()
        }

        CoroutineScope(Dispatchers.Main).launch {

            task2()
        }
    }


    suspend fun task1() {
        Log.d(TAG, "STARTING TASK 1")
        yield()
        delay(1000)
        Log.d(TAG, "END TASK 1")
    }

    suspend fun task2() {
        Log.d(TAG, "STARTING TASK 2")
        yield()
        delay(1000)
        Log.d(TAG, "END TASK 2")
    }
}
