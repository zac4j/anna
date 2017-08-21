package com.zac4j.anna;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

  private EditText mMealInput;
  private TextView mPriceView;
  private PizzaStore mStore;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    mMealInput = findViewById(R.id.main_et_meal_input);
    Button orderBtn = findViewById(R.id.main_btn_order_meal);
    mPriceView = findViewById(R.id.main_tv_meal_price);
    mStore = new PizzaStore();

    // Meal type could choose: "Calzone", "Margherita","Tiramisu"
    orderBtn.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {
        String mealType = mMealInput.getText().toString();
        Meal meal = mStore.order(mealType);
        mPriceView.setText(String.valueOf(meal.getPrice()));
      }
    });
  }
}
