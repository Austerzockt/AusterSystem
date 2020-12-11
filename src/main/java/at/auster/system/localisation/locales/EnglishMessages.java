package at.auster.system.localisation.locales;


import at.auster.system.localisation.AbstractMessages;
import at.auster.system.localisation.Message;
import at.auster.system.localisation.MessageHandler;

public class EnglishMessages extends AbstractMessages {

    @Override
    public void register() {
        messages.put(MessageHandler.Messages.NOPERMS, new Message("&cYou don't have the permission to use this command"));
    }
}
