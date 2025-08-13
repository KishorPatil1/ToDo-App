# ToDo App 📝

A simple and intuitive Android ToDo list application built with Kotlin. This app allows users to manage their daily tasks with persistent storage, ensuring your todos are saved even after closing the app.

## Features ✨

- **Add Tasks**: Easily add new todo items with a simple text input
- **View Tasks**: See all your tasks in a clean, scrollable list
- **Delete Tasks**: Remove completed or unwanted tasks with confirmation dialog
- **Persistent Storage**: All tasks are automatically saved to device storage
- **Material Design**: Modern UI following Material Design guidelines
- **Dark/Light Theme**: Supports both light and dark themes

## Screenshots 📱

*Add screenshots of your app here*

## Technologies Used 🛠️

- **Language**: Kotlin
- **UI Framework**: Android Views with Material Design Components
- **Storage**: File-based serialization using Java ObjectInputStream/ObjectOutputStream
- **Architecture**: Single Activity with utility classes
- **Build System**: Gradle with Kotlin DSL

## Project Structure 📁

```
app/
├── src/main/
│   ├── java/com/example/todo/
│   │   ├── MainActivity.kt          # Main activity handling UI and user interactions
│   │   └── FileHelper.kt           # Utility class for file I/O operations
│   ├── res/
│   │   ├── layout/
│   │   │   └── activity_main.xml   # Main activity layout
│   │   ├── values/
│   │   │   ├── strings.xml         # App strings
│   │   │   ├── colors.xml          # Color definitions
│   │   │   └── themes.xml          # App themes
│   │   └── drawable/               # App icons and drawables
│   └── AndroidManifest.xml         # App configuration
└── build.gradle.kts                # Module-level build configuration
```

## Requirements 📋

- **Android Studio**: Arctic Fox or later
- **Min SDK**: API 25 (Android 7.1)
- **Target SDK**: API 34 (Android 14)
- **Compile SDK**: API 35
- **Java Version**: 11

## Installation & Setup 🚀

1. **Clone the repository**
   ```bash
   git clone https://github.com/yourusername/ToDo.git
   cd ToDo
   ```

2. **Open in Android Studio**
   - Launch Android Studio
   - Select "Open an existing project"
   - Navigate to the cloned repository folder
   - Wait for Gradle sync to complete

3. **Run the app**
   - Connect an Android device or start an emulator
   - Click the "Run" button or press `Ctrl+R` (Windows/Linux) or `Cmd+R` (Mac)

## How to Use 📖

1. **Adding a Task**
   - Type your task in the text field at the top
   - Tap the "Add" button
   - Your task will appear in the list below

2. **Deleting a Task**
   - Tap on any task in the list
   - A confirmation dialog will appear
   - Tap "Yes" to delete or "No" to cancel

3. **Data Persistence**
   - All tasks are automatically saved when added or deleted
   - Your tasks will be restored when you reopen the app

## Build Configuration 🔧

### Dependencies
- AndroidX Core KTX: 1.16.0
- AppCompat: 1.7.0
- Material Components: 1.12.0
- Activity: 1.10.1
- ConstraintLayout: 2.2.1

### Build Info
- Gradle Version: 8.9
- Android Gradle Plugin: 8.7.3
- Kotlin Version: 1.9.24

## Data Storage 💾

The app uses a simple file-based storage system:
- **File**: `listinfo.dat` stored in app's private directory
- **Format**: Java object serialization of `ArrayList<String>`
- **Location**: Internal storage (not accessible to other apps)

## Contributing 🤝

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/new-feature`)
3. Commit your changes (`git commit -am 'Add new feature'`)
4. Push to the branch (`git push origin feature/new-feature`)
5. Create a Pull Request

## Future Enhancements 🚀

- [ ] Edit existing tasks
- [ ] Task categories/tags
- [ ] Due dates and reminders
- [ ] Task priorities
- [ ] Search functionality
- [ ] Export/Import tasks
- [ ] Task completion status
- [ ] Modern architecture (MVVM, Room database)
- [ ] Widget support

## Known Issues 🐛

- File operations are performed on the main thread (should be moved to background)
- No input validation for empty tasks
- Uses deprecated `@SuppressLint` annotation

## License 📄

This project is open source and available under the [MIT License](LICENSE).

