package hhird.harsh123.com.learnerapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.nightonke.boommenu.BoomButtons.ButtonPlaceEnum;
import com.nightonke.boommenu.BoomButtons.HamButton;
import com.nightonke.boommenu.BoomButtons.OnBMClickListener;
import com.nightonke.boommenu.BoomMenuButton;
import com.nightonke.boommenu.ButtonEnum;
import com.nightonke.boommenu.Piece.PiecePlaceEnum;

public class profileactivity extends AppCompatActivity {



    private FirebaseAuth firebaseAuth;
    private TextView welcome;
    private TextView show_email;
    private Button logout;
    private Button prac;
    private Button test;
    private Button leaderboard;
    private BoomMenuButton bmb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profileactivity);

        bmb = (BoomMenuButton) findViewById(R.id.bmb);
        bmb.setButtonEnum(ButtonEnum.Ham);
        bmb.setPiecePlaceEnum(PiecePlaceEnum.HAM_4);
        bmb.setButtonPlaceEnum(ButtonPlaceEnum.HAM_4);
      //
        //  bmb.addBuilder(BuilderManager.getHamButtonBuilder());



       // for (int i = 0; i < bmb.getPiecePlaceEnum().pieceNumber(); i++) {
            HamButton.Builder builder = new HamButton.Builder()
                    .listener(new OnBMClickListener() {
                        @Override
                        public void onBoomButtonClick(int index) {
                            // When the boom-button corresponding this builder is clicked.
                            startActivity(new Intent(getApplicationContext(),StudentAvtivity.class));
                        }


                    })
                    .normalImageRes(R.drawable.piece)
                    .normalTextRes(R.string.Practice)
                    .highlightedTextRes(R.string.Practice);




            bmb.addBuilder(builder);


        HamButton.Builder builder2 = new HamButton.Builder()
                .listener(new OnBMClickListener() {
                    @Override
                    public void onBoomButtonClick(int index) {
                        // When the boom-button corresponding this builder is clicked.
                        Toast.makeText(profileactivity.this, "Clicked " + index, Toast.LENGTH_SHORT).show();
                    }


                })
                .normalImageRes(R.drawable.piece)
                .normalTextRes(R.string.Tests)
                .highlightedTextRes(R.string.Tests);


        bmb.addBuilder(builder2);


        HamButton.Builder builder3 = new HamButton.Builder()
                .listener(new OnBMClickListener() {
                    @Override
                    public void onBoomButtonClick(int index) {
                        // When the boom-button corresponding this builder is clicked.
                        startActivity(new Intent(getApplicationContext(),display_score.class));
                         }


                })
                .normalImageRes(R.drawable.piece)
                .normalTextRes(R.string.LeaderBoard)
                .highlightedTextRes(R.string.LeaderBoard);


        bmb.addBuilder(builder3);


        HamButton.Builder builder4 = new HamButton.Builder()
                .listener(new OnBMClickListener() {
                    @Override
                    public void onBoomButtonClick(int index) {
                        // When the boom-button corresponding this builder is clicked.
                        firebaseAuth.signOut();
                        finish();
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                    }


                })
                .normalImageRes(R.drawable.piece)
                .normalTextRes(R.string.LogOut)
                .highlightedTextRes(R.string.LogOut);


        bmb.addBuilder(builder4);



        firebaseAuth=FirebaseAuth.getInstance();
        if(firebaseAuth.getCurrentUser()==null){
            finish();
            startActivity(new Intent(this,MainActivity.class));

        }
        FirebaseUser user=firebaseAuth.getCurrentUser();


        welcome=(TextView)findViewById(R.id.tv_welcome);
       show_email=(TextView)findViewById(R.id.tv_email);
       // logout= (Button) findViewById(R.id.bu_logout);
        show_email.setText(user.getEmail());
    }

  /*  public void bu_click(View view) {





    }

    public void showleaderboard(View view){


    }

    public void gotopractice(View view){



    }
*/
}
