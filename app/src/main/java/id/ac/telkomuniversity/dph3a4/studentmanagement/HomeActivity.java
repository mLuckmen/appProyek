package id.ac.telkomuniversity.dph3a4.studentmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class HomeActivity extends AppCompatActivity {

    FloatingActionButton qr_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        qr_button = findViewById(R.id.qr_button);
        qr_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotoqrscanner = new Intent(HomeActivity.this, QRCodeScannerActivity.class);
                startActivity(gotoqrscanner);
            }
        });
    }
}
