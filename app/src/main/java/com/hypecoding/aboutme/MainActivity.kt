package com.hypecoding.aboutme

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.done_button).setOnClickListener { adNickname(it) }
    }

    private fun adNickname(view: View) {
        val nicknameEdit = findViewById<EditText>(R.id.name_edittext)
        val nicknameText=findViewById<TextView>(R.id.nickname_text)
        nicknameText.text=nicknameEdit.text
        nicknameText.visibility=View.VISIBLE
        nicknameEdit.visibility=View.GONE

        //hide keyboard
        val imm=getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken,0)
    }
}
