package com.example.bultacocatalogo;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

public class DetailActivity extends AppCompatActivity {
    private TextView textType;
    private TextView textNickname;
    private TextView textAge;
    private TextView textBirthYear;
    private TextView textVersions;
    private TextView textDesc;
    private ImageView imageDetail;

    String type, nickname, versions, desc, urlImage;
    int age, birthYear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        textType = findViewById(R.id.textType);
        textAge = findViewById(R.id.textAge);
        textNickname = findViewById(R.id.textNickName);
        textBirthYear = findViewById(R.id.textBirthYear);
        textVersions = findViewById(R.id.textVersions);
        textDesc = findViewById(R.id.textDescription);
        imageDetail = findViewById(R.id.imageDetail);

        getData();
        setData();

    }

    private void setData(){
        textType.setText(type);
        textNickname.setText(nickname);
        textAge.setText(age + "");
        textBirthYear.setText(birthYear + "");
        textVersions.setText(versions);
        textDesc.setText(desc);

        Picasso.get().load(urlImage)
                .fit()
                .centerCrop()
                .into(imageDetail);

    }

    private void getData(){
        if (getIntent().hasExtra("type") &&
        getIntent().hasExtra("nickname")){
            type = getIntent().getStringExtra("type");
            nickname = getIntent().getStringExtra("nickname");
            age = getIntent().getIntExtra("age",1);
            birthYear = getIntent().getIntExtra("birthyear",1);
            versions = getIntent().getStringExtra("versions");
            desc = getIntent().getStringExtra("desc");
            urlImage = getIntent().getStringExtra("urlImage");

        }else{
            Toast.makeText(this, "No data found", Toast.LENGTH_LONG).show();  // Añadido el .show()
            finish();  // Finaliza la actividad si no hay datos
        }
    }





}