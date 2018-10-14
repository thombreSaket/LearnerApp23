package hhird.harsh123.com.learnerapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class    Teacherquestions extends AppCompatActivity {

    public TextView qunum123;
    public int x,y;
    public String noofques;
    public String test_title1;
    private EditText question;
    private EditText optA;
    private EditText optB;
    private EditText optC;
    private EditText optD;
    private EditText ans;
    private EditText Qnum;
    private TextView tit_view;
    public  String subj;
    public String Q_Num;
    DatabaseReference databaseQuestions;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacherquestions);

        //Read from intent : -
        subj = getIntent().getStringExtra("sub");
        test_title1=getIntent().getStringExtra("title1");
        noofques=getIntent().getStringExtra("no_ofQues");
        x=Integer.parseInt(noofques);
        y=1;
        databaseQuestions = FirebaseDatabase.getInstance().getReference(subj);

        qunum123=(TextView)findViewById(R.id.qnum123 );
       // Qnum = (EditText) findViewById(R.id.QNum);
        question = (EditText)findViewById(R.id.Question);
        optA = (EditText)findViewById(R.id.optA);
        optB = (EditText)findViewById(R.id.optB);
        optC = (EditText)findViewById(R.id.optC);
        optD = (EditText)findViewById(R.id.optD);
        ans = (EditText)findViewById(R.id.answer);
       tit_view=(TextView)findViewById(R.id.title_view);
        tit_view.setText(test_title1);
        Q_Num = String.valueOf(y);

        qunum123.setText(Q_Num);
    }

    public void submitquestion(View view  ){
        if(y<x) {
            Q_Num = String.valueOf(y);
            String Question = question.getText().toString().trim();
            String OPTION_A = optA.getText().toString().trim();
            String OPTION_B = optB.getText().toString().trim();
            String OPTION_C = optC.getText().toString().trim();
            String OPTION_D = optD.getText().toString().trim();
            String Ans = ans.getText().toString().trim();

            Questions questions = new Questions(Q_Num, test_title1, Question, OPTION_A, OPTION_B, OPTION_C, OPTION_D, Ans);
            // title  quetitle =new title(Title_test,Q_Num);
            databaseQuestions.child(test_title1).child(Q_Num).setValue(questions);
            qunum123.setText(Q_Num);
            y++;
            question.setText(null);
            optA.setText(null);
            optB.setText(null);
            optC.setText(null);
            optD.setText(null);
            ans.setText(null);
        }
        else
        {
            Intent intent = new Intent(this, test_title.class);
            startActivity(intent);
        }

       // Intent intent = new Intent(this, StudentAvtivity.class);
        //intent.putExtra("sub",subj);
        //intent.putExtra("title2",test_title1 );
        //intent.putExtra("ques_no",Q_Num);
        //startActivity(intent);


       // startActivity(new Intent(this,StudentAvtivity.class));

      //  Intent i1 = getIntent();
       // String S1 = i1.getStringExtra("sub");
        //disp.setText(subj);



    }


}

