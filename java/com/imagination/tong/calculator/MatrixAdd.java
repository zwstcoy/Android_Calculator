package com.imagination.tong.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Tong on 10/5/2017.
 */
public class MatrixAdd extends Activity {
    Button sumButton;
    EditText addMatrix1,addMatrix2;
    readMatrix readM=new readMatrix();
    TextView answer;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matrix_addition);

        addMatrix1=(EditText)findViewById(R.id.add_matrix1);
        addMatrix2=(EditText)findViewById(R.id.add_matrix2);
        answer=(TextView)findViewById(R.id.sum_answer);

        sumButton=(Button)findViewById(R.id.find_s_button);
        sumButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<Object> matrix1=new ArrayList<Object>();
                ArrayList<Object> matrix2=new ArrayList<Object>();
                ArrayList<Object> sum=new ArrayList<Object>();
                String matrixString1=addMatrix1.getText().toString();
                String matrixString2=addMatrix2.getText().toString();
                matrix1=readM.readNum(matrixString1);
                matrix2=readM.readNum(matrixString2);
                sum=addMatrix(matrix1,matrix2);
                String resule="";
                for(int i=0;i<sum.size();i++){
                    if(sum.get(i)==","){
                        resule+="\n";
                    }
                    else{
                        resule+=sum.get(i)+"  ";
                    }
                }
                answer.setText(resule);

            }
        });

    }


    public ArrayList<Object> addMatrix(ArrayList<Object> list1, ArrayList<Object> list2){
        ArrayList<Object> list3=new ArrayList<Object>();
        for(int i=0;i<list1.size()&&i<list2.size();i++){
            if(list1.get(i)!=","&&list2.get(i)!=","){
                list3.add(((double)list1.get(i)+(double)list2.get(i)));
            }
            else{
                list3.add(",");
            }
        }

        return list3;
    }


}
