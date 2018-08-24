import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.*;

public class Launch extends Frame implements ActionListener{
    private Label lblCount, minCount, secCount, milCount;
    private TextField tfCount;
    private Button btnCount;
    private int count = 0;
    private int minutes = 0;
    private int seconds = 0;
    private int milseconds = 0;
    
    public Launch() {
        setLayout(new FlowLayout());                //Super frame for layout. Sets components from Left to Right
        lblCount = new Label("Counter");            //Constructs the label for "Counter"
        minCount = new Label("Minutes: " + minutes);
        secCount = new Label("Seconds: " + seconds);
        milCount = new Label("Miliseconds: " + milseconds);
        tfCount = new TextField(count + "", 10);    //Constructs the text field compent with the inital text
        add(lblCount);
        tfCount.setEditable(false);                 // Sets to read only (Cannot be edited)
        add(tfCount);                               //Adds textfield component

        btnCount = new Button("Count");             // Constructs the button component
        add(btnCount);                              // Adds button to the frame
        btnCount.addActionListener(this);
        // "btnCount" is the soruce object that fires an ActionEvent when clicked
        // The source add "this" isntance as an ActionEvent listener, which provides
        // an ActionEvent handler called actionPerformed().
        // Clicking btnCount invokes actionPerformed.
        add(minCount);
        add(secCount);
        add(milCount);

        setTitle("Morten's Counter Program");       // Sets the title of the program in the program bar
        setSize(350, 125);                          // Defines the size of the window

        setVisible(true);
        
    }

    public static void main(String []args) {
        Launch app = new Launch();
    }

    //Event action handler. Called back upon button click
    @Override
    public void actionPerformed(ActionEvent evt) {

        while(count<120000){
        count++; // Increases the counter value
        milseconds++;
        if (milseconds >= 1000) {
            if (seconds >= 60) {
                minutes++;
                seconds = 0;
                }
            seconds++;
            milseconds = 0;
            }
        // Display the counter value in TextField tfCount
        tfCount.setText(count + ""); // Convert int to String
        minCount.setText("Minutes: " + minutes); // Convert int to String
        secCount.setText("Seconds: " + seconds); // Convert int to String
        milCount.setText("Miliseconds: " + milseconds); // Convert int to String
        try {
        TimeUnit.MILLISECONDS.sleep(1); // Sleep for a milisecond
        } catch(InterruptedException e) {
            System.out.println(e);
        }
        }
    }
}