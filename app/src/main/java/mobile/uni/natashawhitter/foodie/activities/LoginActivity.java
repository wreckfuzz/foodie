package mobile.uni.natashawhitter.foodie.activities;

import android.app.ProgressDialog;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
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
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import mobile.uni.natashawhitter.foodie.R;
import mobile.uni.natashawhitter.foodie.db.FoodieDatabase;
import mobile.uni.natashawhitter.foodie.utils.SessionManager;
import mobile.uni.natashawhitter.foodie.utils.Utils;

public final class LoginActivity extends BaseActivity
{
	private TextInputLayout emailTil;
	private TextInputLayout passwordTil;
	private TextView forgotPasswordTv;
	private Button loginBtn;
	private TextView signUpTv;
	
	private ProgressDialog dialog;
	private FirebaseAuth mAuth;
	
	// Session Manager Class
	SessionManager session;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		
		emailTil = findViewById(R.id.activity_login_email);
		passwordTil = findViewById(R.id.activity_login_password);
		forgotPasswordTv = findViewById(R.id.activity_login_forgotpassword);
		loginBtn = findViewById(R.id.activity_login_login);
		signUpTv = findViewById(R.id.activity_login_signup);
		
		// Session Manager
		session = new SessionManager(getApplicationContext());
		
		dialog = new ProgressDialog(this);
		dialog.setMessage("Please Wait...");
		dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
		dialog.setIndeterminate(true);
		
		forgotPasswordTv.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				Intent intent = new Intent(LoginActivity.this, ForgotPasswordActivity.class);
				
				if (Utils.isValidEmailAddress(emailTil, false))
				{
					intent.putExtra("email", emailTil.getEditText().getText().toString());
				}
				
				startActivity(intent);
			}
		});
		
		loginBtn.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				
				if (Utils.checkLoginDetails(emailTil, passwordTil))
				{
					// Login user, display error message as toast or textview
					signIn();
				}
			}
		});
		
		signUpTv.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
				
				if (Utils.isValidEmailAddress(emailTil, false))
				{
					intent.putExtra("email", emailTil.getEditText().getText().toString());
				}
				
				startActivity(intent);
			}
		});
		
	}
	
	public void signIn()
	{
		dialog.show();
		final String email = emailTil.getEditText().getText().toString();
		final String password = passwordTil.getEditText().getText().toString();
		
		if (FoodieDatabase.getInstance(LoginActivity.this).getUserDao().checkUserExists(email, password))
		{
			dialog.dismiss();
			Toast.makeText(LoginActivity.this, "Hi", Toast.LENGTH_LONG).show();
		}
		dialog.dismiss();
		
		// session.createLoginSession();
	}
}
