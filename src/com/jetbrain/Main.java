package com.jetbrain;
import javax.swing.*;
import java.text.DecimalFormat;

public class Main {

    public static void main(String[] args) {
        String EmpName,HourNum,Status;
        double IntHourNum,Normalpayrate,Normalpay = 0,Underpayrate,Overtimepayrate,Overtimepay = 0,Totalpay;

        //Initializing the pay rates.
        Normalpayrate = 14.00;
        Overtimepayrate = 16.00;
        Underpayrate = 12.00;

        //Asking user for input and checking if it is correct. If not it repeats itself.
        do {
            EmpName = JOptionPane.showInputDialog("Please enter the employee's name");
            if (!(EmpName != null)) {
                JOptionPane.showMessageDialog(null, "Process ended.", "Termination", JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }
            HourNum = JOptionPane.showInputDialog("Please enter the employee's hours");
            if (!(HourNum != null)) {
                JOptionPane.showMessageDialog(null, "Process ended.", "Termination", JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }
        } while (JOptionPane.showConfirmDialog(null,"Is this correct?"+"\nEmployee Name: " + EmpName + "\nHours Worked: " + HourNum + " Hours","Confirmation",JOptionPane.YES_NO_OPTION)==JOptionPane.NO_OPTION);

        //Converting the hours which were input from string to double.
        IntHourNum = Double.parseDouble(HourNum);

        //Checking if the hours are over 40 and calculating pay. It also determines the status of the worker.
        if (IntHourNum >= 40.00) {

            Status = "Full-Time Worker";
            Normalpay=40*Normalpayrate;
            Overtimepay=0;

            if(IntHourNum>40.00) {
                Overtimepay=(IntHourNum-40)*Overtimepayrate;
                Totalpay=Overtimepay+Normalpay; }
            else
                Totalpay=Underpayrate*IntHourNum;}

        else {

            Status = "Part-Time Worker";
            Totalpay = IntHourNum * Underpayrate; }

        //Creates the format in which the results will be displayed.
        DecimalFormat df = new DecimalFormat("###.##");

        //Displaying the results
        JOptionPane.showMessageDialog(null,"Employee Name: "+EmpName+"\nHours Worked: "+df.format(IntHourNum)+" Hours"+"\nStatus: "+Status+"\nNormal Pay: $"+df.format(Normalpay)+"\nOvertime Pay: $"+df.format(Overtimepay)+"\nTotal Pay: $"+df.format(Totalpay),"Results",JOptionPane.INFORMATION_MESSAGE);
    }
}
