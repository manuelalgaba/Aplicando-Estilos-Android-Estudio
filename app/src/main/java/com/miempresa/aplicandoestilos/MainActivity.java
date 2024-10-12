package com.miempresa.aplicandoestilos;

import static java.lang.Math.log;

import android.os.Bundle;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity {
    private RadioGroup rgColor;
    private CheckBox ckbNegrita, ckbCursiva;
    private SwitchCompat swtObscuro, swtInfoLog;
    private TextView txtRespuesta, lblColor, lblEstilo;
    private RadioButton rdbRojo, rdbVerde, rdbAzul;
    private LinearLayout main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // inicializamos las vistas
        rgColor = findViewById(R.id.rgcolor);
        ckbNegrita = findViewById(R.id.ckbNegrita);
        ckbCursiva = findViewById(R.id.ckbCursiva);
        swtObscuro = findViewById(R.id.swtObscuro);
        swtInfoLog = findViewById(R.id.swtInfoLog);
        txtRespuesta = findViewById(R.id.txtRespuesta);
        rdbRojo = findViewById(R.id.rdbRojo);
        rdbVerde = findViewById(R.id.rdbVerde);
        rdbAzul = findViewById(R.id.rdbAzul);
        main = findViewById(R.id.main);
        lblColor = findViewById(R.id.lblColor);
        lblEstilo = findViewById(R.id.lblEstilo);

        // Listener para el grupo de radio
        rgColor.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.rdbRojo) {
                txtRespuesta.setTextColor(ContextCompat.getColor(this, R.color.rojo));
                logCambio("Cambio de color a rojo");
            } else if (checkedId == R.id.rdbVerde) {
                txtRespuesta.setTextColor(ContextCompat.getColor(this, R.color.verde));
                logCambio("Cambio de color a verde");
            } else if (checkedId == R.id.rdbAzul) {
                txtRespuesta.setTextColor(ContextCompat.getColor(this, R.color.azul));
                logCambio("Cambio de color a azul");
            }
        });

        // Listener para el checkbox de negrita y cursiva combinados
        ckbNegrita.setOnCheckedChangeListener((buttonView, isChecked) -> cambiarEstiloTexto());
        ckbCursiva.setOnCheckedChangeListener((buttonView, isChecked) -> cambiarEstiloTexto());

        // Listener para el switch
        swtObscuro.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                lblColor.setTextColor(ContextCompat.getColor(this, R.color.white));
                lblEstilo.setTextColor(ContextCompat.getColor(this, R.color.white));
                main.setBackgroundColor(ContextCompat.getColor(this, R.color.black));
                swtObscuro.setTextColor(ContextCompat.getColor(this, R.color.white));
                swtInfoLog.setTextColor(ContextCompat.getColor(this, R.color.white));
                rdbRojo.setTextColor(ContextCompat.getColor(this, R.color.white));
                rdbVerde.setTextColor(ContextCompat.getColor(this, R.color.white));
                rdbAzul.setTextColor(ContextCompat.getColor(this, R.color.white));
                ckbNegrita.setTextColor(ContextCompat.getColor(this, R.color.white));
                ckbCursiva.setTextColor(ContextCompat.getColor(this, R.color.white));
                logCambio("Modo obscuro activado");
            } else {
                lblColor.setTextColor(ContextCompat.getColor(this, R.color.black));
                lblEstilo.setTextColor(ContextCompat.getColor(this, R.color.black));
                main.setBackgroundColor(ContextCompat.getColor(this, R.color.white));
                swtObscuro.setTextColor(ContextCompat.getColor(this, R.color.black));
                swtInfoLog.setTextColor(ContextCompat.getColor(this, R.color.black));
                rdbRojo.setTextColor(ContextCompat.getColor(this, R.color.black));
                rdbVerde.setTextColor(ContextCompat.getColor(this, R.color.black));
                rdbAzul.setTextColor(ContextCompat.getColor(this, R.color.black));
                ckbNegrita.setTextColor(ContextCompat.getColor(this, R.color.black));
                ckbCursiva.setTextColor(ContextCompat.getColor(this, R.color.black));
                logCambio("Modo obscuro desactivado");
            }
        });

        // Listener para el switch info log
        swtInfoLog.setOnCheckedChangeListener((buttonView, isChecked) -> {
            Log.d("MainActivity", "Modo info log " + (isChecked ? "habilitado" : "deshabilitado"));
        });
    }

    private void logCambio(String mensaje) {
        if (swtInfoLog.isChecked()) {
            Log.d("MainActivity", mensaje);
        }
    }

    // Método para actualizar el estilo del texto (negrita y cursiva combinados)
    private void cambiarEstiloTexto() {
        if (ckbNegrita.isChecked() && ckbCursiva.isChecked()) {
            txtRespuesta.setTypeface(null, android.graphics.Typeface.BOLD_ITALIC);
            logCambio("Estilo de texto cambiado a negrita y cursiva");
        } else if (ckbNegrita.isChecked()) {
            txtRespuesta.setTypeface(null, android.graphics.Typeface.BOLD);
            logCambio("Estilo de texto cambiado a negrita");
        } else if (ckbCursiva.isChecked()) {
            txtRespuesta.setTypeface(null, android.graphics.Typeface.ITALIC);
            logCambio("Estilo de texto cambiado a cursiva");
        } else {
            txtRespuesta.setTypeface(null, android.graphics.Typeface.NORMAL);
            logCambio("Estilo de texto normal");
        }
    }
}