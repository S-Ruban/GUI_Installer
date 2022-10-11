import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.WindowConstants;

public class Installer extends JFrame
{

	public static void main(String [] args) throws IOException, InterruptedException
	{
		JFrame jf = new JFrame("Installer");
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		JProgressBar jpb = new JProgressBar();
		jpb.setValue(0);
		jpb.setStringPainted(true);
		panel.add(jpb);
		jf.add(panel);
		jf.setSize(500, 500);
		jf.setVisible(true);
		Scanner sc = new Scanner(new File("scripts.txt"));
		ArrayList<String> scripts = new ArrayList<String>();
		ArrayList<Integer> percentages = new ArrayList<Integer>();
		while(sc.hasNext())
		{
			scripts.add(sc.next());
			percentages.add(sc.nextInt());
		}
		ProcessBuilder pb = new ProcessBuilder();
		Process process ;
		for(int i = 0; i < scripts.size(); i++)
		{
			pb.command("./scripts/" + scripts.get(i));
			process = pb.start();
			if(process.waitFor() == 0)
				jpb.setValue(percentages.get(i));
		}
	}
}
