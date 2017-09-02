package com.imagination.tong.calculator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Stack;

/**
 * Created by Tong on 8/25/2017.
 */
public class EquationActivity extends Activity {
    Button equationButton;
    EditText context;
    TextView answer;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equaction);
        equationButton=(Button)findViewById(R.id.equation_button);

        context=(EditText)findViewById(R.id.equation_text);
        equationButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String s=context.getText().toString();
               String postFix=postfix(s);
               String sum=result(postFix)+"";
                answer=(TextView)findViewById(R.id.answer);
                answer.setText("PostFix:    "+postFix+" \nResult:    "+sum);

            }
        });
    }

    public static String postfix(String str){
        Stack<Object> stack=new Stack<Object>();
        String openPren="";
        String postFix="";
        for(int i=0;i<str.length();i++){
            int a=i;
            if((str.charAt(i)>='0'&&str.charAt(i)<='9')){
                postFix+=str.charAt(a);

            }
            else if(str.charAt(i)=='('){
                stack.push(str.charAt(i));
            }
            else if(str.charAt(i)==')'){
                while(!stack.isEmpty()&&!(stack.lastElement().equals('('))){
                    postFix+=" "+stack.pop();
                }
                openPren+=stack.pop();
            }
            else if(str.charAt(i)=='+'||str.charAt(i)=='-'||str.charAt(i)=='*'||
                    str.charAt(i)=='/'||str.charAt(i)=='%'){

                if(!stack.isEmpty()&&(!stack.peek().equals('('))){
                    if((str.charAt(i)=='+'||str.charAt(i)=='-')
                            &&(!stack.peek().equals('*')
                            &&!stack.peek().equals('/'))){
                        postFix+=" "+stack.pop();
                    }
                    else if((str.charAt(i)=='+'||str.charAt(i)=='-')
                            &&((stack.peek().equals('*')
                            ||stack.peek().equals('/')))){
                        postFix+=" "+stack.pop();
                    }
                    else if(((str.charAt(i)=='*'||str.charAt(i)=='/')||str.charAt(i)=='%')&&
                            (stack.peek().equals('*')||stack.peek().equals('/')||stack.peek().equals('%'))){
                        postFix+=" "+stack.pop();
                    }
                }
                postFix+=" ";
                stack.push(str.charAt(i));
            }

        }

        while(!stack.isEmpty()){
            postFix+=" "+stack.pop();
        }


        return postFix;
    }

    public static Double result(String str){
        double result=0;
        int index=0;
        char c;
        StringBuilder strB=new StringBuilder(str);
        Stack<Double> list=new Stack<Double>();

        while(strB.length()>0){
            double a=0,x=0, b=0;
            index=0;
            while(strB.charAt(index)!=' '&&strB.charAt(index)>='0'&&strB.charAt(index)<='9'){
                x=(x*10)+strB.charAt(index)-'0';
                index++;
            }
            list.push(x);
            strB.delete(0, index+1);
            index=0;
            while(strB.length()>0&&(strB.charAt(index)=='+'||strB.charAt(index)=='-'||strB.charAt(index)=='*'
                    ||strB.charAt(index)=='/'||strB.charAt(index)=='%')){
                c=strB.charAt(index);
                strB.deleteCharAt(index);
                if(strB.length()>0){
                    strB.deleteCharAt(index);
                }
                b=list.pop();
                a=list.pop();
                switch(c){
                    case '+':
                        result=a+b;
                        break;
                    case '-':
                        result=a-b;
                        break;
                    case '*':
                        result=a*b;
                        break;
                    case '/':
                        result=a/(double)b;
                    case '%':
                        result=a/b;
                }
                list.push(result);
            }

        }
        return list.pop();
    }

}
