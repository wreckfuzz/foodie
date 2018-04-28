package mobile.uni.natashawhitter.foodie.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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
		session.verifyLoggedIn();
		
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
		
//		SafeHelperFactory factory = SafeHelperFactory.fromUser(emailTil.getEditText().getText());
//		FoodieDatabase db = Room.databaseBuilder(LoginActivity.this, FoodieDatabase.class, Utils.DB_NAME)
//				.openHelperFactory(factory)
//				.build();
		
		if (FoodieDatabase.getInstance(LoginActivity.this).getUserDao().checkUserExists(email, password))
		{
			long userId = FoodieDatabase.getInstance(LoginActivity.this).getUserDao().getUserIdByEmailAndPassword(email, password);
			if (session.createLoginSession(userId))
			{
				session.verifyLoggedIn();
				dialog.dismiss();
			}
			Toast.makeText(this, "Error Logging You In", Toast.LENGTH_LONG).show();
			dialog.dismiss();
		}
		Toast.makeText(this, "Email Or Password Is Incorrect", Toast.LENGTH_LONG).show();
		dialog.dismiss();
	}
}
