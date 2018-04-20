package april.stringoperations;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private static final String inputString = "Lorem ipsum dolor sit amet, consectetur adipiscing elit";
    StringBuilder stringBuilder;
    TextView tvOutput;
    long startTime, estimatedTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //to show result in the View
        tvOutput = (TextView) findViewById(R.id.tvOutput);

        //I use StringBuilder to store data instead of +=, because += not efficient approach
        stringBuilder = new StringBuilder();

        reverseString();

        stringNoSpaces();

        stringWithoutSpaces();
    }

    private void reverseString() {
        startTime = System.currentTimeMillis();
        for (int i = inputString.length() - 1; i >= 0; i--) {
            stringBuilder.append(inputString.charAt(i));
        }
        estimatedTime = System.currentTimeMillis() - startTime;

        tvOutput.setText(String.format(getString(R.string.reverse_string), stringBuilder.toString()));
        tvOutput.append(String.format(getString(R.string.elapsed_time), estimatedTime));
    }

    private void stringNoSpaces() {
        startTime = System.currentTimeMillis();
        stringBuilder.setLength(0); //clean it

        String sItems[] = inputString.split(" ");
        for (String item : sItems) {
            stringBuilder.append(item);
        }

        estimatedTime = System.currentTimeMillis() - startTime;
        tvOutput.append(String.format(getString(R.string.without_spaces), stringBuilder.toString()));
        tvOutput.append(String.format(getString(R.string.elapsed_time), estimatedTime));
    }

    //regex variant
    private void stringWithoutSpaces() {
        startTime = System.currentTimeMillis();

        String result = "";
        String pattern = "[\\s]";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(inputString);

        estimatedTime = System.currentTimeMillis() - startTime;
        tvOutput.append(String.format(getString(R.string.without_spaces), m.replaceAll(result)));
        tvOutput.append(String.format(getString(R.string.elapsed_time), estimatedTime));
    }

}
