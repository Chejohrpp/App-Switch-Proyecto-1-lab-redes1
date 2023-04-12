package gui_logic;

 // @author sergi
import java.io.OutputStream;
import java.io.PrintStream;
import javax.swing.JTextArea;


public class ConsolePrintStream extends PrintStream {
    private JTextArea console;
    public ConsolePrintStream(JTextArea console, OutputStream out) {
        super(out);
        this.console = console;
    }
    public void write(byte[] buf, int off, int len) {
        String message = new String(buf, off, len);
        console.append(message);
    }
}

