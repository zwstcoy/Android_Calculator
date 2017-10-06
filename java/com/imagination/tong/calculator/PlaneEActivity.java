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
public class PlaneEActivity extends Activity {
    Button plantButton;
    TextView answer;
    EditText plantPoint,plantVector;
    LineEActivity lineActivity=new LineEActivity();


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plane_equation);

        plantButton=(Button)findViewById(R.id.find_plant_button);
        plantPoint=(EditText)findViewById(R.id.plane_point);
        plantVector=(EditText)findViewById(R.id.plane_vector);
        answer=(TextView)findViewById(R.id.plane_answer);

        plantButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String point=plantPoint.getText().toString();
                String vector=plantVector.getText().toString();
                String str="Your Miss one";
                if(point!=""&&vector!="") {
                    Plane plane=new Plane(lineActivity.conver(point),lineActivity.conver(vector));
                    str=plane.toString();
                }
                answer.setText(str);
            }
        });

    }
}
class Plane {
    double sum;
    Point norVector, point;

    public Plane(Point norVector, Point point) {
        this.norVector = norVector;
        this.point = point;
        sum = (norVector.x * -point.x) + (norVector.y * -point.y) + (norVector.z * -point.z);
    }

    public String toString() {

        return norVector.x + "(X+" + -point.x + ")+" + norVector.y + "(Y+" + -point.y + ")+" + norVector.z + "(Z+" + -point.z + ")=0\n\n" +
                norVector.x + "X+" + norVector.y + "Y+" + norVector.z + "Z=" + (float)sum;
    }
}
