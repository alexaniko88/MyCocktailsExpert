# Cocktail Explorer

[![License: MIT][license_badge]][license_link]

Cocktail Explorer is an Android application written in Kotlin that allows users to explore a list of cocktails, search for specific cocktails, and view detailed information about each cocktail. The app follows the principles of clean architecture, uses MVVM pattern, Retrofit for consuming endpoints, Koin for dependency injection, and Unit Tests for testing business logic.


## Features

- Browse a diverse selection of cocktails
- Search for cocktails by name
- View detailed information including ingredients and preparation instructions

## Architecture

Cocktail Explorer follows the principles of clean architecture, separating concerns into data, domain, and presentation layers:

- **Data Layer:** Responsible for data retrieval from remote sources using Retrofit.
- **Domain Layer:** Contains business logic and use cases for manipulating data.
- **Presentation Layer:** Handles UI logic and interaction with the user.

## Technologies Used

- **Kotlin:** Primary programming language for development.
- **Retrofit:** HTTP client for consuming RESTful APIs.
- **Koin:** Dependency injection framework for managing dependencies.
- **JUnit and Mockito:** Libraries for writing and running Unit Tests.

## Testing

Cocktail Explorer includes comprehensive Unit Tests to ensure the correctness of the business logic and functionality.

## Demo

<p align="center">
    <img width="35%" src="https://github.com/alexaniko88/MyCocktailsExpert/assets/40612984/37ff64a0-d2dd-4662-85ec-201ee5f30f1f">
</p>

[license_badge]: https://img.shields.io/badge/license-MIT-blue.svg
[license_link]: https://opensource.org/licenses/MIT
