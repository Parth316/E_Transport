package com.example.e_transport.Activity.Admin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.e_transport.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class AdminLogin extends AppCompatActivity {
    EditText userName,password;
    Button login;
    private FirebaseAuth mAuth;
    private EditText edtPhone, edtOTP;
    private Button verifyOTPBtn, generateOTPBtn;

    private String verificationId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login1);

        edtPhone = findViewById(R.id.idEdtPhoneNumber);
        edtOTP = findViewById(R.id.idEdtOtp);
        verifyOTPBtn = findViewById(R.id.idBtnVerify);
        generateOTPBtn = findViewById(R.id.idBtnGetOtp);
        getSupportActionBar().hide();
        mAuth = FirebaseAuth.getInstance();

        // setting onclick listener for generate OTP button.
                generateOTPBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // below line is for checking weather the user
                        // has entered his mobile number or not.
                        if (TextUtils.isEmpty(edtPhone.getText().toString())) {
                            // when mobile number text field is empty
                            // displaying a toast message.
                            Toast.makeText(AdminLogin.this, "Please enter a valid phone number.", Toast.LENGTH_SHORT).show();
                        } else {
                            // if the text field is not empty we are calling our
                            // send OTP method for getting OTP from Firebase.
                            String phone = "+91" + edtPhone.getText().toString();
                            sendVerificationCode(phone);
                        }
                    }
                });

                // initializing on click listener
                // for verify otp button
                verifyOTPBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // validating if the OTP text field is empty or not.
                        if (TextUtils.isEmpty(edtOTP.getText().toString())) {
                            // if the OTP text field is empty display
                            // a message to user to enter OTP
                            Toast.makeText(AdminLogin.this, "Please enter OTP", Toast.LENGTH_SHORT).show();
                        } else {
                            // if OTP field is not empty calling
                            // method to verify the OTP.
                            verifyCode(edtOTP.getText().toString());
                        }
                    }
                });
            }

            private void signInWithCredential(PhoneAuthCredential credential) {
                // inside this method we are checking if
                // the code entered is correct or not.
                mAuth.signInWithCredential(credential)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // if the code is correct and the task is successful
                                    // we are sending our user to new activity.
                                    Intent i = new Intent(AdminLogin.this, AdminPanel.class);
                                    startActivity(i);
                                    finish();
                                } else {
                                    // if the code is not correct then we are
                                    // displaying an error message to the user.
                                    Toast.makeText(AdminLogin.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                                }
                            }
                        });
            }


            private void sendVerificationCode(String number) {
                // this method is used for getting
                // OTP on user phone number.
                PhoneAuthOptions options =
                        PhoneAuthOptions.newBuilder(mAuth)
                                .setPhoneNumber(number)		 // Phone number to verify
                                .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
                                .setActivity(this)				 // Activity (for callback binding)
                                .setCallbacks(mCallBack)		 // OnVerificationStateChangedCallbacks
                                .build();
                PhoneAuthProvider.verifyPhoneNumber(options);
            }

            // callback method is called on Phone auth provider.
            private final PhoneAuthProvider.OnVerificationStateChangedCallbacks

                    // initializing our callbacks for on
                    // verification callback method.
                    mCallBack = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

                // below method is used when
                // OTP is sent from Firebase
                @Override
                public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                    super.onCodeSent(s, forceResendingToken);
                    // when we receive the OTP it
                    // contains a unique id which
                    // we are storing in our string
                    // which we have already created.
                    verificationId = s;
                }

                // this method is called when user
                // receive OTP from Firebase.
                @Override
                public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
                    // below line is used for getting OTP code
                    // which is sent in phone auth credentials.
                    final String code = phoneAuthCredential.getSmsCode();

                    // checking if the code
                    // is null or not.
                    if (code != null) {
                        // if the code is not null then
                        // we are setting that code to
                        // our OTP edittext field.
                        edtOTP.setText(code);

                        // after setting this code
                        // to OTP edittext field we
                        // are calling our verifycode method.
                        verifyCode(code);
                    }
                }

                @Override
                public void onVerificationFailed(FirebaseException e) {
                    // displaying error message with firebase exception.
                    Toast.makeText(AdminLogin.this, e.getMessage(), Toast.LENGTH_LONG).show();
                }
            };

            // below method is use to verify code from Firebase.
            private void verifyCode(String code) {
                // below line is used for getting getting
                // credentials from our verification id and code.
                PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verificationId, code);

                // after getting credential we are
                // calling sign in method.
                signInWithCredential(credential);
            }
        }
