package projects.wsn2.nodes.messages;

import sinalgo.nodes.messages.Message;

public class RouteMessage extends Message {
    @Override
    public Message clone() {
        return this; 
    }
}