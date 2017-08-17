package com.zac4j.anna;

import com.zac4j.factory.Factory;

/**
 * Margherita Pizza
 * Created by Zaccc on 2017/8/16.
 */

@Factory(id = "Margherita", type = Meal.class) public class MargheritaPizza implements Meal {
  @Override public float getPrice() {
    return 6.0f;
  }
}
