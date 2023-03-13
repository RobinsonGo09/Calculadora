package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    TextView tvdisplay;
    double n1, n2, result;
    String operador, cadena;
    boolean punto;
    DecimalFormat df = new DecimalFormat("#.0000");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void botonCero(View view)
    {
        tvdisplay=(TextView) findViewById(R.id.textViewdisp);
        tvdisplay.setText(tvdisplay.getText()+"0");
    }
    public void botonUno(View view)
    {
        tvdisplay=(TextView) findViewById(R.id.textViewdisp);
        tvdisplay.setText(tvdisplay.getText()+"1");
    }
    public void botonDos(View view)
    {
        tvdisplay=(TextView) findViewById(R.id.textViewdisp);
        tvdisplay.setText(tvdisplay.getText()+"2");
    }
    public void botonTres(View view)
    {
        tvdisplay=(TextView) findViewById(R.id.textViewdisp);
        tvdisplay.setText(tvdisplay.getText()+"3");
    }
    public void botonCuatro(View view)
    {
        tvdisplay=(TextView) findViewById(R.id.textViewdisp);
        tvdisplay.setText(tvdisplay.getText()+"4");
    }
    public void botonCinco(View view)
    {
        tvdisplay=(TextView) findViewById(R.id.textViewdisp);
        tvdisplay.setText(tvdisplay.getText()+"5");
    }
    public void botonSeis(View view)
    {
        tvdisplay=(TextView) findViewById(R.id.textViewdisp);
        tvdisplay.setText(tvdisplay.getText()+"6");
    }
    public void botonSiete(View view)
    {
        tvdisplay=(TextView) findViewById(R.id.textViewdisp);
        tvdisplay.setText(tvdisplay.getText()+"7");
    }
    public void botonOcho(View view)
    {
        tvdisplay=(TextView) findViewById(R.id.textViewdisp);
        tvdisplay.setText(tvdisplay.getText()+"8");
    }
    public void botonNueve(View view)
    {
        tvdisplay=(TextView) findViewById(R.id.textViewdisp);
        tvdisplay.setText(tvdisplay.getText()+"9");
    }
    public void botonPunto(View view) {
        if(punto==false){
        tvdisplay=(TextView) findViewById(R.id.textViewdisp);
        tvdisplay.setText(tvdisplay.getText()+".");
        punto=true;
        }else {
            Toast.makeText(MainActivity.this, "No puedes poner mas de un decimal", Toast.LENGTH_LONG).show();
        }


    }

    public void OnClickOperacioncapturanumerouno(View view)
    {
        tvdisplay = (TextView) findViewById(R.id.textViewdisp);
        try {
            n1 = Double.parseDouble(tvdisplay.getText().toString());
            tvdisplay.setText(" ");
            punto=false;
        } catch (NumberFormatException nfe) {
        }
    }
    public void sumar(View view)
    {
        operador = "+";
        OnClickOperacioncapturanumerouno(view);
    }
    public void restar(View view)
    {
        operador="-";
        OnClickOperacioncapturanumerouno(view);
    }
    public void multiplicar(View view)
    {
        operador="*";
        OnClickOperacioncapturanumerouno(view);
    }
    public void dividir(View view)
    {
        operador="/";
        OnClickOperacioncapturanumerouno(view);
    }
    public void cambioSigno(View view)
    {
        operador="+*-";
        tvdisplay = (TextView) findViewById(R.id.textViewdisp);
        try {
            n1 = Double.parseDouble(tvdisplay.getText().toString());
            result=n1*(-1);
            tvdisplay.setText(String.valueOf(result));
        } catch (NumberFormatException nfe) {
        }
    }
    public void potencia(View view) {
        operador = "pot";
        tvdisplay = (TextView) findViewById(R.id.textViewdisp);
        try {
            n1 = Double.parseDouble(tvdisplay.getText().toString());
            tvdisplay.setText(" ");
        } catch (NumberFormatException nfe) {
        }
    }
    public void raiz(View view)
    {
        operador="rz";
        tvdisplay = (TextView) findViewById(R.id.textViewdisp);
        try {
            n1 = Double.parseDouble(tvdisplay.getText().toString());
            result=Math.sqrt(n1);
            tvdisplay.setText(String.valueOf(result));
        } catch (NumberFormatException nfe) {
        }
    }
    public void botonigual(View view)
    {
        try {
        tvdisplay=(TextView) findViewById(R.id.textViewdisp);
        n2=Double.parseDouble(tvdisplay.getText().toString());
            if (operador.equals("+")) {
                result = n1 + n2;

            }
            if (operador.equals("-")) {
                result = n1 - n2;
            }
            if (operador.equals("*")) {
                result = n1 * n2;
            }
            if (operador.equals("/")) {
                result = n1 / n2;
            }

            if (operador.equals("pot")) {
                tvdisplay = (TextView) findViewById(R.id.textViewdisp);
                n2 = Double.parseDouble(tvdisplay.getText().toString());
                tvdisplay.setText(" ");
                result = Math.pow(n1, n2);
            }
            if (operador.equals("rz")) {
                tvdisplay = (TextView) findViewById(R.id.textViewdisp);
                n2 = Double.parseDouble(tvdisplay.getText().toString());
                tvdisplay.setText(" ");
                result = Math.sqrt(n1);
            }
            tvdisplay.setText(" " + df.format(result));
            punto=false;
        }
        catch (NumberFormatException nfe) {
        }

    }
    public void borrardigito(View view)
    {
        if (tvdisplay.getText().toString().equals(" "))
        {
            tvdisplay.setText(tvdisplay.getText().subSequence(0,tvdisplay.getText().length()-1)+ " ");
        }
    }
    public void borrarTodo(View view){
        n1=0.0;
        n2=0.0;
        tvdisplay=(TextView) findViewById(R.id.textViewdisp);
        tvdisplay.setText(" ");
    }
    public void off(View view){
        finish();
    }
}
