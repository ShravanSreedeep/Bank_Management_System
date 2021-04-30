import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*; 

class home extends JFrame implements ActionListener 
{ 
    
    Main m = new Main();
    private static final long serialVersionUID = 1L;
    private Container c;
        private JLabel title; 
        private JLabel name; 
        private JLabel tname;
        private JLabel id;
        private JLabel tid;
        private JLabel balence;
        private JLabel tbalence;
        private JLabel amount;
        private JTextField tamount;
        private JButton deposit;
        private JButton send;
        private JButton withdraw;
        private JButton logout;

        public home(String Name, String Id, String Balence)
        {
            setTitle("BANK"); 
        setBounds(300, 90, 900, 600); 
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
        setResizable(false);

        c = getContentPane(); 
        c.setLayout(null); 

        title = new JLabel("Your Account");
        title.setSize(260, 30);
        title.setFont(new Font("Arial", Font.PLAIN, 20)); 
        title.setLocation(400, 30);
        c.add(title);

        name = new JLabel("Name");
        name.setSize(100, 20);
        name.setLocation(300, 100);
        c.add(name);    

        tname = new JLabel(Name);
        tname.setSize(200, 20);
        tname.setLocation(450, 100);
        c.add(tname);
        m.n = Name;

        id = new JLabel("ID");
        id.setSize(100, 20);
        id.setLocation(300, 150);
        c.add(id); 

        m.iD=Integer.parseInt(Id);

        tid = new JLabel(Id);
        tid.setSize(200, 20);
        tid.setLocation(450, 150);
        c.add(tid);

        balence = new JLabel("Balence");
        balence.setSize(100, 20);
        balence.setLocation(300, 200);
        c.add(balence);    

        tbalence = new JLabel(Balence);
        tbalence.setSize(200, 20);
        tbalence.setLocation(450, 200);
        c.add(tbalence);

        amount = new JLabel("Amount");
        amount.setSize(100, 20);
        amount.setLocation(300, 250);
        c.add(amount);    

        tamount = new JTextField();
        tamount.setSize(200, 20);
        tamount.setLocation(450, 250);
        c.add(tamount);

        deposit = new JButton("Deposit");
        deposit.setSize(150, 20);
        deposit.setLocation(375, 280);
        deposit.addActionListener(this);
        add(deposit);

        send = new JButton("Send");
        send.setSize(150, 20);
        send.setLocation(375, 300);
        send.addActionListener(this);
        add(send);

        withdraw = new JButton("Withdraw");
        withdraw.setSize(150, 20);
        withdraw.setLocation(375, 320);
        withdraw.addActionListener(this);
        add(withdraw);

        logout = new JButton("Logout");
        logout.setSize(150, 20);
        logout.setLocation(375, 360);
        logout.addActionListener(this);
        add(logout);

        setVisible(true);

        }

        
        public void actionPerformed(ActionEvent e) 
        {
            if (e.getSource() == deposit)
            {
                double Amt = Double.parseDouble(tamount.getText());
                int i = 2;
                String Name = m.n;
                data details = new data(m.iD,Name, null, Amt,null, i );
                dispose();
            }
            else if (e.getSource() == send)
            {
                double Amt = Double.parseDouble(tamount.getText());
                int i = 3;
                String Name = m.n;
                data details = new data(m.iD,Name, null, Amt,null, i );
                dispose();
            }
            else if (e.getSource() == withdraw)
            {
                double Amt = Double.parseDouble(tamount.getText());
                int i = 4;
                String Name = m.n;
                data details = new data(m.iD,Name, null, Amt,null, i );
                dispose();
            }
            else if (e.getSource() == logout)
            {
                login loginscreen = new login();
                dispose();
            }
        }
    }
