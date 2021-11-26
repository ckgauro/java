24. Introducing the case study

```java
import java.util.Map;
import java.util.Random;

public class Racer implements Runnable{

	private int id;
	
	private int raceLength;
	private Map<Integer, Integer> currentPositions;
	private Map<Integer, Long> results;

	private final double defaultAverageSpeed = 48.2;
	private int averageSpeedAdjustmentFactor;
	private Random random;	
	
	private double currentSpeed = 0;
	private double currentPosition = 0;
	
	
	public Racer(int id, int raceLength, Map<Integer, Integer> currentPositions, Map<Integer, Long> results) {
		this.id = id;
		this.raceLength = raceLength;
		this.currentPositions = currentPositions;
		this.results = results;
		random = new Random();
		averageSpeedAdjustmentFactor = random.nextInt(30) - 10;
	}
	
	private double getMaxSpeed() {
		return defaultAverageSpeed * (1+((double)averageSpeedAdjustmentFactor / 100));
	}
		
	private double getDistanceMovedPerSecond() {
		return currentSpeed * 1000 / 3600;
	}
	
	private void determineNextSpeed() {
		if (currentPosition < (raceLength / 4)) {
			currentSpeed = currentSpeed  + (((getMaxSpeed() - currentSpeed) / 10) * random.nextDouble());
		}
		else {
			currentSpeed = currentSpeed * (0.5 + random.nextDouble());
		}
	
		if (currentSpeed > getMaxSpeed()) 
			currentSpeed = getMaxSpeed();
		
		if (currentSpeed < 5)
			currentSpeed = 5;
		
		if (currentPosition > (raceLength / 2) && currentSpeed < getMaxSpeed() / 2) {
			currentSpeed = getMaxSpeed() / 2;
		}
	}
		

	@Override
	public void run() {
		
		while (currentPosition < raceLength) {
			determineNextSpeed();
			currentPosition += getDistanceMovedPerSecond();
			if (currentPosition > raceLength )
				currentPosition  = raceLength;
			currentPositions.put(id, (int)currentPosition);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		results.put(id, System.currentTimeMillis());
		
	}
	
}

```

```java
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

	static int raceLength = 100;
	static int displayLength = 160;
	static long start;
	
	private static void displayRace(Map<Integer, Integer> currentPositions) {
		for (int i = 0; i < 50; ++i) System.out.println();
		System.out.println("Race has been running for " + ((System.currentTimeMillis() - start) / 1000) + " seconds.");
		System.out.println("    " + new String (new char[displayLength]).replace('\0', '='));
		for (int i = 0; i < 10; i++) {
			System.out.println(i + " : "  + new String (new char[currentPositions.get(i) * displayLength / 100]).replace('\0', '*'));
		}
	}
	 

	public static void main(String[] args) throws InterruptedException {
		
		Map<Integer, Integer> currentPositions = new ConcurrentHashMap<Integer, Integer>(); 
		Map<Integer, Long> results = new ConcurrentHashMap<Integer, Long>();
		
		start = System.currentTimeMillis();
		
		ExecutorService threadPool = Executors.newFixedThreadPool(10);
		
		for (int i = 0; i <10; i++) {
			Racer h = new Racer(i,raceLength, currentPositions, results);
			currentPositions.put(i, 0);
			threadPool.execute(h);
		}
		
		boolean finished = false;
		while (!finished) {
			Thread.sleep(1000);
			displayRace(currentPositions);
			finished = results.size() == 10;
		}
		
		threadPool.shutdownNow();
				
		System.out.println("Results");
		results.values().stream().sorted().forEach(it -> {
			for (Integer key : results.keySet()) {
				if (results.get(key) == it) {
					System.out.println("Racer " + key + " finished in " + ( (double)it - start ) / 1000 + " seconds.");
				}
			}
		});
	}
}
```
Hell again, in this chapter we're going to take a Java multi-threaded simulation example and convert it to ACA. This will hopefully bring to life what we've learned so far. It will give us the opportunity to practise what we've learned and we'll discover a few more features of ACA along the way. The example case study is a relatively simple racing game. I'm providing you with the standard Java code that will run this game using regular Java multi-threading in the starting workspace for this chapter. We'll be using the two files called main.java and racer.java. There is a palm file here but we'll be using that later on in the chapter so ignore that one for now. So copy along with me. What we'll do is create a new Java project and we'll move these two Java files into that project. So this is going to be a new project and it's a standard Java project. We're not doing it as a Maven project this time, and that's just because we want to be able to run the two classes I showed you in the starting workspace. So a standard Java project, we don't need anything special going on. We'll give it a name, I think I'll call this one Java racing simulation. (keyboard keys clatters) And then when the project is ready, and we have the src folder, will move those two Java files into the src folder. Once again, we want to only have the two Java files in here, not the palm file. We're going to be using that later on in this chapter. Okay, well before we look at the code, I'd like to just run it so we can see what this application does. So we want to open up the main class and we'll be running the public static void main method. The idea of this application is that there are 10 racers competing in a race numbered from zero to nine. The plays of the game will each guess which racer they think will win and then start the race. So for example, let's imagine we want racer number three to win the race. When we click on one, what we see is each racer is running along the track. And when they reach the end, they finished. When all the racers are finished, we're told which racer are finished, in which order and how long it took to run the race. So in our example, racer number three, finished last right at the bottom. Now this is all generated randomly. So if we run it again, we'll see that racer number three finishes in a different position. I'll pause the camera while this runs. And that's finished now. And this time racer number three came second. So let's have a look then at the code. Now I want to point out this isn't a serious game. It's a simple but I think realistic example that I've put together just for this course on how we can use multi-threading in Java to run a simulation. The project has just two classes, the main class and the racer class. And the idea is that as each race will have 10 runners competing against each other, we're going to be instantiating 10 instances of the racer or class. The racer the class as you can see, implements runnable to each racer of runs in its own thread. So we can think of this application as containing a main thread and then 10 racer threads. The main thread will instantiate each of the racer of threads and give each racer of its task and then start the race. As the race progresses, it monitors the progress of each racer and displays it on the screen, and then it prints out the results at the end. So let's start them by looking at the code in the racer class. At the top here, we've got a number of variables first as the ID that will be the unique ID of each racer, which will be a number between zero and nine. Next we have the race length. That's a value that we specify in the main class and pass into each instance of the race objects. And we can use this value to determine how long we want the race to be. Now on my computer, a number here around about a hundred creates a race that takes between about 25 and 30 seconds. So you might need to alter the number for the race length, which we'll see in a few minutes when we look at the code in the main class to get it to run on your computer and around the same amount of time. Next, we have two maps, one called compositions and one called results. Now, this is definitely not the best way to achieve what we're wanting to do, but it is a quick and easy way to do things. If you recall when the application runs the main thread in the application is going to be monitoring the progress of each racer, and then printing out at the end of the race the final results. So we have an issue that we need to share data between the threads. The main thread needs to know about the state of each racer thread, and then finally how long each racer took to run. Now the way I've chosen to implement this requirement, and again, it isn't necessarily a good option, but I just wanted to do something quick and easy is that the main thread will contain a map to store the current position of each racer, and a map to store the current running time for each racer. And then we pass references to these maps into each of the race instances so that the racers can set the values for their own record in these maps. Now we'll look at the way these map objects are being created when we look at the main class, but it has been done in a thread safe way. Okay, so the first few parameters here are set in the constructor of the racer class. Now most of the rest of the code here is about determining how quickly each racer runs. And I'll talk this through. But it isn't that important. If you don't fully understand this part, you can think of this as simply being an algorithm. And we'll be replicating the same algorithm when we go and put this into ACA in a little while. So I'm going to explain the algorithm. But don't worry too much. If it doesn't make complete sense, it's not that important. The idea then is that every racer, will have an average maximum speed that somewhere around this figure here 48.2. Now because every race is different, we will say that the real maximum speed for racer will be somewhere between 10% lower than this figure and 20% higher than this figure. And that's determined by setting up a variable called the average speed adjustment factor. And you can see where we generate this, it's a random number, which is somewhere between minus 10 and plus 20. And that's created in the constructor for this class. There's a method here called getMaxSpeed which uses the average speed adjustment factor to work out what the maximum speed is for this particular racer. And then the final two parameters, the current speed and the current position. Well, they're self explanatory what they represent. And there'll be zero initially, because before the race starts, they were at the beginning of the racer at position zero, and they're not running so their speed is zero. The idea is that as the race proceeds, the speed might change, the colour position will change as it reaches the end. And when it reaches the race length, which if you recall, I've set to 100. That means this one has finished the race. Let's carry on looking down the code. The next thing we have then is a couple of helper methods, one that determines the distance that's been moved by the race at each second, based on its current speed, and one that determines what the speed of the racer should be right now. Now I'm not going to talk through the detail of the method, it's somewhat arbitrary. But it is, I guess, then the algorithm that makes this whole thing work. And then finally, we've got the run method. This, of course, is what happens when the race starts when the main method tells the racer to start racing. When all that actually happens in here is that every second, we recalculate the speed of the racer, and determine its current position based on that speed until the racer has reached the finish line. So that's the racer class. Let's have a look at the main class. Well, this is reasonably straightforward. If we start in the main method, the first thing we do is we instantiate the two maps. And as you can see, I'm instantiating them as concurrent hashMaps. So that means these are thread safe, and therefore it's absolutely fine to pass these into the racer threads. Then we're recording the start time before we start running the race. We're creating a thread pool with a fixed size of 10 and then starting each new thread with a racer of object instantiated in it. Now at this point, we wait until the race is finished. And while we're waiting, we're calling a method called display race, which is actually printing out to the screen, the colour positions. That method is at the top here. And I've used a little trick just to make it look somewhat animated. It's not very pretty, I know, but it sort of works. And that is that every iteration every time we display the race, I'm printing out 50 blank lines, and that should just be enough to clear the console. So it may not work perfectly on your console. If it doesn't, I apologise, but hopefully, you'll get some kind of reasonable looking output, like we saw on mine a few minutes ago. And then finally, once the results are in and we know the race is finished, so we shut down all those threads, and we print out the results to the console. Okay, so that's the Java version. It's not great. I personally don't like this approach of using concurrent hashMaps and passing those into the threads, I think waiting for the threads to have finished. And we're determining whether or not the race has finished whether all the threads have completed by looking at the size of one of those hashMaps. Well, I don't think that's great, because what would have happened if one of those threads had crashed. And there's another issue, which is we're using thread dot sleep here. And I'm dealing with the interrupted exception by slowing it from the main method. Actually, in the racer, there's a thread dot sleep, and we're just catching and ignoring the interrupted exception. So that's not great either. And I'm sure if you looked, you'll find some other issues with this code too. So the idea then is we're going to be improving on this by moving the code to ACA. 


Run the Program

-----------------------

25. Architecting the solution

<img Case study 1>

Create project

POM.xml
```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>org.example</groupId>
    <artifactId>AkkaRacingSimulation</artifactId>
    <version>1.0-SNAPSHOT</version>

    <properties>
        <akka.version>2.6.3</akka.version>
    </properties>


    <dependencies>
        <dependency>
            <groupId>com.typesafe.akka</groupId>
            <artifactId>akka-actor-typed_2.13</artifactId>
            <version>${akka.version}</version>
        </dependency>
        <dependency>
            <groupId>com.typesafe.akka</groupId>
            <artifactId>akka-actor-testkit-typed_2.13</artifactId>
            <version>${akka.version}</version>
        </dependency>
        <dependency>
            <groupId>ch.qos.logback</groupId>
            <artifactId>logback-classic</artifactId>
            <version>1.2.3</version>
        </dependency>
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter-api</artifactId>
            <version>5.5.2</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter-engine</artifactId>
            <version>5.5.2</version>
            <scope>test</scope>
        </dependency>
    </dependencies>
</project>
```

```java
public class RaceController extends AbstractBehavior<RaceController.Command> {
       private RaceController(ActorContext<Command> context) {
        super(context);
    }

    public static Behavior<Command> create() {
        return Behaviors.setup(RaceController::new);
    }


}
```

```java
public class Racer extends AbstractBehavior<Racer.Command> {
    public static Behavior<Command> create() {
        return Behaviors.setup(Racer::new);
    }

}
```

26. Implementing the case study



```java
public class Racer extends AbstractBehavior<Racer.Command> {

}
```

```java
public class RaceController extends AbstractBehavior<RaceController.Command> {
}
```
27. Scheduling and timers

<img Creating timer>