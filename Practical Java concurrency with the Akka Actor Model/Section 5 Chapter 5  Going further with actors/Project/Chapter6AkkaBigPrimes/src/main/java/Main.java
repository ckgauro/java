
import akka.actor.typed.ActorSystem;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
//    public static void main(String[] args) {
//        ActorSystem<String> actorSystem=ActorSystem.create(FirstSimpleBehavior.create(),"FirstActorSystem");
//        actorSystem.tell("say hello");
//        actorSystem.tell("who are you");
//        actorSystem.tell("create a child");
//        actorSystem.tell("This is the second message.");
//    }

    public static void main(String[] args) {
        System.out.println("Start==>");
        ActorSystem<String> bigPrimes=ActorSystem.create(ManagerBehavior.create(),"BigPrimes");
        bigPrimes.tell("start");
        System.out.println("Finished from main");
    }
}
