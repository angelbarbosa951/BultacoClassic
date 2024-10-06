package com.example.bultacocatalogo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import org.mindrot.jbcrypt.BCrypt;

public class LoginActivity extends AppCompatActivity {
    private String storedHashedPassword = hashPassword("1234");

    private EditText textUsername;
    private EditText textPassword;
    private Button buttonLogin;
    private Button buttonSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        textUsername = findViewById(R.id.textUsername);
        textPassword = findViewById(R.id.TextPassword);

        buttonLogin = findViewById(R.id.buttonLogin);
        buttonSignUp = findViewById(R.id.buttonSingUp);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (login(textUsername.getText().toString().trim(), textPassword.getText().toString().trim())) {
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    intent.putExtra("username",textUsername.getText().toString().trim() );
                    intent.putExtra("password",textPassword.getText().toString().trim() );
                    startActivity(intent);
                } else {
                    Toast.makeText(LoginActivity.this, "Error username or password.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, SIngUpActivity.class);
                startActivity(intent);
            }
        });


    }

    private boolean login(String username, String password) {
        return username.equals("a231831as") && checkPassword(password, storedHashedPassword);
    }

    //Encriptacio en HASH
    private String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    private boolean checkPassword(String password, String hashed) {
        return BCrypt.checkpw(password, hashed);
    }
}