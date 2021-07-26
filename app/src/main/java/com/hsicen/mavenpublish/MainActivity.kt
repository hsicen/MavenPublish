package com.hsicen.mavenpublish

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.hsicen.toast.Log
import com.hsicen.toast.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Toast.info(this, "Hello")
        Log.d("Android")
        Toast.error(this, "Error")
    }
}