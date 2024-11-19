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

import com.example.bultacocatalogo.DB.UserDB;
import com.example.bultacocatalogo.model.User;

import org.mindrot.jbcrypt.BCrypt;

import java.sql.SQLException;

public class SIngUpActivity extends AppCompatActivity {

    private EditText textUsername;
    private EditText textPassword;
    private EditText textEmail;
    private EditText textName;
    private Button buttonSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sing_up);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Hooks
        textName = findViewById(R.id.textName);
        textUsername = findViewById(R.id.textUser);
        textPassword = findViewById(R.id.textPassword1);
        textEmail = findViewById(R.id.textEmail);
        buttonSignUp = findViewById(R.id.buttonSingUp1);

        buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*
                Toast.makeText(SIngUpActivity.this, "Botón de registro presionado", Toast.LENGTH_SHORT).show();
                String username = textUsername.getText().toString().trim();
                String email = textEmail.getText().toString().trim();
                String name = textName.getText().toString().trim();
                String password = textPassword.getText().toString().trim();

                if (!username.isEmpty() && !password.isEmpty() && !email.isEmpty() && !name.isEmpty()) {
                    UserDB userDB = new UserDB();
                    try {
                        userDB.conectar();
                        Toast.makeText(SIngUpActivity.this, "Conectado a la base de datos", Toast.LENGTH_SHORT).show();

                        User existingUser = userDB.getUserByEmail(email);
                        if (existingUser == null) {
                            String hashedPassword = hashPassword(password);
                            User newUser = new User(name, username, email, hashedPassword);
                            userDB.insertNewUser(newUser);

                            Toast.makeText(SIngUpActivity.this, "Registro exitoso", Toast.LENGTH_SHORT).show();

                            Intent intent = new Intent(SIngUpActivity.this, LoginActivity.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(SIngUpActivity.this, "El correo electrónico ya está registrado", Toast.LENGTH_SHORT).show();
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                        Toast.makeText(SIngUpActivity.this, "Error al conectar con la base de datos: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                    } finally {
                        try {
                            userDB.desconectar();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                } else {
                    Toast.makeText(SIngUpActivity.this, "Por favor complete todos los campos", Toast.LENGTH_SHORT).show();
                }

                 */
            }


        });

    }

    private String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }
}
