package com.example.yashcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    Button clear,point,one,two,three,four,five,six,seven,eight,nine,zero,euler,factorial,sinf,cosf,tanf,logarithm,squareroot,percentage,power,equality,addition,multiply,substraction,divide;
    double var,var1,var2;
    boolean add,sub,mul,div,log,sqrt,per,pow,e,fact,sin,cos,tan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText=findViewById(R.id.editText);
        clear=findViewById(R.id.clear);
        point=findViewById(R.id.point);
        euler=findViewById(R.id.euler);
        factorial=findViewById(R.id.factorial);
        cosf=findViewById(R.id.cosf);
        sinf=findViewById(R.id.sinf);
        tanf=findViewById(R.id.tanf);
        one=findViewById(R.id.one);
        zero=findViewById(R.id.zero);
        two=findViewById(R.id.two);
        three=findViewById(R.id.three);
        four=findViewById(R.id.four);
        five=findViewById(R.id.five);
        six=findViewById(R.id.six);
        seven=findViewById(R.id.seven);
        eight=findViewById(R.id.eight);
        nine=findViewById(R.id.nine);
        logarithm=findViewById(R.id.logarithm);
        squareroot=findViewById(R.id.squareroot);
        percentage=findViewById(R.id.percentage);
        power=findViewById(R.id.power);
        equality=findViewById(R.id.equality);
        addition=findViewById(R.id.addition);
        substraction=findViewById(R.id.subtraction);
        multiply=findViewById(R.id.multiply);
        divide=findViewById(R.id.divide);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                var1=var=var2=0.0;
                editText.setText(" ");
            }
        });
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText()+"1");
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText()+"2");
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText()+"3");
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText()+"4");
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText()+"5");
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText()+"6");
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText()+"7");
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText()+"8");
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText()+"9");
            }
        });
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText()+"0");
            }
        });
        point.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText()+".");
            }
        });
        logarithm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // var1=Double.parseDouble(editText.getText()+"")
              if(editText!=null)
              {
                  var1=Double.parseDouble(editText.getText()+"");
                  log=true;
                  editText.setText(null);
                  //var=Math.log(var1);
                //  editText.setText(String.valueOf(var));
              }
              else
                  Toast.makeText(MainActivity.this, "enter a value first", Toast.LENGTH_LONG).show();
            }
        });
        squareroot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(editText!=null)
                {
                    var1=Double.parseDouble(editText.getText()+"");
                    sqrt=true;
                    editText.setText(null);
                }
                else
                    Toast.makeText(MainActivity.this, "enter a value first", Toast.LENGTH_LONG).show();

            }
        });
        euler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(editText!=null)
                {
                    var1=Double.parseDouble(editText.getText()+"");
                    e=true;
                    editText.setText(null);
                }
                else
                    Toast.makeText(MainActivity.this, "enter a value first", Toast.LENGTH_LONG).show();

            }
        });
        factorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(editText!=null)
                {
                    var1=Double.parseDouble(editText.getText()+"");
                    fact=true;
                    editText.setText(null);
                }
                else
                    Toast.makeText(MainActivity.this, "enter a value first", Toast.LENGTH_LONG).show();

            }
        });
        sinf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(editText!=null)
                {
                    var1=Double.parseDouble(editText.getText()+"");
                    sin=true;
                    editText.setText(null);
                }
                else
                    Toast.makeText(MainActivity.this, "enter a value first", Toast.LENGTH_LONG).show();

            }
        });
        cosf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(editText!=null)
                {
                    var1=Double.parseDouble(editText.getText()+"");
                    cos=true;
                    editText.setText(null);
                }
                else
                    Toast.makeText(MainActivity.this, "enter a value first", Toast.LENGTH_LONG).show();

            }
        });
        tanf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(editText!=null)
                {
                    var1=Double.parseDouble(editText.getText()+"");
                    tan=true;
                    editText.setText(null);
                }
                else
                    Toast.makeText(MainActivity.this, "enter a value first", Toast.LENGTH_LONG).show();

            }
        });
        percentage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(editText!=null)
                {
                    var1=Double.parseDouble(editText.getText()+"");
                    per=true;
                    editText.setText(null);
                }
                else
                    Toast.makeText(MainActivity.this, "enter a value first", Toast.LENGTH_LONG).show();
            }
        });
        addition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(editText!=null)
                {
                    var1=Double.parseDouble(editText.getText()+"");
                    add=true;
                    editText.setText(null);
                }
                else
                    Toast.makeText(MainActivity.this, "enter a value first", Toast.LENGTH_LONG).show();
            }
        });
        substraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(editText!=null)
                {
                    var1=Double.parseDouble(editText.getText()+"");
                    sub=true;
                    editText.setText(null);
                }
                else
                    Toast.makeText(MainActivity.this, "enter a value first", Toast.LENGTH_LONG).show();
            }
        });
        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(editText!=null)
                {
                    var1=Double.parseDouble(editText.getText()+"");
                    div=true;
                    editText.setText(null);
                }
                else
                    Toast.makeText(MainActivity.this, "enter a value first", Toast.LENGTH_LONG).show();
            }
        });
        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(editText!=null)
                {
                    var1=Double.parseDouble(editText.getText()+"");
                    mul=true;
                    editText.setText(null);
                }
                else
                    Toast.makeText(MainActivity.this, "enter a value first", Toast.LENGTH_LONG).show();
            }
        });
        power.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(editText!=null)
                {
                    var1=Double.parseDouble(editText.getText()+"");
                    pow=true;
                    editText.setText(null);
                }
                else
                    Toast.makeText(MainActivity.this, "enter a value first", Toast.LENGTH_LONG).show();
            }
        });
        equality.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // var2=Double.parseDouble(editText.getText()+"");
                if(add==true)
                {
                    var2=Double.parseDouble(editText.getText()+"");
                 var=var1+var2;
                 editText.setText(String.valueOf(var));
                 add=false;
                }
                if(sub==true)
                {
                    var2=Double.parseDouble(editText.getText()+"");
                    var=var1-var2;
                    editText.setText(String.valueOf(var));
                    sub=false;
                }
                if(mul==true)
                {
                    var2=Double.parseDouble(editText.getText()+"");
                    var=var1*var2;
                    editText.setText(String.valueOf(var));
                    mul=false;
                }
                if(div==true)
                {
                    var2=Double.parseDouble(editText.getText()+"");
                    var=var1/var2;
                    editText.setText(String.valueOf(var));
                    div=false;
                }
                if(pow==true)
                {
                    var2=Double.parseDouble(editText.getText()+"");
                    var=Math.pow(var1,var2);
                    editText.setText(String.valueOf(var));
                    pow=false;
                }
                if (sqrt==true)
                {
                    var=Math.sqrt(var1);
                    editText.setText(String.valueOf(var));
                    sqrt=false;
                }
                if (e==true)
                {
                    var=var1*2.7182818;
                    editText.setText(String.valueOf(var));
                    e=false;
                }
                if (sin==true)
                {
                    var=Math.sin(var1*0.0175);
                    editText.setText(String.valueOf(var));
                    sin=false;
                }
                if (cos==true)
                {
                    var=Math.cos(var1*0.0175);
                    editText.setText(String.valueOf(var));
                    cos=false;
                }
                if (tan==true)
                {
                    var=Math.tan(var1*0.0175);
                    editText.setText(String.valueOf(var));
                    tan=false;
                }

                if (fact==true)
                {
                    var=1;
                    for(int i=1;i<=var1;++i)
                    {
                        var*=i;
                    }
                    editText.setText(String.valueOf(var));
                    fact=false;
                }
                if (log==true)
                {
                    var=Math.log10(var1);
                    editText.setText(String.valueOf(var));
                    log=false;
                }
                if(per==true)
                {
                    var2=Double.parseDouble(editText.getText()+"");
                    var=var1%var2;
                    editText.setText(String.valueOf(var));
                    per=false;
                }
            }
        });
    }
}
