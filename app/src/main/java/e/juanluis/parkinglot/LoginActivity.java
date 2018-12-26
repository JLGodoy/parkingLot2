package e.juanluis.parkinglot;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    private EditText mName;
    private EditText mPass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mName = findViewById(R.id.etName);
        mPass = findViewById(R.id.etPass);
    }

    public void launchMap(View view) {
    }
}
