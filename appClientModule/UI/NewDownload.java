package UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

import Service.SwingWorker;

public class NewDownload extends JFrame {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;

    private NewDownload newdownload = this;


    public NewDownload(int threadsnum, MainFrame mainframe) {
        setTitle("新建下载");
        setSize(550, 250);
        setLocation(400, 300);
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        // setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("下载地址");
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel2.setText("本地地址");

        jButton1.setText("选择");

        jButton2.setText("开始下载");

        jButton3.setText("取消下载");
        jTextArea1.setLineWrap(true);

        jTextArea1.setText("https://dldir1.qq.com/weixin/Windows/WeChatSetup.exe");
        //jTextArea1.setText("https://download.ccleaner.com/ccsetup559.exe");
        
        jTextField1.setText("C:\\Users\\Admin\\Desktop\\download\\WeChatSetup.exe");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup().addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup().addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 234,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup().addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup().addComponent(jButton2)
                                                        .addGap(63, 63, 63).addComponent(jButton3)
                                                        .addGap(0, 0, Short.MAX_VALUE))
                                                .addComponent(jTextField1))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jButton1)
                        .addContainerGap(34, Short.MAX_VALUE)));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
                .createSequentialGroup().addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jLabel1)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 70,
                                javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2).addComponent(jButton1))
                .addGap(18, 18, 18).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton2).addComponent(jButton3))
                .addContainerGap(14, Short.MAX_VALUE)));

        jButton2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                // mf.total=0;

            	
                String url = jTextArea1.getText();
                String local = jTextField1.getText();
                DefaultTableModel dtm;
                dtm =(DefaultTableModel) mainframe.getjTable1().getModel();
                int id=mainframe.getId();
                int rownum=mainframe.getRows();
                Vector<Object> vData=new Vector<Object>();
        		vData.add(rownum+1);
        		mainframe.setId(id+1);
        		mainframe.setRows(rownum+1);
        		//vData.add(jTextField3.getText());
        		//vData.add(jTextField2.getText());
        		dtm.addRow(vData);
        		/*
        		for(int i=0;i<ID;i++)
        		{
        			if(mainframe.getjTable1().getValueAt(i,1)!="下载完成")
        			{
        				mainframe.getjTable1().setValueAt("等待下载",i,1);
        			}
        			
        		}
        		*/
        		String p= mainframe.getjLabel3().getSelectedItem().toString();
        		int priority=Integer.parseInt(p);
        		SwingWorker newsw=new SwingWorker(url, local, threadsnum, mainframe,id,rownum, priority);
        		mainframe.getSw().add(newsw);
        		//System.out.println(mainframe.getSw().size());
        		mainframe.getjTable1().setValueAt("等待下载",rownum,1);
        		mainframe.manager.add(newsw);
        		//newsw.execute();
        		/*
        		xuhao++;
        		System.out.println(xuhao);
        		f[ID].setPriority(ID);
			    manager.add(f[ID]);
			    manager.re();
			    manager.execute();
			    ID++;
			    */
                
                
                
                
                
                
                // int count = downcount;
                
                // List<DownloadInfo> infos = downloader.getInfos();
                // mainframe.addBars(infos); //动态添加进度条

                
                
                
                
                /*
        		Downloader downloader = new Downloader(url, local, threadsnum, mainframe);
                downloader.startDownload(); // 开始下载
                */
                
                
                
                
                
                
                newdownload.dispose();
            }
        });
        
        
        
        jButton1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser choose = new JFileChooser();
                choose.setAcceptAllFileFilterUsed(false);
                choose.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY );
                choose.showOpenDialog(null);
                String savepath= choose.getSelectedFile().getPath();
                String url = jTextArea1.getText();
                String[] splitstr=url.split("/");
                String path=splitstr[splitstr.length-1];
                jTextField1.setText(savepath+"\\"+path);
            }
        });
        


        setVisible(true);
    }
    /*
     * @Override public void actionPerformed(ActionEvent e) { Object source =
     * e.getSource(); //开始按钮 if (source == jButton2){ String url =
     * jTextArea1.getText(); String local = jTextField1.getText(); int count =
     * downcount;
     * 
     * Downloader downloader = new Downloader(url, local, count, this); // 2、取得infos
     * List<DownloadInfo> infos = downloader.getInfos(); // 3、动态添加进度条
     * this.addBars(infos);
     * 
     * // 4、开始下载 downloader.startDownload(); } }'
     */

}
