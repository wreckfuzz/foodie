package mobile.uni.natashawhitter.foodie.activities;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import mobile.uni.natashawhitter.foodie.R;
import mobile.uni.natashawhitter.foodie.utils.Utils;

public final class ForgotPasswordActivity extends BaseActivity
{
	private TextView passwordInfoTv;
	private TextInputLayout emailAddressTil;
	private Button submitBtn;
	private TextView backTv;
	
	private ProgressDialog dialog;
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_forgotpassword);
		
		passwordInfoTv = findViewById(R.id.activity_forgotpassword_information);
		emailAddressTil = findViewById(R.id.activity_forgotpassword_email);
		submitBtn = findViewById(R.id.activity_forgotpassword_submit);
		backTv = findViewById(R.id.activity_forgotpassword_back);
		
		submitBtn.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				// Check email is valid, then send reset email via FireBase
				if (Utils.isValidEmailAddress(emailAddressTil))
				{
				
				}
			}
		});
		
		backTv.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				// Back to Login Activity
				finish();
			}
		});
	}
}
