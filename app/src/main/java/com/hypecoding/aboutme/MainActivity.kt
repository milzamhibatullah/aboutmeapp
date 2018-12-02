package com.hypecoding.aboutme

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.hypecoding.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private val myName : MyName= MyName("Milzam Hibatullah")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =   DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.doneButton.setOnClickListener { adNickname(it) }
        binding.myName=myName
    }

    private fun adNickname(view: View) {
        binding.apply {
            myName?.nickname=nameEdittext.text.toString()
            invalidateAll()
            binding.nameEdittext.visibility=View.GONE
            binding.doneButton.visibility=View.GONE
            binding.nicknameText.visibility=View.VISIBLE
        }
        //hide keyboard
        val imm=getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken,0)
    }
}
