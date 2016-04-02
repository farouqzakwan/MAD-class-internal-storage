package com.farouq.march29;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {

    private String data;
    private EditText editText;
    private String file = "mydata";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText)findViewById(R.id.editText);
    }

    public void save(View view){
        data = editText.getText().toString();
        try{
            FileOutputStream fout = openFileOutput(file,MODE_WORLD_READABLE);
            fout.write(data.getBytes());
            fout.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void load(View view){
        try{
            FileInputStream fin = openFileInput(file);
            int c;
            String temp = "";

            while((c=fin.read()) != -1){
                    temp = temp + Character.toString((char)c);
            }
            editText.setText(temp);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
