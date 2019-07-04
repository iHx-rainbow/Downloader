package UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import Service.SwingWorker;

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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField2;
    
    private List<SwingWorker> sw;
    
    // DownloadThread dt;
    private MainFrame mainframe = this;

    public MainFrame() {
        setTitle("多线程下载器");
        setSize(500, 400);
        setLocation(400, 200);

        // jp = new JPanel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("开始下载");

        jTable1.setModel(
                new javax.swing.table.DefaultTableModel(
                        new Object[][] { { null, null, null, null }, { null, null, null, null },
                                { null, null, null, null }, { null, null, null, null }, { null, null, null, null },
                                { null, null, null, null }, { null, null, null, null }, { null, null, null, null },
                                { null, null, null, null }, { null, null, null, null } },
                        new String[] { "下载队列", "下载状态״̬", "下载进度", "下载速度" }));
        jScrollPane1.setViewportView(jTable1);

        jButton2.setText("暂停");

        jButton3.setText("继续");

        jButton4.setText("暂停全部");

        jButton5.setText("继续全部");

        jLabel1.setText("当前下载进度");

        jLabel2.setText("进程数");

        jButton6.setText("确定");

        jLabel3.setText("0");

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
                                                                jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE,
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
                        .addComponent(jLabel3))
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
                
                sw = new ArrayList<SwingWorker>();
                
                
                
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

            }

        });

        setVisible(true);
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
