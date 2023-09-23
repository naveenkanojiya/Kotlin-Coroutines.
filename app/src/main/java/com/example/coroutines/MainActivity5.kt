package com.example.coroutines

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

class MainActivity5 : AppCompatActivity() {

    private val TAG: String = "KOTLINFUN"

    lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5)


        //Topics covered -
        //1. What is withContext function in Kotlin coroutines in Hindi
        //2. Learn what is runBlocking in Kotlin Coroutines
        //3. Complete Coroutines Practical Examples
//
//        GlobalScope.launch {
//           // executeTask()
//        }
//        runBlocking {
//            launch {
//                delay(6000)
//                Log.d(TAG,"World")
//            }
//            Log.d(TAG,"Hello")
//        }


//    }

//    private suspend fun executeTask() {
//        Log.d(TAG,"Before")
//        withContext(Dispatchers.IO){
//            delay(9000)
//            Log.d(TAG,"Inside")
//        }
//        delay(5000)
//        Log.d(TAG,"After")
//
//    }


//}


//ViewModelScope & LifecycleScope in Android Coroutines

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        lifecycleScope.launch {
            delay(2000)
            val intent= Intent(this@MainActivity5,MainActivity6::class.java)
            startActivity(intent)
            finish()
        }
    }
}