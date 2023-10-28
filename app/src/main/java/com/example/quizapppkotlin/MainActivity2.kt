package com.example.quizapppkotlin

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity2 : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val imageView=findViewById<Button>(R.id.button)
        imageView.setOnClickListener {
            val editText2=findViewById<EditText>(R.id.edit2)
            val name: String = editText2.text.toString()


            val button: String = imageView.text.toString()
            imageView.text = button
            if (name.isEmpty()) {
                Toast.makeText(this@MainActivity2, "please enter your name", Toast.LENGTH_SHORT).show()
            }else {
                Toast.makeText(this@MainActivity2, "login sucessfully", Toast.LENGTH_SHORT).show()


                val intent = Intent(this, MainActivity3::class.java)
                startActivity(intent)
            }
        }


    }
}