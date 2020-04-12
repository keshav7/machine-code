package com.base.foodprocessor.service;

import com.base.foodprocessor.domain.Restaurant;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class RestaurantService {

  List<Restaurant> restaurantList;

  public Restaurant fetchRestaurant(List<String> items) {

    Restaurant result = null;
    List<Restaurant> restaurantList = new ArrayList<>();
    Double minPrice = Double.MAX_VALUE;

    for (Restaurant restaurant : restaurantList) {
      if (canServeAllItems(restaurant, items)) {
        Double price = getPrice(restaurant, items);
        if (price < minPrice) {
          result = restaurant;
        }

      }
    }
    return result;
  }

  private Boolean canServeAllItems(Restaurant restaurant, List<String> items) {

    if (restaurant.getCapacity() < items.size()) {
      return false;
    }
    Set<String> itemIds = restaurant.getItemIdPriceMap().keySet();

    for (String item : items) {
      if (!itemIds.contains(item)) {
        return false;
      }
    }
    return true;

  }

  private Double getPrice(Restaurant restaurant, List<String> items) {

    Double price = 0D;
    for (String item : items) {
      price += restaurant.getItemIdPriceMap().get(item);
    }
    return price;


  }






}
