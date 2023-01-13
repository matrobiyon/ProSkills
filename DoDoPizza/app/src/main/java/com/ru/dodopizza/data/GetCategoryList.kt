package com.ru.dodopizza.data

import com.ru.dodopizza.Constants

class GetCategoryList {

    //Getting some datas for my CategoryRecyclerView
    fun getCategory() : List<CategoryData>{
        val list = mutableListOf<CategoryData>()

        list.add(CategoryData(Constants.ALL))
       list.add(CategoryData(Constants.PIZZA))
       list.add(CategoryData(Constants.DRINKS))
       list.add(CategoryData(Constants.COMBO))

        var counter = 1
        while (counter < 6){
            list.add(CategoryData("Пустой $counter"))
            counter++
        }
        return list
    }
}