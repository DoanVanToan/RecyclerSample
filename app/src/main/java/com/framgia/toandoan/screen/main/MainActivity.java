package com.framgia.toandoan.screen.main;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.framgia.toandoan.R;
import com.framgia.toandoan.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private MainConstract.ViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mViewModel = new MainViewModel(this);
        MainConstract.Presenter presenter = new MainPresenter();
        mViewModel.setPresenter(presenter);
        binding.setViewModel(mViewModel);
    }
}
