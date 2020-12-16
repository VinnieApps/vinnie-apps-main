## What is a process?

When you start your computer, digital circuits initialize all the hardware then load a special piece of software that will bootstrap the operating system. This special piece of software is called the bootloader and it is responsible to load the operating system.

The operating system is responsible to manage access to peripherals, CPU and memory. It also has processes that have multiple different responsibilities. On Linux for example there's the init process that serves as the parent for all the other processes.

But what is a process? A process is an instance of a program. That means that you can write a computer program and then ask the operating system to run multiple instances of it. A process can be as simple as a “Hello World!” type of application or it can be as complex as a browser, a database or a web server.

All operating systems have tools to analyze a process, check how much memory and CPU it is using, for how long it has been running, etc. Processes can also be controlled by signals or messages that the operating system sends to it. When you start a process from the command line, you can send signals using CTRL + (command) for that. In [POSIX](https://en.wikipedia.org/wiki/POSIX) systems you can also use the kill command to send signals to processes.

### Hello Process (JAVA_VERSION)

To illustrate this, let's write an application that generates random numbers and prints them to standard output in an infinite loop until it receives a SIGTERM signal. SIGTERM means that the application should terminate.

In Java, the following is an infinite loop that will print a random number and then sleep for a second:

```java
Random random = new Random();
while (true) { // Infinite loop
    int next = random.nextInt(1000);
    System.out.printf("Next random number was: %d%n", next);
    Thread.sleep(1000);
}
```
[Link to Code](../code/java/chapter-01/random_printer/src/main/java/org/visola/howthewebworks/serverside/Main.java#L15-L20)

In Java, there’s no way to catch specific signals sent to the process. These are captured by the JVM which decides what to do. The only thing you can do is run a piece of code if the process is terminating. To do that, you register a shutdown hook thread like the following:

```java
Runtime.getRuntime().addShutdownHook(new Thread() {
    @Override
    public void run() {
        System.out.println("Process is shutting down...");
    }
});
```
[Link to Code](../code/java/chapter-01/random_printer/src/main/java/org/visola/howthewebworks/serverside/Main.java#L8-L13)
