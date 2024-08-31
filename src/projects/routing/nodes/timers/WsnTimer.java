package projects.routing.nodes.timers;

import projects.routing.nodes.messages.WsnMessage;
import projects.routing.nodes.nodeImplementations.SinkNode;
import sinalgo.nodes.timers.Timer;

public class WsnTimer extends Timer {

    private WsnMessage message = null;

    public WsnTimer(WsnMessage message) {
        this.message = message;
    }

    @Override
    public void fire() {
        ((SinkNode) node).broadcast(message);
    }

}
