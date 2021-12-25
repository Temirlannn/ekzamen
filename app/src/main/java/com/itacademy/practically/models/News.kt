package com.itacademy.practically.models

import java.io.Serializable

// модель
class News(
    var category: Categories,
    var description: String,
    var name: String,
    var imageUrl: String
) : Serializable