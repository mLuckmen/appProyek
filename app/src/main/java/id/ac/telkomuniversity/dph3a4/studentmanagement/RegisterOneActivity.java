package id.ac.telkomuniversity.dph3a4.studentmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class RegisterOneActivity extends AppCompatActivity implements View.OnClickListener{

    private final AppCompatActivity activity = RegisterOneActivity.this;

    TextInputLayout textInputUsernameLayout, textInputEmailLayout, textInputPasswordLayout, textInputRepasswordLayout;
    TextInputEditText textInputUsername, textInputEmail, textInputPassword, textInputRepassword;

    Button btn_continue;

    private InputValidation inputValidation;
    private SqliteHelper sqliteHelper;
    private Mahasiswa mhs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_one);

        initViews();
        initListener();
        initObjects();
    }

    private void initViews() {
        textInputUsernameLayout = findViewById(R.id.textInputUsernameLayout);
        textInputEmailLayout = findViewById(R.id.textInputEmailLayout);
        textInputPasswordLayout = findViewById(R.id.textInputPasswordLayout);
        textInputRepasswordLayout = findViewById(R.id.textInputRepasswordLayout);

        textInputUsername = findViewById(R.id.textInputUsername);
        textInputEmail = findViewById(R.id.textInputEmail);
        textInputPassword = findViewById(R.id.textInputPassword);
        textInputRepassword = findViewById(R.id.textInputRepassword);

        btn_continue = findViewById(R.id.btn_continue);
    }

    private void initListener() {
        btn_continue.setOnClickListener(this);
    }

    private void initObjects() {
        inputValidation = new InputValidation(activity);
        sqliteHelper = new SqliteHelper(activity);
        mhs = new Mahasiswa();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_continue:
                postDataToSQLite();
                break;
        }
    }

    private void postDataToSQLite() {
        if (!inputValidation.isInputEditTextFilled(textInputUsername, textInputUsernameLayout, getString(R.string.error_message_username))) {
            return;
        }
        if (!inputValidation.isInputEditTextFilled(textInputEmail, textInputEmailLayout, getString(R.string.error_message_email))) {
            return;
        }
        if (!inputValidation.isInputEditTextEmail(textInputEmail, textInputEmailLayout, getString(R.string.error_message_email))) {
            return;
        }
        if (!inputValidation.isInputEditTextFilled(textInputPassword, textInputPasswordLayout, getString(R.string.error_message_password))) {
            return;
        }
        if (!inputValidation.isInputEditTextMatches(textInputPassword, textInputRepassword, textInputRepasswordLayout,  getString(R.string.error_password_match))) {
            return;
        }

        if (!sqliteHelper.checkRegister(textInputUsername.getText().toString().trim())) {
            mhs.setUsername(textInputUsername.getText().toString().trim());
            mhs.setEmail(textInputEmail.getText().toString().trim());
            mhs.setPassword(textInputPassword.getText().toString().trim());

            sqliteHelper.createMahasiswa(mhs);

            Intent gotosuccessregister = new Intent(RegisterOneActivity.this, SuccessRegisterActivity.class);

            startActivity(gotosuccessregister);
        } else {
            Toast.makeText(this, getString(R.string.error_username_exists), Toast.LENGTH_LONG).show();
        }
    }

    private void emptyField(){
        textInputUsername.setText(null);
        textInputEmail.setText(null);
        textInputPassword.setText(null);
        textInputRepassword.setText(null);
    }
}
