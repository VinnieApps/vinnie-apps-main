## Java Code

### Running one application

To run one application from the command line, you can use the `run.sh` script.
The script will run Gradle's `distributionZip` task for all projects then go into the build folder of the specified project, unzip the zip file generated and run it.

The following is an example:

```bash
$ cd java
$ ./run.sh chapter-01/hello_process/
Next random number was: 926
Next random number was: 935
Next random number was: 704
Next random number was: 313
Next random number was: 546
^CProcess is shutting down...
```
