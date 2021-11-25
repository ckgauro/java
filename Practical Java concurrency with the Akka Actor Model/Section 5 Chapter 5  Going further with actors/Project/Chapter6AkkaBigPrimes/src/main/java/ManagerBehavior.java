import akka.actor.typed.ActorRef;
import akka.actor.typed.Behavior;
import akka.actor.typed.javadsl.AbstractBehavior;
import akka.actor.typed.javadsl.ActorContext;
import akka.actor.typed.javadsl.Behaviors;
import akka.actor.typed.javadsl.Receive;

import java.util.stream.IntStream;

public class ManagerBehavior extends AbstractBehavior<String> {

    public ManagerBehavior(ActorContext<String> context) {
        super(context);
    }

    public static Behavior<String> create() {
        return Behaviors.setup(ManagerBehavior::new);
    }

    @Override
    public Receive<String> createReceive() {
        return newReceiveBuilder()
                .onMessageEquals("start", () -> {
                    IntStream.range(0, 19).forEach(i -> {
                                ActorRef<String> worker = getContext().spawn(WorkerBehavior.create(), "worker" + i);
                                worker.tell("start");
                            }
                    );
                    return this;

                })
                .build();
    }

//    @Override
//    public Receive<String> createReceive() {
//        return newReceiveBuilder()
//                .onAnyMessage(message -> {
//                    IntStream.range(0, 19).forEach(i -> {
//                                ActorRef<String> worker = getContext().spawn(WorkerBehavior.create(), message+"_worker" + i);
//                                worker.tell("start");
//                            }
//                    );
//                    return this;
//
//                })
//                .build();
//    }
}
