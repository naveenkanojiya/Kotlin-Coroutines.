package com.example.coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch

class MainActivity4 : AppCompatActivity() {

    private val TAG: String = "KOTLINFUN"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)


        //Topics covered -
        //1. What are Coroutines Job & Job Hierarchy?
        //2. Learn how to cancel coroutines using cancel method
        //3. Learn how to do cooperative cancellation in Kotlin Coroutines Hindi
        //4. Cancellation Exception Handing in Coroutines - Structured Concurrency
        //5. Complete Coroutines Practical Examples


        GlobalScope.launch(Dispatchers.Main) {
           // execute()

        }


        //Example :-1
//    private suspend fun execute(){
//        val parents = GlobalScope.launch(Dispatchers.Main){
//            Log.d(TAG,"Parent - $coroutineContext")
//
//            val childJob = launch(Dispatchers.IO){
//                Log.d(TAG,"Child - $coroutineContext")
//            }
//
//        }
//    }


        //Another same Example:-2
//    private suspend fun execute(){
//        val parents = GlobalScope.launch(Dispatchers.Main){
//            Log.d(TAG,"Parent Started")
//
//            val childJob = launch(Dispatchers.IO){
//                Log.d(TAG,"Child JOb Started")
//                delay(5000)
//                Log.d(TAG,"Child JOb Ended")
//            }
//            delay(3000)
//            Log.d(TAG,"Parent Ended")
//        }
//        parents.join()
//        Log.d(TAG,"Parent Completed")
//    }

        //Another Same Example:-3 But Parent job cancel then child job automatically cancel

//    private suspend fun execute(){
//        val parents = GlobalScope.launch(Dispatchers.Main){
//            Log.d(TAG,"Parent Started")
//
//            val childJob = launch(Dispatchers.IO){
//                Log.d(TAG,"Child JOb Started")
//                delay(5000)
//                Log.d(TAG,"Child JOb Ended")
//            }
//            delay(3000)
//            Log.d(TAG,"Parent Ended")
//        }
//        delay(1000)
//        parents.cancel()
//        parents.join()
//        Log.d(TAG,"Parent Completed")
//    }

        //In this Example:-4 We want according your choose to delete the Child JOb...

//    private suspend fun execute(){
//        val parents = GlobalScope.launch(Dispatchers.Main){
//            Log.d(TAG,"Parent Started")
//
//            val childJob = launch(Dispatchers.IO){
//                Log.d(TAG,"Child JOb Started")
//                delay(5000)
//                Log.d(TAG,"Child JOb Ended")
//            }
//            delay(3000)
//            Log.d(TAG,"Child Job Cancelled")
//            childJob.cancel()
//            Log.d(TAG,"Parent Ended ")
//        }
//
//        parents.join()
//        Log.d(TAG,"Parent Completed")
//    }
    }


        suspend fun execute() {
            var parentJob = CoroutineScope(Dispatchers.IO).launch {
                for (i in 1..1000) {
                    if (isActive){
                        executeLongRunningTask()
                        Log.d(TAG, i.toString())}

                }
            }
            delay(100)
            Log.d(TAG, "Canceling Job")
            parentJob.cancel()
            parentJob.join()
            Log.d(TAG, "Parent Completed")


        }

    }

    private fun executeLongRunningTask() {
        for (i in 1..10000000) {

        }
    }

