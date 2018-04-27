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
import com.google.firebase.auth.FirebaseAuth;

import mobile.uni.natashawhitter.foodie.R;
import mobile.uni.natashawhitter.foodie.utils.Utils;

public final class ForgotPasswordActivity extends BaseActivity
{
	private TextView passwordInfoTv;
	private TextInputLayout emailAddressTil;
	private Button submitBtn;
	private TextView backTv;
	
	private ProgressDialog dialog;
	private FirebaseAuth mAuth;
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_forgotpassword);
		
		mAuth = FirebaseAuth.getInstance();
		
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
					dialog.show();
					final String email = emailAddressTil.getEditText().getText().toString();
					
					mAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>()
					{
						@Override
						public void onComplete(@NonNull Task<Void> task)
						{
							dialog.dismiss();
							if (task.isSuccessful())
							{
								// Reset email sent
								Toast.makeText(ForgotPasswordActivity.this, "Email Sent", Toast.LENGTH_LONG).show();
								finish();
							} else
							{
								// If task is unsuccessful, then display error
								Toast.makeText(ForgotPasswordActivity.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
							}
						}
					});
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
