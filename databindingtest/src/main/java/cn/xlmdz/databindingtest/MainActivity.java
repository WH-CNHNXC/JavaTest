package cn.xlmdz.databindingtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import cn.xlmdz.databindingtest.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private DataBindingViewModel mViewModel;
    private ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        mViewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(DataBindingViewModel.class);
        mBinding.setModel(mViewModel);
        mBinding.setLifecycleOwner(this);
    }
}