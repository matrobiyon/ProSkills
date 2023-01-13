package com.ru.dodopizza

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ru.dodopizza.adapter.CategoryAdapter
import com.ru.dodopizza.adapter.PizzaAdapter
import com.ru.dodopizza.data.CategoryData
import com.ru.dodopizza.data.GetCategoryList
import com.ru.dodopizza.data.GetPizzaList
import com.ru.dodopizza.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //Getting list for Pizza RecyclerView
        var listOfPizzas = GetPizzaList().getList()


        //Adapter for Pizza RecyclerView
        val adapterForPizza = PizzaAdapter()
        adapterForPizza.submitList(listOfPizzas)
        binding.pizzaRecyclerView.adapter = adapterForPizza



        //Getting list for CategoryRecyclerView
        val listOfCategory = GetCategoryList().getCategory().toMutableList()


        //Adapter for CategoryRecyclerView
        val adapterForCategory = CategoryAdapter()
        adapterForCategory.submitList(listOfCategory)
        binding.categoryRecyclerView.adapter = adapterForCategory

        //Disabling Animation for Category Recycler View
        binding.categoryRecyclerView.itemAnimator = null


        //2 method for CategoryAdapter
        //On Clicked Selected Item
        adapterForCategory.onClickedSelectedItem = {


            //For changing the selected Item
            var newList = mutableListOf<CategoryData>()


            //Getting new List from previous
            for (item in adapterForCategory.currentList.indices) {
                if (item == it) {
                    val newStateForCategory =
                        adapterForCategory.currentList[item].copy(isChecked = true)
                    newList.add(newStateForCategory)
                } else {
                    newList.add(listOfCategory[item])
                }
            }
            adapterForCategory.submitList(newList)
        }


        //For filtering the Pizzas on Category Clicked
        adapterForCategory.onFilter = { selectedCategory ->
            if (selectedCategory != Constants.ALL){
                val newList = listOfPizzas.filter { previousListItem ->
                    previousListItem.category == selectedCategory
                }
                adapterForPizza.submitList(newList)
            }else {
                adapterForPizza.submitList(listOfPizzas)
            }

        }
    }
}