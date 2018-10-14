package hhird.harsh123.com.learnerapp;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class display_score extends AppCompatActivity {

    ListView listView;
    String[] listitem;
    public String getstring;
    private TextView tvsc;
    public ArrayList<String> listarray=new ArrayList<>();
    public ArrayAdapter<String> aadp;
    public FirebaseDatabase db = FirebaseDatabase.getInstance();
    public DatabaseReference dbscore=db.getReference();
    public DatabaseReference dbes=dbscore.child("Score").child("English");


    int x;
    String y;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_score);

        listView = (ListView)findViewById(R.id.leaderlist);
        aadp=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, listarray);
        listView.setAdapter(aadp);
        tvsc=(TextView)findViewById(R.id.textView654);

        dbes.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot4 : dataSnapshot.getChildren()) {
                    for (x = 0; x <= 5; x++) {
                        y=String.valueOf(x);
                        getstring = dataSnapshot.child("Test").child(y).getValue(String.class);
                       // listarray.add(y+"       "+getstring);
                        listarray.add(x,getstring);
                        aadp.notifyDataSetChanged();
                    }
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        /*dbes.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

              for(DataSnapshot dataSnapshot3:dataSnapshot.getChildren()){


                  for(x=0;x<=5;x++){
                      y=String.valueOf(x);
                      getstring=dataSnapshot3.child("test").child(y).getValue(String.class);
                      listarray.add(getstring);

                  }


              }



            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });*/
        //final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,listarray);
        //listView.setAdapter(adapter);


    }
}
