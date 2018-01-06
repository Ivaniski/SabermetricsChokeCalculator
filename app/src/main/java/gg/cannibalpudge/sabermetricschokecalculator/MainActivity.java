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

        if (message1.matches("")) {
            message1 = "0";
            System.out.println("message 1 was null and now is 0");
        }
        if (message2.matches("")) {
            message2 = "0";
            System.out.println("message 2 was null and now is 0");

        }
        if (message3.matches("")) {
            message3 = "0";
            System.out.println("message 3 was null and now is 0");

        }
        if (message4.matches("")) {
            message4 = "0";
            System.out.println("message 4 was null and now is 0");

        }

    //---------------------truncate string -> int-----------------------//

        message1 = checkInput(message1);
        System.out.println(message1);
        message2 = checkInput(message2);
        System.out.println(message2);
        message3 = checkInput(message3);
        System.out.println(message3);
        message4 = checkInput(message4);
        System.out.println(message4);

//        if(message2 == null) {
//            message2 = 0;
//        }else{
//            return message2;
//        }
//
//        if(message3 == null) {
//            message3 = 0;
//        }else{
//            return message3;
//        }
//
//        if(message4 == null) {
//            message4 = 0;
//        }else{
//            return message4;
//        }
//
        String number1 = message1;
        int result1 = Integer.parseInt(number1);

        String number2 = message2;
        int result2 = Integer.parseInt(number2);

        String number3 = message3;
        int result3 = Integer.parseInt(number3);

        String number4 = message4;
        int result4 = Integer.parseInt(number4);

    //---------------------------sabermetrics-----------------------------//

        int answer = result1 + result2 + result3 + result4;

    //----------------------truncate int -> string------------------------//

        String calculation = Integer.toString(answer);

    //------------------------------output--------------------------------//


        intent.putExtra(EXTRA_MESSAGE, calculation);
        startActivity(intent);

    }


//    private boolean isEmpty(EditText etText) {
//        if (etText.getText().toString().trim().length() > 0)
//            return false;
//
//        return true;
//    }

    public String checkInput(String input){
        if(input != null) {
            return input;
        }else if(input != "") {
            return input;
        }else{
            String var = "0";
            System.out.println(var);
            return var;
        }
    }
}

