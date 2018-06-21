package com.lzk.customviewtest2;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CustomTextView textView=this.findViewById(R.id.custom_text_view);
        textView.setLineColor(Color.WHITE);
        textView.setLineWidth(10);
        /*自定义控件的自定义点击事件*/
        textView.setOnViewClickListener(new CustomTextView.OnViewClickListener() {
            @Override
            public void OnViewClick() {
                Toast.makeText(MainActivity.this,"点击了",Toast.LENGTH_LONG).show();
            }
        });
    }


}
