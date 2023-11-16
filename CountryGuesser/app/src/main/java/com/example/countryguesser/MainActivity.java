package com.example.countryguesser;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView hintText;
    private TextView attemptText;
    private TextView hintView;
    private EditText editText;
    private Button getHintButton;
    private Button submitButton;


    private List<String> countries;
    private Map<String, List<String>> countryHints;
    private String currentCountry;
    private int maxAttempts = 3;
    private int attemptsLeft = maxAttempts;
    private int maxHints = 5;
    private int hintsGiven = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hintText = findViewById(R.id.hintText);
        attemptText = findViewById(R.id.attemptText);
        hintView = findViewById(R.id.hintView);
        editText = findViewById(R.id.editText);
        getHintButton = findViewById(R.id.hintButton);
        submitButton = findViewById(R.id.submitButton);

        initializeCountries();
        startGame();
    }

    private void initializeCountries() {


        /*INITIALIZING THE COUNTRIES*/
        countries = new ArrayList<>(Arrays.asList("Tanzania", "Canada", "USA", "Turkey", "Russia", "India", "UK", "France", "Kenya", "South Africa"));

        /*INITIALIZING THE LISTS OF HINTS*/
        List<String> TzHints = new ArrayList<>(Arrays.asList("The country area is 974,303 kilometres", "This country is located in East africa",
                "The country currency is Shilling", "The spoken language of this country is SWAHILI", "The capital city of this country is DODOMA"));


        List<String> CnHints = new ArrayList<>(Arrays.asList("The country area is 974,303 kilometres", "This country is located in East africa",
                "The country currency is Shilling", "The spoken language of this country is SWAHILI", "The capital city of this country is DODOMA"));


        List<String> UsHints = new ArrayList<>(Arrays.asList("The country area is 974,303 kilometres", "This country is located in East africa",
                "The country currency is Shilling", "The spoken language of this country is SWAHILI", "The capital city of this country is DODOMA"));


        List<String> TrHints = new ArrayList<>(Arrays.asList("The country area is 974,303 kilometres", "This country is located in East africa",
                "The country currency is Shilling", "The spoken language of this country is SWAHILI", "The capital city of this country is DODOMA"));


        List<String> RsHints = new ArrayList<>(Arrays.asList("The country area is 974,303 kilometres", "This country is located in East africa",
                "The country currency is Shilling", "The spoken language of this country is SWAHILI", "The capital city of this country is DODOMA"));


        List<String> InHints = new ArrayList<>(Arrays.asList("The country area is 974,303 kilometres", "This country is located in East africa",
                "The country currency is Shilling", "The spoken language of this country is SWAHILI", "The capital city of this country is DODOMA"));


        List<String> UkHints = new ArrayList<>(Arrays.asList("The country area is 974,303 kilometres", "This country is located in East africa",
                "The country currency is Shilling", "The spoken language of this country is SWAHILI", "The capital city of this country is DODOMA"));



        List<String> FrHints = new ArrayList<>(Arrays.asList("The country area is 974,303 kilometres", "This country is located in East africa",
                "The country currency is Shilling", "The spoken language of this country is SWAHILI", "The capital city of this country is DODOMA"));


        List<String> KyHints = new ArrayList<>(Arrays.asList("The country area is 974,303 kilometres", "This country is located in East africa",
                "The country currency is Shilling", "The spoken language of this country is SWAHILI", "The capital city of this country is DODOMA"));



        List<String> SaHints = new ArrayList<>(Arrays.asList("The country area is 974,303 kilometres", "This country is located in East africa",
                "The country currency is Shilling", "The spoken language of this country is SWAHILI", "The capital city of this country is DODOMA"));




        /*INITIALIZING THE COUNTRIES-MAP HINTS*/
        countryHints = new HashMap<>();


        /*ASSIGNING THE HINTS FOR EACH COUNTRY*/
        countryHints.computeIfAbsent("Tanzania", k -> new ArrayList<>()).addAll(TzHints);

        countryHints.computeIfAbsent("Canada", k -> new ArrayList<>()).addAll(CnHints);

        countryHints.computeIfAbsent("Usa", k -> new ArrayList<>()).addAll(UsHints);

        countryHints.computeIfAbsent("Turkey", k -> new ArrayList<>()).addAll(TrHints);

        countryHints.computeIfAbsent("Russia", k -> new ArrayList<>()).addAll(RsHints);

        countryHints.computeIfAbsent("India", k -> new ArrayList<>()).addAll(InHints);

        countryHints.computeIfAbsent("UK", k -> new ArrayList<>()).addAll(UkHints);

        countryHints.computeIfAbsent("France", k -> new ArrayList<>()).addAll(FrHints);

        countryHints.computeIfAbsent("Kenya", k -> new ArrayList<>()).addAll(KyHints);

        countryHints.computeIfAbsent("South Africa", k -> new ArrayList<>()).addAll(SaHints);
    }

    public void startGame() {
        /*CREATING A RANDOM OBJECT*/
        Random random = new Random();

        /*GETTING A RANDOM COUNTRY FROM THE COUNTRIES LIST*/
        currentCountry = countries.get(random.nextInt(countries.size()));

        updateHintText();
        hintsGiven = 0;

        updateAttempts();
    }


    private void updateHintText() {
        List<String> hints =  countryHints.get(currentCountry);

        if (hints != null && hints.size() > 0 && hintsGiven < maxHints) {
            hintText.setText("Hint: " + (hintsGiven + 1) + "/" +  maxHints);
            hintView.setText(hints.get(hintsGiven));
        }else {
            hintText.setText("No more hints");
            hintView.setText("");
        }
    }

    private void updateAttempts() {
        attemptText.setText("Attempt: " + (maxAttempts - attemptsLeft + 1) + maxAttempts);
        editText.setText("");
    }

    private void onGetHintClick(View view) {
        if (hintsGiven < maxHints) {
            hintsGiven++;
            updateHintText();
        }
    }

    private void onSubmitClick(View view) {
        String userAnswer = editText.getText().toString().trim();

        if (userAnswer.equalsIgnoreCase(currentCountry)) {
            // TODO
        }else {
            attemptsLeft--;
            if (attemptsLeft == 0) {
                // TODO
            }else {
                updateAttempts();
            }
        }
    }


}