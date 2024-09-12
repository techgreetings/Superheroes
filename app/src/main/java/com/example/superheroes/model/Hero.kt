package com.example.superheroes.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.superheroes.R

data class Hero(
 @StringRes val nameRes: Int,
 @StringRes val descriptionRes: Int,
 @DrawableRes val imageRes: Int
)

val heroes = listOf(
  Hero(R.string.hero1,R.string.description1,R.drawable.superhero1),
  Hero(R.string.hero2,R.string.description2,R.drawable.superhero2),
  Hero(R.string.hero3,R.string.description3,R.drawable.superhero3),
  Hero(R.string.hero4,R.string.description4,R.drawable.superhero4),
  Hero(R.string.hero5,R.string.description5,R.drawable.superhero5),
  Hero(R.string.hero6,R.string.description6,R.drawable.superhero6)
 )