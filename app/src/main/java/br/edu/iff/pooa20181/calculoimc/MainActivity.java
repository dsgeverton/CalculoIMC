package br.edu.iff.pooa20181.calculoimc;

import android.inputmethodservice.Keyboard;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static android.R.attr.visible;

public class MainActivity extends AppCompatActivity {

    private EditText edtPeso, edtAltura;
    private Button btnCalcular;
    private TextView txtMostrarTexto;
    private double resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtPeso = (EditText) findViewById(R.id.edtPeso);
        edtAltura = (EditText) findViewById(R.id.edtAltura);
        btnCalcular = (Button) findViewById(R.id.btnCalcular);
        txtMostrarTexto = (TextView) findViewById(R.id.txtMostrarTexto);


        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcular();
            }
        });

    }

    public void calcular(){

        resultado = Float.parseFloat(edtPeso.getText().toString()) / Math.pow(Integer.parseInt(edtAltura.getText().toString()), 2);

        if (resultado < 17 ) {
            txtMostrarTexto.setText("Muito abaixo do peso");
        }
            else if (resultado >= 17 && resultado <= 18.49) {
            txtMostrarTexto.setText("Abaixo do peso");
            }

            else if (resultado >= 18.5 && resultado <= 24.99) {
                txtMostrarTexto.setText("Peso normal");
            }
                else if (resultado >= 25 && resultado <= 29.99) {
                    txtMostrarTexto.setText("Acima do Peso");
                }
                    else if (resultado >= 30 && resultado <= 34.99) {
                        txtMostrarTexto.setText("Obesidade I");
                    }
                        else if (resultado >= 35 && resultado <= 39.99) {
                            txtMostrarTexto.setText("Obesidade II (severa)");
                        }
                            else if (resultado >= 40 ) {
                                txtMostrarTexto.setText("Obesidade III (mósbida)");
                            }
    }
}
