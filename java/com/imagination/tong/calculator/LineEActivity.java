package com.imagination.tong.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Tong on 8/25/2017.
 */
public class LineEActivity extends Activity {
    Button lineButton;
    EditText lineVector,linePoint;
    TextView answer;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_line_equation);

        lineButton=(Button)findViewById(R.id.find_line_button);
        linePoint=(EditText)findViewById(R.id.line_point);
        lineVector=(EditText)findViewById(R.id.line_vector);
        answer=(TextView)findViewById(R.id.line_answer);

        lineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String point=linePoint.getText().toString();
                String vector=lineVector.getText().toString();
                String str="Your Miss one";
                if(point!=""&&vector!="") {
                    str = lineEq(conver(point), conver(vector));
                }
                answer.setText(str);

            }
        });
    }

    public Point conver(String str){
        double a=0,b=0,c=0;
        int i=0,k=10;
        double n=1;
        while(str.charAt(i)!=' '&&i<str.length()) {
            if(str.charAt(i)=='.'){
                n=.1;
                k=1;
            }
            a = a * k + (n*str.charAt(i++)-'0');

        }
        n=1;
        k=10;
        i++;
        while(str.charAt(i)!=' '&&i<str.length()){
            if(str.charAt(i)=='.'){
                n=.1;
                k=1;
            }
            b=b*(k)+(str.charAt(i++)-'0')*n;

        }
        i++;
        n=1;
        k=10;
        while(i<str.length()){
            if(str.charAt(i)=='.'){
                n=.1;
                k=1;
            }
            c=c*k+(n*str.charAt(i++)-'0');


        }
        double list[]={a,b,c};
        Point point =new Point(list);
        return point;
    }
    public String lineEq(Point point,Point vector){
                 return "X="+point.x+"+"+vector.x+"t\n"+
                        "Y="+point.y+"+"+vector.y+"t\n"+
                        "Z="+point.z+"+"+vector.z+"t";
    }

}
class Point{
    double x,y,z;
    public Point(double list[]){
        this.x=list[0];
        this.y=list[1];
        this.z=list[2];
    }
    public String toString(){
        return "("+x+", "+y+", "+z+")";
    }
}