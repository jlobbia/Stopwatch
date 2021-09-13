package com.jaden.stopwatch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import android.widget.Button
import android.widget.Chronometer

class MainActivity : AppCompatActivity() {

    lateinit var stopwatch : Chronometer
    lateinit var startstop : Button
    lateinit var reset : Button
    var lasttimestopped = 0L

    companion object {
        //static constants
        val TAG = "MainActivity" //val is for constants
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        stopwatch = findViewById(R.id.stopwatch)
        startstop = findViewById(R.id.startstop)
        reset = findViewById(R.id.reset)
        startstop.text = "START"
        reset.text = "RESET"
        startstop.setOnClickListener {
            if(startstop.text == "START") {
                stopwatch.setBase(SystemClock.elapsedRealtime()+lasttimestopped)
                stopwatch.start()
                startstop.text = "PAUSE"
            }
            else {
                lasttimestopped = (stopwatch.getBase()-SystemClock.elapsedRealtime())
                startstop.text = "START"
                stopwatch.stop()
            }
        }
        reset.setOnClickListener {
            stopwatch.stop()
            startstop.text = "START"
            stopwatch.setBase(SystemClock.elapsedRealtime()-lasttimestopped)
            lasttimestopped = 0L
        }
    }


    override fun onStart () {
        super.onStart()
        Log.d(TAG, "onStart")
    }
    override fun onResume () {
        super.onResume()
        Log.d(TAG, "onResume")
    }
    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause: ")
    }
    override fun onStop () {
        super.onStop()
        Log.d(TAG, "onStop")
    }
    override fun onDestroy () {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
    }
}