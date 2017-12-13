package com.example.user.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

//Creating class by extending AppCompatActivity and implementing OnClickListener.
public class MainActivity extends AppCompatActivity implements View.OnClickListener
{

    Button saveBtn,checkBtn;      //Creating references for buttons.

    @Override
    //onCreate method.
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);   //Setting content view.

        //Setting Buttons with their IDs.
        saveBtn=(Button)findViewById(R.id.save);
        checkBtn=(Button)findViewById(R.id.check);

        //Setting OnClick listener.
        saveBtn.setOnClickListener(this);
        checkBtn.setOnClickListener(this);
    }

    @Override
    //Method to handle onClick event.
    public void onClick(View v)
    {
        //if SAVE is clicked.
        if(v.getId()==R.id.save)
        {
            //try and catch blocks.
            try
            {
                //opening file by FileOutputStream.
                FileOutputStream fileOut=openFileOutput("myAndroidFile",MODE_PRIVATE);

                //OutputStreamWriter to write in the file.
                OutputStreamWriter outputStreamWriter=new OutputStreamWriter(fileOut);

                //Writing in file.
                outputStreamWriter.write("Hi!! I am writing file.");

                //closing OutpuutStreamWriter.
                outputStreamWriter.close();

                //Displaying Toast.
                Toast.makeText(getApplicationContext(),"File Saved",Toast.LENGTH_SHORT).show();

            }
            catch (FileNotFoundException e)
            {
                e.printStackTrace();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        else if(v.getId()==R.id.check)
        {
            try
            {
                //Checking by opening the file.
                FileInputStream fileInputStream=openFileInput("myAndroidFile");

                //Displaying Toast.
                Toast.makeText(getApplicationContext(),"File is there in Internal Storage",Toast.LENGTH_SHORT).show();
            }
            catch (FileNotFoundException e)
            {
                //Displaying Toast.
                Toast.makeText(getApplicationContext(),"File is not there in Internal Storage",Toast.LENGTH_SHORT).show();
            }
        }
    }
}   //End of MainActivity.
