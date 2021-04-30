import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

class data 
{
    public data(Integer Id, String Name, String Password, Double Amount, String Email, Integer i)
    {
        try
        {
                
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankdetails","root","admin123");
            Statement state = c.createStatement();
            if(i==0)    //registration
            {
                int rs = state.executeUpdate("insert into bank (Name,password,email) Values ('"+Name+"','"+Password+"','"+Email+"');");
            }
            else if(i==1)    //To login to homescreen
            {
                ResultSet r = state.executeQuery("select * from bank where email = '"+Email+"' and password = '"+Password+"';");
                if (r.next() == false)
                {
                    JFrame a = new JFrame();
                    JOptionPane.showMessageDialog(a,"Incorrect email or password", "Alert", JOptionPane.WARNING_MESSAGE);
                    login loginscreen = new login();
                }
                Main mydata = new Main();
                System.out.println(r.getString(3));
                mydata.iD=r.getInt(1);
                mydata.n = r.getString(2);
                mydata.a = r.getDouble(4);
                String id =String.valueOf(mydata.iD);
                String a =String.valueOf(mydata.a);
                home homescreen = new home(mydata.n,id,a);
            }
            else if (i==2)  //To deposit
            {
                ResultSet ra = state.executeQuery("select * from bank where  Id = '"+Id+"';");
                ra.next();
                Double bal = ra.getDouble(4);
                Double total = bal + Amount;
                int rs = state.executeUpdate("UPDATE bank SET amount = '"+total+"' WHERE  Id = '"+Id+"';");
                ResultSet r = state.executeQuery("select * from bank where Id = '"+Id+"';");
                r.next();
                Main mydata = new Main();
                System.out.println(r.getString(3));
                mydata.iD=r.getInt(1);
                mydata.n = r.getString(2);
                mydata.a = r.getDouble(4);
                String id =String.valueOf(mydata.iD);
                String a =String.valueOf(mydata.a);
                home homescreen = new home(mydata.n,id,a);
            }
            else if (i==3)  //To Send
            {
                JFrame sending = new JFrame();
                String receiver = JOptionPane.showInputDialog(sending,"Email of receipient", null);
                ResultSet r = state.executeQuery("select * from bank where Id = '"+Id+"';");
                r.next();
                Double bal = r.getDouble(4);
                if(Amount>bal)
                {
                    JFrame broke = new JFrame();
                    JOptionPane.showMessageDialog(broke,"Not enough money","Alert",JOptionPane.WARNING_MESSAGE);
                }
                else
                {    
                    Double total = bal - Amount;
                    int rs = state.executeUpdate("UPDATE bank SET amount = '"+total+"' WHERE  Id = '"+Id+"';");
                    ResultSet rb = state.executeQuery("select * from bank where Email = '"+receiver+"';");
                    rb.next();
                    Double balnce = rb.getDouble(4);
                    Double ttl = balnce + Amount;
                    int rd = state.executeUpdate("UPDATE bank SET amount = '"+ttl+"' WHERE email ='"+receiver+"';");
                    JFrame success = new JFrame();
                    JOptionPane.showMessageDialog(success,"Money send","Alert",JOptionPane.WARNING_MESSAGE);
                }
                        
                ResultSet re = state.executeQuery("select * from bank where  Id = '"+Id+"';");
                re.next();
                Main mydata = new Main();
                mydata.iD=re.getInt(1);
                mydata.n =re.getString(2);
                mydata.a =re.getDouble(4);
                String id =String.valueOf(mydata.iD);
                String a =String.valueOf(mydata.a);
                home homescreen = new home(mydata.n,id,a);
            }
            else if (i==4)  //To withdraw
            {
                ResultSet ra = state.executeQuery("select * from bank where  Id = '"+Id+"';");
                ra.next();
                Double bal = ra.getDouble(4);
                Double total = bal - Amount;
                int rs = state.executeUpdate("UPDATE bank SET amount = '"+total+"' WHERE  Id = '"+Id+"';");
                ResultSet r = state.executeQuery("select * from bank where  Id = '"+Id+"';");
                r.next();
                Main mydata = new Main();
                System.out.println(r.getString(3));
                mydata.iD=r.getInt(1);
                mydata.n = r.getString(2);
                mydata.a = r.getDouble(4);
                String id =String.valueOf(mydata.iD);
                String a =String.valueOf(mydata.a);
                home homescreen = new home(mydata.n,id,a);
            }
            
            c.close();
        
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
    }
}
