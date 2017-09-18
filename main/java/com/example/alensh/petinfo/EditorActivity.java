package com.example.alensh.petinfo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.alensh.petinfo.Data.PetContract;
import com.example.alensh.petinfo.Data.PetContract.PetEntry;

public class EditorActivity extends AppCompatActivity {

    /** EditText field to enter the pet's name */
    private EditText mNameEditText;

    /** EditText field to enter the pet's breed */
    private EditText mBreedEditText;

    /** EditText field to enter the pet's weight */
    private EditText mWeightEditText;

    /** EditText field to enter the pet's gender */
    private Spinner mGenderSpinner;

    private int mGender = PetEntry.GENDER_UNKNOWN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor);
        mNameEditText = (EditText) findViewById(R.id.edit_pet_name);
        mBreedEditText =(EditText)findViewById(R.id.edit_pet_breed);
        mWeightEditText= (EditText) findViewById(R.id.edit_pet_weight);
        mGenderSpinner = (Spinner) findViewById(R.id.spinner_gender);

        setUpSinnper();
    }

    private void setUpSinnper() {
        final ArrayAdapter genderSpinnerAdapter = ArrayAdapter.createFromResource(this,R.array.array_gender_options,
                android.R.layout.simple_spinner_item);

        genderSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


//       Apply Adapter to Spinner
        mGenderSpinner.setAdapter(genderSpinnerAdapter);
        mGenderSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            String Selection = (String) parent.getItemAtPosition(position);
                if(!TextUtils.isEmpty(Selection)){

                    if(Selection.equals(R.string.gender_male)){
                        mGender = PetEntry.GENDER_MALE;
                    }
                    else if(Selection.equals(R.string.gender_female)){
                        mGender= PetEntry.GENDER_FEMALE;
                    }
                    else if(Selection.equals(R.string.gender_unknown)){
                        mGender = PetEntry.GENDER_UNKNOWN;
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                mGender = PetEntry.GENDER_UNKNOWN;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.editor_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_done:
                inserted();
                finish();
                return true;

            case R.id.action_delete:
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void inserted() {
        String name  = mNameEditText.getText().toString().trim();
        String breed = mBreedEditText.getText().toString().trim();
        String weight = mWeightEditText.getText().toString().trim();

        int numWeight = Integer.parseInt(weight);
    }
}
