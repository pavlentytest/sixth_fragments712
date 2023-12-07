package com.example.myapplication

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.DialogFragment

class MyDialog : DialogFragment() {

    /*
    override fun onCreateDialog(savedInstanceState: Bundle?) =
        AlertDialog.Builder(context)
            .setMessage("Какое-то сообщение в диалоге!")
            .setNegativeButton("Cancel"){ _,_ -> }
            .setPositiveButton("Ok"){ _,_ -> }
            .create()
*/

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = LayoutInflater.from(context).inflate(R.layout.mydialog,container,false)
        view.findViewById<Button>(R.id.button3).setOnClickListener {
            // обработка клика
        }
        return view
    }

    companion object {
        const val TAG = "MyDialog"
    }
}