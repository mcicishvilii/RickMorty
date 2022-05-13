package com.example.rickmorty.RickMortyModels.json

data class ListRickMorty(
    val info: Info,
    val results: List<Result>
)
//1. ) არასწოორი package  სახელია json
//2.) RickAndMortyModels არაა საჭირო პირდააპირ models საკმარისია
//3.) packageName დიდი ასოთი არ დაიწყო პატარათი ყოველთვის
