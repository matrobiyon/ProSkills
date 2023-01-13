package com.ru.dodopizza.data

import com.ru.dodopizza.Constants
import com.ru.dodopizza.R

class GetPizzaList {
    fun getList() : List<PizzaData>{
        val list = mutableListOf<PizzaData>()
        repeat(5) {
            list.add(PizzaData(R.drawable.pizza_1,"2 пиццы и напиток", "2 пиццы 25 см и напиток на выбор. Для компании из 2-4 человек",94,Constants.PIZZA))
        }
        repeat(5){
            list.add(PizzaData(image = R.drawable.coca_cola, name = "Coca-Cola Zero", price = 8, category = Constants.DRINKS))
        }
        repeat(4){
            list.add(PizzaData(R.drawable.combo,"10 medium pizzas", "10 pizzas 40sm for every taste. For a company of 20-30 people",675,Constants.COMBO))
        }
            return list
        }
    }