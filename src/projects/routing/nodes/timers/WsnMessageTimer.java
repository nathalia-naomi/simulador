package projects.routing.nodes.timers;

import projects.routing.nodes.messages.WsnMessage;
import sinalgo.nodes.timers.Timer;

public class WsnMessageTimer extends Timer {

    private WsnMessage message = null;

    public WsnMessageTimer(WsnMessage message) {
        this.message = message;
    }

    @Override
    public void fire() {
        node.broadcast(message);
    }

}
