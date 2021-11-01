import akka.actor.typed.ActorRef;
import akka.actor.typed.Behavior;
import akka.actor.typed.javadsl.AbstractBehavior;
import akka.actor.typed.javadsl.ActorContext;
import akka.actor.typed.javadsl.Behaviors;
import akka.actor.typed.javadsl.Receive;

import java.io.Serializable;
import java.util.stream.IntStream;

public class ManagerBehavior extends AbstractBehavior<String> {
    // public interface Command  extends Serializable { }

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
                    IntStream.rangeClosed(0, 19).forEach(i -> {
                        ActorRef<WorkerBehavior.Command> worker = getContext().spawn(WorkerBehavior.create(), "worker" + i);
                        worker.tell(new WorkerBehavior.Command("start", getContext().getSelf()));
                    });
                    return this;
                })
                .build();
    }


}
