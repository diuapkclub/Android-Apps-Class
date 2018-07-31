package com.diu.normalcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity {

    TextView tvExpression, tvResult;
    Button btnNine, btnEight, btnSeven,btnSix,btnFive,btnFour,btnThree,btnTwo,btnOne,btnZero,btnAdd,btnSub,btnMul,btnDiv,btnEqual,btnClear;

    boolean isPressed = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        initView();

        initListener();

    }

    public void initView(){
        setContentView(R.layout.activity_main);

        tvExpression = findViewById(R.id.tv_expression);
        tvResult = findViewById(R.id.tv_result);

        btnZero = findViewById(R.id.btn_zero);
        btnOne = findViewById(R.id.btn_one);
        btnTwo = findViewById(R.id.btn_two);
        btnThree = findViewById(R.id.btn_three);
        btnFour = findViewById(R.id.btn_four);
        btnFive = findViewById(R.id.btn_five);
        btnSix = findViewById(R.id.btn_six);
        btnSeven = findViewById(R.id.btn_seven);
        btnEight = findViewById(R.id.btn_eight);
        btnNine = findViewById(R.id.btn_nine);

        btnAdd = findViewById(R.id.btn_add);
        btnSub = findViewById(R.id.btn_sub);
        btnMul = findViewById(R.id.btn_mul);
        btnDiv = findViewById(R.id.btn_div);
        btnClear = findViewById(R.id.btn_clr);
        btnEqual = findViewById(R.id.btn_equal);
    }

    public void initListener(){
        btnZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvExpression.setText(tvExpression.getText()+"0");
                isPressed = false;
            }
        });

        btnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvExpression.setText(tvExpression.getText()+"1");
                isPressed = false;
            }
        });

        btnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvExpression.setText(tvExpression.getText()+"2");
                isPressed = false;
            }
        });

        btnThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvExpression.setText(tvExpression.getText()+"3");
                isPressed = false;
            }
        });

        btnFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvExpression.setText(tvExpression.getText()+"4");
                isPressed = false;
            }
        });

        btnFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvExpression.setText(tvExpression.getText()+"5");
                isPressed = false;
            }
        });

        btnSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvExpression.setText(tvExpression.getText()+"6");
                isPressed = false;
            }
        });

        btnSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvExpression.setText(tvExpression.getText()+"7");
                isPressed = false;
            }
        });

        btnEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvExpression.setText(tvExpression.getText()+"8");
                isPressed = false;
            }
        });

        btnNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvExpression.setText(tvExpression.getText()+"9");
                isPressed = false;
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(isPressed == false){
                    tvExpression.setText(tvExpression.getText()+"+");
                    isPressed = true;
                }

            }
        });

        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isPressed == false){
                    tvExpression.setText(tvExpression.getText()+"-");
                    isPressed = true;
                }
            }
        });

        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isPressed == false){
                    tvExpression.setText(tvExpression.getText()+"*");
                    isPressed = true;
                }
            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isPressed == false){
                    tvExpression.setText(tvExpression.getText()+"/");
                    isPressed = true;
                }
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                tvExpression.setText("");
                tvResult.setText("");
            }
        });

        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String expressionString = tvExpression.getText().toString();

                if (expressionString.endsWith("+") || expressionString.endsWith("-") || expressionString.endsWith("*") || expressionString.endsWith("/")){
                    tvResult.setText("Error");

                }
                else {
                    // Create an Expression (A class from exp4j library)
                    Expression expression = new ExpressionBuilder(expressionString).build();
                    try {
                        // Calculate the result and display
                        double result = expression.evaluate();
                        tvResult.setText(Double.toString(result));

                    } catch (ArithmeticException ex) {
                        // Display an error message
                        tvResult.setText("Error");

                    }
                }
            }
        });
    }
}
