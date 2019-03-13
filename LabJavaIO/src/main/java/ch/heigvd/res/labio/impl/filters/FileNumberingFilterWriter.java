package ch.heigvd.res.labio.impl.filters;

import java.io.FilterWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.logging.Logger;

/**
 * This class transforms the streams of character sent to the decorated writer.
 * When filter encounters a line separator, it sends it to the decorated writer.
 * It then sends the line number and a tab character, before resuming the write
 * process.
 *
 * Hello\n\World -> 1\Hello\n2\tWorld
 *
 * @author Olivier Liechti
 */
public class FileNumberingFilterWriter extends FilterWriter {

  private static final Logger LOG = Logger.getLogger(FileNumberingFilterWriter.class.getName());

  private int tab = 0;
  private int test = 0;

  public FileNumberingFilterWriter(Writer out) {
    super(out);
  }

  @Override
  public void write(String str, int off, int len) throws IOException {
    if (test == 0) {
      out.write("" + ++tab + "\t");
      test = 1;
    }
    for (int i = off; i < (off + len); ++i) {
      out.write(str.charAt(i));
      if ( (i+1 < off+len) && str.charAt(i) == '\r' && str.charAt(i+1) == '\n') {

      } else if (str.charAt(i) == '\n' || str.charAt(i) == '\r' ) {
        out.write("" + ++tab + "\t");
      }
    }
  }

  @Override
  public void write(char[] cbuf, int off, int len) throws IOException {
    if (test == 0) {
      out.write("" + ++tab + "\t");
      test = 1;
    }
    for (int i = off; i < (off + len); ++i) {
      out.write(cbuf[i]);
      if ( (i+1 < off+len) && cbuf[i] == '\r' && cbuf[i] == '\n') {

      } else if (cbuf[i] == '\n' || cbuf[i] == '\r' ) {
        out.write("" + ++tab + "\t");
      }
    }
  }

  @Override
  public void write(int c) throws IOException {
    if (test == 0) {
      out.write("" + ++tab + "\t");
      test = 1;
    }
    out.write((char)c);
    if ((char)c == '\n') {
      out.write("" + ++tab + "\t");
    }
  }

}
