package fatma.firebaseproje.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import fatma.firebaseproje.R;

public class MainActivity extends AppCompatActivity {

    Button btnEkle,btnListele;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnEkle=(Button)findViewById(R.id.btn_ekle);
        btnListele=(Button)findViewById(R.id.btn_listele);

        btnEkle.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(MainActivity.this,KayitActivity.class));
            }

        });

        btnListele.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(MainActivity.this,ListeleActivity.class));
            }
        });
        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();

    }
}
