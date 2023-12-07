package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity(), View.OnClickListener {


    private lateinit var btn1: Button
    private lateinit var btn2: Button
    private lateinit var fm: FragmentManager
    private lateinit var job: Job


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn1 = findViewById(R.id.button)
        btn2 = findViewById(R.id.button2)
        btn1.setOnClickListener{
          // thread(start=true) {
           //    Thread.sleep(10000)
          // }
            job = CoroutineScope(Dispatchers.IO).launch {
                Thread.sleep(10000)
            }

            // job.cancel()
            Log.d("RRR","!!!")
        }
        btn2.setOnClickListener(this)

        //fm = supportFragmentManager
    }

    override fun onClick(v: View) {
        if(v.id == R.id.button) {
           // changeFragment(FirstFragment())
            MyDialog().show(fm,MyDialog.TAG)
        } else {
            changeFragment(SecondFragment())
        }
    }

    private fun changeFragment(f: Fragment) {
        val transaction: FragmentTransaction = fm.beginTransaction()
        transaction.replace(R.id.fragmentContainerView,f)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}