package kunal.project2.mmse

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import kotlin.system.exitProcess

class TestResult : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_result)
        var total=0

        val layout1=findViewById<LinearLayout>(R.id.layout1)
        val layout2=findViewById<LinearLayout>(R.id.layout2)
        val layout3=findViewById<LinearLayout>(R.id.layout3)
        val layout4=findViewById<LinearLayout>(R.id.layout4)


        val patientName=findViewById<TextView>(R.id.patientName)
        patientName.text=intent.getStringExtra(QuestionsData.Patientname)

        val patientAge=findViewById<TextView>(R.id.patientAge)
        patientAge.text=intent.getStringExtra(QuestionsData.age)

        val doctorName=findViewById<TextView>(R.id.doctor)
        doctorName.text=intent.getStringExtra(QuestionsData.doctorName)

        val result=intent.getIntegerArrayListExtra("result")

        if (result != null) {
            for(i in result){
                total += i
            }
        }

        if(total in 27..30){
            layout1.setBackgroundColor(Color.parseColor("#FBA1B7"))
        } else if(total in 21..26){
            layout2.setBackgroundColor(Color.parseColor("#FBA1B7"))
        }else if(total in 11..19){
            layout3.setBackgroundColor(Color.parseColor("#FBA1B7"))
        }else if(total in 1..9){
            layout4.setBackgroundColor(Color.parseColor("#FBA1B7"))
        }

    }
    fun restart(view: View){
        startActivity(Intent(this,MainActivity::class.java))
    }
}