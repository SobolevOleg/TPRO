package com.example.mult;

import android.app.Activity;
import android.os.Bundle;
import android.provider.Settings;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private EditText Text1;
    private EditText Text2;
    private Button myButton;

    private TextView stolbikTime, KaratsybaTime;
    private TextView stolbikAnswer, KaratsybaAnswer;
    private TextView algorythmResume;

    private int size_a, size_b, length;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Text1 = (EditText) findViewById(R.id.editText);
        Text2 = (EditText) findViewById(R.id.editText2);
        myButton = (Button) findViewById(R.id.button);

        stolbikTime = (TextView) findViewById(R.id.textView2);
        KaratsybaTime = (TextView) findViewById(R.id.textView6);

        stolbikAnswer = (TextView) findViewById(R.id.textView7);
        KaratsybaAnswer = (TextView) findViewById(R.id.textView8);

        algorythmResume = (TextView) findViewById(R.id.textView9);


        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                long t1 = System.nanoTime();
                //---------Умножение столбиком---------
                String temp1 = Text1.getText().toString();
                String temp2 = Text2.getText().toString();
                

                size_a = temp1.length();
                size_b = temp2.length();

                length = size_a + size_b + 1;

                int a[] = new int[size_a];
                int b[] = new int[size_b];
                int c[] = new int[length];

                for (int i = 0; i<size_a; i++)
                    a[i] = Character.getNumericValue(temp1.charAt(size_a-i-1));

                for (int i = 0; i<size_b; i++)
                    b[i] = Character.getNumericValue(temp2.charAt(size_b-i-1));


                for (int ix = 0; ix < size_a; ix++)
                    for (int jx = 0; jx < size_b; jx++)
                        c[ix + jx] += a[ix] * b[jx];

                for (int ix = 0; ix < length-1; ix++)
                {
                    c[ix + 1] +=  c[ix] / 10;
                    c[ix] %= 10;
                }

                while (c[length-1] == 0)
                    length-- ;

                String s="";
                for (int i=length-1; i>=0; i--)
                    s += Integer.toString(c[i]);
                //-------------------------------------
                long t2 = System.nanoTime();
                stolbikAnswer.setText("Ответ: "+s);
                stolbikTime.setText(Long.toString(t2-t1) + " наносекунд");




                Karatsuba Krt = new Karatsuba();  //время на создание класса не учитываем, т.к. можно его методы вписать и сюда
                long t3 = System.nanoTime();
                //-----------Метод Каратцубы-----------
                String answer = Krt.longMult(temp1, temp2);// учтем только время исполнения самого алгоритма
                //-------------------------------------
                long t4 = System.nanoTime();
                KaratsybaTime.setText(Long.toString(t4-t3) + " наносекунд");
                KaratsybaAnswer.setText("Ответ: "+answer);


                float efficiency = (t2-t1)/(t4-t3);
                algorythmResume.setText("Эффективность алгоритма Карацубы в "+efficiency+" раз выше, чем умножение столбиком для этого примера.");
            }
        });
     }


}
