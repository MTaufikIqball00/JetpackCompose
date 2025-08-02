package com.example.myapplication.data.model

import com.google.gson.annotations.SerializedName

data class SuperheroResponse(

	@field:SerializedName("image")
	val image: Image? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: String? = null,

)

data class Image(

	@field:SerializedName("url")
	val url: String? = null
)