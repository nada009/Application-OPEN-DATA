# JSON Parsing using Java
This project uses three JSON files - bibliotheques.json, logements.json and restaurants.json - and filters data to show establishments in different zones provided by the files. The Graphical User Interface is handled using the JavaFX API and the main window displays 6 lists - 3 on the left with the complete list of data in all 3 files and the other 3 on the right with the filtration results. In the middle, there is a short description displayed each time an item in the list is selected. The "Plus de details.." link opens a new window with more details on the list item selected. In this window, the "Show in maps" link opens another window which loads the Google Maps web page directly into the application. This window has two buttons - next and previous - to navigate through the other similar establishments in the same zone.

### Dependency for compilation
	* java 8+ (for JavaFX)
	* json-simple-1.1.1.jar

### Files used by the application
The JSON files used by the application can be found in the `json_files` folder of the root directory of the project.

### Built with
	* Eclipse Oxygen

### Authors
	* KANITA Nada
	* ARKAM Sara
	* GOUSSIN Floriane

### Sources used for learning JavaFX and JSON parsing
	* http://tutorials.jenkov.com/javafx/index.html
	* https://docs.oracle.com/javase/8/javafx/embedded-browser-tutorial/overview.htm
