package com.example.pentagram.menu_opciones;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.pentagram.MainActivity;
import com.example.pentagram.R;

public class Contacto extends AppCompatActivity implements View.OnClickListener{

    private EditText etNombre,etEmail, etComentario, etSubject;
    private Button btnMensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        etNombre= (EditText) findViewById(R.id.etNombre);
        etComentario= (EditText) findViewById(R.id.etComentario);
        etEmail= (EditText) findViewById(R.id.etEmail);
        etSubject= (EditText) findViewById(R.id.etSubject);
        btnMensaje= (Button) findViewById(R.id.btnMensaje);

        btnMensaje.setOnClickListener(this);

        //Enviar email credential




        Toolbar miActionBar = findViewById(R.id.miActionbar);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        miActionBar.setNavigationOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Contacto.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }

    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if(keyCode == KeyEvent.KEYCODE_BACK){
            Intent intent = new Intent(Contacto.this, MainActivity.class);

            startActivity(intent);
        }
        return super.onKeyDown(keyCode, event);
    }

    private void sendEmail() {
        //Getting content for email
        String email = etEmail.getText().toString().trim();
        String subject = etSubject.getText().toString().trim();
        String message = etComentario.getText().toString().trim();

        //Creating SendMail object
        SendMail sm = new SendMail(this, email, subject, message);

        //Executing sendmail to send email
        sm.execute();
    }

    @Override
    public void onClick(View v) {
        sendEmail();
    }

}