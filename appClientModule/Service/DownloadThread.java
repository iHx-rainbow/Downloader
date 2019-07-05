package Service;

import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;

import Model.DownloadInfo;

public class DownloadThread extends Thread {

    private DownloadInfo info;
	private int total;
	volatile boolean stop = false;
	volatile boolean suspend = false;
	
    // private Downloader dl;
    public DownloadThread(DownloadInfo info) {
        this.setInfo(info);
    }

    @Override
    public void run() {
        try {
            URL url = new URL(getInfo().getURL());
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestProperty("Range", "bytes=" + getInfo().getStart() + "-" + getInfo().getEnd());
            InputStream is = conn.getInputStream();

            RandomAccessFile raf = new RandomAccessFile(getInfo().getLocal(), "rw");
            raf.seek(getInfo().getStart());
            byte[] buffer = new byte[1024];
            int len = -1;
            total=0;
            while ((len = is.read(buffer)) != -1) {
                raf.write(buffer, 0, len);
                total+=len;
                //System.out.println("线程【"+info.getIndex()+"】已下载数据："+(total+info.getStart()));
                // ui.updateBar(info.getIndex(), len,fileLength);
                // dl.updateprocess(info.getIndex(), len);
                synchronized (this) {
                    while(suspend) {
                    	wait();
                    }
                }

            }
            raf.close();
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


	public int getThreadTotal() {
		// TODO Auto-generated method stub
		//System.out.println("线程下载："+total);
		return total;
	}

	public void setSuspend(boolean b) {
		// TODO Auto-generated method stub
		suspend=b;
	}

    public synchronized void setResume(){
		notify();
    }

	public DownloadInfo getInfo() {
		return info;
	}

	public void setInfo(DownloadInfo info) {
		this.info = info;
	}

}
