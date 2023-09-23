package com.example.coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.yield
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    private val TAG: String = "KOTLINFUN"

    lateinit var counterText: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //Topics covered -
        //1. Process, Thread and Coroutines
        //2. Issue with Threads
        //3. What is Coroutine?
        //3. How coroutines solves this problem?
        //4. What are cooperating functions?


        counterText = findViewById(R.id.textView)
        Log.d(TAG, "${Thread.currentThread().name}")

    }

    fun UpdateCounter(view: View) {
        Log.d(TAG,"${Thread.currentThread().name}")
        "${counterText.text.toString().toInt() +1}".also { counterText.text = it }
    }

    private fun executeLongRunningTask(){
        for (i in 1..1000000000000L){

        }
    }


    fun doAction(view: View) {
        CoroutineScope(Dispatchers.IO).launch {
            Log.d(TAG, "1 - ${Thread.currentThread().name}")
        }
        GlobalScope.launch(Dispatchers.Main) {
            Log.d(TAG, "2 - ${Thread.currentThread().name}")
        }
        MainScope().launch(Dispatchers.Default) {
            Log.d(TAG, "3 - ${Thread.currentThread().name}")
        }
    }
}


