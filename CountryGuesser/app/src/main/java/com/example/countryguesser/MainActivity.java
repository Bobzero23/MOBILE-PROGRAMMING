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
    private int totalScore;


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
        List<String> TzHints = new ArrayList<>(Arrays.asList("The country area is 974,303 kilometres", "This country is located in EAST AFRICA",
                "The country currency is SHILLING", "The spoken language of this country is SWAHILI and ENGLISH", "The capital city of this country is DODOMA"));


        List<String> CnHints = new ArrayList<>(Arrays.asList("The country area is  9,984,670 kilometres", "This country is located in NORTH AMERICA",
                "The country currency is DOLLAR", "The spoken language of this country is ENGLISH and FRENCH", "The capital city of this country is OTTAWA"));


        List<String> UsHints = new ArrayList<>(Arrays.asList("The country area is  9,631,418 kilometres", "This country is located in NORTH AMERICA",
                "The country currency is DOLLAR", "The spoken language of this country is ENGLISH", "The capital city of this country is Washington, D.C"));


        List<String> TrHints = new ArrayList<>(Arrays.asList("The country area is 783,356 kilometres", "This country is located in EUROPE and ASIA",
                "The country currency is LIRA", "The spoken language of this country is TURKISH", "The capital city of this country is ANKARA"));


        List<String> RsHints = new ArrayList<>(Arrays.asList("The country area is the largest in the world, approximately 17,098,242 square kilometers", "This country is located in EASTERN EUROPE AND NORTH ASIA",
                "The country currency is RUBLE", "The spoken language of this country is RUSSIAN", "The capital city of this country is MOSCOW"));


        List<String> InHints = new ArrayList<>(Arrays.asList("The country area is 3,287,590 kilometres", "This country is located in SOUTH ASIA",
                "The country currency is RUPEE", "The spoken language of this country is HINDI", "The capital city of this country is NEW DELHI"));


        List<String> UkHints = new ArrayList<>(Arrays.asList("The country area is 243,610 kilometres", "This country is located in NORTH WESTERN EUROPE",
                "The country currency is POUND STERLING", "The spoken language of this country is ENGLISH", "The capital city of this country is LONDON"));



        List<String> FrHints = new ArrayList<>(Arrays.asList("The country area is 551,695 kilometres", "This country is located in WESTERN EUROPE",
                "The country currency is EURO", "The spoken language of this country is FRENCH", "The capital city of this country is PARIS"));


        List<String> KyHints = new ArrayList<>(Arrays.asList("The country area is 580,367 kilometres", "This country is located in EAST AFRICA",
                "The country currency is SHILLING", "The spoken language of this country is SWAHILI and ENGLISH", "The capital city of this country is NAIROBI"));



        List<String> SaHints = new ArrayList<>(Arrays.asList("The country area is 1,219,090 kilometres", "This country is located in SOUTHERN AFRICA",
                "The country currency is RAND", "The spoken language of this country is AFRIKAANS, ENGLISH and ISIZULU", "The capital city of this country is PRETORIA, BLOEMFONTEIN, CAPETOWN"));




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

        totalScore = 1000;

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
        attemptText.setText("Attempt: " + (maxAttempts - attemptsLeft + 1) + "/" + maxAttempts);
        editText.setText("");
    }

    public void onGetHintClick(View view) {
        if (hintsGiven < maxHints) {
            hintsGiven++;
            totalScore = totalScore - 200;
            updateHintText();
        }
    }

    public void onSubmitClick(View view) {
        String userAnswer = editText.getText().toString().trim();

        if (userAnswer.equalsIgnoreCase(currentCountry)) {
            hintView.setText("CONGRATULATIONS!! YOU ARE CORRECT. YOU SCORED " + totalScore + "POINTS");
        }else {
            attemptsLeft--;
            if (attemptsLeft == 0) {
                hintView.setText("YOU LOST");
            }else {
                updateAttempts();
            }
        }
    }


}