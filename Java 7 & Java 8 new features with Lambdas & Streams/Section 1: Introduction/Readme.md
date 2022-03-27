### 1. Course Overview.md
Hello and welcome to the course of Java, seven and eight new features which will cover all the new

features that got introduced in Java seven and eight versions.

And this course will discuss all these new features in depth.

And this course will take your knowledge from zero to master, especially on the new features that got

introduced in Java, seven and eight versions.

In this course, we will be discussing all these new features that got introduced in Java seven like

try with resources statement, what are the improvements happened in Java seven, especially in terms

of exceptional handling

How can you catch multiple exceptions?

What are enhancements happened when we deal with files and directories?

What are the improvements happen to switch statement?

What is a diamond operator?

What are JDBC improvements?

What are binary literals?

And along with the Java Seven features, we put a major effort inside this course discussing on Java

eight new features, as we all know, Java eight is a major release that happened in entire Java history.

So this is the version which released major enhancements in terms of lambda expression streams, functional

interfaces.

And this is the version which will break many rules that we set from day one of Java, like writing

default method, static methods inside interfaces.

So due to that reason, we will spend a good amount of time discussing all these new features that got

introduced in Java eight.

And also, we will put some good amount of effort in understanding what is the new date and time API

that got introduced in Java eight, along with other enhancements happen to MAP.

And what is a completable feature, that got introduced in Java eight, which will help you in

asynchronous programming.

Since we are going to focus in this course about Java seven and eight new features I would like to highlight

in order to take this course or in order to enroll for this course, you should have at least minimum

and basic knowledge inside Java, like you should know how to write Java code and how to read a Java

code what are collections, how do you do exceptional handling.

So all those basics and the knowledge of at least 1.6 is recommended to take this course.

If you are a new person to Java, then I would recommend not to enroll this, because in this course

we are not going to teach the basics of how to write a method, how to write a class, what are collections.

So we are not going to touch all those basic topics.

So this is a cause for someone who want to upskill themselves in the major enhancements happen inside

Java 8 like lambda expression, streams.

This course will help the developers, architects, team leads, students and someone who want to attempt

an interview based upon Java because it is going to cover all the new features that got introduced in

Java seven and eight, which are major releases in the Java history.

And we can't imagine any interview without asking Java eight new features like What are lambdas, how

to write lambda code, what are streams, how to process data using streams.

So without these questions, we can't imagine a Java interview.

So if we can spend some time along with me in this course, you are going to become a master in all the

new features, especially complex features like lambda expressions, streams, functional interfaces in Java

eight.

In this course, we are going to have a detailed discussion about all the features that got introduced

in Java seven and eight, and particularly there is a good focus put on to the complexed major enhancements

like lambda expressions to discuss on them in detail and also in this course

I keep highlighting what are the important topics for an interview perspective and what are the important

features that you should consider inside your projects to write less code and achieve more results.

In this case, along with the theory discussion of each and every feature that got introduced in Java

seven and eight, we are going to have a in detailed discussion about how to code that feature inside your

Java program so that you will have a better understanding and in detail understanding from both theory

and practical's perspective and inside this course

I will also sharing all the material that I have discussed so that you don't have to put an effort to

make notes while attending this course.

So this way you can take this material once you're done with your course and you can keep referring

that as a refresher whenever you want to attempt an interview or whenever you're upgrading your project

from Java seven to Java eight, Java six to Java seven.

And at last, I'll be also sharing what is the GitHub location where you can find all the examples that

we are going to discuss inside discourse.

So this way you have complete information that you need, upskilling yourself from Java

old versions like six to the new versions, like seven and eight.

So please go ahead and enroll this course without any hesitate.

And I can guarantee you, I will make you understand all the new features inside Java seven and eight.

Thank you.

And hoping you to see in the next lecture. Bye.

### 2. Java versions history.md
Before we jump onto the new features of Java seven and Java eight, let's try to spend a few minutes

on what is happening in the Java ecosystem.

As you can see, the initial version of Java is released in 1996 with the concept of Hoopes, which

is object oriented programming language and Latron Java team.

They used to release the next versions based upon the market trends and the competition that we have

from other languages.

But you can see there is no consistency on how Java team is releasing this resource.

So futilities there to Guarnere a few releases that took two years and there are releases where they

took five years as well.

Like you can see in 2006, they have released Java six version and Java seven came in 2011, which is

almost five years and the same from Java seven to Java eight.

They took again three years.

So with all this irregular way of releasing Java, team quickly realized that this is not going to work

in order to survive in the market based upon the competition that it receives from the languages like

Python, Ruby go.

So all that languages are giving very big competition.

Due to that reason, Java team decided from Java nine version.

They are going to release the next version every six months.

Like you can see in 2017, September, we had a Java nine version and immediately after six months we

had Java C 10, followed by 11, 12, 13 and the same.

They're continuing and releasing a release every six months and I am proud to say the same six months

release is continued even in the pandemic situation of covid.

But you can see there are few options which I marked as Altius.

So here Elba's is long term support.

The reason of this eightieths release is if you keep releasing every six months a new version, there

are certain conservative organizations are big enterprise projects where they don't have that agile

in nature of adapting every six months in next to version of Java is released.

So far, such organizations, the Java team said every three years they are going to have in a press

release, which is long term support release.

So these Altius versions can be adopted by bigger organizations where they can't upgrade every six months

to get new releases.

And you may ask me, what's the difference between an LPs version and Nonnatus version?

So non LTE solutions focus on the features.

Like every time we heard something from the market, Java team is going to adopt them quickly and every

six months they are going to release.

Due to that, it is going to be a continuous process where you heard feedback from the market, from

the developer community and you adopt them so that you really don't have to wait for a major release

to release the new features.

But for the bigger organizations, they came up with an option.

And these LPs versions will have a longer support, either in terms of security and patches and updates

that Oracle is going to release, whereas the non LTE versions, as soon as an immediate non LPs version

releases the previous and on LPs version will be archived and no support will be given.

Like you can see, as soon as a C 10 released the support that a C nine is receiving, all these six

months time will be stop and Java team and Oracle.

Everyone will focus on providing support and patches to see technology.

But they will make sure whatever features that got introduced in the previous releases are also present

in the latest version that got released, whether it might be an LDS or non-religious version.

So if you are a developer who want to explore all the new features that got introduced every six months,

you can always go and explore non-religious versions.

But if you are working on a bigger organization, definitely there should go with the long term LPs

versions because usually Altius versions, they come up with a minimum support of three to five years.

But due to that reason, organizations are not forced to upgrade to the immediate next release.

As you can see, we have a Java associate released in 2014 Bozak.

We had an earlier version in 2018 and one is expected in 2021, but still.

Seventy five percent of the projects still using Java as a tool.

The reason is it is an LTE version and the support is still continuing on, whereas the support for

nine 10, which are in between eight and 11, are stopped because those are non-religious versions along

with this LDS and non-religious versions update.

There is also a change happening in terms of licensing.

Sutil, Java eight.

We used to use the Java freely without any cost, but based upon the recent changes happen, Oracle

came up with that.

They are going to charge for the projects where they are using Java inside production.

Of course, they can use in their development environment and even developers can download it freely

and they can use into their development.

But if someone is using in production environment, definitely they have to pay for it to fight these

kind of projects.

Oracle also is going to support through their call centers and patching system where they will prioritize

all this request.

So since Oracle came up with this approach, there is a lot of pushback happen from the industry.

And due to that reason, there are many vendors came into picture who are trying to make Java still

open source.

So let's try to discuss them in detail about these various vendors involved in the next lecture by.

### 3. Different JDK vendors in Java ecosystem.md
As I said in the previous lecture, since Archil is trying to make Java commercial one by forcing enterprise

projects to use its license to washin rather than a free one like we used to do to Java eight.

So there are many vendors came into picture who are trying to make still Java open source.

The very first one is an open Jelica project.

So this is a website of open JDK.

So all the source code of Java is built and developed and maintained by open jerrycan.

So this is the team who does all the brainstorming of the features, adopting the new features, making

the code changes inside Java libraries.

So Open Jaedicke is a project that is responsible, but it holds only the Java source code.

And as you can see for open JDK, this duplicate is the logo which you can easily identify when someone

is referring to that article, Jelica, are open.

So whenever you see this DOOK logo, that means it's open.

Jerrica, but problem with open JDK is it only provides source code.

It is not focused on building binaries based upon different operating systems and distribute to everyone.

So due to that reason, we have Oracle who takes ownership of taking that source code, building binaries

out of those Java libraries and distribute to various interested parties in the form of executable files

are DAJA files are binaries and this is the sample Oracle download file.

You can see right now that encouraging everyone to download Java and C 15, which is the latest.

But if you go and see immediately after 15 that encouraging everyone, whatever the reason is 12, 13,

14, which are non Elba's versions, as soon as the next Nonnatus version released, they will be archived.

So due to that reason, Leverne is followed by Immediately 15, which is a current nonentities solution

maintained by Oracle.

Similarly, before Leverne, you can see it only there is no nine and 10.

Since 11 is available, nine and 10 will be archived.

But since Oracle came up with the licensing changes to support enterprise applications, there are many

vendors in the market like Amazon, RedHat, Microsoft.

So all such vendors, they formed a new project called Adopt Open.

So what this Adopt Open Jerrica team will do is they will also does the same job like Oracle does,

like taking the source code from open JDK and building binaries for free for everyone.

So this is the project which is making sure that Java remains open source so that everyone don't have

to depend and rely on Oracle only.

And there might be some projects who don't want to pay to Oracle and they want to remain to use the

open source Java binaries for such organizations and projects.

So this is the project which helped them.

And right now this is being maintained by various vendors like Microsoft, Amazon.

RedHat, on top of this, adopt open JDK.

Every vendors like Amajan, RedHat, they build their own dedication's based upon open JDK.

This is to increase their in-house claims, but use that Djuric and they'll also make sure this JDK

is more compatible with their products by providing more features like better SEAL support or better

performance with their products.

Similarly, you can see for RedHat also they have their own JDK based upon open source code, but we

just have to avoid any vendor that is building their own Jerrica based upon open Jerrica where it is

article, whether it is adopt open JDK or whether it is red.

Hard to imagine they can't change the underlying source code.

So people just can't propose a new method inside collection or lamba streams by themselves.

They have to strictly adhere to the whatever open Jerrica is giving.

On top of that, if they want to build something beyond Tusker specific to their organization, they

can build and use them.

But as I said, these changes should not be something where you are changing Java code, these changes

like you are providing.

Better performance monitoring, better profiling, better logging or better CLIA support.

So all these kind of features you can enhance by taking open.

So with this, I'm assuming you are very clear about what are different parties involved right now in

Java ecosystem.

So please so please be aware.

Open Jerrica is the best that maintains source code from this article is a major vendor that try to

build the binaries and distribute to everyone.

But there is a caveat.

Oracle, Jadakiss.

Nowadays you can only use in the non-profit environment, but if you want to use in the production environment,

you have to pay for it.

But if there is a scenario where you can't pay or you don't want to go with Oracle Jerrica, there is

a adopt open JDK project also available, which is providing binaries of Java for free.

So there is no difference between all these, Gerrick, is that various companies is building except

on a few changes are enhancements that they are doing specific to their organization requirements.

So with this, we spent a lot of time discussing on the Java history and what is happening in the Java

ecosystem these days.

Let's try to jump onto the new features that got introduced in Java seven in the next lecture.

Thank you.

And see you by.

### 4. Other Courses from EazyBytes 