package com.example.volleyballanalaysor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.sql.Array;

public class NewGameInfo extends AppCompatActivity {

    protected int numberOfSets, numberOfPoints;


    private Spinner setsSpinner;
    private Button saveBtn;

    private EditText numberOfPointsIn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_game_info);




        setsSpinner = (Spinner) findViewById(R.id.SetsSpinner) ;


        saveBtn = (Button) findViewById(R.id.newGameInfoSaveBtn);



        numberOfPointsIn = (EditText) findViewById(R.id.NumberOfPointsEditText);


        Intent intent = new Intent(this, NewGameTeamsInfo.class);




        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.sets, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);

        setsSpinner.setAdapter(adapter);

        setsSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                TextView tv = (TextView) findViewById(R.id.textView5);
                tv.setVisibility(View.INVISIBLE);
                saveBtn.setVisibility(View.INVISIBLE);
                numberOfPointsIn.setVisibility(View.INVISIBLE);
                if(i == 0){

                }

                else{
                    switch (i){
                        case 1:
                            numberOfSets = 1;
                            break;

                        case 2:
                            numberOfSets = 2;
                            break;

                        case 3:
                            numberOfSets = 3;
                            break;

                        default:
                            break;

                    }

                    tv.setVisibility(View.VISIBLE);
                    numberOfPointsIn.setVisibility(View.VISIBLE);


                }




            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        numberOfPointsIn.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                saveBtn.setVisibility(View.INVISIBLE);

                if(!(TextUtils.isEmpty(numberOfPointsIn.getText().toString().trim()))){
                    saveBtn.setVisibility(View.VISIBLE);
                    numberOfPoints = Integer.parseInt(numberOfPointsIn.getText().toString());

                }

                else{
                    Toast.makeText(NewGameInfo.this, "The number of sets should be a number and cannot be empty", Toast.LENGTH_SHORT).show();
                }

            }
        });

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("numberOfSets", numberOfSets);
                intent.putExtra("numberOfPoints", numberOfPoints);
                startActivity(intent);
            }
        });







    }



}