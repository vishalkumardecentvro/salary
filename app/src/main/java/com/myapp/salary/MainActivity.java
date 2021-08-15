package com.myapp.salary;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
  private EditText basicPay, allowances, deductions;
  private Button salaryButton, emailButton;
  private TextView totalSalary;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    basicPay = findViewById(R.id.etBasicPay);
    allowances = findViewById(R.id.etAllowence);
    deductions = findViewById(R.id.etDeductions);
    salaryButton = findViewById(R.id.salaryButton);
    totalSalary = findViewById(R.id.tvSalary);
    emailButton = findViewById(R.id.mailButton);

    salaryButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        int basePay = Integer.parseInt(basicPay.getText().toString());
        int allowance = Integer.parseInt(allowances.getText().toString());
        int deduction = Integer.parseInt(deductions.getText().toString());

        totalSalary.setText("Your total salary: "+String.valueOf((basePay + allowance) - deduction));
      }
    });

    emailButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL, "shobhitvijay36@gmail.com");
        intent.putExtra(Intent.EXTRA_SUBJECT, "Salary");
        intent.putExtra(Intent.EXTRA_TEXT, "your salary shobit = " + totalSalary.getText().toString());

        if (intent.resolveActivity(getPackageManager()) != null) {
          startActivity(intent);
        }
      }
    });

  }
}