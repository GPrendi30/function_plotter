## src.main.java.com.plotter.Function Plotter Plus

[*Paola Guma*](https://github.com/paolaguma)

### Idea
Build an advanced function plotter, and if possible graph calculator. Based on the labs 8 to 10, updated with our own ideas and solutions.


### Milestones
* Implement the labs
* Have a working function plotter with GUI.
* add support for types such as double, float.
* add functions such as sin, cos.
* add new features.


#### _MVC_ (Model View Controller)
We will try to divide the logic of the program from the graphical interface as described in the MVC.  

##### _Observer pattern_  
We used the observer pattern for the GUI.

### Maven build tool
We use _maven_ for test coverage.

### Run
Run the application from the command-line <br>
<code> javac Main.java
java Main </code> <br>
or you can run with maven
<code> mvn exec:java -Dexec.mainClass=Main</code>
