# Team Members App

A simple, modern Android application built using **Kotlin** and **Jetpack Compose** (Material 3). This project demonstrates how to display a scrollable list of team members using `LazyColumn` (the Compose equivalent of `RecyclerView`), along with interactive click handling and a Material 3 `TopAppBar`.

## Features

- **Material 3 Design:** Uses `Scaffold`, `TopAppBar`, `Card`, and Material 3 color schemes with edge-to-edge display support (`enableEdgeToEdge()`).
- **Scrollable List (`LazyColumn`):** Efficiently renders a list of `User` items with proper spacing and unique keys.
- **Interactive UI:** Displays `Toast` messages when clicking on any team member card or the TopAppBar action icons (Menu and Search).
- **Compose Preview:** Includes `@Preview` support for quick UI inspection inside Android Studio.

## Tech Stack & Versions

- **Language:** Kotlin `1.9.0`
- **UI Toolkit:** Jetpack Compose (BOM `2024.04.01`)
- **Design System:** Material Design 3
- **Android Gradle Plugin (AGP):** `8.5.2`
- **Core KTX:** `1.13.1`
- **Activity Compose:** `1.9.0`

## Project Structure

The core logic and UI live inside `MainActivity.kt`:
- `MainActivity`: Entry point that sets up edge-to-edge UI and loads `UserScreen()`.
- `User`: Data class representing a team member (`id`, `name`, `role`).
- `UserScreen()`: Main composable screen containing the `Scaffold`, `TopAppBar`, and `LazyColumn`.
- `UserCard()`: Reusable composable card item displaying a user's name and department role.

## Getting Started

1. Clone this repository:
   ```bash
   git clone [https://github.com/AndroKotlin/](https://github.com/AndroKotlin/)<your-repository-name>.git
