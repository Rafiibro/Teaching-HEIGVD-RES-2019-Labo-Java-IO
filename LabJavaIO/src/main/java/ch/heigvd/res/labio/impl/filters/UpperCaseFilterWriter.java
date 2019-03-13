package ch.heigvd.res.labio.impl.filters;

import java.io.FilterWriter;
import java.io.IOException;
import java.io.Writer;

/**
 *
 * @author Olivier Liechti
 */
public class UpperCaseFilterWriter extends FilterWriter {
  
  public UpperCaseFilterWriter(Writer wrappedWriter) {
    super(wrappedWriter);
  }

  @Override
  public void write(String str, int off, int len) throws IOException {
    //throw new UnsupportedOperationException("The student has not implemented this method yet.");

    for (int i = off; i < (len + off); ++i) {
      if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
        out.write(str.charAt(i) - 32);
      } else {
        out.write(str.charAt(i));
      }
    }
  }

  @Override
  public void write(char[] cbuf, int off, int len) throws IOException {

    for (int i = off; i < (len + off); ++i) {
      if (cbuf[i] >= 'a' && cbuf[i] <= 'z') {
        out.write(cbuf[i] - 32);
      } else {
        out.write(cbuf[i]);
      }
    }
  }

  @Override
  public void write(int c) throws IOException {
    if (c >= 'a' && c <= 'z') {
      out.write((char)(c - 32));
    } else {
      out.write((char)c);
    }
  }

}
