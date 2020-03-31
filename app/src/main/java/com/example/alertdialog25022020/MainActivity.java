package com.example.alertdialog25022020;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button mBtnAlert;
    int index = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnAlert = findViewById(R.id.buttonAlert);

        mBtnAlert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Thông báo mới");
                builder.setMessage("Bạn vừa nhận tin nhắn mới");
                builder.setIcon(R.mipmap.ic_launcher);
                builder.setCancelable(false);


                    final String[] arrayAnimals = {"Mèo","Chó","Heo","Gà","Voi","Ngựa"};
                    // Single choice
                builder.setSingleChoiceItems(arrayAnimals, -1, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Toast.makeText(MainActivity.this, "Có", Toast.LENGTH_SHORT).show();
                            dialogInterface.dismiss();
                            index = i;
                        }
                    });
                    //Button từ chối
                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                        builder.setPositiveButton("Chọn", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(MainActivity.this, "Không", Toast.LENGTH_SHORT).show();
                                Toast.makeText(MainActivity.this, arrayAnimals[index] , Toast.LENGTH_SHORT).show();
                            }
                        });
                        // Multiple choice

                        //Button hủy
                        builder.setNeutralButton("Hủy", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(MainActivity.this, "Hủy", Toast.LENGTH_SHORT).show();
                            }
                        });


                builder.show();
            }
        });
    }
}
