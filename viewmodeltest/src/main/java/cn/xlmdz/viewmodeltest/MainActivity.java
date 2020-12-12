package cn.xlmdz.viewmodeltest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private MyViewModel myViewModel;
    private TextView mTextView;
    private Button mButton1, mButton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myViewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(MyViewModel.class);

        initView();
    }

    private void initView() {
        mTextView = findViewById(R.id.textView);
        mTextView.setText(String.valueOf(myViewModel.number));

        mButton1 = findViewById(R.id.button1);
        mButton2 = findViewById(R.id.button2);

        mButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myViewModel.number++;
                mTextView.setText(String.valueOf(myViewModel.number));
            }
        });

        mButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myViewModel.number += 2;
                mTextView.setText(String.valueOf(myViewModel.number));
            }
        });
    }
}