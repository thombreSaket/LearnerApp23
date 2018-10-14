package hhird.harsh123.com.learnerapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class disp_score0 extends AppCompatActivity {

    private TextView scor;
    private String s1;
    DatabaseReference db;
    private String nameid;
    private FirebaseAuth ref;
    private String sub;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        scor = (TextView)findViewById(R.id.scoredisplay);
        ref=FirebaseAuth.getInstance();
        sub = getIntent().getStringExtra("subject");

        s1 = getIntent().getStringExtra("scr");

        scor.setText("Your Score is :   " +s1 +"/5");
        db = FirebaseDatabase.getInstance().getReference("Score");
        nameid=ref.getCurrentUser().toString();

        db.child(sub).child(nameid).setValue(scor);

        setContentView(R.layout.activity_disp_score0);
    }
}
