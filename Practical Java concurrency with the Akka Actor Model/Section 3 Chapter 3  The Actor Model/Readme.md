7. The concepts of the actor design pattern 
THe Actor Model
<img src="images/actor2.png">

As we saw in the last chapter,concurrent programming using the core Java libraries is achieved by creating threads and assigning tasks to them. When we code in this way, we need to think about coding from the perspective of how processes work? We have to consider, how to split the process in between the threads, how threads are going to share data, and how to do this in a safe way. 

The actor model gives us a very different way of thinking about concurrent programming, which means that we'll be able to almost completely forget about threads, data sharing, thread safety, and interrupted exceptions. Now for programmers who have never come across the actor model before, it's a completely different mindset to any traditional programming that you might've done. So we're going to build up the concepts in this chapter bit by bit. So what I want to do is start by introducing the theory of the actor model, and talk more about what the different components of the model are. And this will be really from a very theoretical point of view. 

This chapter is about understanding the concepts of what we're going to be coding up, how it works, and why it's a good option. Once we've done that, then we can start to learn how to write the code that uses this model. And that will start in the next chapter. So we'll start then with the main idea behind what the actor model is. I think the best way to understand this is to think about it being based on actors in a play, or even better, how humans generally interact with each other. So let's forget completely about computers for a few minutes and imagine that you're the manager of a team of employees. And you need to come up with a list of 20 big probable prime numbers, the example we saw in the last chapter. 

You might go to each employee in turn and say to them, "Please can you come up with a big probably prime number?" Each employee will say, "Yes, no problem, sure.", something similar to that. And they'll go away and do some work. At some point later on, each employee comes back to you and says, "I've done what you asked for. The number I came up with is." And they give you a number. Well, if we go into code up the example from the last chapter using the actor model, this is what it would look like. The first two really important concepts in the actor model then are actors and messages. 

In our example, we'd have an actor for the manager, and well, maybe 20 actors, because we want to generate 20 prime numbers, one for each of the employees in the team. Actors can communicate with each other. The verb we tend to use is that actors tell each other things. So the manager actor can tell each of the employee actors to go and create a number. And the employee actors, when they've done the work, can tell the manager actor, "Here's the result that I found." And the other things that actors can do then is they can do some work. That is computing terms, they can run their own code.


8. What is an actor?
<img src="images/actor1.png">
Now that we have a basic overview of the model, let's look a little bit more deeply at what an actor actually is, then. That is, we'll try and bring the concept slightly away from the idea of people and back to computers, and we'll see a little bit about how the model is implemented. 
Again, really, this is still just going to be theory at this stage, but we will be seeing lots of examples over the coming chapters, so don't worry if not everything we learn about here makes sense just yet. 

So an **actor**, then, in computing terms, is an object which has a number of key features. The first thing is that **actors** have a couple of properties or fields. These are the `name` and the `path`.
We'll see programmatically what this means later on, but for now, they're used to allow us to identify and locate an actor. Actually, thinking back to our employees in an office example, if the manager wants to go to an employee called Sally, he might need to go to her desk, which could be the third desk along in the second row to find her. That would be Sally's location. 

There might be more than one employee called Sally, but we can differentiate between them because they have different locations, they'll sit at different desks. And in computing terms, the actor's name and path mirror this idea. The path will allow us to uniquely identify each **actor**. Next, actors have a message queue. When one actor tells another actor something, what happens is that the message, the information being told from one **actor** to the other **actor**, gets put into that actor's queue. And finally, actors have code that can tell them what to do when they receive a message, and we call this the actor's behavior. When an actor receives a message, it could ignore it, it could respond to the actor that sent the message, or it could just run some code. It could do all sorts of things, and this is defined by the actor's behaviour. 

The behaviour will take a message out of the queue and process it one at a time. So the messages that actors can send and receive are not just going to be strings or numbers. They can be any class that's serializable. So actors can send some quite complex data to each other as their messages. 

-  Actor has following properties
    -   Name
    -   Path  


<img src="images/actor3.png">
After receiving message in behavior it will remove from queue.
<img src="images/actor4.png">
-------------------
9. Why does this model work?  
-   The Actor Model 
    -   Each actor has its won thread
    -   Actors  won't share data
    -   Messages must be immutable
    -   Messages are processed one at a time.  

### Each actor has its won thread
Before we start writing any code, I think it's worth understanding why this model works from a thread safety point of view. That is how it overcomes those difficulties we learned about with the traditional way of doing concurrent programming in Java. Well, the answer to this is that there are a few built-in features of the model that ensure everything works in a thread safe way, and so that we don't need to think about thread safety, unblocking, and so on. So the idea, then, is that first of all, each actor learns in its own thread. And actors won't share data with other actors. 

### Actors  won't share data
What I mean by this is that each actor has its own state, its own set of data, but it won't share that data with any other actor. So two actors can't have the same reference to the same memory space on the heap. Any variables contained in an actor's memory space is going to be isolated just to that single actor. And because each actor has it's own thread, that means there is no sharing of data across threads. So there is no issue about thread safety when we use the actor model. Now we have seen that actor's can send each other messages and this is how data can be shared between actors but, and this is really important, 

### Messages must be immutable
each message must be immutable. What we're doing is we're sending information from one actor to another or from one thread to another but the message, once it's been set up cannot be changed by either actor. So any data sent from one thread to another is immutable and therefore by definition is thread safe. 

So thinking about our big prime example, the manager actor might hold the collection to store the results. The main list of big primes. And this could be a regular collection. It doesn't have to be a thread safe one. The manager actor might send a message to each of the employee actors that says get me a number please and that could be for example a string. The employee actors are never going to change that string. The employee actors are going to be sending the manager actor a message containing a big integer. And the manager can store those big integers in their array list. But it can't change the big integers. Now without that has been sent between the manager and the employees, no actor is changing data that it receives. It's immutable. An actor can take a copy of the data so that it can store it, manipulate it, or change it locally, but it's always going to be changing a copy, not the original. So thread safety is going to be taken care of for us. 
<img src="images/actor2.png">

### Messages are processed one at a time.  
The next important thing to understand is how actors process these messages. I've already mentioned that messages are processed one at a time. So when we send a message to an actor, it goes into that actor's message queue. The actor will take a message, do some processing, and only when it's finished will it get the next message in the queue. Now this is important because it means that the processing of a message cannot be interrupted. Because an actor can only access the data in its own state, and it won't write any code until the processing of the message has been completed, there is no chance of an interrupted exception. There are no risks around needing synchronization and so on. Just to make this clear, let's think again about the manager actor. 

This actor is going to be receiving messages that say here's a number, and it's going to be processing that message by, well for example, adding that number into its array list. Now at the same time there could be another actor, maybe a supervisor in the office, who asks the manager what numbers have you got so far? If the manager is responding to that supervisor actor, or in our terms iterating freely array list, while that processing is happening, that iterating, some new messages arrive. Maybe the other employees sending manager a message that says here's another number. Those messages will wait in the queue until the manager's finished doing the iterating. Once the manager has finished, then it can take the messages from the queue. So there is no risk of the array list being updated while the iterating is taking place. If you'll remember that concurrent modification exception that we saw in the last chapter, well that can't happen with the actor model. Because all the processing is taking place in the sponsor receiving the message and messages are processed one at a time. There's no chance of two different pieces of code that need to access the object being run at the same time. Well, that's quite a lot of for way so let's start to get practical, and in the next chapter, we'll create our first actors and start to code up the big prime numbers example.