package com.lzk.customviewtest2;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*CustomTextView*/
        CustomTextView textView=this.findViewById(R.id.custom_text_view);
        textView.setLineColor(Color.BLUE);
        textView.setLineWidth(8);
        /*自定义控件的自定义点击事件*/
        textView.setOnViewClickListener(new CustomTextView.OnViewClickListener() {
            @Override
            public void OnViewClick() {
                Toast.makeText(MainActivity.this,"点击了",Toast.LENGTH_LONG).show();
            }
        });

        /*CustomViewGroup*/
        final CustomViewGroupTest1 customViewGroupTest1=findViewById(R.id.custom_view_group_title);
        customViewGroupTest1.setTitleClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"点击Title:"+customViewGroupTest1.getTitle(),Toast.LENGTH_LONG).show();
            }
        });

        customViewGroupTest1.setTitleBackgroundColor(Color.YELLOW);
        customViewGroupTest1.setTitleTextColor(Color.RED);

        CustomView customView=findViewById(R.id.custom_view);
        customView.setCustomViewClickListener(new CustomView.OnCustomViewClickListener() {
            @Override
            public void onCustomViewClicked() {
                Toast.makeText(MainActivity.this,"点击了继承自View的自定义View",Toast.LENGTH_LONG).show();
            }
        });
        customView.setCustomBackgroundColor(Color.GREEN);
    }


}
