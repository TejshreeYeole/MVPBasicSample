package com.android.mvpsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements MainInterface.MainView, View.OnClickListener, TextWatcher {

    private TextView tv_updatedVal;
    private Button btnUpdate;
    private MainInterface.MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        tv_updatedVal= (TextView) findViewById(R.id.tv_updatedval);
        btnUpdate= (Button) findViewById(R.id.btn_updatevalue);
        btnUpdate.setOnClickListener(this);

        mainPresenter=new MainPresenterImpl(this);
        tv_updatedVal.addTextChangedListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_updatevalue:
                mainPresenter.clicked();
                break;
        }
    }

    @Override
    public void clickedAction(Model model) {
        tv_updatedVal.setText(model.getName());
    }

    @Override
    public void showToast(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        mainPresenter.textHasChanged(charSequence.toString());

    }

    @Override
    public void afterTextChanged(Editable editable) {

    }
}
