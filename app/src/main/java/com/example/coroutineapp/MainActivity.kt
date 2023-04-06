package com.example.coroutineapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.math.log
import kotlin.system.measureTimeMillis

class MainActivity : AppCompatActivity() {
    val TAG = "Yogi"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        /*val jobs = mutableListOf<Job>()

        GlobalScope.launch {
             jobs += launch {
                process("A")
                process("B")
            }

            /*async {
                process("AA")
                process("BB")
            }*/

            jobs += launch {
                process("AA")
                process("BB")
            }

            jobs.joinAll()
        }*/

        GlobalScope.launch {
            val time = measureTimeMillis {
                val job1 = async {
                    delay(100L)
                    "job1 success"
                }
                //Log.d(TAG," Job1 status ${job1.await()}")

                val job2 = async {
                    delay(100L)
                    "job2 success"
                }
                //Log.d(TAG," job2 status ${job2.await()}")
            }
            Log.d(TAG,"Timetaken $time in ms")


        }


    }

    suspend fun process(name:String) {
        for(i in 1..5) {
            delay(1000L)
            Log.d(TAG,"Process Id:$i name $name ThreadName ${Thread.currentThread().name}")
        }
    }

}