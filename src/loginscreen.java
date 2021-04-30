import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*; 


class login 
    extends JFrame 
    implements ActionListener { 
    private static final long serialVersionUID = 1L;
    private Container c;
        private JLabel title; 
        private JLabel email; 
        private JTextField temail;
        private JLabel password;
        private JPasswordField tpassword;
        private JButton login;
        private JButton signup;

        public login()
        {
            setTitle("BANK"); 
        setBounds(300, 90, 900, 600); 
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
        setResizable(false);

        c = getContentPane(); 
        c.setLayout(null); 
        

        title = new JLabel("Bank Login Screen");
        title.setSize(300, 30);
        title.setFont(new Font("Arial", Font.PLAIN, 20)); 
        title.setLocation(360, 30);
        c.add(title);

        email = new JLabel("Email Address");
        email.setSize(200, 20);
        email.setLocation(300, 100);
        c.add(email);    

        temail = new JTextField();
        temail.setSize(200, 20);
        temail.setLocation(450, 100);
        c.add(temail);

        password = new JLabel("Password");
        password.setSize(100, 20);
        password.setLocation(300, 150);
        c.add(password);    

        tpassword = new JPasswordField();
        tpassword.setSize(200, 20);
        tpassword.setLocation(450, 150);
        c.add(tpassword);

        login = new JButton("Login");
        login.setSize(150, 20);
        login.setLocation(375, 220);
        login.addActionListener(this);
        add(login);

        signup = new JButton("Sign up");
        signup.setSize(150, 20);
        signup.setLocation(375, 240);
        signup.addActionListener(this);
        add(signup);

        setVisible(true);

        }
        
        public void actionPerformed(ActionEvent e) 
        {
            if (e.getSource() == signup)
            {
                registration regsistrationcall = new registration(); 
            }
            else if (e.getSource() == login)
            {
                String Email = temail.getText();
                char[] p= tpassword.getPassword();
                String Password =new String(p);
                int j=1;
                data details = new data(null, null, Password, null, Email, j );
                dispose();
            }
        }

        
    }

