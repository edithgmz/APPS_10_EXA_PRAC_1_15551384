package edith.example.tic_tac_toe;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Principal extends AppCompatActivity implements View.OnClickListener {
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnReinicia;
    TextView txtVwInfo;

    boolean bTurnoX = true;
    boolean bReinicia, bGanador=false;

    int iTurnos = 0;
    int[][] iArrTablero = new int[3][3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btnReinicia = findViewById(R.id.btnReinicia);
        txtVwInfo = findViewById(R.id.txtVwInfo);

        reiniciar();

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btnReinicia.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        bReinicia = false;
        //Checa cuál botón ha sido presionado y cambia el texto según sea el turno
        switch (v.getId()){
            case R.id.btn1:
                if(bTurnoX){
                    btn1.setText("X");
                    iArrTablero[0][0] = 1;
                } else{
                    btn1.setText("O");
                    iArrTablero[0][0] = 0;
                }
                btn1.setEnabled(false);
                break;
            case R.id.btn2:
                if(bTurnoX){
                    btn2.setText("X");
                    iArrTablero[0][1] = 1;
                } else{
                    btn2.setText("O");
                    iArrTablero[0][1] = 0;
                }
                btn2.setEnabled(false);
                break;
            case R.id.btn3:
                if(bTurnoX){
                    btn3.setText("X");
                    iArrTablero[0][2] = 1;
                } else{
                    btn3.setText("O");
                    iArrTablero[0][2] = 0;
                }
                btn3.setEnabled(false);
                break;
            case R.id.btn4:
                if(bTurnoX){
                    btn4.setText("X");
                    iArrTablero[1][0] = 1;
                } else{
                    btn4.setText("O");
                    iArrTablero[1][0] = 0;
                }
                btn4.setEnabled(false);
                break;
            case R.id.btn5:
                if(bTurnoX){
                    btn5.setText("X");
                    iArrTablero[1][1] = 1;
                } else{
                    btn5.setText("O");
                    iArrTablero[1][1] = 0;
                }
                btn5.setEnabled(false);
                break;
            case R.id.btn6:
                if(bTurnoX){
                    btn6.setText("X");
                    iArrTablero[1][2] = 1;
                } else{
                    btn6.setText("O");
                    iArrTablero[1][2] = 0;
                }
                btn6.setEnabled(false);
                break;
            case R.id.btn7:
                if(bTurnoX){
                    btn7.setText("X");
                    iArrTablero[2][0] = 1;
                } else{
                    btn7.setText("O");
                    iArrTablero[2][0] = 0;
                }
                btn7.setEnabled(false);
                break;
            case R.id.btn8:
                if(bTurnoX){
                    btn8.setText("X");
                    iArrTablero[2][1] = 1;
                } else{
                    btn8.setText("O");
                    iArrTablero[2][1] = 0;
                }
                btn8.setEnabled(false);
                break;
            case R.id.btn9:
                if(bTurnoX){
                    btn9.setText("X");
                    iArrTablero[2][2] = 1;
                } else{
                    btn9.setText("O");
                    iArrTablero[2][2] = 0;
                }
                btn9.setEnabled(false);
                break;
            case R.id.btnReinicia:
                bReinicia = true;
                break;
            default:
                break;
        }
        //Verifica si el tablero ha sido reiniciado
        if(bReinicia){
            reiniciar();
        } else{
            iTurnos++;
            bTurnoX = !bTurnoX;

            if(bTurnoX){
                escribeInfo("Turno de las X");
            } else{
                escribeInfo("Turno de las O");
            }

            if(iTurnos == 9 && !bGanador){
                resultado("Empate");
            }
            verResultado();
        }
    }
    //Comprueba el resultado del juego
    void verResultado(){
        //Filas
        for (int i = 0; i < 3; i++) {
            if(iArrTablero[i][0] == iArrTablero[i][1] && iArrTablero[i][0] == iArrTablero[i][2]){
                if(iArrTablero[i][0] == 1){
                    resultado("Gana X");
                    bGanador = true;
                    break;
                } else if(iArrTablero[i][0] == 0) {
                    resultado("Gana O");
                    bGanador=true;
                    break;
                }
            }
        }
        //Columnas
        for (int j = 0; j < 3; j++) {
            if(iArrTablero[0][j] == iArrTablero[1][j] && iArrTablero[0][j] == iArrTablero[2][j]){
                if(iArrTablero[0][j] == 1){
                    resultado("Gana X");
                    bGanador = true;
                    break;
                } else if(iArrTablero[0][j] == 0) {
                    resultado("Gana O");
                    bGanador = true;
                    break;
                }
            }
        }
        //Diagonal 1
        if(iArrTablero[0][0] == iArrTablero[1][1] && iArrTablero[0][0] == iArrTablero[2][2]){
            if(iArrTablero[0][0] == 1){
                resultado("Gana X");
            } else if(iArrTablero[0][0] == 0) {
                resultado("Gana O");
            }
        }
        //Diagonal 2
        if(iArrTablero[0][2] == iArrTablero[1][1] && iArrTablero[0][2] == iArrTablero[2][0]){
            if(iArrTablero[0][2] == 1){
                resultado("Gana X");
                bGanador = true;
            } else if(iArrTablero[0][2] == 0) {
                resultado("Gana O");
                bGanador = true;
            }
        }
    }
    //Indica el resultado del juego
    void resultado(final String resu){
        escribeInfo(resu);
        estadoBotones(false);
        new AlertDialog.Builder(this).setTitle("Resultado del juego")
                .setMessage(resu).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), resu, Toast.LENGTH_SHORT).show();
                    }
                }).create().show();
    }
    //Reinicia el juego
    void reiniciar(){
        btn1.setText("-");
        btn2.setText("-");
        btn3.setText("-");
        btn4.setText("-");
        btn5.setText("-");
        btn6.setText("-");
        btn7.setText("-");
        btn8.setText("-");
        btn9.setText("-");

        estadoBotones(true);

        bTurnoX = true;
        iTurnos = 0;

        bGanador = false;

        iniciaTablero();

        escribeInfo("Inician las X");
    }
    //Habilita o deshabilita todos los botones del tablero
    void estadoBotones(Boolean estado){
        btn1.setEnabled(estado);
        btn2.setEnabled(estado);
        btn3.setEnabled(estado);
        btn4.setEnabled(estado);
        btn5.setEnabled(estado);
        btn6.setEnabled(estado);
        btn7.setEnabled(estado);
        btn8.setEnabled(estado);
        btn9.setEnabled(estado);
    }
    //Escribe en el TextView
    void escribeInfo(String info){
        txtVwInfo.setText(info);
    }
    //Inicia el tablero
    void iniciaTablero(){
        for(int i = 0; i < 3; i++) for (int j = 0; j < 3; j++) iArrTablero[i][j] = -1;
    }
}
