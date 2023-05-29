package com.example.myloginrotation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

public class MainActivity extends AppCompatActivity {

    private EditText userNameEditText;
    private EditText passWordEditText;
    private AppCompatButton login;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userNameEditText = findViewById(R.id.user_name);
        passWordEditText = findViewById(R.id.password);
        login = findViewById(R.id.button);


        //create a listener for the submit order Button
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginMethod();
            }
        });
        userNameEditText = (EditText) findViewById(R.id.user_name);
        passWordEditText = (EditText) findViewById(R.id.password);
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.viewContainer);


        YoYo.with(Techniques.RotateInDownRight)
                .duration(1400)
                .repeat(0)
                .playOn(findViewById(R.id.informationText));
        YoYo.with(Techniques.FlipInY)
                .duration(1400)
                .repeat(0)
                .playOn(findViewById(R.id.viewContainer));

        //creates and Animation object called animation
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fadetext);
        userNameEditText.startAnimation(animation);
        //creates and Animation object called animation1
        Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fadetext);
        passWordEditText.startAnimation(animation1);

        //non focus of EditText views
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);


    }

    //Login Validation
    private boolean loginMethod() {

        fieldsValidation();


//        Toast.makeText(this, "checking 1st validation", Toast.LENGTH_SHO RT).show();
        if (fieldsValidation() == true) {

            EditText nameDetails = (EditText) findViewById(R.id.user_name);
            String name = nameDetails.getText().toString();

            //gets address text from input on the EditText Field
            EditText passwordDetails = (EditText) findViewById(R.id.password);
            String password = passwordDetails.getText().toString();


        }
        public boolean fieldsValidation() {
            if (TextUtils.isEmpty(userNameEditText.getText().toString().trim())
                    || TextUtils.isEmpty(passWordEditText.getText().toString().trim()))


//            Toast.makeText(this, "Checking EditText Validation", Toast.LENGTH_SHORT).show();

            {
                userNameEditText.setError("Please fill in the username");
                passWordEditText.setError("Please fill in your password");


            }
            return false;
        }


    }
}

