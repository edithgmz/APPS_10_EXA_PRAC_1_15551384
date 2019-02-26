package com.example.propietario.cua;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class Principal extends AppCompatActivity implements View.OnClickListener, View.OnTouchListener {
    private TextView txtVwAngulo;
    private EditText edtTxtRadio;
    private SeekBar seekA;
    private Button btnCalcula;
    private double v, a, r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        edtTxtRadio = findViewById(R.id.edtTxtRadio);
        txtVwAngulo = findViewById(R.id.txtVwAngulo);
        seekA = findViewById(R.id.seekBar);
        btnCalcula = findViewById(R.id.btnCalcula);

        btnCalcula.setOnClickListener(this);

        findViewById(R.id.layPrincipal).setOnTouchListener(this);

        seekA.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                a = i*3.6;
                txtVwAngulo.setText(""+a);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }

    @Override
    public void onClick(View view) {
        calculaVolmen();
    }

    private void calculaVolmen(){
        r = Double.parseDouble(edtTxtRadio.getText().toString());
        v = (0.66667)*(a*r*3); //(2/3)*(a*r*3);
        Toast.makeText(this, v+"", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        return false;
    }
}
