import org.example.controller.filters.Messages;

import java.util.Locale;

import static junit.framework.TestCase.assertEquals;

public class CanGetLocalizedStrings {
    @org.junit.Test
    public void testUkrainianMessages(){
        Locale locale = new Locale("uk");
        Messages messages = new Messages(locale);
        System.out.println(messages);
        assertEquals("Увійти", messages.getLogin());
    }
}
