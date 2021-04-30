import javax.swing.*;
import java.util.Arrays;
import java.awt.*;
import java.awt.event.*; 

class registration 
    extends JFrame 
    implements ActionListener { 
    private static final long serialVersionUID = 1L;
    private Container c;
        private JLabel title; 
        private JLabel name; 
        private JTextField tname;
        private JLabel password;
        private JPasswordField tpassword;
        private JLabel repassword;
        private JPasswordField trepassword;
        private JLabel email; 
        private JTextField temail;
        private JButton signup;

        public registration()
        {
            setTitle("BANK"); 
        setBounds(300, 90, 900, 600); 
        setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
        setResizable(false);

        c = getContentPane(); 
        c.setLayout(null); 

        title = new JLabel("Bank Registration Screen");
        title.setSize(300, 30);
        title.setFont(new Font("Arial", Font.PLAIN, 20)); 
        title.setLocation(360, 30);
        c.add(title);

        name = new JLabel("Name");
        name.setSize(100, 20);
        name.setLocation(300, 100);
        c.add(name);    

        tname = new JTextField();
        tname.setSize(200, 20);
        tname.setLocation(450, 100);
        c.add(tname);

        password = new JLabel("Password");
        password.setSize(100, 20);
        password.setLocation(300, 150);
        c.add(password);    

        tpassword = new JPasswordField();
        tpassword.setSize(200, 20);
        tpassword.setLocation(450, 150);
        c.add(tpassword);

        repassword = new JLabel("Re Enter Password");
        repassword.setSize(150, 20);
        repassword.setLocation(300, 200);
        c.add(repassword);    

        trepassword = new JPasswordField();
        trepassword.setSize(200, 20);
        trepassword.setLocation(450, 200);
        c.add(trepassword);

        email = new JLabel("Email");
        email.setSize(100, 20);
        email.setLocation(300, 250);
        c.add(email);    

        temail = new JTextField();
        temail.setSize(200, 20);
        temail.setLocation(450, 250);
        c.add(temail);

        signup = new JButton("Sign up");
        signup.setSize(150, 20);
        signup.setLocation(375, 280);
        signup.addActionListener(this);
        add(signup);

        setVisible(true);

        }

        
        public void actionPerformed(ActionEvent e) 
        {
            String Name = tname.getText();
            char[] Password = tpassword.getPassword();
            char[] RePassword = trepassword.getPassword();
            String Email = temail.getText();
            Integer i = 0;
            if(Arrays.equals(Password, RePassword))
            {

                String p = new String(Password);
                data d = new data(null, Name, p, null, Email, i );
                System.out.println(Password);
                JFrame f=new JFrame();  
                JOptionPane.showMessageDialog(f,"Success","Alert",JOptionPane.WARNING_MESSAGE);
                dispose();
            }
            else
            {
                JFrame f=new JFrame();  
                JOptionPane.showMessageDialog(f,"Passwords donot match","Alert",JOptionPane.WARNING_MESSAGE);
                tpassword.setText("");
                trepassword.setText("");
            }
        }
    }
