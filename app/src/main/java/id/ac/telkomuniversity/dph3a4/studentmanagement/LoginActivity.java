package id.ac.telkomuniversity.dph3a4.studentmanagement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {

    private final AppCompatActivity activity = LoginActivity.this;

    Button btn_login;
    TextInputEditText textInputUsername, textInputPassword;
    TextInputLayout textInputUsernameLayout, textInputPasswordLayout;

    NestedScrollView nestedScrollView;

    private SqliteHelper sqliteHelper;
    private InputValidation inputValidation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        sqliteHelper = new SqliteHelper(getApplicationContext());
        inputValidation = new InputValidation(activity);

        textInputUsername = findViewById(R.id.textInputUsername);
        textInputUsernameLayout = findViewById(R.id.textInputUsernameLayout);
        textInputPassword = findViewById(R.id.textInputPassword);
        textInputPasswordLayout = findViewById(R.id.textInputPasswordLayout);


        btn_login = findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verifyFromSQLite();
            }
        });
    }

    private void verifyFromSQLite() {
        if (!inputValidation.isInputEditTextFilled(textInputUsername, textInputUsernameLayout, getString(R.string.error_message_username))) {
            return;
        }
        if (!inputValidation.isInputEditTextFilled(textInputPassword, textInputPasswordLayout, getString(R.string.error_message_password))) {
            return;
        }

        int userId = sqliteHelper.checkLogin(textInputUsername.getText().toString().trim(),
                textInputPassword.getText().toString().trim());
        if (userId != 0){
                Preference pref = new Preference(getApplicationContext());
                pref.userHasLoggedIn(true);
                pref.setUserCredentials(userId);

                Intent gotohome = new Intent(LoginActivity.this, HomeActivity.class);
                gotohome.putExtra("username", textInputUsername.getText().toString());
                emptyField();
                startActivity(gotohome);
        } else {
            Toast.makeText(this, getString(R.string.error_valid_email_pass), Toast.LENGTH_LONG).show();
//            Snackbar.make(nestedScrollView, getString(R.string.error_valid_email_pass), Snackbar.LENGTH_LONG).show();
        }
    }

    private void emptyField() {
        textInputUsername.setText(null);
        textInputPassword.setText(null);
    }
}
