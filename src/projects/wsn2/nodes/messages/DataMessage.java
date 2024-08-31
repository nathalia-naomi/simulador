package projects.wsn2.nodes.messages;

import sinalgo.nodes.messages.Message;

public class DataMessage extends Message {
    private String data;

    public DataMessage(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    @Override
    public Message clone() {
        return new DataMessage(data);
    }
}