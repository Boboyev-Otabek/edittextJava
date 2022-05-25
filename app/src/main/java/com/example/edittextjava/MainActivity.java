package com.example.edittextjava;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edittext;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    void initView() {
        edittext = findViewById(R.id.edittext);
        textView = findViewById(R.id.text);

        edittext.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                Toast.makeText(getApplicationContext(),editable,Toast.LENGTH_SHORT).show();
                if(editable.length()<8){
                    textView.setText("Belgilar soni 8 ta dan ko'p bo'lishi kerak");
                    textView.setTextColor(Color.RED);
                }else{
                    textView.setText("Raxmat");
                    textView.setTextColor(Color.GREEN);
                }
            }
        });
        edittext.setOnKeyListener(new mykeylister());


    }
    class mykeylister implements View.OnKeyListener{

        @Override
        public boolean onKey(View view, int keycode, KeyEvent keyEvent) {
            if(keyEvent.getAction()==KeyEvent.ACTION_DOWN && keycode==KeyEvent.KEYCODE_ENTER){
                Toast.makeText(MainActivity.this,edittext.getText(),Toast.LENGTH_SHORT).show();
            textView.setText("Assalom "+edittext.getText());
            return true;
            }
            return false;
        }
    }
}