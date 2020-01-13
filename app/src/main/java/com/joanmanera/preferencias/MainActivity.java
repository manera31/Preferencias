package com.joanmanera.preferencias;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Intent intent;
    private TextView tvUsuario, tvPass, tvServicio, tvCifrado;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvUsuario = findViewById(R.id.tvUsuario);
        tvPass = findViewById(R.id.tvPass);
        tvServicio = findViewById(R.id.tvServicio);
        tvCifrado = findViewById(R.id.tvCifrado);

        button = findViewById(R.id.bPreferencias);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MainActivity.this, OpcionesActivity.class);
                startActivity(intent);
            }
        });


    }
    @Override
    protected void onResume() {
        super.onResume();
        cargarPreferencias();
    }

    private void cargarPreferencias(){
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        tvUsuario.setText(preferences.getString("user", "Usuario"));
        tvPass.setText(preferences.getString("pass", "Contraseña"));

        boolean servicio = preferences.getBoolean("service", false);
        if (servicio){
            tvServicio.setText("Si");
        } else {
            tvServicio.setText("No");
        }

        boolean cifrado = preferences.getBoolean("encryption", false);
        if (cifrado){
            String list = preferences.getString("list", "null");
            tvCifrado.setText("Si " + list);
        } else {
            tvCifrado.setText("No");
        }
    }
}
