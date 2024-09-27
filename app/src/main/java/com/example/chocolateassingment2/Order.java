package com.example.chocolateassingment2;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;

import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


import java.util.ArrayList;

public class Order extends AppCompatActivity {

    private CheckBox Kitkat,DairyMilk,Snickers,Ferrero;
    ArrayList<String> arr= new ArrayList<>();

    private RadioGroup radioGroup;
    private RadioButton radioButton;


    private TextView quantityTextView,totalPriceTextView,Chocolates,ratingText;


    private Button increment,decrement,placeorder;
    private int quantity=0;
    private int totalprice=0;

    private AlertDialog.Builder builder;
    private RatingBar ratingBar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_order);



        Kitkat=findViewById(R.id.Kitkat);
        DairyMilk=findViewById(R.id.DairyMilk);
        Snickers=findViewById(R.id.Snickers);
        Ferrero=findViewById(R.id.Ferrero);
        Chocolates=findViewById(R.id.chocolates);

        radioGroup=findViewById(R.id.radioGroup);


        quantityTextView=findViewById(R.id.quantityTextView);
        totalPriceTextView=findViewById(R.id.totalPriceTextView);
        increment=findViewById(R.id.increment);
        decrement=findViewById(R.id.decrement);

        placeorder=findViewById(R.id.order_btn);
        builder=new AlertDialog.Builder(this);

        ratingBar=findViewById(R.id.ratingBar);
        ratingText=findViewById(R.id.rating);


        Kitkat.setOnCheckedChangeListener((buttonView, ischecked) -> {
            check(buttonView, ischecked);


        });

        DairyMilk.setOnCheckedChangeListener((buttonView, ischecked) -> {
            check(buttonView, ischecked);


        });

        Snickers.setOnCheckedChangeListener((buttonView, ischecked) -> {
            check(buttonView, ischecked);


        });

        Ferrero.setOnCheckedChangeListener((buttonView, ischecked) -> {
            check(buttonView, ischecked);


        });

        increment.setOnClickListener(v -> {
            quantity++;
            quantityTextView.setText("" + quantity);
            updateQuantityAndPrice();
        });



        decrement.setOnClickListener(v -> {
            if (quantity > 0) {
                quantity--;
                quantityTextView.setText("" + quantity);
                updateQuantityAndPrice();
            }
        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                radioButton = findViewById(checkedId);
            }
        });

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromuser) {
                ratingText.setText("Rating: " + rating);

            }
        });

        placeorder.setOnClickListener( v -> {
            try {
                if (arr.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please select chocolates!!", Toast.LENGTH_SHORT).show();
                }
                String radioValue = radioButton.getText().toString();
                if (quantity == 0) {
                    Toast.makeText(getApplicationContext(), "Please add quantity!!", Toast.LENGTH_SHORT).show();
                } else {
                    builder.setTitle("Order placed")
                            .setMessage("Order Summary:\n" + "Chocolates: " + arr + "\nChocolates Types: " + radioValue + "\nQuantity: " + quantity + "\nTotal Price: BDT " + totalprice + "\nRating: " + ratingBar.getRating() + "\nThank you!!")
                            .setCancelable(false)
                            .setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.cancel();
                                    Toast.makeText(getApplicationContext(), "Order Placed!!", Toast.LENGTH_SHORT).show();
                                    quantity = 0;
                                    totalprice = 0;
                                    quantityTextView.setText("0");
                                    totalPriceTextView.setText("BDT 0");
                                    Chocolates.setText("");
                                    Kitkat.setChecked(false);
                                    DairyMilk.setChecked(false);
                                    Snickers.setChecked(false);
                                    Ferrero.setChecked(false);
                                    radioGroup.clearCheck();
                                    ratingBar.setRating(0);
                                }
                            }).show();
                }
            } catch (Exception e){
                Toast.makeText(getApplicationContext(), "Please Select chocolates types!!", Toast.LENGTH_SHORT).show();
            }



        });

        }

    private void countTotalPrice() {

        updateQuantityAndPrice();
    }

    private void updateQuantityAndPrice() {
        double chocolateprice = 0.0;

        int selectedProductId = radioGroup.getCheckedRadioButtonId();
        if (selectedProductId == R.id.darkchocolate) {
            chocolateprice = 200.0;
        } else if (selectedProductId == R.id.silkchocolate) {
            chocolateprice = 160.0;
        } else if (selectedProductId == R.id.whitechocolate) {
            chocolateprice = 120.0;
        }


        totalprice = (int) (chocolateprice * quantity);


        totalPriceTextView.setText("Total Price: BDT " + totalprice);
    }



    void check(CompoundButton buttonView, Boolean isChecked){
        if (isChecked) {
            arr.add(buttonView.getText().toString());
            Log.d("array", String.valueOf(arr));
        } else{
            arr.remove(buttonView.getText().toString());
        }

    }














    }
