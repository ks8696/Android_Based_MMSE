package kunal.project2.mmse

import android.content.Intent
import android.graphics.Color
import androidx.core.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    var button:Button?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var marq=findViewById<TextView>(R.id.txt)
        marq.text = "\t\t\t\t\t\t\t\t\t\t\t\t\t\tMini-Mental State Examination(MMSE)\t\t\t\t\t\t\t\t\t\t\t\t\t\t"
        marq.isSelected=true
        marq.isSingleLine = true
        val entered1=findViewById<EditText>(androidx.core.R.id.text)
        val entered2=findViewById<EditText>(androidx.core.R.id.text2)
        val entered3=findViewById<EditText>(R.id.text3)
        button=findViewById(R.id.button)

        button?.setOnClickListener {
            if(entered1.text.isNotEmpty() && entered2.text.isNotEmpty() && entered3.text.isNotEmpty()){
                val inten=Intent(this,TestScreen::class.java)
                inten.putExtra(QuestionsData.Patientname,entered1.text.toString())
                inten.putExtra(QuestionsData.age,entered2.text.toString())
                inten.putExtra(QuestionsData.doctorName,entered3.text.toString())

                startActivity(inten)
                finish()

            }
            else{
                Toast.makeText(this, "All the feilds are required", Toast.LENGTH_SHORT).show()
            }
        }

    }
}