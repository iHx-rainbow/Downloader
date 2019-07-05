package UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

import Service.SwingWorker;
import Service.TaskManager;

@SuppressWarnings("unused")
public class MainFrame extends JFrame {
    /**
     * 
     */

    /*
     * public int exist=0; public int total=0; public JProgressBar[] bars; public
     * JPanel jp;
     */
    private static final long serialVersionUID = 1L;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    @SuppressWarnings("rawtypes")
	private JComboBox jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField2;
    
    
    
    private ArrayList<SwingWorker> sw=new ArrayList<SwingWorker>();
    private int id=0;	//下载任务id
    private int rows=0;	//下载队列行数
    // DownloadThread dt;
    public TaskManager manager = new TaskManager();
    private MainFrame mainframe = this;

    @SuppressWarnings({ "rawtypes", "unchecked" })
	public MainFrame() {
        setTitle("多线程下载器");
        setSize(600, 400);
        setLocation(400, 200);

        // jp = new JPanel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        setjTable1(new javax.swing.JTable());
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        setjLabel3(new javax.swing.JComboBox());
        
        getjLabel3().setModel(new DefaultComboBoxModel(new String[] {"1","2","3"}));
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("开始下载");

        getjTable1().setModel(
                new javax.swing.table.DefaultTableModel(
                        new Object[][] {},
                        new String[] { "下载队列", "下载状态״̬", "下载进度", "下载地址", "优先级" }));
        jScrollPane1.setViewportView(getjTable1());

        jTable1.getColumnModel().getColumn(3).setPreferredWidth(300);
        
        jButton2.setText("暂停");

        jButton3.setText("继续");

        jButton4.setText("暂停全部");

        jButton5.setText("继续全部");

        jLabel1.setText("优先级");

        jLabel2.setText("进程数");

        jButton6.setText("修改");

        //jLabel3.setText("0");

        jTextField2.setText("3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
                .createSequentialGroup().addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup().addComponent(jButton1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jButton3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jButton4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jButton5))
                                        .addGroup(layout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout
                                                        .createSequentialGroup().addComponent(jLabel1)
                                                        .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(
                                                                getjLabel3(), javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout
                                                        .createSequentialGroup().addComponent(jLabel2)
                                                        .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(jTextField2,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 57,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jButton6))))
                                .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
                .createSequentialGroup().addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jButton1)
                        .addComponent(jButton2).addComponent(jButton3).addComponent(jButton4).addComponent(jButton5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel1)
                        .addComponent(getjLabel3()))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel2)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 208,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap()));

        jButton1.addActionListener(new ActionListener() // 开始下载
        {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub

                int threadsnum = Integer.parseInt(jTextField2.getText());
                
                new NewDownload(threadsnum, mainframe);
                //NewDownload mf = new NewDownload(count);
                //mf.setVisible(true);
            }

        });

        jButton2.addActionListener(new ActionListener() // 暂停下载
        {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
            	int row=jTable1.getSelectedRow();
            	sw.get(row).suspend(row);
            	/*
            	System.out.println("swjilu"+sw.size());
            	System.out.println(row);
            	System.out.println(sw.get(row).swid);
            	*/
            	//manager.sus(f[row]);
            }

        });
        
        jButton3.addActionListener(new ActionListener() // 继续下载
        {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
            	int row=jTable1.getSelectedRow();
            	sw.get(row).resume(row);
            	
            	//manager.sus(f[row]);
            }

        });
        
        jButton4.addActionListener(new ActionListener() // 暂停全部下载
        {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
            	//int row=jTable1.getSelectedRow();
            	for(int row=0;row<getRows();row++) {
            		if(jTable1.getValueAt(row,1)=="正在下载") {
            			sw.get(row).suspend(row);
            		}
            	}
            	
            	//manager.sus(f[row]);
            }

        });
        
        jButton5.addActionListener(new ActionListener() // 继续全部下载
        {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
            	
            	for(int row=0;row<getRows();row++) {
            		if(jTable1.getValueAt(row,1)=="暂停下载") {
            			sw.get(row).resume(row);
            		}
            	}
            	
            	//manager.sus(f[row]);
            }

        });
        
        jButton6.addActionListener(new ActionListener() // 更改优先级
        {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
            	int row=jTable1.getSelectedRow();
            	int priority=Integer.parseInt(getjLabel3().getSelectedItem().toString());
            	sw.get(row).setPriority(priority);
				mainframe.getjTable1().setValueAt(priority,row,4);
            	manager.res();
            }

        });

        setVisible(true);
    }

	public javax.swing.JTable getjTable1() {
		return jTable1;
	}

	public void setjTable1(javax.swing.JTable jTable1) {
		this.jTable1 = jTable1;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ArrayList<SwingWorker> getSw() {
		return sw;
	}

	public void setSw(ArrayList<SwingWorker> sw) {
		this.sw = sw;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	@SuppressWarnings("rawtypes")
	public JComboBox getjLabel3() {
		return jLabel3;
	}

	@SuppressWarnings("rawtypes")
	public void setjLabel3(JComboBox jLabel3) {
		this.jLabel3 = jLabel3;
	}



    /**
     * @param args
     */

    /*
     * public static void main(String[] args) { // TODO Auto-generated method stub
     * new MainFrame(); //主界面 }
     */

    /*
     * public void addBars(List<DownloadInfo> infos) {
     * 
     * bars = new JProgressBar[infos.size()]; int yOffset = 45; for (DownloadInfo
     * info : infos){ bars[info.getIndex()] = new JProgressBar();
     * bars[info.getIndex()].setMaximum(info.getEnd() - info.getStart() + 1);
     * bars[info.getIndex()].setValue(0); bars[info.getIndex()].setBounds(230,
     * yOffset + info.getIndex() * 16 , 200, 15); exist=exist+1;
     * this.add(bars[info.getIndex()]); //this.add(jp); } this.repaint(); }
     * 
     * public void removeBars() { //this.remove(jp); if(exist!=0) { for (int i
     * =0;i<exist;i++){ this.remove(bars[i]); } } exist=0; }
     * 
     * 
     * public void updateBar(int index, int len, int fileLength) {
     * bars[index].setValue(bars[index].getValue() + len); /* int[] a = new
     * int[exist]; for (int i=0;i<exist;i++){ a[i]=bars[i].getValue(); }
     * 
     * total=0; for (int i=0;i<exist;i++){ total=bars[i].getValue()+total; }
     * updateProcess(fileLength); //total = total+len; /*
     * 
     * 
     * 
     * //a[index]=bars[index].getValue(); //total=a[0]+a[1]+a[2];
     * 
     * }
     * 
     * 
     * public void updateProcess(int fileLength) {
     * 
     * jLabel3.setText(total+"/"+fileLength); this.repaint(); }
     */

}
