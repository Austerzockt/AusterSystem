package at.auster.system.localisation;

import at.auster.system.localisation.locales.EnglishMessages;

public class MessageHandler {
    private AbstractMessages abstractMessages;
    public MessageHandler(Languages languages) {
        switch (languages) {
            case ENGLISH:
                abstractMessages = new EnglishMessages();
                break;
        }
    }

    public enum Languages {
        ENGLISH
    }
    public enum Messages {
        NOPERMS,
        RANK_SET,
        RANK_ADD,
        RANK_REMOVE

    }
    public Message getMessage(Messages messages) {
    return abstractMessages.getMessage(messages);
    }
}
