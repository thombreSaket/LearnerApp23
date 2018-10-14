package hhird.harsh123.com.learnerapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class teacheraskpassword extends AppCompatActivity {


    private TextView t1 = (TextView)findViewById(R.id.enterpass);
    private EditText pass = (EditText)findViewById(R.id.passtech);
    private Button submit = (Button)findViewById(R.id.enter);
    public String s1=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacheraskpassword);




    }

    public void loginteacher(View view){
        s1 = pass.getText().toString().trim();
        if(s1.equals("abcd")){
            startActivity(new Intent(this , TeacherActivity.class));
        }
        else{
            Toast.makeText(this,"Invalid Password",Toast.LENGTH_LONG).show();
        }

    }
}
