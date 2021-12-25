package com.itacademy.practically.models

import java.io.Serializable

data class CategoryModel(
    var category: Categories,
    var name: Int,
    var news : List<News>
) : Serializable