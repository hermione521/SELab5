package unitTest;

import static org.junit.Assert.*;
import interfaces.UiActions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.junit.Rule;
import org.junit.Test;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.jmock.Expectations;

import sun.swing.UIAction;
import ui.config.ButtonExit;

public class PanelTest {
	@Rule public JUnitRuleMockery context = new JUnitRuleMockery();
    
    @Test 
    public void oneSubscriberReceivesAMessage() {
        // set up
        final ActionListener actionListener = context.mock(ActionListener.class);

        ButtonExit buttonExit = new ButtonExit();
        buttonExit.addActionListener(actionListener);
        
        final String message = "message";
        
        // expectations
        context.checking(new Expectations() {{
            ((UiActions) oneOf (actionListener)).clickReturnMenu();
        }});

        // execute
        buttonExit.publish(message);
    }
}