package gui_Panel_NhanVien;

import com.twilio.Twilio;
import com.twilio.converter.Promoter;
import com.twilio.exception.TwilioException;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import java.net.URI;

import javax.swing.JOptionPane;

import java.math.BigDecimal;

public class MessageSMS {
  // Find your Account Sid and Token at twilio.com/console
	
	public static final String ACCOUNT_SID = "AC9c66801519b2addffb818fb83c0f9d51";
    public MessageSMS() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static final String AUTH_TOKEN = "8b8fc6ab05f97a6be6902b8cd2c5b5d9";

    public static void sendMessage(String content) {
        try {
            Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
            Message message = Message.creator(
            	      new com.twilio.type.PhoneNumber("+84394352614"),
            	      new com.twilio.type.PhoneNumber("+12405415184"),
            	      content)
            	    .create();


            System.out.println(message.getSid());
            JOptionPane.showMessageDialog(null,"Thành công.\nSuccess.", "Notify", JOptionPane.INFORMATION_MESSAGE);
        } catch (TwilioException e) {
            // Handle Twilio-related exceptions here
            System.err.println("TwilioException: " + e.getMessage());
            JOptionPane.showMessageDialog(null,e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            // Handle other exceptions here
            System.err.println("Exception: " + e.getMessage());
            JOptionPane.showMessageDialog(null,e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}