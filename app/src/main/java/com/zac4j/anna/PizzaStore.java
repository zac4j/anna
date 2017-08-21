package com.zac4j.anna;

/**
 * Pizza Store
 * Created by Zaccc on 2017/8/21.
 */

public class PizzaStore {

  private MealFactory factory = new MealFactory();

  public Meal order(String mealName) {
    return factory.create(mealName);
  }
}
