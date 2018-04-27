package mobile.uni.natashawhitter.foodie.activities;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import mobile.uni.natashawhitter.foodie.R;

public final class SignUpActivity extends BaseActivity
{
	private TextInputLayout emailTil;
	private TextInputLayout passwordTil;
	private TextView termsAndPrivacyPolicyTv;
	private Button signUpBtn;
	private TextView backTv;
	
	private ProgressDialog dialog;
	private FirebaseAuth mAuth;
	
	@Override
	public void onStart()
	{
		super.onStart();
		// Check if user is signed in (non-null) and update UI accordingly.
		if (mAuth == null)
		{
			mAuth = FirebaseAuth.getInstance();
		}
		FirebaseUser currentUser = mAuth.getCurrentUser();
		//updateUI(currentUser);
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_registration);
		
		mAuth = FirebaseAuth.getInstance();
		
		emailTil = findViewById(R.id.activity_registration_email);
		passwordTil = findViewById(R.id.activity_registration_password);
		termsAndPrivacyPolicyTv = findViewById(R.id.activity_registration_information);
		signUpBtn = findViewById(R.id.activity_registration_signup);
		backTv = findViewById(R.id.activity_registration_back);
		
		dialog = new ProgressDialog(this);
		dialog.setIndeterminate(true);
		dialog.setMessage("Registering...");
		
		signUpBtn.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				// Sign up
				createAccount();
			}
		});
		
		backTv.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				finish();
			}
		});
	}
	
	public void createAccount()
	{
		dialog.show();
		final String email = emailTil.getEditText().getText().toString();
		final String password = passwordTil.getEditText().getText().toString();
		
		mAuth.createUserWithEmailAndPassword(email, password)
				.addOnCompleteListener(this, new OnCompleteListener<AuthResult>()
				{
					@Override
					public void onComplete(@NonNull Task<AuthResult> task)
					{
						dialog.dismiss();
						if (task.isSuccessful())
						{
							// Sign up success
							Toast.makeText(SignUpActivity.this, "Account Successfully Created", Toast.LENGTH_LONG).show();
							finish();
						} else
						{
							// If sign in fails, display a message
							Toast.makeText(SignUpActivity.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
						}
					}
				});
	}
}
