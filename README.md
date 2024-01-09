# 🐱🐶 Animal Facts

App that shows cats and dogs facts, in any amount you want. Preserving data when activity is recreated

https://github.com/CarlosAcioli/AnimalFacts/assets/131110961/d70ccf9d-e1a5-4e4e-aa62-0d3c322c72bb

## 🎯 Objective

This app was developed to show differences between code implementations with 2 approaches:

- LiveData and Response (_Retrofit_)
- StateFlow and Flow (_Both by Kotlin_)

## 📋 General Description 

The application was built with the MVVM Architecture and Clean Architecture pattern, divided into 2 services CatService and DogService

✔️ The CatService was created using LiveData and Response, the Response is a Retrofit Class to handle API Calls, and LiveData is a class that holds data and observe them (brief very brief explanation)

 ✔️ The DogService was created using StateFlow and Flow, the StateFlow is a modern alternative for LiveData, that is, do the same as LiveData, watches data and storage them, and Flow is basically a flow that can emit certains values defined by you developer, and then handle it

> The explanations made above was very brief and it's recommended that you search this terms you don't know
