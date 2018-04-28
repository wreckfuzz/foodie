package mobile.uni.natashawhitter.foodie.activities;

import android.app.ProgressDialog;
import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.commonsware.cwac.saferoom.SafeHelperFactory;

import mobile.uni.natashawhitter.foodie.R;
import mobile.uni.natashawhitter.foodie.db.FoodieDatabase;
import mobile.uni.natashawhitter.foodie.utils.Utils;

public final class SignUpActivity extends BaseActivity
{
	private TextInputLayout emailTil;
	private TextInputLayout passwordTil;
	private TextView termsAndPrivacyPolicyTv;
	private Button signUpBtn;
	private TextView backTv;
	
	private ProgressDialog dialog;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_registration);
		
		//mAuth = FirebaseAuth.getInstance();
		
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
		
//		SafeHelperFactory factoryEmail = SafeHelperFactory.fromUser(emailTil.getEditText().getText());
//		SafeHelperFactory factoryPassword = SafeHelperFactory.fromUser(passwordTil.getEditText().getText());
//		FoodieDatabase.getInstance(SignUpActivity.this);
		
		FoodieDatabase.getInstance(SignUpActivity.this);
		
		//db.getUserDao();
	}
}
