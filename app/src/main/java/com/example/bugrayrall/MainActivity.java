package com.example.bugrayrall;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private EditText targetInput;
    private Button confirmTargetButton;
    private Button zikirButton;
    private int count = 0;
    private int dailyTarget = 0;
    private boolean isTargetConfirmed = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        targetInput = findViewById(R.id.targetInput);
        confirmTargetButton = findViewById(R.id.confirmTargetButton);
        zikirButton = findViewById(R.id.button);

        confirmTargetButton.setOnClickListener(v -> {
            String targetString = targetInput.getText().toString().trim();
            if (!targetString.isEmpty()) {
                dailyTarget = Integer.parseInt(targetString);
                isTargetConfirmed = true;
                targetInput.setEnabled(false); // Hedef belirlendikten sonra düzenlenemez
                confirmTargetButton.setEnabled(false); // Hedef onay butonu devre dışı bırakılır
                zikirButton.setEnabled(true); // Zikir butonu aktif hale gelir
                Toast.makeText(this, "Zikir hedefi:" + dailyTarget, Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Zikir Hedefi Giriniz:", Toast.LENGTH_SHORT).show();
            }
        });

        zikirButton.setOnClickListener(v -> {
            if (isTargetConfirmed) {
                count++;
                textView.setText("Zikir: " + count);

                if (count == dailyTarget) {
                    Toast.makeText(this, "Allah Çektiğiniz Zikri Kabul Etsin İnşallah!", Toast.LENGTH_LONG).show();
                    zikirButton.setEnabled(false); // Hedef tamamlanınca ziki

                }
            }
        });
    }
}

