package com.imagination.tong.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Tong on 8/25/2017.
 */
public class MatrixActivity extends Activity {
    private Button addButton,mulityButton,determentButton,sumButton,produceButton,dButton;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matrix);

        addButton=(Button)findViewById(R.id.add_button);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.activity_matrix_addition);
            }
        });

        mulityButton=(Button)findViewById(R.id.multiply_button);
        mulityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.activity_matrix_multiplcation);
            }
        });

        determentButton=(Button)findViewById(R.id.determent_button);
        determentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.activity_materix_determent);
            }
        });

        sumButton=(Button)findViewById(R.id.sum_button);

        produceButton=(Button)findViewById(R.id.produce_button);




    }


}

