import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class user{
    private int plate;
    private int jug;
    private int spoon;

    public int getPlate() {
        return plate;
    }

    public void setPlate(int plate) {
        this.plate = plate;
    }

    public int getJug() {
        return jug;
    }

    public void setJug(int jug) {
        this.jug = jug;
    }

    public int getSpoon() {
        return spoon;
    }

    public void setSpoon(int spoon) {
        this.spoon = spoon;
    }

    @Override
    public String toString() {
        return "user{" +
                "plate=" + plate +
                ", jug=" + jug +
                ", spoon=" + spoon +
                '}';
    }
}

public class Hi {


    public static void main(String[] args) {
        JFrame f = new JFrame();

        JButton b1 = new JButton("OK");
        b1.setPreferredSize(new Dimension(100,50));
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
    int a;
                ArrayList<user> nalin = new ArrayList<user>();
                try{
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection c= DriverManager.getConnection("jdbc:mysql://localhost:3306/jtable","root","123");
                    Statement st = c.createStatement();
                    ResultSet rs = st.executeQuery("select * from simple where id ='1'");
                    while (rs.next())
                    {
                        user sim = new user();


                      rs.getInt(3);
                        sim.setJug(rs.getInt(4));
                        sim.setSpoon(rs.getInt(5));
                        nalin.add(sim);


                    }



                    Map hm = new HashMap();
                    hm.put("test", 7);
                    JasperDesign jp = JRXmlLoader.load(new File("").getAbsolutePath()+"\\newReports.jrxml");


                    JasperReport jr = JasperCompileManager.compileReport(jp);
                    JasperPrint jpr = JasperFillManager.fillReport(jr);

                    JasperViewer jv = new JasperViewer(jpr,false);
                    jv.setVisible(true);

                }catch (Exception xe)
                {
                    System.out.println(xe);
                }


            }
        });

        JButton b2 = new JButton("Save");
        b2.setPreferredSize(new Dimension(100,50));

        f.setLayout(new GridBagLayout());

        f.add(b1, new GridBagConstraints(0,0,1,1,1,0, GridBagConstraints.NORTH,
                GridBagConstraints.CENTER, new Insets(4,4,4,4), 0, 0));

        f.add(b2, new GridBagConstraints(1,0,1,1,1,0, GridBagConstraints.NORTH,
                GridBagConstraints.CENTER, new Insets(6,6,6,6), 0, 0));

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(600,600);
        f.setVisible(true);


    }
}