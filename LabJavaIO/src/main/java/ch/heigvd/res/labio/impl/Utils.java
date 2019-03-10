package ch.heigvd.res.labio.impl;

import java.util.logging.Logger;

/**
 *
 * @author Olivier Liechti
 */
public class Utils {

  private static final Logger LOG = Logger.getLogger(Utils.class.getName());

  /**
   * This method looks for the next new line separators (\r, \n, \r\n) to extract
   * the next line in the string passed in arguments. 
   * 
   * @param lines a string that may contain 0, 1 or more lines
   * @return an array with 2 elements; the first element is the next line with
   * the line separator, the second element is the remaining text. If the argument does not
   * contain any line separator, then the first element is an empty string.
   */
  public static String[] getNextLine(String lines) {
    //throw new UnsupportedOperationException("The student has not implemented this method yet.");

    String[] line = new String[2];

    for(int i = 0; i < lines.length(); ++i) {
      if((i+1 < lines.length()) && lines.charAt(i) == '\r' && lines.charAt(i+1) == '\n') {
        line[0] = lines.substring(0, i+2);
        line[1] = lines.substring(i + 2);
        break;
      } else if (lines.charAt(i) == '\r' || lines.charAt(i) == '\n') {
        line[0] = lines.substring(0, i+1);
        if ((i+1 > lines.length())) {
          line[1] = "";
        } else {
          line[1] = lines.substring(i + 1);
        }
        break;
      }
    }

    if (line[0] == null && line[1] == null) {
      line[0] = ""; 
      line[1] = lines;
    }

    return line;
  }

}
