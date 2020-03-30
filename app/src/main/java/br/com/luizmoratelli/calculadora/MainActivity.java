package br.com.luizmoratelli.calculadora;

import androidx.appcompat.app.AppCompatActivity;
import androidx.arch.core.util.Function;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText screen;
    private String stringOnScreen = "";

    private String number1 = "";
    private String number2 = "";
    private String op;
    private Float result = 0f;

    private Button button0;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;
    private Button buttonC;
    private Button buttonDot;
    private Button buttonMinus;
    private Button buttonPlus;
    private Button buttonDivided;
    private Button buttonTimes;
    private Button buttonEnter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        screen = findViewById(R.id.Resultado);
        button0 = findViewById(R.id.Button0);
        button1 = findViewById(R.id.Button1);
        button2 = findViewById(R.id.Button2);
        button3 = findViewById(R.id.Button3);
        button4 = findViewById(R.id.Button4);
        button5 = findViewById(R.id.Button5);
        button6 = findViewById(R.id.Button6);
        button7 = findViewById(R.id.Button7);
        button8 = findViewById(R.id.Button8);
        button9 = findViewById(R.id.Button9);
        buttonC = findViewById(R.id.ButtonC);
        buttonDot = findViewById(R.id.ButtonDot);
        buttonMinus = findViewById(R.id.ButtonMinus);
        buttonPlus = findViewById(R.id.ButtonPlus);
        buttonDivided = findViewById(R.id.ButtonDivided);
        buttonTimes = findViewById(R.id.ButtonTimes);
        buttonEnter = findViewById(R.id.ButtonEnter);

        handleButtonsListeners();
    }

    private void handleButtonsListeners() {
        button0.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                number("0");
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                number("1");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                number("2");
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                number("3");
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                number("4");
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                number("5");
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                number("6");
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                number("7");
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                number("8");
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                number("9");
            }
        });

        buttonDot.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                number(".");
            }
        });

        buttonPlus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                operation("+");
            }
        });

        buttonMinus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                operation("-");
            }
        });

        buttonDivided.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                operation("/");
            }
        });

        buttonTimes.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                operation("*");
            }
        });

        buttonC.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                clean();
            }
        });

        buttonEnter.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                operation("=");
            }
        });
    }

    private void number(String n) {
        System.out.println(op);
        if (op == null) {
            number1 += n;
            updateScreen(number1);
        } else {
            number2 += n;
            updateScreen(number2);
        }
    }

    private void operation(String o) {
        if (o.equals("=")) {
            calculate();
        } else if (op != null) {
            number1 = calculate();
            op = o;
        } else {
            op = o;
            updateScreen(o);
        }
    }

    private String calculate() {
        float n1 = number1 == "" ? 0 : Float.parseFloat(number1);
        float n2 = number2 == "" ? 0 : Float.parseFloat(number2);
        String o = op == null ? "" : op;

        switch (o) {
            case "+":
                number1 = String.valueOf(n1 + n2);
                break;
            case "-":
                number1 = String.valueOf(n1 - n2);
                break;
            case "/":
                number1 = String.valueOf(n1 / n2);
                break;
            case "*":
                number1 = String.valueOf(n1 * n2);
                break;
            default:
                number1 = "";
                break;
        }

        number2 = "";
        op = null;

        updateScreen(number1);

        return number1;
    }

    private void updateScreen(String value) {
        screen.setText(value);
    }

    private void clearScreen() {
        screen.setText("0");
    }

    private void clean() {
        number1 = "";
        number2 = "";
        op = null;
        clearScreen();
    }
}
