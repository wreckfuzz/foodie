package mobile.uni.natashawhitter.foodie.activities;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import mobile.uni.natashawhitter.foodie.R;


public final class OnboardingActivity extends BaseActivity
{
	private TextInputLayout firstNameTil;
	private TextInputLayout surnameTil;
	private TextInputLayout birthDateTil;
	private Spinner favoriteFoodSp;
	private RadioGroup restaurateurCheck;
	private Button doneBtn;
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_onboarding);
		
		firstNameTil = findViewById(R.id.activity_onboarding_firstName);
		surnameTil = findViewById(R.id.activity_onboarding_surname);
		birthDateTil = findViewById(R.id.activity_onboarding_birthDate);
		favoriteFoodSp = findViewById(R.id.activity_onboarding_favoriteFood);
		restaurateurCheck = findViewById(R.id.activity_onboarding_restaurateur_check);
		doneBtn = findViewById(R.id.activity_onboarding_done);
		
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.favorite_food_array, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		favoriteFoodSp.setAdapter(adapter);
		
		restaurateurCheck.getCheckedRadioButtonId();
		
		doneBtn.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				try
				{
					addDetailsToDatabase();
				} catch (Exception e)
				{
				
				}
			}
		});
	}
	
	private void addDetailsToDatabase() throws Exception
	{
		// Data validation (name is valid, birthDate >= 16, user has checked an radiobutton
		// Get data (if favorite food not selected, don't add to database)
		String firstName = firstNameTil.getEditText().getText().toString();
		String surname = surnameTil.getEditText().getText().toString();
		String birthDate = birthDateTil.getEditText().getText().toString();
		String favoriteFood = favoriteFoodSp.getSelectedItem().toString();
		boolean isRestaurateur;
		
		int checkId = restaurateurCheck.getCheckedRadioButtonId();
		
		if (checkId != -1)
		{
			RadioButton isRestaurateurRb = restaurateurCheck.findViewById(checkId);
			int idx = restaurateurCheck.indexOfChild(isRestaurateurRb);
			
			// Get Selected Radio Text on RadioGroup
			RadioButton r = (RadioButton) restaurateurCheck.getChildAt(idx);
			String selectedRestaurateurCheck = r.getText().toString();
			
			if (selectedRestaurateurCheck.equalsIgnoreCase("Yes"))
			{
				isRestaurateur = true;
			} else if (selectedRestaurateurCheck.equalsIgnoreCase("No"))
			{
				isRestaurateur = false;
			}
		} else
		{
			throw new Exception("Please select type of user");
		}
	}
	
	private boolean getRestaurateurCheck()
	{
		int checkId = restaurateurCheck.getCheckedRadioButtonId();
		RadioButton isRestaurateur = restaurateurCheck.findViewById(checkId);
		int idx = restaurateurCheck.indexOfChild(isRestaurateur);
		
		// Get Selected Radio Text on RadioGroup
		RadioButton r = (RadioButton) restaurateurCheck.getChildAt(idx);
		String selectedRestaurateurCheck = r.getText().toString();
		
		return false;
	}
}
