package com.itacademy.practically.models

import com.itacademy.practically.R

class Constants {
    companion object {
        var news = arrayListOf(
            News(Categories.Sport, "1","Спорт","https://api.живуспортом.рф/imagecache/full_jpeg/article_image/130/129249/5e5628e139feb.jpeg"),
            News(Categories.Sport, "2","Спорт","https://api.живуспортом.рф/5/full_jpeg/article_image/130/129249/5e5628e139feb.jpeg"),
            News(Categories.Sport, "3","Спорт","https://api.живуспортом.рф/imagecache/full_jpeg/article_image/130/129249/5e5628e139feb.jpeg"),
            News(Categories.weather, "4","Погода","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQTLwPkCMn9hI9BERg4qTuVQs9F37aUbnvHCg&usqp=CAU"),
            News(Categories.weather, "5","Погода","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQTLwPkCMn9hI9BERg4qTuVQs9F37aUbnvHCg&usqp=CAU"),
            News(Categories.weather, "6","Погода","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQTLwPkCMn9hI9BERg4qTuVQs9F37aUbnvHCg&usqp=CAU"),
        )
        val categories = arrayListOf(
            CategoryModel(Categories.Sport,R.string.Sports,getNewsByCategories(Categories.Sport)),
            CategoryModel(Categories.weather,R.string.weather,getNewsByCategories(Categories.weather)),
        )

        private fun getNewsByCategories(categories: Categories): List<News> {
            return news.filter { it.category == categories }
        }
    }
}
enum class Categories {
    Sport,
    weather
}