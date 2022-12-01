import java.util.*;
import javax.swing.*;

public class Kriptografi { 
  public static final String alpha = "abcdefghijklmnopqrstuvwxyz";

  public static String encryptCaesar(String message, int shiftKey) {
    message = message.toLowerCase().replaceAll("\\s+","");
    String cipherText = "";
    for (int ii = 0; ii < message.length(); ii++) {
      int charPosition = alpha.indexOf(message.charAt(ii));
      int keyVal = (shiftKey + charPosition) % 26;
      char replaceVal = alpha.charAt(keyVal);
      cipherText += replaceVal;
    }
    return cipherText;
  }
  public static String decryptCaesar(String cipherText, int shiftKey) {
    cipherText = cipherText.toLowerCase();
    String message = "";
    for (int ii = 0; ii < cipherText.length(); ii++) {
      int charPosition = alpha.indexOf(cipherText.charAt(ii));
      int keyVal = (charPosition - shiftKey) % 26;
      if (keyVal < 0) {
        keyVal = alpha.length() + keyVal;
      }
      char replaceVal = alpha.charAt(keyVal);
      message += replaceVal;
    }
    return message;
  }

  public static String encryptVig(String text, final String key)
  {
      String res = "";
      text = text.toUpperCase();
      for (int i = 0, j = 0; i < text.length(); i++)
      {
          char c = text.charAt(i);
          if (c < 'A' || c > 'Z')
              continue;
          res += (char) ((c + key.charAt(j) - 2 * 'A') % 26 + 'A');
          j = ++j % key.length();
      }
      return res;
  }

  public static String decryptVig(String text, final String key)
  {
      String res = "";
      text = text.toUpperCase();
      for (int i = 0, j = 0; i < text.length(); i++)
      {
          char c = text.charAt(i);
          if (c < 'A' || c > 'Z')
              continue;
          res += (char) ((c - key.charAt(j) + 26) % 26 + 'A');
          j = ++j % key.length();
      }
      return res;
  }


  public static void main(String[] args) {
    String message,keyword,enC,enVig,deVig, deC = new String();    
    int key;

    JOptionPane.showMessageDialog(null, "Super Encryption Caesar and Vigenere Cipher \n         123190086-Raden Rara Lydia Devina", "123190086-IF D", JOptionPane.PLAIN_MESSAGE );
    message =JOptionPane.showInputDialog("Enter the String for Super Encryption:");
    key= Integer.parseInt(JOptionPane.showInputDialog("Enter Integer for Shift Key Caesar Encryption"));
    keyword =JOptionPane.showInputDialog("Enter the Keyword for Vigenere Encryption:");
    enC= encryptCaesar(message, key);
    enVig=encryptVig(enC,keyword);
    deVig= decryptVig(enVig, keyword);
    deC=decryptCaesar(deVig, key);

    JOptionPane.showMessageDialog(null, "Caesar Encrypted Message  : " + enC + "\nVigenere Encrypted Message : " +enVig+
    "\nVigenere Decrypted Message : "+deVig+"\nCaesar Decrypted Message : "+deC, "SUPER ENCRYPTION",JOptionPane.INFORMATION_MESSAGE);
  } 
} 

