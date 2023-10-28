package com.example.quizapppkotlin
import android.annotation.SuppressLint
    import android.content.Intent
    import androidx.appcompat.app.AppCompatActivity
    import android.os.Bundle
    import android.widget.ImageView
    import android.widget.TextView

    class MainActivity4 : AppCompatActivity() {

    lateinit var w: TextView
    lateinit var s: TextView
    @SuppressLint("SetTextI18n", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)
        var res=findViewById<ImageView>(R.id.imageView5)
        s = findViewById(R.id.scores)
        w = findViewById(R.id.wrongs)

        val i = intent

        val score = i.getIntExtra("Scores", 0)
        val wcount = i.getIntExtra("Wrong", 0)

        w.text = "Wrong: $wcount"
        s.text = "Score: $score"


        res.setOnClickListener  {
            val intent= Intent (this,MainActivity2::class.java)

            startActivity(intent)

            }
    }
}