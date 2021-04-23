package fatma.firebaseproje.Activity;

import android.app.VoiceInteractor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.GridLayoutAnimationController;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;


import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import fatma.firebaseproje.GridAdapter;
import fatma.firebaseproje.Model.Kitaplar;
import fatma.firebaseproje.R;

public class ListeleActivity extends AppCompatActivity {

    FirebaseStorage storage = FirebaseStorage.getInstance();
    StorageReference referans = storage.getReference();
    final File localFile = File.createTempFile("images","jpg");
    ArrayList<Kitaplar> kitaplar;
    Button kitapListele;
    ImageView resim;
    GridAdapter adapter;
    GridView gridview;

    public ListeleActivity() throws IOException{
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listele);

        FirebaseDatabase database=FirebaseDatabase.getInstance();
        DatabaseReference myRef=database.getReference();

        kitaplar = new ArrayList<>();
        adapter = new GridAdapter(this,kitaplar);
        gridview= (GridView)findViewById(R.id.grid);
        kitapListele = (Button)findViewById(R.id.kitap_listele);
        resim=(ImageView)findViewById(R.id.kitapResim);

        kitapListele.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              /*  for(int i=0; i<kitaplar.size(); i++){
                    Log.d("KİTAP", kitaplar.get(i).getAdi());
                    Log.d("YAZAR", kitaplar.get(i).getYazar());
                    Log.d("YAYİNEVİ", kitaplar.get(i).getYayinevi());
                    Log.d("SAYFA", kitaplar.get(i).getSayi());
                    Log.d("TÜR", kitaplar.get(i).getTur()); */
              gridview.setAdapter(adapter);
            }
        });

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    Toast.makeText(getApplicationContext(),"KİTAP : " +kitaplar.get(0).getAdi(),Toast.LENGTH_LONG).show();
                    final StorageReference indir = referans.child("satranc.jpg");
                    indir.getFile(localFile).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                            Bitmap bitmap=BitmapFactory.decodeFile(localFile.getAbsolutePath());
                            resim.setImageBitmap((bitmap));
                        }
                    });
                }
                else if(position==1){
                    Toast.makeText(getApplicationContext(),"KİTAP : " +kitaplar.get(1).getAdi(),Toast.LENGTH_LONG).show();
                    final StorageReference indir = referans.child("ucurtmaAvcisi.jpg");
                    indir.getFile(localFile).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                            Bitmap bitmap=BitmapFactory.decodeFile(localFile.getAbsolutePath());
                            resim.setImageBitmap((bitmap));
                        }
                    });
                }
                else if(position==2){
                    Toast.makeText(getApplicationContext(),"KİTAP : " +kitaplar.get(1).getAdi(),Toast.LENGTH_LONG).show();
                    final StorageReference indir = referans.child("sekerportakali.jpg");
                    indir.getFile(localFile).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                            Bitmap bitmap=BitmapFactory.decodeFile(localFile.getAbsolutePath());
                            resim.setImageBitmap((bitmap));
                        }
                    });
                }
                else if(position==3){
                    Toast.makeText(getApplicationContext(),"KİTAP : " +kitaplar.get(1).getAdi(),Toast.LENGTH_LONG).show();
                    final StorageReference indir = referans.child("madonna.jpg");
                    indir.getFile(localFile).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                            Bitmap bitmap=BitmapFactory.decodeFile(localFile.getAbsolutePath());
                            resim.setImageBitmap((bitmap));
                        }
                    });
                }
            }
        });

        myRef.child("kitaplar").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for(DataSnapshot postSnapshot : dataSnapshot.getChildren()){
                    Kitaplar kitap = postSnapshot.getValue(Kitaplar.class);

                    kitaplar.add(
                            new Kitaplar(
                                    kitap.getAdi(),
                                    kitap.getYazar(),
                                    kitap.getYayinevi(),
                                    kitap.getSayi(),
                                    kitap.getTur()
                            )

                    );

                 //   Log.d("LOG",kitap.getAd());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
