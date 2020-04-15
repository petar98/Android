# Noter

`Noter` is an application for writing and saving notes on an Android device. It is built against target SDK version 29. The minimum required in this case is version 22. The application runs on Android version 5.1 (Lollipop) and above (which is 92.3 % of Android devices worldwide). It has been tested on Android 9 (Pie) and it runs without any difficulties.

##### `Noter` use cases are listed bellow:

1. User starts the application from the application icon in device menu.
2. User finds the home screen of `Noter` showing all notes that he/she has saved on the device before. If the user starts the application for the first time, or if he/she has deleted all already saved notes, the screen shown to them is without any listed notes and with a text, saying "There aren't any notes yet."
3. User taps the floating button with `+` symbol on it. The application starts another activity (screen) for adding a new note, which has a text input field for the text of the note, and a button with label `SAVE` for  persisting user notes.
4. After filling the input field with desired information and saving the newly created note using the `SAVE` button, user is redirected to the home screen, showing all notes listed in `RecyclerView` including the newly created one at the end of the `RecyclerView`. 
5. If the user has not filled the text input field and it remains empty after taping the `SAVE` button, home screen comes at focus with a `Snackbar` showing that the *empty* note has not been added.
6. User has the ability to delete all persistent notes using the floating button with a recycle bin on it in the left of the home screen. Note that this button is hidden until the user has at least one note listed in `RecyclerView`. After the user taps this button, all notes are deleted and the screen shows no listed notes as well as the text "There aren't any notes yet.".
7. User also has the ability to delete a single note on his/her choice. That is achieved by swiping gesture on the note, which has to be deleted left or right. After that a `Snackbar` is showed on the bottom of the screen for a short period of time, saying that the note has been deleted.

##### `Noter` UI elements (screens and pop ups):

<img src="/home/petar/Pictures/Screenshot_20200415_144528_com.example.wordssample.jpg" style="zoom:25%;" />

[^This is the home screen of Noter if there are no notes saved by the user or it has been started for the first time]: 

<img src="/home/petar/Pictures/Screenshot_20200415_144534_com.example.wordssample.jpg" style="zoom:25%;" />

[^Second screen for entering note text and saving the note on the database]: 

<img src="/home/petar/Pictures/Screenshot_20200415_144645_com.example.wordssample.jpg" style="zoom:25%;" />

[^A Snackbar showing that an empty note cannot be saved]: 

<img src="/home/petar/Pictures/Screenshot_20200415_144628_com.example.wordssample.jpg" style="zoom:25%;" />

[^Home screen with user notes listed in a RecyclerView]: 

<img src="/home/petar/Pictures/Screenshot_20200415_144636_com.example.wordssample.jpg" style="zoom:25%;" />

[^Snackbar showing that a note has been deleted]: 

##### `Noter` architecture:

All of the application components are created along with the advices of Android Architecture Components patterns. It includes 

- `lifecycle-aware components` for managing activities `lifecycles`
-  `ViewModel` for storing UI-related data, persisting configuration changes
- `LiveData` object, used to notify views for data changes
- `Room` database. `Room` is a SQLite object mapping  library, used for providing compile time checks of SQLite statements and returning `LiveData` observables.
- `Repository` object, used for single source of truth for all app data. In other words - clean API for communication between UI and database.

The diagram bellow shows the basic concept of Android Architecture Components:

![](/home/petar/Pictures/Screenshot from 2020-04-15 15-14-12.png)