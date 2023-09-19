package kunal.project2.mmse

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat

class TestScreen : AppCompatActivity() , View.OnClickListener{
    private var mQuestion:ArrayList<Questions>?=null
    private var mCurrent=1
    private var onceSelected=0
    private var mtotalScore:Int?=null

    var patientName:String?=null
    var age:String?=null
    var doctor:String?=null

    private var progressB: ProgressBar?=null
    private var image: ImageView?=null
    private var question: TextView?=null
    private var progressText: TextView?=null

    private var optionFirst: TextView?=null
    private var optionSecond: TextView?=null
    private var optionThird: TextView?=null
    private var mScore:Int?=null

    var deque=ArrayList<Int>()
    var options=ArrayList<TextView>()

    private var buttonprev: Button?=null
    private var buttonnext: Button?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_screen)
        mQuestion=QuestionsData.QuestionList()

      patientName=intent.getStringExtra(QuestionsData.Patientname)
        age=intent.getStringExtra(QuestionsData.age)
        doctor=intent.getStringExtra(QuestionsData.doctorName)

        progressB=findViewById(R.id.progress)
        image=findViewById(R.id.img)
        question=findViewById(R.id.Question)
        progressText=findViewById(R.id.progress_text)

        optionFirst=findViewById(R.id.Option1)
        optionSecond=findViewById(R.id.Option2)
        optionThird=findViewById(R.id.Option3)

        optionFirst?.setOnClickListener(this)
        optionSecond?.setOnClickListener(this)
        optionThird?.setOnClickListener(this)

        optionFirst?.let { options.add(0,it) }
        optionSecond?.let { options.add(1,it) }
        optionThird?.let { options.add(2,it) }

        buttonnext=findViewById(R.id.bttn3)
        buttonnext?.setOnClickListener {
            if(mCurrent< progressB?.max!! && onceSelected==1){
                mCurrent++
                default_values()
                default_click(options)
                onceSelected=0
                mtotalScore?.let { it1 -> deque.add(it1) }
                if(mCurrent>1){
                    buttonprev?.isEnabled=true
                }
            }
            else if(mCurrent==progressB?.max!! && onceSelected==1){
                mtotalScore?.let { it1 -> deque.add(it1) }
                val inten1=Intent(this,TestResult::class.java)
                 inten1.putExtra("result",deque)
                 inten1.putExtra(QuestionsData.doctorName,doctor)
                 inten1.putExtra(QuestionsData.Patientname,patientName)
                 inten1.putExtra(QuestionsData.age,age)
                 startActivity(inten1)
                finish()
            }
        }

        buttonprev=findViewById(R.id.bttn2)
        buttonprev?.setOnClickListener {
            if(mCurrent>1){
                mCurrent--
                default_values()
                default_click(options)
                onceSelected=0
                deque.removeLast()
            }
            if(mCurrent<2){
               buttonprev?.isEnabled=false
            }
        }

        default_values()

    }
    private fun default_values() {
        var que: Questions = mQuestion!![mCurrent - 1]
        progressB?.progress = mCurrent
        progressText?.text = "${mCurrent}/${progressB?.max}"
        question?.text = "${que.id}. " + que.question
        optionFirst?.text = que.option1
        optionSecond?.text = que.option2
        optionThird?.text = que.option3
        image?.setImageResource(que.image)
        mScore = que.Score

        if (mCurrent == mQuestion?.size)
            buttonnext?.text="FINISH"
        else
            buttonnext?.text="NEXT ->"
    }

    private fun default_click(options:ArrayList<TextView>){
        for(option in options){
            option.setTextColor(Color.parseColor("#27374D"))
            option.typeface= Typeface.DEFAULT
            option.background= ContextCompat.getDrawable(this,R.drawable.default_specs)
        }

    }

    private fun onSelect(text:TextView,options:ArrayList<TextView>){
        default_click(options)
        onceSelected=1
            text.setTextColor(Color.parseColor("#A2FF86"))
            text.setTypeface(text.typeface, Typeface.BOLD)
            text.background= ContextCompat.getDrawable(this,R.drawable.selected_specs)
        }



    override fun onClick(view: View?) {
            when(view?.id){
                R.id.Option1 ->{
                    optionFirst?.let { onSelect(it,options) }
               mtotalScore=mScore
                }
                R.id.Option2 ->{
                    optionSecond?.let { onSelect(it,options) }
               mtotalScore=0
                }
                R.id.Option3 -> {
                    optionThird?.let {
                        onSelect(it, options)
                    mtotalScore=0}
                }
            }
        }
    }
