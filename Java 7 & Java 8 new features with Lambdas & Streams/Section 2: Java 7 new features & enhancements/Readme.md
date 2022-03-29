###  5. Java 7 new features & enhancements content.md
Slide 12,13, 14
https://github.com/eazybytes/Java-New-features/blob/main/Java7/src/com/eazybytes/java7/TryWithResources.java

###  6. Try With Resources statement.md


#### JAVA 7 NEW FEATURES
###### THE TRY - WITH - RESOURCES STATEMENT

-   To make Developer life easy and improve the quality of the code, a new feature called **'TRY-WITH-RESOURCES statements’** are introduced.
-   Using this we don’t have to explicitly close the resource. We just have to initialize the resources details inside the () immediately next to try keyword. In its simplest form, the trywith-resources statement can be written as,
```java
try (BufferedReader br= ...) {
    //work with br

}
```
-   When try block execution completes the br.close() method will be automatically called by JVM. For this a new interface is created in Java 7 which is **‘java.lang.AutoCloseable’**.
-   Before **‘java.lang.AutoCloseable’** introduced in Java 7, we have an interface **‘java.io.Closeable’** which restricts the type of exception thrown to only IOException.
-   But the new Interface(AutoCloseable) can be used in more general contexts, where the exception thrown during closing is not necessarily an IOException.
-   Since Closeable meets the requirements for **AutoCloseable**, it is implementing **AutoCloseable** when the latter was introduced.
-   A **try-with-resources** statement can itself have catch and **finally** clauses for other requirements inside the application.
-   You can specify multiple resources as well inside the **try-with-resources** statement.
-   Sample implementation of **try-with-resources** statement,
```java
    public static void withJava7() throws IOException {
        try(BufferedReader br=new BufferedReader(new FileReader(path)); ){
            String sCurrentLine;
            while((sCurrentLine=br.readLine())!=null){
                System.out.println(sCurrentLine);
            }
        }
    }
```    
-   All resource reference variables should be final or effective final. So we can’t perform reassignment with in the try block.

-   Till Java 1.6, try block should be followed by either catch or **finally** block but from Java 7 we can have only try with resource block with out catch & **finally** blocks.


In this lecture, we will discuss one of the great future, introducing Java 7, which is the private resources statement.So this feature is introduced specially to help developers and to make their life easy when they are dealing with the resources like database connections, file reading, file writing operation before this future.It is the responsibility of the developer to make sure whatever resource he's trying to use inside his code blog or inside his call to close them gracefully by leveraging a **finally** block.

If we forgot to close any of the resources, it may result into unexpected issues due to memory leakage issues.So to help developer in such scenarios, Java seven came with a beautiful feature called **try with Resources**. Using this, we don't have to explicitly close any of the resource that we are trying to tell insideour blog. As soon as your code execution is completed inside my blog, the resource will be automatically closed by JVM internally. But there is a change on how we are going to use this try statement until Java seeks.You will create a blog just with the {} after that statement.

```java
 try(BufferedReader br=new BufferedReader(new FileReader(path)); ){
            String sCurrentLine;
            while((sCurrentLine=br.readLine())!=null){
                System.out.println(sCurrentLine);
            }
        }
```        

But now you can see you are allowed to create this { opening bracket and closing }.Inside this bracket.You have to mention what is the resource that you are trying to create, where it might be a file or it might be a database connection, and you will use the same variable, which is in this case, br,to perform your operations using the same resource.And once your execution is completed inside the try block and there is no need for the developer to close like you used to do before Java seven inside the final blocks. And as I said, everything is automatically taken by internal JVM.So for this purpose in new interface is created in Java seven, which is ‘**java.lang.AutoCloseable**’.

So any resource which is implementing this interface, we don't have to close them and JVM will takecare as long as we are using these private resource statements.And you can imagine in its simplest form, we don't have to write catch blog and **finally** block from Java seven only with the {} blog, we can go ahead and write our code.So previously we used to write a blog and **finally** blog final blog inside.We used to close all the connections.

Now that is also became optional, which will make our final block also in such scenarios optional.And I'm good to go with time block alone.And if there is a scenario where I don't have to catch the exception explicitly inside my catalogue,so as you can see, in its simplest form, it is just a try block where inside I block presses, youwill declare the resource details and you perform whatever logic you want to do with that resource andclosing of it will be taken care of by the JVM automatically.Let's try to understand by doing some coding using this new feature so that we can understand in a bettermanner. 

### TryWithResources.java
```java
package com.gauro.java7;
import util.CustomResource;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Chandra
 */
public class TryWithResources {
    static String path="/Users/ckgauro/Tutorial/github/java/Java 7 & Java 8 new features with Lambdas & Streams/Java7Example/src/main/resources/data.txt";


    public static void main(String[] args) throws Exception {
        beforeJava7();
        System.out.println("------");
        withJava7();
        System.out.println("------");
        withCustomResInJava7();

    }

    /**
     * Sample implementation before Java 7
     * @throws Exception
     */
    public static void beforeJava7() throws Exception{
        BufferedReader br=null;
        try{
            br=new BufferedReader(new FileReader(path));
            String sCurrentLine;
            while((sCurrentLine= br.readLine())!=null){
                System.out.println(sCurrentLine);
            }

        }finally{
            br.close();
        }

    }

    /**
     * Sample implementation from Java 7
     * @throws java.io.IOException
     * @throws java.io.FileNotFoundException
     */
    public static void withJava7() throws IOException {
        try(BufferedReader br=new BufferedReader(new FileReader(path)); ){
            String sCurrentLine;
            while((sCurrentLine=br.readLine())!=null){
                System.out.println(sCurrentLine);
            }
        }
    }
    /**
            * Sample implementation from Java 7
            * @throws Exception
	 */
    public static void withCustomResInJava7() throws Exception {
        try(CustomResource cr=new CustomResource();){
            cr.readFromResource();
        }

    }
}

``` 
### CustomResource.java
```java
package util;

/**
 * @author Chandra
 */
public class CustomResource implements AutoCloseable{

    @Override
    public void close() throws Exception {
        System.out.println("From close method inside the CustomResource class");

    }
    public void readFromResource(){
        System.out.println("Reading data ....");
    }
}

```
So far this I have written this class private resources. As you can see, there is a main method.I have written a method where to show what we used to do **beforeJava7** and the Java seven, how it is going to change if we can absorb inside.**beforeJava7**, I used to create a resource inside try blog with the statement, whatever bufferreader and the failure and passing the file where it is located.And once I have that buffer reader I used to read using a web log line by line and bring them in.So the value finally, once I'm done with my try block execution, the developer has to make sure to write this **finally** be that close.Otherwise you are **br** will never get close.And if someone tried to perform any operations on the same file, it may result in two unexpected issues. As you can see, if I remove this **finally** block, you will get an error saying that try block has to be followed by final statement if you don't have any cash statements.So as you can see, this method is already drawing. That means we don't want to catch that exception inside this method.And due to that reason, we have not written catch flow.And when I don't have catch block **beforeJava7**, definitely my try block should be followed by **finally** block.

So these are all limitations and one third are redundant code that we have to take care.And we are always relying on some developer to making sure that.This has to be close before JVM, which may result in to some human errors due to that result in new feature called Private Resources is introduced in Java seven. Now, let's try to understand what is change with Java seven version. As I was saying, now we are allowed to create a resource inside this brackets. As you can see, the same declaration of that resource I have created by using buffer reader and filereader inside the try brackets itself. 


And there is no limitation that we can create only one resource.You can create any number of resource inside the try brackets, like you can create a one file responseand you can also create one database connection resource.So there is no such limitation.But please be aware, whatever you declared here is final effect to final.That means even though you are not mentioning it as a final, the JVM will treat it as a final.The reason is if it allows the user to reassign that resource to some other resource, the try block cannot understand which resource it has to close automatically.So due to that reason, the resource that you are going to create with the help of private resource statements, it is effective final, like I can show you now if I try to create one more resource witha different file called Easy Start one, but be active with the same variable you can see you will geta compilation error saying that the resource buyer of private resource statements can be assigned.

That means it's final.So due to that, please make sure that whatever you're declaring is final inside my blog and don't try to reassign to some other value.And it's not alone.And you can see here now there is no final blog.It's just a try blog I'm having here.And there is free from writing unwonted **finally** blogs. And at the same time, we are avoiding human errors.That may be possible when the developers are forget to close the resources. Maybe I may put only **finally** blog, but inside the final blog instead of being that close.I mean how different logos are different logic.But see Java seven, we used to rely on developers to close the resources.But now with this feature, the final blog itself, we don't need and we don't have to close any ofthe resources and it will be taken care of by the JVM automatically.

### CustomResource.java
```java
public class CustomResource implements AutoCloseable{

    @Override
    public void close() throws Exception {
        System.out.println("From close method inside the CustomResource class");

    }
    public void readFromResource(){
        System.out.println("Reading data ....");
    }
}

```
And as I was saying in New Interface,we can implement this new Interface in Java seven.And I have created a custom resource which implements this are plausible.And whenever I'm implementing this AHTO closable, there is only one method called close inside thisinterface.Definitely I have to provide what is a logic that I have to offer while closing the resource.So for now I just put inside the closed method.I'm just calling a CustomResource, and at the same time I also have some real from resource Materne where to perform some reading operationson the resource that I have created.So this is just a simple custom resource that I have created to give a demo to you.So now we have treatment.That's certainly one which will tell you how you used to handle resources **beforeJava7** and how it is going to change with Java seven.And along with the custom resource, if I try to execute this one, we can see the output that we areexpecting.So I just kept breakpoints in all the methods.Let me try to execute this class.As you can see with Java seven, I got the content loaded.I, I'm counting Line-by-line content of the text is Hello, how are you.Hope you like discourse now.Once the execution of the try block is complete **beforeJava7**, we had to close it explicitlyusing **finally** block time releasing the execution from here.

Now you can see it stopped with Java seven method with the similar kind of logic has been written,except that you don't have to close the resource and Java and will take care of it.So you can see the same similar output has been printed with the both the methods.But Java 7 Method is an enhanced method with the new feature. Now I'm releasing the breakpoint from this method, which will stop at the method where we are tryingto create a custom resource that we created.As you can see, I'll just read the data from that custom resource and it will just print reading data.

Now, I am going to put a break point here to make sure the JVM is calling close automatically.I'm releasing the breakpoint here.As you can see now, it has been invoked by the JVM to close after my block is executed.So in this way, we can improve the way how we deal with the resources inside our Java code by leveragingthis new feature, which according to.In Java seven, so **beforeJava7**, where we introduced our two closable interface, we have an interfacecalled Closable, which restricts that type of exception to only Iwerks.I'll tell you what I mean with this segment. If you go to the bar, Fareeda, this is one of the reasons.As you can see, it extends Reider and it implements closable interface.You can see there is a closed method here itself and this clause implements the newly created with closeable interface.But you may ask when we have already closable, which has the same syntax of closed matter, what isthe need of a new interface called auto closable?

The reason is the closable interface will restrict your closed method to throw only Iwerks option.But there might be scenarios you want to throw different exceptions like file for an exception or anygeneric exception.So due to that reason, a plausible new interface is introduced from one point seven and this methodsignature you can see it will allow you to draw.General exceptions are generic exceptions rather than restricting yourself with the Iwerks options thatwe have seen in the closable interface.We also said, like in its simplest form, private resources statement can have only try statement,but that doesn't mean we should not have catch in **finally** blocks.You may have another business logic that needs to be implemented inside your code, like handling the exception or making sure some other stuff you want to write in the file.So you are free to use catch block **finally** block even after the private resource statement. 

But it's just that if there is a scenario where you're strictly looking for closing the resource, then finally block itself is optional and catch block itself is optional.If anyone asks you in any of the interviews or any of the discussions, so you can probably say from Java seven, you don't have to write unnecessary.So that is a major difference that you can identify between the Java six and Java seven.As you can see, this is what we discussed.This is a sample implementation of private resource statement, which I have kept inside this deck.So that for your reference, in future, whenever you want to quickly revise what we discussed.So we also discussed what are we are declaring inside the private resource statements that is goingto be effective final and you can't be assigned a new value to that variable.And at the same time, deal, Java one point six try blocks should be followed by a catch block or finallyblock by.But with Java seven with this new feature is introduced, the final block and catch blocks are totallyoptional.You can still write the code with only try block alone.So with this, I'm hoping that you understand this new feature in depth.I would recommend you also try doing some coding exercise using this new feature so that you are comfortablewith this.So please remember in future, whenever you are dealing with resources and you have a Java version,which is from one point seven or ABO, please make sure to use private resource statements inside yourcode.Thank you.And see you in the next lecture by

[Code](https://github.com/ckgauro/java/blob/master/Java%207%20%26%20Java%208%20new%20features%20with%20Lambdas%20%26%20Streams/Java7Example/src/main/java/com/gauro/java7/TryWithResources.java)

-----------------


###  7. Suppressed Exceptions.md

#### JAVA 7 NEW FEATURES

##### SUPPRESSED EXCEPTIONS

-   Suppressed exceptions are the exceptions thrown in the code but were ignored somehow. One of the classic example is in the scenario’s ‘try-catch-finally’ block execution, where we received an exception in try block and again there is one more exception thrown due to which the super exception from try block will be ignored.

-   To support suppressed exceptions better handling, a new constructor and two new methods were added to the Throwable class (parent of Exception and Error classes) in JDK 7.
    -   Throwable.addSupressed(aThrowable);
    -   Throwable.getSupressed();//Returns Throwable[]
```java
package com.gauro.java7;

import util.CustomDirtyResource;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Chandra
 */
public class SupressedExceptions {
    private final static Logger LOGGER=Logger.getLogger(SupressedExceptions.class.getName());

    /**
     *
     * @param args
     */
    public static void main(String[] args)  {
        System.out.println("Prior Java 7====>");
        try {
            beforeJava7();
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, ex.getMessage());
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("With Java 7====>");
        try {
            withJava7();
        }catch(Exception ex){
            LOGGER.log(Level.SEVERE,ex.getMessage());
            final Throwable[] suppressedExceptions=ex.getSuppressed();
            final int numSuppressed=suppressedExceptions.length;
            if(numSuppressed>0){
                for(final Throwable exception:suppressedExceptions){
                    LOGGER.log(Level.SEVERE,exception.getMessage());
                }
            }
        }

    }
    /**
     * Sample implementation before Java 7
     *
     * @throws Exception
     */
    public static void beforeJava7() throws Exception {
        System.out.println("beforeJava7 Java 7 Example=======");
        CustomDirtyResource cr=null;
        try{
            cr=new CustomDirtyResource();
            cr.readFromResource();
        }finally {
            cr.close();
        }

    }

    /**
     * Sample implementation from Java 7
     * @throws Exception
     */
    public static void withJava7() throws Exception {
        System.out.println("With Java 7 Example=======");
        try (CustomDirtyResource cr = new CustomDirtyResource();) {
            cr.readFromResource();
        }
    }

}

```
Run the program
### Output
```java
Prior Java 7====>
beforeJava7 Java 7 Example=======
Mar 28, 2022 12:32:41 AM com.gauro.java7.SupressedExceptions main
SEVERE: OOPs . It is very bad to have a NUllPointerException
With Java 7====>
With Java 7 Example=======
Mar 28, 2022 12:32:42 AM com.gauro.java7.SupressedExceptions main
SEVERE: I am sorry. I don't have data available right now due to network issue!!!
Mar 28, 2022 12:32:42 AM com.gauro.java7.SupressedExceptions main
SEVERE: OOPs . It is very bad to have a NUllPointerException
```



In this lecture, let's try to understand one more exciting new feature that got introduced in Java seven, which is handling the suppressed exceptions. So suppressed exceptions are the exceptions thrown in the **code**, but were ignored somehow during the execution of your code through multiple methods, multiple catch blocks and **finally** blocks. One of the classic example that we can think of is think of a scenario.You have a three block catch block and **finally** block.There was an exception came inside your try block and eventually when you are executing your catch block or **finally** block, it resulted into another exception.So in such scenarios **beforeJava7**, there is no way for us to store and access what is a virtual super exception which caused the issue.

So to overcome these challenges, Java seven came up with a new excellent feature called Suppressed Exceptions.To support this, there are two methods are added to the strawberry class, which is a parent of all exceptions and errors that we have in Java.So those two methods are one is add suppressed and the other one is that gets suppressed.Whenever you want to add an exception, details you use add suppressed so that you don't lose the track of the original option that is being thrown while you are handling the the lawyer exception inside your code **finally** blocks.And obviously the second method which is gets suppressed, will give you the list of suppressed exceptions so that you can use them for better logging and debugging purposes.

Now, let's try to understand this more by trying it in the coding exercise for the same.I'm going to the program that I have written.So now I'm into the class where I have to turn to represent this new feature, the class name is SuppressedExceptions. And before doing what we have written inside this class, let me talk about this **CustomDirtyResource** that I have written.So to simulate the scenario where a user is getting an exception in try Block, followed by another exception in the final blog, I have created this **CustomDirtyResource** where now some user call thismethod read from resource inside the try blog.
```java
package util;

/**
 * @author Chandra
 */
public class CustomDirtyResource implements AutoCloseable{
    @Override
    public void close() throws Exception{
      //  System.out.println("OOPs . It is very bad to have a NUllPointerException");
        throw new NullPointerException("OOPs . It is very bad to have a NUllPointerException");

    }
    public void readFromResource(){
        throw new RuntimeException("I am sorry. I don't have data available right now due to network issue!!!");
    }
}
```

It will draw a runtime exception saying that right now I can't get the data from the resource becausethere was a network issue next one.This exception is thrown inside the try blog.The final blog will call this close matter before seven.But even from Java seven, when you use private resource feature, the Java will call this close method.Whether you're using Java seven or **beforeJava7**, you will get another pointer exception saying that an eloquent option is thrown and it's very bad.So this way we are into a scenario where we are getting multiple exceptions during a code execution.Now let's try to go to the suppression exception class here to help our understanding I have createdto try blocks.One is written **beforeJava7** and other one with the Java seven.So if you go and see **beforeJava7**, I'm just trying to create the reference to a custom that datasource,which is a CPA, and since **beforeJava7**, we can't use private resource new feature I had to create explicitly inside that block.And when I call this route from resource method, I'll get the runtime exception followed by another operation inside closed method, which is null pointer.And obviously, since there is no catch block here, it will be drawn to the main method.And inside this code there is a longer statement to log the exception that created the issue.But the problem here is this logger will log the **NullPointerException**, which is the most recent exception,but it will lose the track of the Woods exception which caused the issue, which is the network runtimeexception. But with Java seven, there are ways to identify them and give them to the user for better logging and debugging purposes.

Let's try to understand what is inside with Java seven.So as you can see here from Java seven, you can use private resource statement.That's why I'm using private resource without **finally** block to **finally** block is not there that we will call the closed method, which will eventually create null exception. And since there is no catch block, the exceptions will be thrown to the main method.Here you can see the difference between what we have **beforeJava7** and from Java seven.So from Java seven.When you logged the exception, the logical exception will be given to the user, which is the network.So that makes sense, right? Because the user has to know what is the root exception, which is the network extraction, which was another exception called **NullPointerException**.So that's where you were an exception.Object will always hold the original exception and all the subsequent exceptions will be present inthe form of suppressed exceptions.So that's where we have it gets suppressed.A matter which is introduced in Java seven.Using that, we are calling all the suppressed exceptions.And if we loop one by one, you will get null pointerexception also.

So with these details, the developer can easily debug the personal issue and he can also know or giventhat I'm getting a network exception inside microblog, I'm also getting an Alpine Dexatrim in the finalblog and he will make a fix for that, not the product production.So this can help developer to do his job more effectively since we are providing more details to him through logging.But you may ask me, like we are not even adding anything using either suppression method, which is present in the.But then how come all these exceptions are present inside the suppressed exception?But get here the beauties. Whenever we use try resource that Java will take care of adding all the recent exceptions to the suppressed.But if we have a custom scenario where you have written your own custom core in that scenario as a developer,it's your responsibility to call the AI a separate matter and add them into the suppressed applicationso that when the in the super matter. So please remember, these two methods is introduced in Java seven.

-   Throwable.addSupressed(aThrowable);
-   Throwable.getSupressed();//Returns Throwable[]

As you can see, **addSupressed** is a method which will accept the exception as a parameter and add them to the list of getSupressed. Exceptions, and it is introduce since one point seven, and at the same time, we have one more method,which is get suppressed again, it is also from one point seven.So get suppressed, will return the empty if there are no suppressed exceptions, otherwise it will return whatever is present inside the suppressed exceptions are. So now we have it in detail. Walkthrough of the **code**.Let's try to execute this call for the same.I am just keeping Breakpoint in the catch block of **beforeJava7** and inside this methods, alongwith the breakpoint in the catch block of Java seven matter, 

I'm starting debugging of the code.As you can see now, I am into the before Java seven letter and when I call this method, I'll get the network exception.And now when the developer is calling the closed method, he will get another exception, call one exception and both of them will be thrown to the main method.But as you can see, when logic, surprisingly, you'll get the **NullPointerException** detail, but not the network exception, which means before Java seven, we always lose the track of the awards anelection because the issue unlogged the most recent exception.So I'm just clearing the console now with Java seven. Let's try to understand how things got changed.So again here, when I and calling the read from Resource, I will get an runtime exception.And at the same time, since we will call the closed method, it will also get an exception.Releasing the breakpoint will land us inside the cache block of the Java seven method.As you can see now, when I logged an exception that I received here you can absorb, I got the words in an exception, which is I don't have data available right now due to network. Now, how about the null point?So for the same as we discussed, we had to get those details from the list of get suppressed.Now, the get suppressed array has one exception.So when you log it, you can see that exceptional.So it is null point, but exception.So this way, developer has more power to debug the runtime exceptions.So my sincere request is if we are using Java seven or above please leaverage, these two methods aresuppressed and get suppressed to make your life easy.Whenever we get runtime exceptions in higher environments like production, though, it seems like only two methods has been added to the trouble.But these two methods use a lot of power to the developer to make his job more effectively and productively.Thank you and see you in the next lecture by.


###  8. **Catching Multiple Exceptions** using a single catch block.md

-   Before Java 7, suppose if you have the same action need to be performed in the case of different RuntimeException exceptions like NullPointerException & ArrayIndexOutOfBoundsException we will forced to write multiple catch blocks like below,
```java
  private static void beforeJava7() {
       // int arr[]={1,2,3,4};
        int arr[]=null;
        try{
            for(int i=0;i<arr.length+1;i++){
                System.out.println(arr[i]);
            }
        }catch (NullPointerException nex){
            LOGGER.log(Level.SEVERE,nex.toString());
        }catch (ArrayIndexOutOfBoundsException aioex){
            LOGGER.log(Level.SEVERE,aioex.toString());
        }
    }
```
-   To reduce the code duplication in the scenarios where we have a common action/business logic need to be performed for different run time exceptions we can use a single catch block with multiple exceptions separated by a | operator as shown below,
```java
 private static void withJava7() {
       // int arr[]={1,2,3,4};
        int arr[]=null;
        try{
            for(int i=0;i<arr.length+1;i++){
                System.out.println(arr[i]);
            }
        }catch (NullPointerException | ArrayIndexOutOfBoundsException nex){
           // nex.addSuppressed(new Throwable("Data issue"));
            LOGGER.log(Level.SEVERE,nex.toString());
        }
    }

```
-   When you catch multiple exceptions, the exception variable is implicitly final. So, you cannot assign a new value to ex in the body of the catch clause

### Example
```java

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Chandra
 */
public class CatchingMultipleExceptions {
    private final static Logger LOGGER=java.util.logging.Logger.getLogger(CatchingMultipleExceptions.class.getName());

    /**
     * 
     * @param args
     */
    public static void main(String[] args) {
        beforeJava7();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("With Java 7====>");
        withJava7();
        
    }

    /**
     * Sample implementation before Java 7
     *
     */
    private static void beforeJava7() {
       // int arr[]={1,2,3,4};
        int arr[]=null;
        try{
            for(int i=0;i<arr.length+1;i++){
                System.out.println(arr[i]);
            }
        }catch (NullPointerException nex){
            LOGGER.log(Level.SEVERE,nex.toString());
        }catch (ArrayIndexOutOfBoundsException aioex){
            LOGGER.log(Level.SEVERE,aioex.toString());
        }
    }

    /**
     * Sample implementation from Java 7
     *
     */
    private static void withJava7() {
       // int arr[]={1,2,3,4};
        int arr[]=null;
        try{
            for(int i=0;i<arr.length+1;i++){
                System.out.println(arr[i]);
            }
        }catch (NullPointerException | ArrayIndexOutOfBoundsException nex){
           // nex.addSuppressed(new Throwable("Data issue"));
            LOGGER.log(Level.SEVERE,nex.toString());
        }
    }


}
```
Run this program
### Result
```txt
Mar 29, 2022 3:42:55 AM com.gauro.java7.CatchingMultipleExceptions beforeJava7
SEVERE: java.lang.NullPointerException
With Java 7====>
Mar 29, 2022 3:42:57 AM com.gauro.java7.CatchingMultipleExceptions withJava7
SEVERE: java.lang.NullPointerException

Process finished with exit code 0
```


Now, in this lecture, let's try to understand another feature which got introduced in Java seven,which is **Catching Multiple Exceptions**, using a single catch block before Java seven.Suppose if you have a scenario where you have the same business logic to be executed for multiple exceptions,still, you will ended up writing multiple catch blocks to handle all these exceptions.As you can see on the presentation, I have a matter which can throw an exception and **ArrayIndexOutOfBoundsException**.And for both these exceptions, my business logic is simple, like catching that exception and logging the details into the larger file.But I still ended up catching these two different exceptions with the two different catch logs.And there is a redundancy of business logic, the same business logic that is being executed in both the catch block.

So to avoid these kind of issues and to help developers to reduce the redundancy in the core Java seven introduce a new feature called **Catching Multiple Exceptions** using a single catch block.The method that we have discussed previously can be rewritten using a single catch block where you are catching both **NullPointerException** and **ArrayIndexOutOfBoundsException**.But please make sure that there is a vertical line operator in between exceptions that we are tryingto handle.Again, there is no limit that we can handle.Only two exceptions.You can handle any number of exceptions as long as you are separating them with the vertical line operator that I am showing here in the presentation.

So now this **code** perfectly makes sense since these two exceptions have a same business logic to be executed.I have a single catch block, but this catch block can handle multiple exceptions now, which is **NullPointerException** and **ArrayIndexOutOfBoundsException**.You may ask me a question.Why can't you simply catch the exception, which is a super class of these two exceptions?Yeah, that is possible.But if we have a specific scenario where you need to handle some kind of exception, but all other exceptions you need to throw to the super method, then in such scenarios we can't always use the generic exception to catch all kinds of exceptions.And one more important point that we need to be aware is you can see there is a single variable for all exceptions that you are creating inside catchable.So we have two different exceptions.Both of them are being represented using the single variable colleagues.And since this is being used by both these exceptions as a reference, you can reassign this variable inside catch block.

That means it is implicitly final one.And any resentment that you try to do for this will result in two compilation error.Now we have a clear understanding on catching, multiple exceptions, using a single catch block.Let's try to go to the **code** and see how we can implement this new feature inside our program to representand how we can leverage this new feature.

I created a new class called **CatchingMultipleExceptions**.As you can see, there are two methods inside the main method.One is **beforeJava7** and other one is viceversa inside **beforeJava7**. In order to catch **NullPointerException**  and **ArrayIndexOutOfBoundsException** where we have a similar logic needs to be performed.But you still ended up writing multiple catch blocks because before Java seven, this feature is not available.Now with Java seven, you can just write a single catch block where all kinds of exceptions which have similar business logic can be separated with this operator, as I said to, is not the only limit.You can write any number of exceptions and you can handle them.Like if you see now I'll just say exceptionals what that means for all these three kind of exceptions.This method will catch and do the same logic that I have written inside the catchable.As I also said previously, you can't reassign the preference of those objects to another exceptioninside Cash-Flow, because that will create confusion to the compiler.Due to that reason, you'll get a compilation error saying that the parameter of multicast block cannotbe assigned.So that's right.Please remember about this.Never try to we assign that variable to another class or another exception.

So now we have the code really to simulate the exception.I just updated the length inside the for loop by incrementing plus one.So since the loop three.But I'm still saying to my follow that my loop form.So when we try to access the fourth element, you will get the **ArrayIndexOutOfBoundsException** in the both methods.So there is difference on how we handle the catalog's by leveraging the new feature in both these methods, but the way the **code** will execute and the results will never change.That means the outcome of the program is not going to affect this feature, is just to reduce the redundancy inside or let me try to start this class insert debug mode.As you can see, both methods through the same exception, **ArrayIndexOutOfBoundsException**.And there is no change in the way the program runs it, just that this new feature will help us to reduce that redundancy inside our code with this.I'm hoping you're clear about this new feature.


###  9. Rethrowing exceptions with more inclusive type checking.md

##### RETHROWING EXCEPTIONS WITH MORE INCLUSIVE TYPE CHECKING
-   The Java SE 7 compiler performs more precise analysis of rethrown exceptions than earlier releases of Java SE. This enables you to specify more specific exception types in the throws clause of a method declaration.
-   Consider the below example,
```java
static class FirstException extends Exception{}
static class SecondException extends  Exception{}
 /**
     * Sample implementation before Java 7
     * @param exceptionName
     * @throws Exception
     */

    private static void beforeJava7(String exceptionName) throws Exception{
        try{
            if(exceptionName.equals("First")){
                throw new FirstException();
            }else{
                throw new SecondException();
            }
        }catch (Exception e){
            throw e;
        }
    }


```    
-   This examples' try block could throw either FirstException or SecondException. Suppose you want to specify these exception types in the throws clause of the beforeJava7 method declaration. In releases prior to Java SE 7, you cannot do so. Because the exception parameter of the catch clause, e, is type Exception, and the catch block rethrows the exception parameter e, you can only specify the exception type Exception in the throws clause of the beforeJava7 method declaration.

-   However, in Java SE 7, you can specify the exception types FirstException and SecondException in the throws clause in the rethrowException method declaration. The Java SE 7 compiler can determine that the exception thrown by the statement throw e must have come from the try block, and the only exceptions thrown by the try block can be FirstException and SecondException. Even though the exception parameter of the catch clause, e, is type Exception, the compiler can determine that it is an instance of either FirstException or SecondException.

-   Code snipper with Java 7 new feature,
```java
    static class FirstException extends Exception{}
    static class SecondException extends  Exception{}
 /**
     * Sample implementation after Java 7
     * @param exceptionName
     * @throws SecondException
     * @throws FirstException
     */

    private static void withJava7(String exceptionName) throws SecondException, FirstException {
        try{
            if(exceptionName.equals("First")){
                throw new FirstException();
            }else{
                throw new SecondException();
            }
        }catch (Exception e){
            throw e;
        }
    }

```


```java
package com.gauro.java7;

/**
 * @author Chandra
 */
public class RethrowExceptions {
    public static void main(String[] args) throws Exception {
       // beforeJava7("First");
        withJava7("FIrst");
    }

    private static void beforeJava7(String exceptionName) throws Exception{
        try{
            if(exceptionName.equals("First")){
                throw new FirstException();
            }else{
                throw new SecondException();
            }
        }catch (Exception e){
            throw e;
        }
    }

    private static void withJava7(String exceptionName) throws SecondException, FirstException {
        try{
            if(exceptionName.equals("First")){
                throw new FirstException();
            }else{
                throw new SecondException();
            }
        }catch (Exception e){
            throw e;
        }
    }



    static class FirstException extends Exception{}
    static class SecondException extends  Exception{}
}
```

Run the program
### RESULTS:
```txt
Exception in thread "main" com.gauro.java7.RethrowExceptions$SecondException
	at com.gauro.java7.RethrowExceptions.withJava7(RethrowExceptions.java:29)
	at com.gauro.java7.RethrowExceptions.main(RethrowExceptions.java:9)

Process finished with exit code 1
```


In this election, let's try to understand another feature that got introduced by Java seven, which can help us in handling exceptions in a more better manner.So this feature called rethrowing exception with more inclusive by checking loop.Very hard and difficult.I know.But let me clarify you about this feature in detail.So think of a scenario as a showing in this presentation.You have two exception, which is **FirstException** and other one is a **SecondException**.The FirstException extends the the superclass, which is exception, as you can see in the before Java, seven , if there is an exception comes we are throwing that to catch block. And since this **FirstException** and **SecondException**, they both extending exception.Obviously you can mention catch-Flow with the exception itself rather than **FirstException** and **SecondException**.

But the problem here is, since you are catching the exception with the class type as exception, you can only trust with the class exception.As a developer, I know that this method, it can throw **FirstException** than our **SecondException**.Before Java seven.The compiler will not allow me to mention those exceptions inside brackets's because it will accept whatever I mentioned inside the cache block.The same class type has to be present.It is not smart enough to identify what is being thrown from the try block and accept inside the trust.It is always relying on the catch block to accept the same class type inside the try.
```java
   /**
     * Sample implementation before Java 7
     * @param exceptionName
     * @throws Exception
     */

    private static void beforeJava7(String exceptionName) throws Exception{
        try{
            if(exceptionName.equals("First")){
                throw new FirstException();
            }else{
                throw new SecondException();
            }
        }catch (Exception e){
            throw e;
        }
    }
```    
So since there is a chance of improvement here, Java seven compiler has been enhanced to detect these kind of scenarios and accept **FirstException** and **SecondException** details inside try declaration to your catch block having exception class.Let's try to see how it is in Java seven.So the same code snippet can be rewritten using Java seven.As you can see, though, I'm handling the exceptions, using exception class type inside my catch blockand I am throwing the same exception value, but still in my method signature after TROs, my compilerthis time will accept **FirstException** and **SecondException** to mention them.This is possible from Java seven.
```java
    /**
     * Sample implementation after Java 7
     * @param exceptionName
     * @throws SecondException
     * @throws FirstException
     */

    private static void withJava7(String exceptionName) throws SecondException, FirstException {
        try{
            if(exceptionName.equals("First")){
                throw new FirstException();
            }else{
                throw new SecondException();
            }
        }catch (Exception e){
            throw e;
        }
    }

```

The compiler is smart enough to go and analyze my prior block and get this **FirstException**and **SecondExceptions** are being thrown from the try block and I should accept them in catch.You can always ask me what is the harm of mentioning only try exception?Why you want to mention first and **SecondException**?The reason is sometimes if you mention them inside or method signature, the developer who are usingyour yapper are method he can understand or get these kind of possible exceptions that may come fromthis method.Otherwise, if you just simply mention exception, he or she may not have full detail what kind of exceptionthat this method is going to draw.Now let's try to go to the **code** and try to analyze this in detail.To demonstrate this, I have created a class called Retros Exception.As usual, we have two methods before July seven and with Java seven, before Java seven, as I wasmentioning, whatever percent inside the catch block, the same value we can mention here.If you mention **FirstException** and **SecondException** in code block, your compiler is not smart enough to detect them so it will throw and completion error, saying the only exception is a lower after thetruce.Whereas with the Java seven, the compiler is smart enough to detect what is being thrown from the try block to your catch block is catching the super type of exception of type exception type.
It will still allow **FirstException** and **SecondException**s to be thrown from the catch block and youcan also mention them after true statement.So this way the developers, whoever is using your class and method, will have more details aroundwhat kind of exceptions will this matter is going to throw.Now let's try to run this class.So I'm going to start in debug more, as you can see where the value is first.I'm just throwing the **FirstException** and just running it.And you can see an exception is drawn by the catch block of before Java seven and it will never reachwith the Java seven because we don't have any catch around before Java seven.Now let me try to come in this and this time I will rerun the class again.And you can see the similar kind of functionality is going to happen even with Java, so that the onlyadvantage here is we are making sure our methods are more readable in terms of what kind of exceptionsthey're being thrown.So now I'm assuming you got some basic understanding of what is this redrawing exceptions with more inclusive type checking.So in future, whenever you are using Java seven or ABO versions, please make sure if you have anysuch type of scenarios, feel free to mention whatever some exceptions that your block is going to throwafter your true statement.So this will make your code more readable and understandable by developers.


###  10. Easier Exception handling for reflective methods.md


Now, let's try to discuss another new feature which got introduced in Java seven, which is ObjectsClass, a brand new class, which is introducing Java seven itself.So don't confuse with the object class that we have, which is a super class of each class that we haveinside Java.So this is a plural form of it.It's objects.And this package is different.Instead of Java, that langue, it is Java dot util.So do not confuse with the other object that we have.So this is a plural form of it which presents inside the package Java that you do.So this objects class is a utility class which is created in Java seven, especially to have staticmethods, utility static methods that you may need while operating on objects.These methods include doing Nylex computing, hoshko, comparing different objects, returning a stringform of an object.Instead of you writing your own to string method, you can rely on the utility method available insidethis object's class.So that's one of the common scenario that you can think of.Most importantly, these objects class has introduced two new methods for MultiChoice.Both of them will draw Nalpas attraction if the given object is null.And at the same time, you can also customize your exception with whatever message you want to drawby providing inside your constructor.As you can see, there are two methods.One is required Nundle and you object to it, and when the object is null, it will draw null pointerexception.Otherwise it will continue to flow to execute and other methods and quite normal where it will acceptone more extra parameter which is matches itself.So this is a customizes that you can pass, which can be used when null point option is being loved.And it may look very weird and surprising for few developers.Why should I use these methods if the object anyway is null?My code will turn null pointer.But please remember, these new methods will bring a lot of control to behavior and easier debugging.When I say controlled behavior, your code readability will increase and at the same time it will alsohelp for easier debugging inside your code, especially using these methods.You can always validate whatever method parameters are constructor parameters that you have receivedbefore starting.You are hundreds of lines of code inside your methods.So that way you can avoid a lot of if conditions.And if there is a scenario where if the given object is null, I should not execute all further linesof code.I should straightaway throw an exception to the color.Then in such scenarios, these two methods will become very handy to the developers.If you go and see Java Framework Code, you can see a lot of places.These two methods are used by the Java developers team itself, which shows how useful these two methodsare.Now we have it understanding what is this object's class which is introducing Java seven.Let's try to go and see inside the call about this new class.As you can see, I came to a class called Requirement on here.First, let me open up and show you the objects class.As you can see here it is introducing one point seven and it has many static methods which will helpyou while dealing with objects like equals beep equals hash code hash value to string Kampai.And at the same time we have required normal methods at the end.Let's try to see the demo of required normal.As you can see, I have created a person object which is of type null and I'm calling a method processperson details with the null object of person.And my expectation here is whenever I receive another person for this matter, I should straightawaydraw an eloquent exception to the caller and should not proceed to the four lines inside the methodso that where I will use one of the Requena method by using objects, class and past the object thatI want to validate null check.And this is the customizes that I want to draw in the case of multipoint exception.So since this is the first line, my null will happen here and when the object is null, it will drawan Alpine transcription along with this message, which is my custom message, and it will not executethe four other lines in the method.So let me execute this.You will get another point reception, as you can see, and getting an eloquent exception.So this way you will have a better control on your code and at the same time better readability andbetter debugging also possible.With this new methods, again, these are simple brand new class that is introducing Java seven, pleasemake sure to use this recording on wherever is applicable inside your code and don't try to string methodinside your objects.You can always use a two string method available inside this utility class, which is objects classintroducing Java seven.Thank you.And see you in the next video by.
###  11. Objects Class & Null Checks .md
.md
Now, let's try to understand a new method has been introducing you are order from Java seven.The purpose of it is usually using you are a class in order.You can lower classes and resources from it.You are a are you Warrell, which is referring to your directory, a file.As I was showing in that slide, you can see here I can talk to you also pointing to two different jobs.Once I had those URLs I can load, the class is present inside those jobs using you are a class loaderand once I had the loader using law class, I can load whatever class I want during runtime.But the problem with this code is it will create a lot of memory resource leaks due to this Java sevenonwards.We have a close method introduce for you all class in order by implementing our top closable interface.If we can recall our previous discussion about private resource statement, any interface or any classthat implements auto closable will get a method called close that will be called by JVM automaticallywhenever you try to use private resource statement.So due to that reason, the code that we discussed in the upper part of the slide can be rewritten usingprivate resource statement, as I was showing here.So this will make sure the closing method will be called by the JVM whenever you try to load the classesand eventually will avoid any resource leaks or memory leaks inside your application.Again, this is very simple new method that has been introduced inside.You are a class, right?So with this, I'm assuming you're clear about it.Just make sure whenever you're trying to use you are a class of insider applications.Please try to use this class with private resource statement so that the class method will be calledby your JVM automatically and thus you will avoid any kind of resource leaks.Come outside of it..
###  12. Close method inside URLClassLoader.md
We'll discuss about what is he pollution in some time.So due to that reason, whenever you use that ax inside your and constructors, your compiler will throwyour compilation warning, saying that it may cause he pollution.And again, please me, just a warning, but not an error.So to make our methods and constructors safe and to suppress this warning, we can use at the rate severalannotation on top of our methods.So whenever I use this annotation on top of my maternal constructor's, I'm just certifying, OK, Imake sure that there is no code is written inside this method which will cause he pollution addressif that annotation can be applied on final methods, static methods and constructors.The reason that we can't write on top of public method is this annotation cannot be used on any warrelated methods.Like if I have a public method, anyone can extend my class and they can go over it.And when they were read the meaning of safe that I will lose, like in my parent class, I might havetaken all measures to not cause he pollution.And I put that annotation on top of it.But tomorrow some other developer comes and extends my class and he won't write it whatever method Ihave written.And he ended up creating a heap pollution inside the new method that he has written, then the meaningof that out will lose.Due to that reason, save dogs can only apply to the methods and constructors where we can't overridesince we can't go our final method static methods constructors.Due to that reason, severance is allowed on top of them.And you can also ask.Private matters also cannot be related.So due to that reason from Java nine, this annotation is also allowed on top of private instance matter.But in Java seven, these are allowed only on top of final metastatic contents and constructors.So now we have a basic understanding about this annotation and water acts.Let's try to go to the code and understand about them in detail for the same.I just came to the eclipse.First, let's try to understand what is var ok.What is variable argument to this feature is introducing Java file one point five.I still see many developers.They are not able to understand this due to that reason.I just wanted to spend one minute on this feature.As you can see here, there is a method called sum and it will accept the parameters nums of type int.So this three extra dots that you mentioned after in will make this nums variable as variable args,which means this method can accept any number of parameters as input as long as they are of type int.So I can call this some method with only one parameter or two or three, whatever I want.So due to that reason you can see here first I'm calling with one second time, I'm calling with onecomma to the third time, I'm calling with three parameters.So this will help us to write less code.If I don't have this feature, which is introducing Java onepoint file.In order to achieve this scenario, I have to write three methods which are overloaded versions of eachother, so that where this feature is one of the great feature in Java, which will save a lot of methodsbeing duplicated just for the sake of extra parameters that it want to accept.So now we are clear about what is safe Barrack's.Now let's try to on.Stan, what is he, pollution?Whenever we try to use the same acts to think of a scenario, I have three lists declared and each listhas a one word inside them.And I'm calling from the method inside this glass with these three list.Since there are three parameters, I can write a print method which acts of three parameters or I canuse that acts as shown here, which indicates this method can accept any number of lists of type string.And due to that reason, now I'm passing three lists of type string, as you can see here.The problem is first, I'm taking all this message into a object so there is no wrong here.A string also can be converted into an object at the end of the string is an object.So that's why Compiler is not complaining.Now, I will create one more list this time of type integer and I will add a new value int inside it.Now what I will do is I will try to assign this new impulse to the object array at the Detroit indexand compiler can't complain anything because integer also an object and string Altun object.Now the real problem is when I tried to access the first element inside my messages and tried to convertinto a string, I will get a class cast exception.The reason is the first element here is integer, but if I try to get it as a string, I'll get a classexception.And Compiler also is not complaining anything during compilation time because all this code is verytricky because we are using generic object type as Arrietty.So here a heap is getting polluted.That means the heap is having strings and integers, which is a mix which will eventually create a classcast exception.So in such scenario, since there is a possibility of getting key polluters, usually your compilerwill throw and warning, saying that potential pollution via Radack's barometer's messages.So whenever you use that axe with the Generex, you will get this warning.So as a developer, what I can do is I can remove all this code, which can create key pollution andput the annotation at the rate Cevat acts to indicate my method is Supersaver and Compiler should notthrow at any warning, but let me remove it and give you a demo of it.So I'm running a debug more.You can see here I'm getting a class Casodex option, as we discussed.Now what I will do is I will remove all this dirty code I have inside my method and put a direct safe.Radack's and my borning also will disappear.There is no need of some order here.I'm removing it.So now my method is super safe.There is no chance of class ghast exceptionality pollution.That's why I'm putting this annotation so that the compiler and for other developers who are want touse my method, they have my assurance in terms of that my method will not create any pollution.So now if I run the same Java class, I got the output, which is the first element inside my list,which is easy.So this is the purpose of annotation.Aderet, save that X with this.Assuming you are very clear about what is a valid acts inside Java, which is what Ginelli introducesin one point five, and what is the need of new annotation order itself that X, which is introducedin one point seven.Thank you.And see you in the next lecture by.
###  13. @SafeVarargs Annotation .md
In this video, let's try to understand one more exciting feature that caught introducing Java sevendeleted files and directories.So Java seven brought a series of major enhancements which will help developers while doing operationsrelated to files like reading, copying, deleting.So all files are IWA operations that we do from a Java code is going to change to a great extent fromJava seven.The reason is Java team refreshed and better and I will package which orginally introducing Java onepoint four.Again, please remember there are two Iowa related packages in Java.One is Java Dot AWA, which represents Java input output package and another package is an AWA, whichindicates new AWOO and stands for new and few people call it as non blocking a world.So whatever we call the end for a new or non blocking.So inside this and I will package new interfaces and classes are created in Java, seven like parties,one interface parts and files.So all these new classes and interface are created to make development life easy while dealing withfiles and I will operations.So these new classes and interfaces like body parts and files can be used to overcome the limitationsthat we have with the file class inside.I will package if you really ask me, like under what scenario I have to use, I will honor what scenario,how to use and I will package related interfaces and classes.So before jumping on to that question, I just wanted to clarify the differences between a war and Nivoon a high level.One of the major difference that between both of them is I will use a blocking operation.So whenever you try to do some reading and writing operations using Avio packages, it will block yourentire thread, which is again a performance issue for some applications.And at the same time, if you take and I will package it is non blocking in nature, which means wheneveryou try to do reading and writing operations on files, you will try.It won't be blocked.It will just give the operation responsibility to one of the socket channel and it will continue totake care of other operations so that in this way we are trying to leverage all the processes that wehave inside our CPU's, our GPU.So one example we can take where we should use a package related classes and interface is suppose ifwe want to try to transfer a very big file like which is in GBIF, IGB 10 GB.In that scenario, it always preferred to use Avio package so that you are giving a dedicated trackto that operation and you are blocking that operation because obviously when you're dealing with highervolume of data, it has to be in blocking NAGE.And another classic example where we can use and a whole package is suppose if you are building a chartbased applications where millions of connections, millions of socket channels are available and youwill only transfer very light weight of data, like only text messages like, hi, hello, how are you?So for such applications we can always go to and I will package because it is non blocking in natureand it can handle multiple corrections at the same time since it needs less threats to operate withmore connections.And one more difference is I will package related interfaces and classes work more with the streams,whereas and they will package related classes and interfaces, they will work more on buffer.The difference between stream and buffer ease using stream.You can read the data, but you can move back and forward.You can only read whatever data available at that point of time.That's why we carlita's live streaming.When someone tried to do like we called live streaming and buffering means whenever there is a scenariowhere you should allow the user to move back and forward, that way we use buffering where the datawill be loaded, are saved in a cache memory.Like if I'm seeing a movie on a Netflix, I might be looking at a specific point of time.But if I try to press Maurois 10 seconds and backward 10 seconds, you can see you will get the resultimmediately because the boundaries data around the time will be providing the cache.Due to that, you will get results immediately, whereas.If I'm seeing a movie at the starting position around 15 minutes and if I am trying to jump directlyinto the 60 at the minute, then definitely it will take some time because my mobile will take sometime to buffer that data and show it to me.So that's a primary difference between stream and buffer.Since I will package is more in blocking nature.It needs lots of threats.Like if you go with them, I will package interfaces and classes for a chat based application.You will end up creating a lot of connections with a lot of threads which will degrade your performance.And at the same time, Java and I will package related classes and interfaces that can work with veryless threats because it's non blocking nature.But that's why it is more suited to the applications where we have to maintain a lot of connectionswith the less threats we will go with the narrow package related classes and interfaces.One of the major advancement happened in Java seven in terms of Eivor is the interaction of a part interface.So this is introduced to replace the Avio package file class, which will make developer life easy.A bot means usually it's a sequence of directress and it can have a file name also.Optionally, EPOP can be used to create both directories and files that we need.And at the same time we also have a plural form of bot, which is pods to create bot objects.So this is a utility class which has a gatemouth tag to create path objects out from a string valuethat you pass around you where you are a value that you pass to the government, that the advantagewith bots and part is it internally.Take care of the file separate.Like if you just go to the list of directories when it goes and end in part of the file, it automaticallyupends the whois specific file to pretend like you may have it in Linux and Unix, you'll have a separateparts operator compared to Windows.All those things it will handle internally based upon the operating system that it is running.So this is one of the major advantages that we have it bot and coming to the methods that got introducedin body parts and files.So these are the list of all the methods that got introduced in Java seven.Again, we will discuss the important ones in the coding exercise, but every method has a differentfunctionality that can help develop.Like if I want to get a root of my part, I can use Getrude if I want to check with the given part isan absolute part are related.Part I can use is absolute get filesystem can help me to understand better which operating system I'mworking.And at the same time we have many utility methods inside files which can help us in reading and writing,creating, deleting, moving, copying of all the data between files.So now we have a basic understanding of what got introduced in Java seven in terms of files and directories.In the next lecture, let's try to understand the coding exercise related to part parts and files.Thank you.And see you in the next RELU.
###  14. Enhancements related to Files & Directories.md
In the previous video we discussed about the new interfaces and class that got introduced in Java andI will package from Java seven and three important interface and classer body parts and files.First, let's try to discuss more about bots in the coding exercise that we have written to demo thecoding exercise.I just written a new class called Bots in Java seven, and there is a method built the part that I havecreated.So inside this method I try to use all the various important methods available inside bots and partto make Dolapo life easy and at the same time to demonstrate it.I also created a file to start under Java seven folder as I was showing here, and you can see the contentinside the text file is this is the one that I'm showing on the screen now.I kept a breakpoint here and starting the class in debug mode, as you can see, jettison utility methodinside parts which will accept a robot followed by any number of directories that we can pass.So using these parameters, it will give us a combined part based upon the file system that we are running.And at the same time, we also have another get method which will accept you are here.We are using the gate method which accepts string parameters, as you can see here, and passing threevalues to this matter.One is the home directory of my operating system, and this is this folder followed by the file hereafter I provided this input.As soon as I execute, you can see now I have an object and this is the entire part of it.And it's a combination of directress and the filenames.So once we have a path object, we have various methods inside it to understand the data on the partone such important matters to get the filename.So based upon the part, I can get the filename, which is that xactly so my party's Martynov.If I pass a part value target, it can tell me is there a file inside it.And if it is there, what is the **finally** the same.I'm printing out using the filename that closely you can see this is the file name next using part wecan also identify what is the current to file system.When I say current file system, whether we are using the windows are uniques are mank.So since I'm using Windows File system, it reinterred that one and every file system will have itsown parts operator.And we can also display that using get filesystem that gets operator.So this is the parts operator for Windows and inside, but usually out of folders and file names willbe maintained.An array like if you take this entire path.So this is positioned as a road and this is a zero position and this is at the first operation.So that way, if you want to know how many subparts we have inside, but this will give you that number.So Leaving wrote, the very first part that I have in my part is the Java seven, and that's where itwill try to print it.And the next value that I have inside my part is the file itself.So if you have a scenario where you want to identify the support, the details, you can always convertyour path into an array and play with the index numbers to identify what are some parts that we haveand what the file names that we have inside it are.If we want to know your support in the range of particular indexes, you can always use the support.Just like we use substring inside string.You can pass what is a starting index and what is the last index.As you can see inside our part C Java seven test see the root.So ignoring that the very first Sopot adroit location is Java seven, followed by text start at thefirst operation.So whenever you pass end index, usually it will take minus one and give the part till that value again.If you want to know your route path from a path you can use, Getrude and parent will tell you likeright now my path is still tested, not be like us showing this is my path and for this path.So this is the parenteral.So this five percent inside this pattern.And that way if you try to print get and it will bring that value here.And one more utility that we have is normalized.So some.When we try to deal with bad values in between, we will have some redundant information like Dardaror Slasher's, so all such duplicator redundant values can be removed using normalized methods likeyou can see here.I'm just trying to create a new path.But in between, I just kept one more dot, which is redundant now.So my redundant part is so this is the redundant part.As you can see, there is a dot in between.If I want to remove all that unnecessary, redundant values, I can just call normal's.And now if I bring that value, all those redundant values will be cleaned.Using Normal's and two you are is a utility method which can convert your part to an array value likethis is my part.If I try to convert this into an you are right.So this is my Yubari value.So usually we you you are a whenever we try to load using you are a that where we want to load a classbased upon that you are a bust and at the same time we have an absolute pot to convert a particularpart to an absolute pot since this is already an absolute pot.So there is nothing happening, it is just going to display the same value.And next, we also have a resolved matter which can be used to combine multiple pots like you can seehere.First, I build a partial pot which has only C Java seven.Next, I want to combine this partial pot with my text-based.So when I use Resul, I will get a combined pot, which is C Java seven text part B and to show youpartial pot is different and combined.The party's different partial pot has bottle Java seven only, whereas combined pot, which we willusing result method has a filename also that if you try to compare both of them, you will get falsiesin input.And that's why this statement is being printed in the council.So we discussed a lot inside.But what are different methods available?So I would request go ahead and explore all the methods available in pots and pot.And if we have a scenario where you're dealing with files, try to use this new classes and interfaceswhich got introduced in Java seven.Thank you.And in the next lecture, we can discuss about files by.
###  15. Coding exercise using Path & Paths.md
In this lecture, let's try to understand more about files by exploring a sample Java file, which itlays out the methods available inside of fights for the same, I have created a new class called Filesin Java seven, and it has a method called Working with files, as you can see first, and creatinga part, bypassing the same home directory, Java seven and Xactly.So I'll try to start this class in debug mode and I will try to show you what is happening at Line-by-line.So now I have a part.As we discussed previously, Files has a utility method called Read All Byte based upon it.But if I Passepartout value to this reader I'll buy it.I'll get the content of that file into an array of bytes and you can display that content on the console.So this is the content that we have in the file.Let me clear it next.We also have another utility method inside the files, which is read on lines where it will help youinstead of reading all the data at the time.And converting into about this utility method will give you a list of lines inside your file.And I just read the data again with the same rate or length.And if I try to reprint all those lines that I received, you can see the same content is being displayedon the console.I'm just clearing the console now.So to whatever content we have inside that file, I want to append new data.So in such scenarios, I have a new line that I want to write, which is How are you?And this time I can use a method called write and I can pass.What is the value of it and what is a new data that I want to pass and what is the operation that Iwant to perform?As you can see here, I'm saying happen.But you also have a lot of other values, like you can create a new file or append file.For now, we are just going to happen and that means it will try to append one more.How are you to my text?Like you can see I have only one.How are you right now if I run this line and you can go and check.You have one more.How are you open.So that's the purpose of right now.I'm creating one more new part with Java eight.Now, as you can see here, I don't have Java eight folder at all.If I want to create a folder directory, I can just call create directory bypassing the part.So I assume this line is executed.I will get a new folder called Java eight, similar to directory.We can also create a file using create file method.So to the previous path that we build, which is to reach our aid, I'm just creating another file calledof text, which will be empty one, as you can see here, that is created, but the content is empty.So now I build another part which can tear apart like siege, our extortive.So now I have a new file, but inside Java eight and at the same time I'm trying to load the existingdata from this part, which is inside Java seven folder.So what I'm trying to do is I want to copy the content from this Java, want to start being st2 to thisnew file that I'm going to create, which is Java Astarte so far to load together, we can also usenew input stream.So now I have that as a stream and using copy method, I can pass the what is the value that I wantto copy along with the new part, which is Astarte.So since I ran this code, you can see inside Java eight, there is a new file called to start directlywith the content what we have inside Java seven folder.Similarly, we have overloaded methods of copy.Also, like if I want to copy, I can also mention if there is already a file are contained, do youwant to replace or about the operation to such things?I can mention like here I was saying replace the existing one and the option is to copy the content.So.So as soon as I execute this line of code, you can see what our values present inside to start to reallymove and copy to that big stick which is previously empty.At last, if you want to believe the file, you can pass that part value and it will delete the file.So here and a new file part, we want to delete test dot text.So as soon as I do this, my desktop will disappear.But in the scenarios where you need a boolean value that the deletion is happened successfully or not,you can use the method delete FXE.That means this will delete only if the file is exit.Otherwise it will not.So since we already deleted.So this should give you a boolean value false, and that's what being printed here.So this way we have many utility methods available in files whether to read the data right there thatare creating temporary files, directories, files, copying, moving.So for all such operations, we have different methods inside files.Please explore them and try to build your own program, leveraging all these methods..
###  16. Coding exercise using Files .md
.md
In the last few lectures, we discussed a lot about the enhancements that happen inside, and I willpackage especially about the new class and interfaces that caught introducing Java seven now in thislecture.Let's try to discuss one more exciting feature that got introduced in Java seven, which is what Sari'sagain, this is a new interface that has been introduced in Java seven under the Java dot.And I would not file that package for the purpose of this.What services you might have is scenarios where you have to keep watching a particular directory orfile for any changes happening, maybe due to business requirements that you how like if you have abatch for a location, whenever someone drops a file into a safety folder, you want to trigger a badge.So in such scenarios, you may want to always keep pulling for that folder.And before Java seven, we used to have build this business logic using threads, which is very complicatedin nature.So to make life easy in Java seven, a new interface called What Service has been introduced.Using this new interface, you can handle scenarios like suppose if you have a file manager and a directory,you can restart the directory and the reward service and using what service you can monitor if thereare any additions, deletions, modification happening inside that directory.Usually we use what service to register for unwatchable object like watchable.Our object is like my directory or file.So all those kind of objects will become watchable.And if an object is watchable, then definitely we can restart that using what service?And whenever we restart, we get a watch key.So this is a key that we can use inside our program.And using that key, we can keep falling for any events happening under that watchable object.If there are any changes happening, we will get a signal and we can take those signals by keep callingall our tech methods.And once you are processing them, a consumer can reset the key, which really allows the key to bea signal and recording the further events.We can also use this in scenarios where we want to keep all our events happen inside a queue, and theconsumer can keep calling that queue for any events that are getting pushed into that queue.And when we're done processing that queue, we can call reset method available under Watsky to resetall those already processed.Even so, that again, the watchable and Watsky will give the fresh kind of events to our program.And these are the important methods and classes related to what service, as you can see inside whatservice, we have three methods.One is Paul, which will keep on pulling for the events and take is a method which will take the detailsof the events happen and close will **finally** will close that service and will not monitor any of thechanges unwatchable.That resistor is a method which will register our watchable objects with the watch service.And when we register, we get a watch key, which represents 80 for that particular watchable objectunder watch.We can always see whether the particular object is watchable.Using watchable method is valid to check whether the watch key is still valid and polygons we can useto poll for the new events and reset at, as we discussed, is used to reset the event and to startfresh and cancel will cancel the entire Watsky and that no further monitor will happen.And at last also mention what are the standard watch event counts, like what kind of events we usuallyend up using, what service we can monitor, any events related to creating of the file deleting ofthe file modification and Wuerffel.So these are the most common standard watch even guides that we can use from this.What service?So now we are clear on what is this, what service.Let's try to understand by discussing a Java program.So now I came to the eclipse.As you can see here, I created a new class called WhatsApp is in Java seven, and there is a matterdirectory.What service?So in this method, first I got the word service from my file system since I want to watch directoriesand files, definitely how to get the word service from the file system.Next, I have a pod.So this part is a representation of the directory in my file system, which is C followed by what servicefolder?And this is the folder that we are mentioning inside the pod.Now we have a pod and part is a watchable object.You can check by navigating to that part.And since it is extending watchable, which indicates any what service can have a monitor system usingwhat service inside the part that we are mentioning.So now we are clear path is a virtual object.So when I call pod that resistor I have to pass what is a what service followed by what kind of events.I want to register and watch for changes.So I am mentioning here the create, modify and delete.So all these three options, I want to be notified and there is a boolean I just created with the truevalue that the Boolean name is Paul.And once we have that service we have to call back in order to get the watch from it.So at this point of time, my what service will register the watchable object and I will azami watchkey to my program.So once I have a watch key, I just have a while loop, which will keep running till this boolean becomesfalse.Since it's true, it entered into this value and using that watch key, I'm pulling for the events thatare happening inside the part that I indicated.If there are any changes, I will get those events and I'm just printing here the list of events andevery time I'm just trying to reset my watch key so that I will get fresh events as well, which arehappening inside that direct.Again, this is a stand alone program.I have used a value, but if you have a correction scenario inside a Web application are actual batchesthat you are building, definitely you can have more control on this on how you want to monitor to Fano.Since we have a value, just assume this value will keep running and look for any changes happeninginside the directory called See what service.Now I will start this class in a debug mode and you can see there's nothing happening and there is athread running under the line.Now, what I will do is I'll go to this folder.What service?I'm just doing some operations, try to observe these operations that I'm trying to do.First, I created a new text document.Later on, I rename it to Hello.Once I renamed, I opened the file and modify it with the content high.Then I closed it and at last I deleted the.Now let's try to go to our program and see what is being displayed on the console.You can see in the console every event that we set out to monitor, especially in terms of create,delete, modify, is being monitored and the same is being displayed on the console.First, there is a creation to happen for the file new text document.Then since I tried to rename it first, it will delete the existing file and will create a new filewith the name Haloed.And at last I open the file and enter some content.That's why this is treated as entry modified and eventually towards the end I deleted that file.Due to that, my even taking this entry delete.So this way we can leverage what service and keep looking.What are changes happening under a watch object like path.So in future insider projects, if we have a scenario where you have to monitor a folder or a safetyprofile location, you can always leverage on this what service, which is introduced in Java seven.Thank you.And see you in the next lecture by.
###  17. WatchService.md
In this lecture, let's try to understand one of the new feature, which is introducing Java seven calledBinary Literals, as we know, a binary representation of a number consist of zeros and ones, becauseat the end of the day, whatever input that we give to our processors, they will get converted intozeros and ones, because that's the only format that our processors can understand tofor outside world.Inside our Java code, we use by short end and long to return to our decimal values are integer values.But at the end of the day, all this will get converted into binary format, which consists zeros andones.And in fact, in Java also, there are ways how to get a binary representation of a number, especiallyusing bitwise operators to handle the scenarios where we need to express a long or integer chart byteof a number in a binary number system.Java seven added a new feature called Binary Litoral.So if you have a binary representation of a number, if you add a zero, B in small letters are zero,b in capital letters at the starting of the No Java will take care of automatically converting thatbinary value into human readable values like in long byte and sharp.As you can see here, there is a binary representation of a number, which is seven.The binary representation of the number seven is triple one.So this is the triple one that we are talking.So this represent 2.0 to Power-One 2.0.So to part two is four to power.One is two and two.Zero is one.So four plus two plus one is seven.So we know because we calculated it manually.But if there is a scenario where you want to convert that value automatically, especially while youare programming for microprocessors in such scenarios, this new Litoral is going to become a saviorfor the developers.So here as a developer, I will just keep zero B as a prefix before this number of the binary representation.And when I try to display the value of the NUM using C.S, definitely my JVM did all the magic of converting that binary representation to integer representation.So let's try to see a program to understand it in more detail.Here I have written a class binary Latrell's, and as you can see, these are all the binary representationsof various number.Before all these numbers I just put the prefix zero, B and B can be in small letters are capital letters.If I take these numbers and try to print out them, I will get the actual decimal value of them withoutdoing anything.My JVM will take care of internal.But before Java seven, in order to achieve these, Delaporte has to rely on these parts in our partslong, all those methods that are available inside of wrapper objects.So they will take string input, which is a binary representation.And what is the radix number that you want to construct?Like these are two power or three power or four power.So you just have to pass that radix representation now instead of doing all those unleveraged pass inthe Alapatt can just add zero B as a prefix value and JVM will do all the magic for you.So let me keep a breakpoint here.I'm starting the program in debug mode now.I declare all the variables using binary litoral.The first one is a binary representation of seven.So if you try to display that, you will get the output at seven followed by the next one is one whichis a short number and at last one zero one and fail.And we also have one complicated number, which is a long and output is one eight nine one, which isthe representation of this number, not only displaying or converting the data, we can also performlogical operations and automatic operations using these values like you can see here, we know and thenumber is a representation of fire and we declare the number qualified.If we try to compare both of them, the output will be true because they're both in the same decimalvalue.And at the same time, if I take the long binary representation and multiply by two, I will get outputin decimal representation.So let's try to run these two statements.As you can see, we'll get the output as true.And next we get the multiplied value of this number and we have not done any logic to convert that intoa decimal number followed by multiplication.So everything is being taken care of by the zero.So this way we can make our lives easy whenever we are dealing with the binary representation of a number,especially if you are a programmer who is concentrating more on coding Java for microprocessors, thenthis is going to be a useful feature for you.And again, this is just a simple feature that got introduce nothing super complex.You just have to add zero B as a prefix before the binary printed add value and JVM will automaticallyconvert into whatever decimal value that you want, like a by Chautara in the long format.So with this, I'm hoping you're clear about this new feature.Thank you.And see you in the next lecture by.
###  18. Binary Literals.md
Now, let's try to discuss the enhancements happen to our favorite feature statement inside Java seven.We are not what is the purpose of switch statement?So a switch statement will allow you to how different the case is and the logic that needs to be executedfor each case.And we can also associate the default case for the switch.The main advantage of switch statement is it will improve repeatability and reduce the unnecessary blocksthat you have to write using if blogs and LGF and ELT's blogs.And this is what the history about the switch statement.But the problem is still before Java seven.In order to use a switch statement as an input to your switches blogs, you have to pass either enumtime or in numbers.And this is a very annoying for many developers, forcing them to create unnecessary enum classes andat the same time they have to go with the intent types only if the creating of enum types is not possible.So there is a strong demand from the developer community to allow the strings also as an input for thisfeature expression's.So due to that reason in Java seven, this change has been introduced where for this switch expressions,you can pass string object also as an input.Again, whatever path you as an input, that string value is a case.InSitu and null objects are not allowed.If you pass a string which is declared to null, you will get another pointer exception.So please do note that point and please do remember only string objects are allowed, but not all otherobjects like your own custom.Bojo objects are not allowed.So this is one of the sample representation where inside your switch expressions the input is a stringand inside your case statements you can pass the directly the whatever string value that you want insteadof only passing enum and into types that was happening before javas, even though it is very clear.Let's try to do one simple Java program and run it for the same.I'm going to eclipse.Here I have created a class called Switch with a string and there is a main method, and inside themain metal there are two methods.The first metal is displayed to the details, like if you pass Wednesday as the input, it will takethat input and the corresponding logic associated that case will be executed.The main difference that I want you to observe here is the input piece of tape string and the same stringvalue can be passed.And inside your case statement also, you can hard code or leverage any string values or string constantsinside your Java programs.Along with this, you can also mention multiple case statements by placing them next to each other.Suppose like in this program, if many case statements have a same business logic, then instead ofwriting all of them in multiple cases and along with their break statements and business logic, whatyou can do is you can put them next to each other, which will allow you to reduce your unnecessarycode, are written and called.Like as you can see here, we have a logic to determine whether to raise a weekday or weekend.So for Saturday and Sunday, it will be called as we can.All other days, it will be weekday.And for any default, I just put it as a holiday.The main observation that we have to see here is you can see I have mentioned five case conditions herein one lane and all of them have a same business logic, which I'm trying to leverage here.So please be aware of these enhancements happen in Java, one point seven on Java, seven in future,whenever you are building a switch statement are making it changes in that switch statement, please.Leverett's this new feature where you can pasturing also as an input parameter instead of you takinga pane of creating enum classes and enum types are using some irrelevant Entocort inside your switchedIDs.Thank you.And see you in the next week by.
###  19. Using String in Switch Statements.md
Now, in this lecture, let's try to understand by inference, our diamond operator, which got introducedin Java seven, the named diamond operator looks very funny, but I'll tell you why.It is also called as diamond operator in some time.And this is the operator that we use only when you are dealing with generic types, especially whilecreating objects from collections and storing data inside them.As you can see before Java seven, in order to create an object with a generic type, we have to mentionthem.What are those Generex on both sides of the expression, like on the right hand side?On the left hand side here as highlighted in a local, you can see in this expression, I'm trying tocreate a map with the name input map.And since a map is an interface while creating an object, I'm trying to pass implementation of MAP,which is Hashmat here.If you observe, I have mentioned the generic on both sides of the statement indicating key should beof string type and my value should be of type integer.But if you observe this statement, we are mentioning the same string integer on both sides.It seems to be something unnecessary that we are maintaining on both sides.So to reduce the effort of the developer in writing that extra Generex on the right hand side from Javaseven, the compiler has been improved to make it smart enough to infer the type of generic instancesbased upon what we had declared on the left hand side.It is also called as diamond operator because if you remove the string comma integer, the operatorwill look like a diemen.Due to that reason, it is mentioned as diamond operator.Also in Java seven.If you can observe the same statement now we can write from Java seven using diamond operator by removingthe string comma integer on the right hand side, which means my compiler is smart enough to understandthe Hashmat object that it is going to create should accept the string as key and integer as value types.But please note that we can't use this diamond operator feature inside the anonymous in our classes.But this limitation is resolved in Java nine.Again, this is just a small feature.Our update happened to Java seven, but it's going to help developers in a extend because on a day today basis, millions of the developers leverages connections in their business logic.And they're using that effort of mentioning Generex on the right hand side will definitely help to developus.Now we understand what this diamond operator are.Type inference operator.Let's try to write a simple Java program to understand it even more better.For the same, I came to a close and open the class that I had written, the class name is Diamond Operator.As you can see, we have two methods before Java seven and with Java seven before Java seven, whilecreating a map object.I have to mention the same string comma integer on both sides of the statement.It's not only about the map, it can be applicable for any collection, like Liste said.So that's why.Please remember, this is applicable for all types of collections, not only map and as usual, we putvalues inside that map with the key and values that we can also display all of them using the entries.So this is what used to happen in before Java.So now with Java seven, with the introduction of this diamond operator, I can remove this string commainteger.I can just mention empty diamond operator.Now, my compiler is smart enough to make this hash map object to follow this string comma integer value.Like if I try to change this one to string, definitely I'll get a compilation error saying that integervalue is expected.So this way you can leverage diamond operator whenever you're dealing with the collections and creatingobjects of collections and it is going to help you in reducing your code and making your code more readablealso.Let me try to run this program in debug mode.As you can see, the first method will print all the map values and the second method will print allthese map values, which has months since Hashmat will not maintain the order.So all those values are printed in whatever order internally JVM maintains.So please remember to use them, operator, if you are using Java seven are both inside your code.Thank you.And see you in the next lecture by.
###  20. Diamond Operator or Type Inference Operator.md
In this lecture, let's try to explore the interaction of underscore inside numerically literals fromJava seven.This feature will allow you to put underscore values inside numeric values to improve the reliabilityof the code.For example, if our code contains a numeric value one followed by eight or nine zeros, it's very toughfor a developer or anyone who is reviewing the code are trying to understand the code to identify anumber of zeros that the number has.UMAY ended up putting some extra focus on that number to understand and count the number of digit thatnumber has.So due to that reason, in order to improve the reliability of your code, an excellent future is introducingJava seven, which will allow you to maintain underscore inside your numeric values representation.To underscore is a special character.You are JVM and compiler.Remove them internally while processing the numeric values.As a developer, you can see those underscore values inside your numerical numbers.But internally all these underscore values will be removed before processing that value.So this is very similar.Like we used to use commas in our school days, our college days, whenever you try to do some mathematicaloperations so that for us are whoever is evaluating your answer sheet, it is very easy to understandhow many numbers are there inside your numeric value.As you can see here, I have a number one, followed by seven zeros in mentioning one and all sevenzeros continuously.With this new feature, I can put underscore wherever I want and anyone who is reviewing and tryingto understand my code, I can easily understand.OK, this has seven zeros without putting any effort.But please note that there are few restrictions on where and how we can apply this underscore in numericvalues.Number one, you can't use underscore at the starting or at the ending of the number.So this is the first example like you see on that score.Six is not a valid number because you are putting unnecessarily underscore before the stopping of thenumber.And at the same time, six, followed by underscore also is not a lot since you are putting an underscoreat the end of a number next and a score is not allowed adjacent to your decimal point, since you canalso use this underscore in float and double numbers also.But please remember the underscore value is not allowed around the boundaries of dot value or decimalpoint.So six point underscore zero is not valid because you are keeping an underscore just after a decimalpoint.The same for this number also where you are keeping underscore just before decimal point.And the next restriction is whenever you try to create long number and float numbers, we usually mentionIlari of suffix to indicate that those are longer flawed numbers.But in such scenarios you can't put underscore just around this and are EFIC suffixes.So make sure that you are not using them like our showing here between zero zero and the URL you havekept under score, which is not a lot.The same applies for enfold.So even if you are using binary literals like we discussed in the last we'll use, the underscore isnot allowed immediately after zero B and at the same time.And the score is also not allowed when you try to create string representation of digits like you maythink, like I'll keep this value as a string and I'll try to pass integer that pass in to convert thatstring into into value by assuming compiler will remove all those underscores.But that is not going to work.You can't put underscores when you try to represent a number in a string format, because if you tryto convert that string value in future to some numeric value, you will get that number format.So to understand this even more better, I have written a simple class and a score in numerics wherewe have a method before Java seven to show how we used to return to long numbers before Java seven andhow it is going to change with Java seven.So before Java seven, you can't put underscore inside the numeric values.So due to that reason, it's very tough for me to identify how many numbers are there, what is thevalue of that number in terms of.Readability.But from Java seven, you can see the same numbers can be represented and separated with the help ofUnderscore to improve the readability.As you can see, we can use this underscore in all type of numbers, like normal int values, long values,float values, double values, and at the same time inside the binary representation of the numbers.So I'm trying to run this in a debug more if we can observe here.All my underscores are remote.If I try to print them.As I said previously, my JVM will take care of removing them before processing for any operations onthose values, like printing, automatic operations, logical operators.So for all such scenarios, this underscore value will be removed.This is only for Java developer purpose to improve the reliability of the code.As soon as you started compiling your program, you were allowed under squads will be removed from usernumbers by the company.So please do remember about this new feature.And if we have a scenario where you have to hard**code** very higher number of values and binary representativevalues, you can use this feature to improve the readability.And don't get surprised if someone inside your team they're using underscore inside their numbers.But still, Compiler didn't complain anything, though it is a special character that is due to thisnew feature that got introduced in Java seven..
###  21. Using underscore in numeric values.md
In Java seven, The Daily Beast that we use to interact with the database and perform operations isimproved by leveraging latest features that has been introduced in Java one point seven.One of the features that got introduced in Java seven is private recent statements.Definitely JBC has a lot of interfaces and classes which acts like a resource and that needs to be closedat any cost.Such objects like Conexion, ResultSet and statement.So now we can use all these interfaces and their implementations and objects creation inside privateresource so that there is no need for us to write to **finally** block statements and close them.And again, you may be using frameworks like Hibernate and J-P, which will carry away all this burdenfrom you.But if there are someone who are still using GBC plain implementation when they are creating an objectsof connection ResultSet and statement, they can use the new feature called Private Resource, so thatthere is no need for them to write a **finally** block and close them inside it.And one more major enhancement happen inside GBC.In Java seven is the introduction of the Rossett factory interface and the Rossett provider class,which will enable you to create Rosett objects of various Rossett supported by what is provided easilyso before Java seven.In order to create a Rossett object, you have to write a very complicated code.But from Java seven, by using Rossett factory, you can easily create the objects of these any rosettesthat are provided by GBC in a single line and the various rosettes provided by Jerry BCR, Castro said.Filter Rousset, Jeremy Set and Jane Rossett and Web browser.So these rosettes are used in different different scenarios.And before Java seven, we used to create them by depending on JBC Rossett implementation class forthe same.Now we can create all this object from a single factory class that is Rossett factory.And if you are wondering what is the difference between ResultSet and Rosaire?So Rossett is an advanced version of ResultSet using roseate.You can make your results scrollable and updatable at runtime.So that's a major difference between ResultSet and ROSET.Now we have discussed about JDBC improvement on a high level in theory.Let's try to go to a program and try to understand them and how we can implement them inside code.For the same, I have a class called JBC Enhancements, I have written to methods on his view resultsand create JDBC Rossett method Inside View results.You can see I have used private resource statements where I have created the objects of connection statementResultSet inside these parentheses, which means now I'm free from writing a final blog and closingthem.And one more thing that you can observe.Years I have mentioned all of them by separating with a semicolon, with discord and free from writingunnecessary code for closing all these resources related to GBC.So that's one key point that we have to observe here.The other feature that I'm mentioning is about this Rossett factory.So Rossett provider is an implementation of Rossett factory.Using that, you can create any Rossett object that are supported by your provider like you can if youtype create.You can see these are all the processes that we can create using this Rossett provider class.And once we have Rossett, we can pass the Euroleague credentials, all those names, and when you execute,you will get the results.Since this program need a database connection, for now, I'm not executing, but I think this is prettyself-explanatory.If you have a data base and you want to try on your own, just replace all these hostname some credentialsand try to execute this program.So please be aware of this enhancement.And if you are using database related code, try to leverage this new features, especially the privateresource which will improve the quality of your code.Thank you.And see you in the next video by.
###  22. Jdbc Improvements .md
.md

###  23. Garbage First (G1) collector .md
.md
We all know what is the purpose of garbage collector in Java, one of the great advantages of Java comparedto other languages like C and C++ is you don't have to clean the heap or clean the objects that arenot used no more.All this heavy lifting of memory management and cleaning of unused objects is handled by garbage collectorinternally by Java City Java seven.We used to have a garbage collector with the name concurrent marks we collected, which is Seumas garbagecollector.But it has certain limitations because there are a lot of advancements happening in terms of processoravailability, memory availability.And the applications are also demanding for garbage collectors, which can handle large heap size inGB's and terabytes.So due to this, since the current garbage collector, which is Seumas has certain limitations whenhandling large AHEPE sizes in new garbage collector called Jevin is introduced in Java.But this is not by default activated in Java seven.This garbage collector is the default one from Java nine Virtanen.If we want to use in Java seven and Java eight, you have to specifically activity which means by default,Java seven, Java eight.They will still use the old Seumas garbage collector only from Java nine.This one garbage collector, which is introducing Java seven, made it as a default one.This is because Java people want to give that flexibility to the developers and the projects and enterpriseorganizations to switch between Seumas and Jivin garbage collectors build Java name since the Ziyuanis newly introduced and there might be some issues for certain organizations.So due to that reason, they give this flexibility to switch water garbage collector that we want.But as I said, this is stabilized by Java nine and from Java nine G1 Garbage collector is the defaultone that you have to use inside your Java applications.So let's try to discuss what's a problem with the previous garbage collector and what advantage thatthese one garbage collector is bringing in to the Java applications.The older garbage collector will split our keep memory, like if you Buzby as your keep memory for yourapplication, it split your entire heap memory into three buckets.First one is anger generation and second one is the old generation.And the last one is a permanent generation.Permanent generation is a place where we hold all the data that we need to hold permanently and comingto generation.It has again two spaces inside.One is Uden space, the other one is a survivor space.As soon as an object is created by using a new operator in Java, it will be placed into Yuren space.And once we are done using that object, it will become an unused object.As soon as an object become unused, it may surveil certain garbage collection cycles.So what internally jaivin will try to do is it will keep running regularly at some intervals and tryto mark and sweep all the unused objects every time it do a cleanup.And in these scenarios, there might be a chance, whatever unused object that we have, it may survivea few garbage collector cycles.In such scenarios, it will present in the survivor space.But due to some reason, if this object is able to survive even more garbage collector cycles, thenit eventually moved to the older generation.So once it is there in one generation, it will definitely be cleaned because any garbage collectorin order to clean the old generation, keep it, don't have to hide the application execution.Only garbage collector will halt the execution of the thread if it is trying to clean the space insidesurvivable space.But you can see here, the problem is if you use some form of deep space, it will divided into big,big chunks and it will be very tough to manage and take decisions, especially for a larger space applications,which is holding hip size in GB's and terabytes.And one more limitation that we have the same as garbage collectors.Whenever we try to clean the space in the survivor space, which is in another generation, it willhide the threat execution temporarily till it cleans the space of the engine, which.Which, again, is a performance issue for many applications.But now the new garbage collector, which is introducing Java seven, takes a different approach.So what does collectors will do is if you do a heap size together, it will divide your entire heapspace into small, small sizes of equal size, like to be Artforum, be each heap space.But internally it will have the same terminologies like Yuren space, survivor space and old generationspace.Since there are many he projects with a smaller amount, the job of garbage collector will become moreeasy and it can handle any amount of heap size like Fuji B or Tanguy due to internally.It will again split that, he says, into small, small chance.And you can see the difference before you'll have only three generations pieces of big size.Whereas with the G one garbage collector, you will have small regions and all the small regions assignedwith various pieces like you in space, survivable space and all generation space internally.Along with the space management, the new garbage collector, Jiwon, has big advantages.One is it can do most of its work concurrently without application threats, like if you see the samegarbage collector and trying to clean the space.And in a generation, it will hold the thread temporarily.Whereas given garbage collectors can do the job efficiently, concurrently, without hurting the applicationthreads and splitting the heap into small regions, enables the G1 to select a small group of regionsto collect and finish quickly instead of you waiting on a large heap size to get it filled.If you have a small heap sized regions, definitely you have a good chance of filling them quickly sothat you can collect them and make them available for newer objects.And this cycle will continue.Continue, which will bring efficiency to your application.And at the same time, this garbage collector, Jiwon, is a very good option for applications withhow large a hip size.But if your application, how very less, he says requirement than it is recommended to not use thisone and go with the old CMS one only.But at the same time you also have an option of using Jiwon even for applications with small heap sizealso.But in that case, you have to leverage one of the configuration where you can control your Jevin garbagecollector on how much time it can pass before jumping onto another clean up of unused objects.This, we call it as Max G.S. pass Busmalis and will accept the amount of milliseconds that it has topass.What is the maximum amount that it has to pass before resuming the cleanup work?And as we discussed, since there are many applications coming into the market which require a lot ofhip size due to that reason given is more suitable for such applications, which has, he says, morethan 60 B and even terabytes also.And this G one garbage collector has been made as a default one from the Chavan.Again, this is something not specific to the allotment feature.This is what internally changed inside Java in terms of garbage collector.So please do remember in Java seven, there is a new garbage collector called G1 has been introducedand its primary features are it can work concurrently and it will split the heap's into small regions,which will make it efficient by collecting and finishing the clean up quickly.Thank you.And see you in the next lecture by.
###  24. Fork & Join framework.md
Now, in this lecture, let's try to understand one more important feature that got introduced in Javaseven, which is for conjoin framework, the reason for this new framework is there are a lot of advancementshappening on the processes inside our CPU's.And decades before, we used to have only a single processor inside our CPU.Then we got dual core process, quad core and now core.So there a lot of advancements happening day by day and year by year due to which there is a lot ofdemand from the developer community that Java should leverage all the processors available inside theCPU rather than using only a single processor and letting the all other process available freely.So to address this issue, Java seven introduce new for conjoin framework that supports parallel processingby splitting huge task into small subtasks so that those small subtask can be processed independentlyby using all the available free CPU course and eventually join the results from all the subtasks intoa final result.And this is a sample pseudocode that is the idea behind of the four conjoin framework.Like if you have a problem and if you do that to this framework, if the problem is too small, it willtry to solve directly.Otherwise it will keep splitting that problem till it becomes a small problem.And eventually all these subtask that God created in this process, they will execute the problem.Ballylee, and at last we will compose all the results from all the subtask into the final result.So this is the sample representation of how four conjoin framework works.So it usually applies to divide and conquer principle.The framework will recursively divide the task into smaller subtask until a given threshold is reached.So this is called for Copart.That means splitting the bigger task into small, small tasks.Then all the subtask are processed independently and if they return a result, all the results are recursivelycombined into a single result.So this is called joint.But so due to that reason, we have the name itself for conjoin framework, as you can see here first.We had a very big problem.We split that into two subtask.But subtasks is still not small enough to start working on its own.So due to that reason, it is against trying to do more subtasks.And since now my subtask is small enough to work independently, my code will start processing thistask by leveraging all the parallel processes available.So once we have the result from each subtasks, they will be clubbed using joint till we get the finalresult.Let's try to understand what are the important framework interface and classes that are supporting forconjoin feature.At the heart of this framework, we have a fork gene pool, which is an implementation of executer servicesfrom previous Java versions that manages all the threads that we create as part of subtask creationand provides us the tools to get information about them and their performance.After that, we also have the basic representation of a task which is for conjoin tasks.So this is the best time of all the tasks that you execute inside for gene pool.In practice, one of its two subclasses should be extended to make any class of Java Quogue to run ina four joint task style.The two classes are the Katsu action and the other one is that the recursive task.I will tell you what's the difference between them in some time.They both have a method called compute, which will be keepon executing till it reaches a result internally.Fork join framework follows work stealing algorithms where free threads where they don't have any work.They will try to steal some work from the busy threads.So this way all processors inside your CPU are balanced and leveraged efficiently.But again, so it is providing a lot of fut. to the developers due to it's complicated in nature.This feature didn't go into developer community successfully because not all developers are comfortabledue to its complex in nature.So due to that reason, in Java eight, a concept called Streams is introduced by leveraging for framework.But that streams is very easy to use compared to this for Joint Framework will discuss about streamsin Java eight section.But for now, try to understand what is for conjoin framework, which is a base for our parallel streamprocessing that got introduced in Java ET.Now we have a clear theory understanding around it.Let's try to go and execute our programming using for conjoin framework.So I have written a class called, for example, the purpose of this class is to calculate the Fibonaccinumber of a given input.This is a number which is a sum of all the numbers still given number.As you can see, the first requirement for any Java class to use for joint framework is to either extendrecursion, action or recursive tasks.Let's try to discuss what is recursive action, what is recursive task, what's the difference betweenthem?So they both extend for joint task, which is a base type representation for any form joint executionor surpass even recursive task.Also extend for joint task.The only difference between these two classes are they both have compute method, but recursive actionwill not return any value, whereas recursive tasks will return a return time that you are expecting.Like if you have a requirement where from your four conjoin framework you are expecting no outcome fromit, you just need a competition and stored the data in the database or print them or log them, thenyou can go and use their Akutsu action.But in the scenario where you are expecting some return value from four conjoin framework, then youhave to use the recursive task and eat compute method will return whatever value that you want whenit's done, executing and deriving the final result.So now in this case, my requirement is pretty simple.Algebra number and Fibonacci's value of that number has to be printed on the console.And since I don't need any return value, I just use recursive action.And since I implemented recursive action, I have to go write the compute method which will return Y.And inside this you can see I have defined the threshold value for my or conjoin framework to decidewhich point that subtask has to be keep on happening.And this threshold I have given as to so my number is to the subtask creation will keep happening andthat's where in the L block you can see my number will be again divided into two subtasks and minusone and minus two, and those will be invoked, which will again call the compute method.And if this condition is not satisfied, they will again go.So in this way it will recursively keep on calling till it reaches this threshold.And once that threshold is met, it will directly call this FEBA method, which will return the Fibonacci'svalue of the given number.And again, please note inside this method until we have Eric Asacol a little bit, just one at lessthan one, an inside main method.I'm just creating a object of the given class and this is my input.I want to find the Fibonacci number of twenty and that's the number that I'm passing, which will beset using constructor.This is the number that I'll use to get the ones all the subtask are executed.As you can see, whenever we reach threshold, we are updating their number and even inside the subtask.Also, we are collecting the results from all the tasks like from F1 and F2 and clubbing them to getthe results like we have shown in that slide.Once I created this object using Forgan Pool, I had to invoke bypassing the task I can pass this objectto invoke because my class extends the work joint task, which is a best representation of any taskinside for Choying Framework.So due to that reason, I can pass to this and when I pass to invoke this will take care of callingcompute internally.And which ones are Tushka executed and the result is accumulated in this line.Execution will be done.And at last I'm just calling the gate member, which will have the final result.No.So this way, using joint, I'm able to find the output of my program.Let me start this program and you can see for Tonti, this is the Fibonacci number.But as you can see, there is a lot of complexity involved.There is a lot of understanding has to happen by the developer, especially for the new developers,since it's very hard to understand and implement not everyone.Welcomed it due to that reason, eventually its concept, called streams introduced in Java aid to processthe data inside collections, which internally leverages that for conjoin framework.But as a developer, I don't have to worry about for conjoin framework in Java eight, I can easilyuse dreams because they are very easy to use and understand.And we will discuss about the same in detail in Java section.So with this, I'm assuming at least you got some basic understanding on what is for conjoin framework,which got introducing Java seven.But if you feel it is heavy to understand, don't worry, things will become better in Java eight.Thank you.And see you in that next section by.
###  25. Summary of Java 7 new features.md
We cover a lot of Java seven new fut. that got introduced from developer perspective in this lecture.Let's try to recap what we discussed in Java, seven new features and after we can close this sectionand move towards Java, create new features.We started this section by discussing the very important new feature that got introduced in Java seven,which is the private resource statement which will allow you to deal with resources without the needof closing them inside.The final blog post that we discussed many new features focusing exceptions like suppressed exceptions,**Catching Multiple Exceptions**, redrawing exceptions with the type checking and easier exception handlingfor reflections.So all these new features related to exceptions will make life easy and also help in debugging any runtimeexceptions that you code Metro.Was that we also discussed about the objects utility class that got introduced and how we can performnormal checks using required national methods present inside this class.Next, we also discussed that there is a new clause matter introduced inside.You are old class in order to avoid any resource leakage or memory leakage issues, followed by theenhancements done inside files and directories, especially the new interfaces and classes like padpads and files that got introduced in Java seven, which will make their life easy while dealing filesand directories.Both that we also discussed about what service, which provides an easier approach to track any directoryor files for changes instead of using complex threat based approach was that we discussed features likeBindery Latrell's and string in switch statement, which will increase the reliability of your codeand also make life easy when dealing with binary numbers and switch statements.After that, we discussed about diamond operator, our type inference operator, which will reduce theunnecessary code that you had to write on the right hand side of your object's declaration wheneveryou're using Generex inside collections was that we discussed that we can write underscore inside numerically,Trelles, to increase the readability followed by the GDP.See improvements happened in Java seven.And we also had a very good discussion about the new garbage collector, which got introduced in Javaseven, which is garbage first our G1 collector.And at last we discussed about four conjoin framework that will process huge task Parmalee by leveragingthe CPU cores available inside your server.We also discussed a lot of coding exercise corresponding to each and every new feature that we discussedin this section.Before closing this section, I want to highlight whatever features that we discussed in this section,those are developer focused new features, and I want to share those details to you so that you canuse them on day to day basis.Apart from these features, Java seven also has many security, are non developer focused features thatare introduced are enhanced in it.For more details on them, please visit the link that I have given here.Like if I click here, you can go to that link.And this is the release note of the delicate seven.As you can see, it will have all the features that got introduced.And we discuss very important features like Java programming, language changes like binary Latrell'sstrings and switch statement, private resources, **Catching Multiple Exceptions**, whatnot.So we discussed all the important features that are needed for developers to make their code more readableand powerful.But if there is some feature that is interesting to you, I would request you to go and explore allthe features that code introduce, especially in terms of security and non developer in this page.And as I said, we also discussed a lot of coding exercises and this is the GitHub link that you canuse to check those classes.And from there you can clone the project and try to understand them on your own time.And they would also require you to edit them, update them based upon the scenarios that you can thinkinside your projects and client requirements.Like if you go to these GitHub link inside Java, new features, there is a Java seven directory.If you click this package, you can see all of classes that we discussed which will help you to getstarted quickly on Java, seven new features.I'm also attaching this presentation, whatever we have discussed in this section to this video.So please download it.And whenever you want to do a refresh of the new features that got introduced in Java seven, you canquickly look at the slides.And based upon our discussions, you can recall them easily, which will save your time from takingnotes and capturing them again and again.So instead of that, I would recommend you to download this code and this document that are attachedto this video so that you can look at them and you are going to some interview or whenever there isa requirement inside your project to upgrade to Java seven are to use any of the Java seven new feature.So with this, we are done discussing all the Java seven developer focused the new features and veryexcited in moving on to the next lecture, which is Java Create new features where a lot of major enhancementsand new features are introduced.Looking forward to seeing you in that section.Thank you.And to you in the next section by.
###  Quiz 2: Java 7 new features & enhancements quiz