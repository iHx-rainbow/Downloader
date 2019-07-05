package Service;

import java.util.List;

import UI.MainFrame;


public class SwingWorker extends javax.swing.SwingWorker<Integer, Integer> {
    
	
	public int swid;
    private String url;
	private String local;
	private int threadsnum;
	private MainFrame mainframe;
	private Downloader downloader;
	private int priority;
	private int rownum;
	boolean hang=false;
	

	

	public SwingWorker(String url, String local, int threadsnum, MainFrame mainframe,int id, int rownum) {
		this.swid=id;
        this.url = url;
        this.local = local;
        this.threadsnum = threadsnum;
        this.mainframe = mainframe;
        this.setPriority(1);
        this.setRownum(rownum);
    }

	
	
	@Override
	protected Integer doInBackground() throws Exception {
		// TODO Auto-generated method stub
		mainframe.getjTable1().setValueAt(local,swid,3);
		downloader = new Downloader(url, local, threadsnum, mainframe);
		downloader.startDownload(); // 开始下载
		mainframe.getjTable1().setValueAt("正在下载",swid,1);
		while(downloader.getTotal()<100){
			Thread.sleep(200);
			publish(downloader.getTotal());
		}
		if(downloader.getTotal()==100){
			mainframe.getjTable1().setValueAt("下载完成", swid, 1);
			mainframe.manager.finish(this);
			/*
			for (int i = 1; i <= xz.threadCount; i++) {
                 File delteFile = new File(xz.path1+i+xuhao+".txt");
                     delteFile.delete();
                 }
            */
			//demo.NewJFrame.manager.finish(this);
		}
		
		return null;
	}
	
	public void process(List<Integer> chunks) {
		/*for (Integer per : chunks) {
			//String a = String.valueOf(per);
			//ui.jLabel3.setText(per+"%");
		}*/
		//if ( flag== false) {
			for (int i : chunks) {
				mainframe.getjTable1().setValueAt(i + "%", swid, 2);
			}
		//}
	}


	public void suspend(int row) {
		// TODO Auto-generated method stub
		downloader.suspend();
		//System.out.println(downloader.getLocal());
		this.hang=true;
		mainframe.getjTable1().setValueAt("暂停下载", row, 1);
	}


	public void resume(int row) {
		// TODO Auto-generated method stub
		downloader.resume();
		
		mainframe.getjTable1().setValueAt("正在下载", row, 1);
	}


	public int getPriority() {
		return priority;
	}


	public void setPriority(int priority) {
		this.priority = priority;
	}


	public int getRownum() {
		return rownum;
	}


	public void setRownum(int rownum) {
		this.rownum = rownum;
	}
		
}
