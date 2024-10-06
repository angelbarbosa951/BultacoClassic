package com.example.bultacocatalogo;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bultacocatalogo.model.Bultaco;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Bultaco> bultacos = new ArrayList<>();
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //HOOK:
        recyclerView = findViewById(R.id.recyclerView);
        initData();
        MyAdapter myAdapter = new MyAdapter(bultacos, this);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


    }

    private void initData(){
        String[] bultacoVersions1 = {"370cc", "250cc", "74cc"};
        Bultaco bultaco1 =  new Bultaco(
                "https://clasicaslegendarias.com/shop/c/233-category_default/bultaco-frontera.jpg","Frontera","mk9-mk11",45,1975,bultacoVersions1,"La Bultaco Frontera fou un model de motocicleta fabricat per Bultaco entre 1975 i 1981, dissenyat específicament per a la pràctica de l'enduro (modalitat anomenada a l'època \"Tot Terreny\"). Al llarg de la seva vida comercial se'n produïren diverses versions en cilindrades variades -des dels 74 fins als 370 cc-,[1] totes elles amb les següents característiques generals: motor de dos temps monocilíndric refrigerat per aire, bastidor de simple bressol (tret de les versions de 74 i 125 cc, en què era doble), frens de tambor i amortidors de forquilla convencional davant i telescòpics darrere."
        );
        bultacos.add(bultaco1);

        String[] bultacoVersions2 = {"370cc", "250cc"};
        Bultaco bultaco2 =  new Bultaco(
                "https://clasicaslegendarias.com/shop/c/234-category_default/bultaco-pursang.jpg","Pursang","mk1-mk12",45,1967,bultacoVersions2,"La Bultaco Pursang fou un model de motocicleta fabricat per Bultaco entre 1967 i 1981, dissenyat específicament per a la pràctica del motocròs. Al llarg de la seva vida comercial se'n produïren diverses versions en cilindrades variades (des dels 125 fins als 400 cc), per bé que les més populars foren les de 250 i 370 cc. Com a característiques generals a totes les versions, disposaven d'un motor de dos temps monocilíndric refrigerat per aire, bastidor de simple bressol, frens de tambor i amortidors de forquilla convencional davant i telescòpics darrere."
        );
        bultacos.add(bultaco2);

        String[] bultacoVersions3 = {"350cc", "250cc"};
        Bultaco bultaco3 =  new Bultaco(
                "https://clasicaslegendarias.com/shop/c/238-category_default/bultaco-sherpa.jpg","Sherpa","m10-221",45,1964,bultacoVersions3,"La Bultaco Sherpa T fou un model de motocicleta de trial fabricat per Bultaco entre 1964 i 1985, època durant la qual fou una de les millors motocicletes d'aquesta modalitat (en forta competència amb les també catalanes Montesa Cota i OSSA MAR) i assolí un gran prestigi internacional. Les seves característiques principals eren el motor de dos temps monocilíndric refrigerat per aire (inicialment de 250 i més tard de 350 cc, a banda de les versions juvenils de 74 i 125 cc), bastidor de simple bressol (tret dels versions de 74 i 125 cc, en què era doble), frens de tambor i amortidors de forquilla convencional davant i telescòpics darrere."
        );
        bultacos.add(bultaco3);

        String[] bultacoVersions4 = {"350cc", "250cc"};
        Bultaco bultaco4 =  new Bultaco(
                "https://clasicaslegendarias.com/shop/c/240-category_default/bultaco-alpina.jpg","Alpina","m85-213",45,1971,bultacoVersions4,"La Bultaco Alpina fou un model de motocicleta de fora d'asfalt fabricat per Bultaco entre 1971 i 1980. Al llarg de la seva vida comercial se'n produïren diverses versions en cilindrades variades (des dels 125 fins als 350 cc), per bé que les més populars foren les de 250 i 350 cc."
        );
        bultacos.add(bultaco4);

        String[] bultacoVersions5 = {"125cc", "175cc", "200cc"};
        Bultaco bultaco5 =  new Bultaco(
                "https://clasicaslegendarias.com/shop/c/237-category_default/bultaco-mercurio-y-saturno.jpg","Mercurio","m125-m175gt",45,1961,bultacoVersions5,"La Bultaco Mercurio fou un model de motocicleta de turisme fabricat per Bultaco entre 1961 i 1986. Al llarg de la seva vida comercial se'n produïren diverses versions en cilindrades variades (des de 125 fins a 200 cc), totes elles amb les mateixes característiques generals: motor de dos temps monocilíndric refrigerat per aire, bastidor de simple bressol, frens de tambor i amortidors de forquilla convencional davant i telescòpics darrere. Durant anys, se li introduïren constants millores en els acabats, com ara la caixa d'eines carenada i petites modificacions en el grup termo-dinàmic."
        );
        bultacos.add(bultaco5);

        String[] bultacoVersions6 = {"125cc"};
        Bultaco bultaco6 =  new Bultaco(
                "https://clasicaslegendarias.com/shop/c/236-category_default/bultaco-tralla.jpg","Tralla","m101-m102",45,1959,bultacoVersions6,"La Bultaco Tralla fou un model de motocicleta de turisme fabricat per Bultaco en dues etapes: la primera, amb el nom de Tralla 101, de 1959 a 1963 i la segona, amb el nom de Tralla 102, de 1963 a 1971. Ambdues versions eren gairebé idèntiques i es diferenciaven sobretot pel seu acabat estètic, actualitzat en la 102, ja que compartien les mateixes característiques generals: motor de dos temps monocilíndric refrigerat per aire de 125 cc, bastidor de simple bressol, frens de tambor i amortidors de forquilla convencional davant i telescòpics darrere"
        );
        bultacos.add(bultaco6);

        String[] bultacoVersions7 = {"350cc", "250cc", "200cc"};
        Bultaco bultaco7 =  new Bultaco(
                "https://clasicaslegendarias.com/shop/c/248-category_default/bultaco-matador.jpg","Matador","mk2-mk10",45,1963,bultacoVersions7,"La Bultaco Matador fou un model de motocicleta fabricat per Bultaco entre 1963 i 1979, dissenyat específicament per a la pràctica de l'enduro (modalitat anomenada a l'època \"Tot Terreny\"). Al llarg de la seva vida comercial se'n produïren diverses versions, totes elles amb les següents característiques generals: motor de dos temps monocilíndric refrigerat per aire, bastidor de simple bressol, frens de tambor i amortidors de forquilla convencional davant i telescòpics darrere. Pel que fa a la cilindrada del motor, tret de la versió inicial de 200 cc totes en duien un de 250 cc, fins que el 1975 -amb el llançament de la Mk9- passaren a dur-lo de 350 cc"
        );
        bultacos.add(bultaco7);


    }
}