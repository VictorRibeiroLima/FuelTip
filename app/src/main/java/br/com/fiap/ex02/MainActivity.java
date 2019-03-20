package br.com.fiap.ex02;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private SeekBar gasSeekBar;
    private SeekBar etSeekBar;
    private TextInputLayout titleTextInput;
    private EditText resultEditText;
    private ImageView imageView;
    private int gas;
    private int et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gasSeekBar = findViewById(R.id.gasSeekBar);
        etSeekBar = findViewById(R.id.etSeekBar);
        resultEditText = findViewById(R.id.resultEditText);
        imageView =(ImageView) findViewById(R.id.image);
        gas=gasSeekBar.getProgress();
        et=etSeekBar.getProgress();
        calculation(gas,et);
        gasSeekBar.setOnSeekBarChangeListener(new gasSeekWatcher());
        etSeekBar.setOnSeekBarChangeListener(new etSeekWatcher());
    }
    private class gasSeekWatcher implements SeekBar.OnSeekBarChangeListener{
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            gas = progress;
            calculation(progress,et);
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    }
    private class etSeekWatcher implements SeekBar.OnSeekBarChangeListener{
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            et = progress;
            calculation(gas,progress);
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    }
    public void calculation(int gas,int et){
        if(gas<=0){
            gas = 1;
        }
        if(et<=0){
            et =1;
        }
        float result = et/(float)gas;
        if(result>0.7){
            resultEditText.setText(R.string.gas);
            imageView.setImageResource(R.drawable.gas);
            imageView.setContentDescription(String.valueOf(R.string.gasDesc));
        }else{
            resultEditText.setText(R.string.et);
            imageView.setImageResource(R.drawable.et);
            imageView.setContentDescription(String.valueOf(R.string.etDesc));
        }
    }
}
