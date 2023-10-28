package com.example.quizapppkotlin

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView

class oop : AppCompatActivity() {
    lateinit var w: TextView
    lateinit var s: TextView
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_oop)
        var res=findViewById<ImageView>(R.id.imageView5)
        s = findViewById(R.id.score)
        w = findViewById(R.id.wrong)

        val i = intent

        val score = i.getIntExtra("Scores", 0)
        val wcount = i.getIntExtra("Wrong", 0)

        w.text = "Wrong: $wcount"
        s.text = "Score: $score"


        res.setOnClickListener(View.OnClickListener {
            val intent= Intent(this,MainActivity2::class.java)
            startActivity(intent)

        })

    }
}