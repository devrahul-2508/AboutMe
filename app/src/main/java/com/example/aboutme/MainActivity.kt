package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val myName: MyName = MyName("Aleks Haecky")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding=DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.myName = myName


        binding.doneButton.setOnClickListener {
            binding.apply {
                myName?.nickname = nicknameEdit.text.toString()
                invalidateAll()
               nicknameText.visibility=View.VISIBLE
               doneButton.visibility= View.GONE
                nicknameEdit.visibility=View.GONE
            }

            val view = this.currentFocus
            if (view != null) {
                val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
            }
        }
        binding.nicknameText.setOnClickListener{
            binding.doneButton.visibility=View.VISIBLE
            binding.nicknameEdit.visibility=View.VISIBLE
            binding.nicknameEdit.setText("")
            binding.nicknameText.visibility=View.GONE
        }

    }
}