package com.oxionaz.projectn;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int guess;
    boolean gameFinished;

    TextView tvInfo;
    EditText etInput;
    Button bControl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvInfo = (TextView)findViewById(R.id.textView);
        etInput = (EditText)findViewById(R.id.editText);
        bControl = (Button)findViewById(R.id.button);

        guess = (int)(Math.random()*100);
        gameFinished = false;
    }

    public void onClick(View v){
        if (!gameFinished){
            if (!etInput.getText().toString().isEmpty()) {
                int inp = Integer.parseInt(etInput.getText().toString());
                if (inp > guess)
                    tvInfo.setText(getResources().getString(R.string.ahead));
                if (inp < guess)
                    tvInfo.setText(getResources().getString(R.string.behind));
                if (inp == guess) {
                    tvInfo.setText(getResources().getString(R.string.hit));
                    bControl.setText(getResources().getString(R.string.play_more));
                    gameFinished = true;
                }
            }
        }
        else
        {
            guess = (int)(Math.random()*100);
            bControl.setText(getResources().getString(R.string.input_value));
            tvInfo.setText(getResources().getString(R.string.try_to_guess));
            gameFinished = false;
        }
        etInput.setText("");
    }
}
