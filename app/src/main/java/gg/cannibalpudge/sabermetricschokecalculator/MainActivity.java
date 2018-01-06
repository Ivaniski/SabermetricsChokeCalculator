package gg.cannibalpudge.sabermetricschokecalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import java.lang.*;


public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "gg.cannibalpudge.sabermetricschokecalculator";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab1);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String output = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.textView7);
        textView.setText(output);


    }

    /* Called when the user taps the Send button */
    public void sendMessage(View view) {
        Intent intent = new Intent(this, MainActivity.class);

    //---------------------------read input-----------------------------//

        EditText editTextMine1 = (EditText) findViewById(R.id.editText2);
        String message1 = editTextMine1.getText().toString();

        EditText editTextMine2 = (EditText) findViewById(R.id.editText3);
        String message2 = editTextMine2.getText().toString();

        EditText editTextMine3 = (EditText) findViewById(R.id.editText4);
        String message3 = editTextMine3.getText().toString();

        EditText editTextMine4 = (EditText) findViewById(R.id.editText5);
        String message4 = editTextMine4.getText().toString();


    //---------------------truncate string -> int-----------------------//

        message1 = checkInput(message1);
        message2 = checkInput(message2);
        message3 = checkInput(message3);
        message4 = checkInput(message4);

        String number1 = message1;
        int result1 = Integer.parseInt(number1);

        String number2 = message2;
        int result2 = Integer.parseInt(number2);

        String number3 = message3;
        int result3 = Integer.parseInt(number3);

        String number4 = message4;
        int result4 = Integer.parseInt(number4);

    //---------------------------sabermetrics-----------------------------//

        int res1 = result2 - result1;
        res1 = res1 * 12;
        int res2 = result3 - result4;
        res2 = res2 * 20;

        int answer = res1 + res2;

    //----------------------truncate int -> string------------------------//

        String calculation = Integer.toString(answer);

    //------------------------------output--------------------------------//


        intent.putExtra(EXTRA_MESSAGE, calculation);
        startActivity(intent);

    }

    public String checkInput(String input){
        if (input.matches("")) {
            input = "0";
        }
        return input;
    }
}

