package com.example.inteneyali;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

     EditText display;
     Button plus, sub, multi, division, equal, delete, credits;
     float result, num;
     String oper, str;
     int count, check;
     TextView name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        oper="";
        str="";
        display = findViewById(R.id.editText);
        plus = findViewById(R.id.button);
        sub = findViewById(R.id.button2);
        multi = findViewById(R.id.button3);
        division = findViewById(R.id.button4);
        delete = findViewById(R.id.button5);
        equal = findViewById(R.id.button6);
        credits = findViewById(R.id.button7);
    }

    public void add(View view) {

        str = display.getText().toString();
        if (!str.isEmpty()) {
            count += 1;
            num = Float.parseFloat(str);
            if (oper.equals("-"))
                result -= num;
            else if (oper.equals("*"))
                result *= num;
            else if (oper.equals("/")) {
                if (num == 0)
                    display.setText("Error");
                else
                    result /= num;
            } else
                result += num;
            oper = "+";
        }

        display.setText("");
        display.getHint();

    }

    public void equal(View view) {
        if (oper.equals("+")) {
            str = display.getText().toString();
            num = Float.parseFloat(str);
            result += num;
        }
        if (oper.equals("-")) {
            str = display.getText().toString();
            num = Float.parseFloat(str);
            result -= num;
        }
        if (oper.equals("*")) {
            str = display.getText().toString();
            num = Float.parseFloat(str);
            result *= num;
        }
        if (oper.equals("/")) {
            str = display.getText().toString();
            num = Float.parseFloat(str);
            if (num == 0)
                display.setText("Error");

            else {
                result /= num;
                display.setText(result + "");
            }
        } else
            display.setText(result + "");

    }

    public void delete(View view) {
        count = 0;
        result = 0;
        oper = "";
        display.setText("");
        display.getHint();
    }

    public void sub(View view) {

        str = display.getText().toString();
        if (!str.isEmpty()) {
            count += 1;
            num = Float.parseFloat(str);
            if (oper.equals("+"))
                result += num;
            else if (oper.equals("*"))
                result *= num;
            else if (oper.equals("/")) {
                if (num == 0)
                    display.setText("Error");
                else
                    result /= num;
            } else {
                if (count == 1)
                    if (oper.equals(""))
                        result = num;
                    else
                        result = Float.valueOf(-num);
                else
                    result -= num;
            }

        }

        oper= "-";
        display.setText("");
        display.getHint();
    }

    public void multi(View view) {
        str = display.getText().toString();
        if (!str.isEmpty()) {
            count += 1;
            num = Float.parseFloat(str);
            if (oper.equals("+"))
                result += num;
            else if (oper.equals("-"))
                result -= num;
            else if (oper.equals("/")) {
                if (num == 0)
                    display.setText("Error");
                else
                    result /= num;
            } else {
                if (count == 1)
                    result = num;
                else
                    result *= num;
            }

            oper= "*";

        }

        display.setText("");
        display.getHint();

    }

    public void division(View view) {
        str = display.getText().toString();
        if (!str.isEmpty()) {
            count += 1;
            num = Float.parseFloat(str);
            if (oper.equals("+"))
                result += num;
            else if (oper.equals("-"))
                result -= num;
            else if (oper.equals("*"))
                result *= num;
            else {
                if (count == 1)
                    result = num;
                else if (num == 0)
                    display.setText("Error");
                else
                    result /= num;
            }

            oper= "/";
        }

        display.setText("");
        display.getHint();

    }

    public void credits(View view) {
        Intent si = new Intent(this, MainActivity2.class);
        if (display.getText().toString().equals("Error"))
            si.putExtra("error", "Error");
        else
            si.putExtra("num", result);
        startActivity(si);


    }
}