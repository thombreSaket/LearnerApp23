
package hhird.harsh123.com.learnerapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TeacherActivity extends AppCompatActivity {

    private Button upques = (Button)findViewById(R.id.enter_questions);
   // private Button leaderboard = (Button)findViewById(R.id.scrbutton);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher);
    }

    public void showleaderboard(View view){

        startActivity(new Intent(this,display_score.class));
    }
    public void enterques(View view){
        startActivity(new Intent(this,sub_screen_for_teacher_uploads.class));
    }
}
