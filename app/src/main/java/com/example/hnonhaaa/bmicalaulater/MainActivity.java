package com.example.hnonhaaa.bmicalaulater;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText height ;
    private EditText weight ;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        height = (EditText) findViewById(R.id.height_edit_text) ;
        weight = (EditText) findViewById(R.id.weight_edit_text) ;
        button = (Button)findViewById(R.id.buttonn);

        MyListener myListener1 = new MyListener(); // create object for setOnclick button
        //MainActivity myListener2 = new MainActivity() ;   OR this     //Soln two Use mine
       // button.setOnClickListener(this);  // set ให้เวลาคลิกแล้ว ให้ทำในคลาสของออปเจ็ค //บรรทัดนี้เป็นการต่อจิ๊กซอ
        button.setOnClickListener(new View.OnClickListener() { //Soln three แบบประกาศทางเข้าเลย
            @Override
            public void onClick(View v) {
                String heightText =height.getText().toString() ;
                Double hetghtt = Double.valueOf(heightText) ;
                Double weightt = Double.valueOf(weight.getText().toString()) ;
                Double bmi = weightt / ((hetghtt/100)*(hetghtt/100)) ; // height/100  เพรา เอาเอาหน่วย'เมตร'
               // String box = "ค่า BMI ที่ได้คือ "+String.valueOf(bmi) ;

                String bmiText = getBmiText(bmi) ;
                String box = String.format("ค่า BMI ที่ได้คือ %.3f\n\n อยู่ในเกณท์ : %s",bmi , bmiText);
                //box +="\n\n อยู่ในเกณท์ : "+ bmiText ;
                /*AlertDialog.Builder dialog = new  AlertDialog.Builder(MainActivity.this) ;
                dialog.setTitle("YOUR BMI");
                dialog.setMessage(box) ;
                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //finish() ;  // เมื่อกดปุ่ม ok  บน dialog  จะทำการปิดโปรแกรม เพราะ คำสั่งนี้
                        height.setText("");
                        weight.setText("");
                        height.requestFocus() ; // เพื่อให้มันโฟกัส พร้อมกรอกใหม่ได้ทันที ที่กดปุ่ม OK
                    }
                });
                dialog.show() ;*/
                Intent intent = new Intent(MainActivity.this , Main2Activity.class) ;   // การ ลิ้ง ไปหน้าต่อไป อย่าลืม หน้าต่อไปที่จะไป ต้องมี .class
                intent.putExtra("bmi_values" , bmi);            // sand values to page 2
                intent.putExtra("bmi_text" , bmiText) ;         // sand values to page 2
                startActivity(intent); // start
            }
        });
    }

    @Override
    public void onClick(View v) {
        Toast t = Toast.makeText(MainActivity.this , "Hello" , Toast.LENGTH_SHORT);
        t.show();
    }

    //soln one OnClick แยกคลาส
    private class MyListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            Toast t = Toast.makeText(MainActivity.this , "Hello" , Toast.LENGTH_SHORT);
            t.show();
        }
        // code will run then click
    }

    private String getBmiText(Double bmi){
        String bmiText =null ;
        if(bmi<18.5){
            bmiText = "น้ำหนัก น้อยกว่าแกติ" ;
        }else if(bmi<25){
            bmiText = "หุ่นดีนะเราเนี่ยยยยยย" ;
        }else if(bmi<30){
            bmiText = "อวบๆ กำลังดีเลยยย" ;
        }else{
            bmiText = "E'อ้วนนนนนนนนนนนน!!!!";
        }
        return bmiText ;
    }
}
