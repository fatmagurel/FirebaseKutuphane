package fatma.firebaseproje.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import fatma.firebaseproje.Model.Kitaplar;
import fatma.firebaseproje.R;

public class KayitActivity extends AppCompatActivity {

    EditText adi,yazar,yayinevi,sayfa,tur;
    Button kaydet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kayit);

        kaydet=(Button)findViewById(R.id.kaydet);
        adi=(EditText)findViewById(R.id.adi);
        yazar=(EditText)findViewById(R.id.yazar);
        yayinevi=(EditText)findViewById(R.id.yayinevi);
        sayfa=(EditText)findViewById(R.id.sayi);
        tur=(EditText)findViewById(R.id.tur);

        kaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference dbRef=FirebaseDatabase.getInstance().getReference().child("kitaplar");
                dbRef.push().setValue(
                        new Kitaplar(
                                adi.getText().toString(),
                                yazar.getText().toString(),
                                yayinevi.getText().toString(),
                                sayfa.getText().toString(),
                                tur.getText().toString()
                        )
                );
            }
        });
    }
}
