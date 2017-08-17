package com.zac4j.anna;

import com.zac4j.factory.Factory;

/**
 * Calzone Pizza
 * Created by Zaccc on 2017/8/16.
 */

@Factory(id = "Calzone", type = Meal.class) public class CalzonePizza implements Meal {
  @Override public float getPrice() {
    return 8.5f;
  }
}
