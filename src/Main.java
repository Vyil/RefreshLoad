import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.InputEvent;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws AWTException, InterruptedException, IOException, UnsupportedFlavorException {

        Robot robot = new Robot();
        ArrayList<Double> results = new ArrayList<>();
        double total = 0.0;

        for(int i =0; i <10;i++){
            System.out.println("On turn: "+i);
            robot.keyPress(17);
            robot.keyPress(116);
            robot.keyRelease(17);
            robot.keyRelease(116);
            robot.delay(6000);
            robot.mouseMove(1715,825);
            robot.delay(200);
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            robot.delay(100);
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            robot.delay(500);
            robot.keyPress(17);
            robot.keyPress(67);
            robot.keyRelease(17);
            robot.keyRelease(67);
            Thread.sleep(500);
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            Transferable content = clipboard.getContents(clipboard);
            String copyResult = (String) content.getTransferData(DataFlavor.stringFlavor);
            Double result = Double.parseDouble(copyResult);
            results.add(result);
            System.out.println(result);
        }

        for(Double a: results){
            total += a;
        }

        System.out.println("The average load time was: "+ total / results.size());

    }
}
