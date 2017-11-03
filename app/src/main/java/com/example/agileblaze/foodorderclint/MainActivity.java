package com.example.agileblaze.foodorderclint;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    private EditText email,password;
    private DatabaseReference mDatabase;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email=(EditText)findViewById(R.id.email);
        password=(EditText)findViewById(R.id.password);
        mAuth=FirebaseAuth.getInstance();
        mDatabase= FirebaseDatabase.getInstance().getReference().child("users");

    }


    public  void  signUp(View view)
    {
        final String email_text=email.getText().toString().trim();
        String password_text=password.getText().toString().trim();

        if(!TextUtils.isEmpty(email_text)&& !TextUtils.isEmpty(password_text))
        {
            mAuth.createUserWithEmailAndPassword(email_text,password_text).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful())
                    {
                        String user_id=mAuth.getCurrentUser().getUid();
                        DatabaseReference current_user=mDatabase.child(user_id);
                        current_user.child("name").setValue(email_text);
                    }
                }
            });
        }
    }


    public void signIn(View view)
    {
        Intent intent=new Intent(MainActivity.this,LoginActivity.class);
        startActivity(intent);
    }
}
