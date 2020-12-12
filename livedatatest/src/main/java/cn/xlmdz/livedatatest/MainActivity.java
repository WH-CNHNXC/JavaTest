package cn.xlmdz.livedatatest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private LiveDataViewModel mViewModel;
    private TextView mTextView;
    private ImageButton mIbThumbUp, mIbThumbDown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        mViewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(LiveDataViewModel.class);

        mViewModel.getLikedNumber().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                mTextView.setText(String.valueOf(integer));
            }
        });
        mIbThumbUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewModel.addLikedNumber(1);
            }
        });
        mIbThumbDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewModel.addLikedNumber(-1);
            }
        });
    }

    private void initView() {
        mTextView = findViewById(R.id.tv_text);
        mIbThumbUp = findViewById(R.id.ib_thumb_up);
        mIbThumbDown = findViewById(R.id.ib_thumb_down);
    }
}