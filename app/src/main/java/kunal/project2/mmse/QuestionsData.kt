package kunal.project2.mmse

object QuestionsData {
     var Patientname:String="patient_name"
     var age:String="age"
     var doctorName:String="doctor_name"


    fun QuestionList():ArrayList<Questions>{
        var QuestionArr=ArrayList<Questions>()

        val question1=Questions(
            1,"What year is this?", R.drawable.img,"1","0","Not Required",1
        )
        QuestionArr.add(question1)

        val question2=Questions(
            2,"What is the current season?", R.drawable.img,"1","0","Not Required",1
        )
        QuestionArr.add(question2)

        val question3=Questions(
            3,"What month is this?", R.drawable.img,"1","0","Not Required",1
        )
        QuestionArr.add(question3)

        val question4=Questions(
            4,"What's the date today?", R.drawable.img,"1","0","Not Required",1
        )
        QuestionArr.add(question4)

        val question5=Questions(
            5,"What day of the week it is?", R.drawable.img,"1","0","Not Required",1
        )
        QuestionArr.add(question5)

        val question6=Questions(
            6,"Which country are we in right now?", R.drawable.img,"1","0","Not Required",1
        )
        QuestionArr.add(question6)

        val question7=Questions(
            7,"What state/province are we in?", R.drawable.img,"1","0","Not Required",1
        )
        QuestionArr.add(question7)

        val question8=Questions(
            8,"What city or town are we in?", R.drawable.img,"1","0","Not Required",1
        )
        QuestionArr.add(question8)

        val question9=Questions(
            9,"I'm going to name three words/objects and you need to repeat them. Then remember them because I'm going to ask you to name them again later. (EX: BALL-CAR-MAN/APPLE-PENNY-TABLE)", R.drawable.img,"1","0","Not Required",3
        )
        QuestionArr.add(question9)

        val question10=Questions(
            10,"On which floor are we located / In which room are currently located?", R.drawable.img,"1","0","Not Required",2
        )
        QuestionArr.add(question10)

        val question11=Questions(
            11,"Spell WORLD backwards? Answer: D-L-R-O-W", R.drawable.img,"1","0","Not Required",5
        )
        QuestionArr.add(question11)

        val question12=Questions(
            12,"Now, name the three objects/words I asked you to remember", R.drawable.img,"1","0","Not Required",3
        )
        QuestionArr.add(question12)

        val question13=Questions(
            13,"What object is this? Show a wrist watch.", R.drawable.img,"1","0","Not Required",1
        )
        QuestionArr.add(question13)

        val question14=Questions(
            14,"What object is this? Show a pencil", R.drawable.img,"1","0","Not Required",1
        )
        QuestionArr.add(question14)

        val question15=Questions(
            15,"Repeat this phrase: No Ifs, ands, or buts.", R.drawable.img,"1","0","Not Required",1
        )
        QuestionArr.add(question15)

        val question16=Questions(
            16,"Read the words and then do what it says. (Give the patient/client a sheet of paper with CLOSE YOUR EYES written on it.)", R.drawable.img,"1","0","Not Required",1
        )
        QuestionArr.add(question16)

        val question17=Questions(
            17,"Take the paper in your right/left hand, fold it in half, and put it on the floor. (Give the patient/client a piece of paper and score 1 for each action taken.)", R.drawable.img,"1","0","Not Required",3
        )
        QuestionArr.add(question17)

        val question18=Questions(
            18,"Make up and write a complete sentence on a piece paper. (Sentence must contain a verb and noun)", R.drawable.img,"1","0","Not Required",1
        )
        QuestionArr.add(question18)

        val question19=Questions(
            19,"Copy The Design please", R.drawable.img,"1","0","Not Required",1
        )
        QuestionArr.add(question19)

        return QuestionArr
    }

}