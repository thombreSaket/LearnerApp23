package hhird.harsh123.com.learnerapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class profileactivity extends AppCompatActivity {



    private FirebaseAuth firebaseAuth;
    private TextView welcome;
    private TextView show_email;
    private Button logout;
    private Button prac;
    private Button test;
    private Button leaderboard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profileactivity);

        firebaseAuth=FirebaseAuth.getInstance();
        if(firebaseAuth.getCurrentUser()==null){
            finish();
            startActivity(new Intent(this,MainActivity.class));

        }
        FirebaseUser user=firebaseAuth.getCurrentUser();


        welcome=(TextView)findViewById(R.id.tv_welcome);
        show_email=(TextView)findViewById(R.id.tv_email);
        logout= (Button) findViewById(R.id.bu_logout);
        show_email.setText(user.getEmail());
    }

    public void bu_click(View view) {



        firebaseAuth.signOut();
        finish();
        startActivity(new Intent(this,MainActivity.class));

    }

    public void showleaderboard(View view){

        startActivity(new Intent(this,display_score.class));
    }

    public void gotopractice(View view){

        startActivity(new Intent(this,StudentAvtivity.class));

    }
}
