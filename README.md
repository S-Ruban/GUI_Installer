# GUI Installer

This is a GUI application written using Java Swing. This application executes a bunch of shell scripts in the background which will install any application, and display a progress bar on the screen for the same.

Ensure that you have OpenJDK 17 installed on the system. If not, you can always install it using the default package manager available.

The shell scripts that are to be installed should be put into the `scripts` folder.

To define the shell scripts to be executed along with the cumulative percentage of the application installed, edit the `scripts.txt` file, where each line **must** be in the form 

`<script_file> <total_percentage>`

where `<script_file>` should be a valid shell file and `<total_percentage>` should be an integer **between 0 and 100**

To run the installer, type `./install.sh` in the terminal (you may have to do `chmod u+x install.sh` to grant permission to execute it).