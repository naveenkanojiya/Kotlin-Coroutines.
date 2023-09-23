package com.example.coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity3 : AppCompatActivity() {

    private val TAG: String = "KOTLINFUN"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)


        //Topics covered -
        //1. What are coroutine builders in Kotlin?
        //2. Learn about Launch coroutine builder and Job object.
        //3. Learn how async coroutine builder works with the deferred object.
        //4. Complete examples covering different scenarios of async and launch.



        CoroutineScope(Dispatchers.IO).launch {
            printFolloers()
        }
    }


    //Example in Launch and job functions.................................

//    private suspend fun printFolloers() {
//        var fbfollowers =0
//        var instafollowers =0
//        var job =CoroutineScope(Dispatchers.IO).launch {
//            fbfollowers = getFbfollowers()
//        }
//        var job2 =CoroutineScope(Dispatchers.IO).launch {
//            instafollowers = getInstafollowers()
//        }
//        job.join()
//        job2.join()
//
//        Log.d(TAG,"FB- $fbfollowers, Insta - $instafollowers")
//    }
//
//    private suspend fun getFbfollowers():Int{
//        delay(1000)
//        return 50
//    }
//    private suspend fun getInstafollowers():Int{
//        delay(1000)
//        return 150
//    }


    //Same Thing in Async Await Operation............................................


//    private suspend fun printFolloers() {
//        var fb =CoroutineScope(Dispatchers.IO).async {
//             getFbfollowers()
//        }
//        var insta =CoroutineScope(Dispatchers.IO).async {
//            getInstafollowers()
//        }
//        Log.d(TAG,"FB- ${fb.await()} - ${insta.await()}")
//    }
//
//    private suspend fun getFbfollowers():Int{
//        delay(1000)
//        return 50
//    }
//    private suspend fun getInstafollowers():Int{
//        delay(1000)
//        return 150
//    }
//}





//Another Same Example with Async await..............................................


    private suspend fun printFolloers() {
        CoroutineScope(Dispatchers.IO).launch {
            var fb = async { getFbfollowers() }
            var insta  = async { getInstafollowers() }
            Log.d(TAG," FB - ${fb.await()}, Insta- ${insta.await()}")
        }
    }

    private suspend fun getFbfollowers(): Int {
        delay(1000)
        return 50
    }

    private suspend fun getInstafollowers(): Int {
        delay(1000)
        return 150
    }
}