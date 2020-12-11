package at.auster.system.localisation;

import java.util.HashMap;

public abstract class AbstractMessages {
    protected HashMap<MessageHandler.Messages, Message> messages = new HashMap<>();
    public Message getMessage(MessageHandler.Messages message) {
        return messages.get(message);
    }
    public abstract void register();
}
