package com.example.ex10;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText display;
    double res = 0;
    char op = ' ';

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display = findViewById(R.id.display);
    }

    public void clickPlus(View v) { setOp('+'); }
    public void clickMinus(View v) { setOp('-'); }
    public void clickMult(View v) { setOp('*'); }
    public void clickDiv(View v) { setOp('/'); }

    private void setOp(char nextOp) {
        calculate();
        op = nextOp;
        display.setHint(String.valueOf(res));
        display.setText("");
    }

    public void clickEqual(View v) {
        calculate();
        if (res == 999999999) {
            display.setText("Error");
            res = 0;
        } else {
            display.setText(String.valueOf(res));
        }
        op = ' ';
    }

    public void clickAC(View v) {
        display.setText("");
        display.setHint("0");
        res = 0;
        op = ' ';
    }

    public void calculate() {
        String s = display.getText().toString();
        if (s.isEmpty() || s.equals(".")) return;

        double num = Double.parseDouble(s);

        if (op == ' ') res = num;
        if (op == '+') res += num;
        if (op == '-') res -= num;
        if (op == '*') res *= num;
        if (op == '/') {
            if (num == 0) res = 999999999;
            else res /= num;
        }
    }
}