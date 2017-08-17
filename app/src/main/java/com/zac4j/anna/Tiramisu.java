package com.zac4j.anna;

import com.zac4j.factory.Factory;

/**
 * Tiramisu
 * Created by Zaccc on 2017/8/16.
 */

@Factory(id = "Tiramisu", type = Meal.class) public class Tiramisu implements Meal {
  @Override public float getPrice() {
    return 4.5f;
  }
}
