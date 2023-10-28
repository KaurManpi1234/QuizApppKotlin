package com.example.quizapppkotlin

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast

class MainActivity3 : AppCompatActivity() {
    private val questions = arrayOf(
        "1. Where is the “Gurudwara Ber Sahib” situated?",
        "2.Who was the composer of the “Asa Di Vaar",
        "3. Which of the following Gurus composed the “Japuji Sahib”?",
        "4. Which had been the distinguished industry in Punjab during the 16th century?",
        "5. Which are the main two difficulties in writing of the Punjab history?",
        "6. When was the first battle of Panipat fought?",
        "7. How many paise did Guru Angad Dev offer and paid obeisance to the successor",
        "8. Which place is that, where Guru Nanak Dev ji acquired the celestial knowledge?",
        "9. Which languages is the ‘Jafarnama’ available in? ",
        "10. What is called as the Punjabi script? ",
        "11. How old was Guru Amardass during his accession to the Gurgaddi?",
        "12.Who composed the Ratnawali ?",
        "13. Who did introduce the coins of the Sikhs?",
        "14. How many compositions have been included in the Dasam Granth?",
        "15.When was Punjab merged into the British territory?",
        "16.Which of the ‘Sakhies’ is considered as to be the most reliable?",
        "17. When did Babur attack Punjab for the first time?",
        "18. How many times did Babur attack Punjab in all?",
        "19. Who had been the founder of the Bhakti movement?",
        "20. Where did the Sajjan Thug use to live?"
    )

    private val choices = arrayOf(
        arrayOf("Tarantaran ", "  Nankana sahib", "Sultanpur", "  Amritsar"),
        arrayOf("Guru Nanak", " Guru Angad", "Guru Ramdass", " Guru Arjan"),
        arrayOf(" Guru Ramdass", " Guru Angad", "Guru Nanak", " Guru Amardass"),
        arrayOf(" Agriculture", "Textile Industry", " Animal Husbandry", " None of these"),
        arrayOf(" Lack of reliable sources", " Religious fanaticism of the Muslim writers", " Indolence of the Punjabies", "Lack of reliable sources and religious fanaticism of the Muslim Writers"),
        arrayOf(" In April 21, 1524 AD", "In April 21, 1526 AD", " In April 26, 1526 AD", " In September 26, 1526 AD"),
        arrayOf(" Two paise", " Three paise", "Five paise", " Ten paise"),
        arrayOf("Sultanpur lodhi", " Muktsar", " Amritsar", " Nanaksar"),
        arrayOf(" Persian and Hindi", "Punjabi and Persian", " Punjabi and English", "All of these"),
        arrayOf(" Persian", "Punjabi", "Gurmukhi", " English"),
        arrayOf("60 years", " 80 years", " 45 years", "73 years"),
        arrayOf(" Bhai Veer Singh", " Meharban Ji", "Bhai Mani Singh", "Bhai Bala"),
        arrayOf(" Maharaja Ranjit Singh", "Banda Singh Bahadur", " Ahmed Shah Abdali", " None of these"),
        arrayOf(" 18", "16", "10", " 12"),
        arrayOf("In 1849 AD", "In 1876 AD", "In 1842 AD", "In 1843 AD"),
        arrayOf(" Bhai Mani Singh’s Janam Sakhi", "Ancient Janam Sakhi", "Sakhi, by Meharban", "The Janam Sakhi by Bhai Bala"),
        arrayOf("In 1539", "In 1516", "In 1519", "In 1529"),
        arrayOf(" Four times", " Six times", " Three times", "Five times"),
        arrayOf("Guru Nanak Dev Ji", " Guru Arjan Dev Ji", " Guru Gobind Singh Ji", " Guru RamDas Ji"),
        arrayOf(" Multan", " Rai Bhoyen", "Talumba village", " Lahore")
    )

    private val answer = arrayOf(
        "Sultanpur",
        "Guru Nanak",
        "Guru Nanak",
        "Textile Industry",
        "Lack of reliable sources and religious fanaticism of the Muslim Writers",
        "In April 21, 1526 AD",
        "Five paise",
        "Sultanpur lodhi",
        "Punjabi and Persian",
        "Gurmukhi",
        "73 years",
        "Bhai Mani Singh",
        "Banda Singh Bahadur",
        "10",
        "In 1849 AD",
        "Ancient Janam Sakhi",
        "In 1519",
        "Five times",
        "Guru Nanak Dev Ji",
        "Talumba village"
    )
    private lateinit var t: TextView
    private lateinit var que: TextView
    private lateinit var rg: RadioGroup
    private lateinit var sub: Button
    private lateinit var a: RadioButton
    private lateinit var b: RadioButton
    private lateinit var c: RadioButton
    private lateinit var d: RadioButton
    private var score = 0
    private var id = -1
    private var wcount=0
    private lateinit var sAnswer: String
    private var totalQuestion = questions.size
    private var currentQuestion = 0
    private var current = 1
    private lateinit var selectedAnswer: RadioButton


    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        que = findViewById(R.id.tv_question)
        rg = findViewById(R.id.radiogrp)

        a = findViewById(R.id.radioButton1)
        b = findViewById(R.id.radioButton2)
        c = findViewById(R.id.radioButton3)
        d = findViewById(R.id.radioButton4)
        sub = findViewById(R.id.nextQuestionBtn)
        t = findViewById(R.id.tv_noOfQues)
        t.text = "Total Question :$currentQuestion/$totalQuestion"
        loadNewQuestion()
        sub.setOnClickListener {

            id = rg.checkedRadioButtonId
            if (currentQuestion < questions.size) {
                if (id < 0) {
                    Toast.makeText(this@MainActivity3 , "select one option", Toast.LENGTH_SHORT).show()
                } else {
                    selectedAnswer = findViewById(id)
                    sAnswer = selectedAnswer.text.toString()
                    if (sAnswer == answer[currentQuestion]) {
                        score++

                        rg.clearCheck()
                        currentQuestion++
                    } else {
                        wcount++
                        currentQuestion++
                        rg.clearCheck()

                    }
                    if (currentQuestion < questions.size) {
                        loadNewQuestion()}
                        else {

                            if(currentQuestion==questions.size){
                                if(score>=18){
                                    val intent=Intent(this,MainActivity4::class.java)

                                    intent.putExtra("Scores", score)
                                    intent.putExtra("Wrong", wcount)
                                    startActivity(intent)
                                }else{
                                    val intent= Intent(this,oop::class.java)
                                    intent.putExtra("Scores", score)
                                    intent.putExtra("Wrong", wcount)
                                    startActivity(intent)
                                }
                            }
                        }
                    }
                } else {
                    Toast.makeText(this@MainActivity3, " NO Question are available", Toast.LENGTH_SHORT).show()

                }

                }}

    @SuppressLint("SetTextI18n")
    private fun loadNewQuestion() {
        que.text = questions[currentQuestion]
        a.text = choices[currentQuestion][0]
        b.text = choices[currentQuestion][1]
        c.text = choices[currentQuestion][2]
        d.text = choices[currentQuestion][3]
        t.text = "Total Question :$current/$totalQuestion"
        current++
    }}




