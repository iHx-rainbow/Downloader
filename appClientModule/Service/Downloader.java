package Service;

import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import Model.DownloadInfo;
import UI.MainFrame;

/**
 * 下载器
 */
public class Downloader {
    private String url;
    private String local;
    private List<DownloadInfo> infos;
    private int count;
    private int fileLength;
	private DownloadThread[] thread=new DownloadThread[10];

    public Downloader(String url, String local, int count, MainFrame ui) {
        this.url = url;
        this.setLocal(local);
        this.count = count;
        prepareDownload();
    }

    public List<DownloadInfo> getInfos() {
        return infos;
    }

    /**
     * 准备下载
     */
    private void prepareDownload() {
        try {
            // 获取URL文件大小
            URL u = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) u.openConnection();
            fileLength = conn.getContentLength();
            // 创建本地文件并且设置大小
            RandomAccessFile raf = new RandomAccessFile(getLocal(), "rw");
            raf.setLength(fileLength);
            raf.close();
            // 计算下载信息集合
            initDownloadInfos();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initDownloadInfos() {
        infos = new ArrayList<DownloadInfo>();
        DownloadInfo info = null;
        int block = fileLength / count;
        for (int i = 0; i < count; i++) {
            info = new DownloadInfo();
            info.setURL(url);
            info.setLocal(getLocal());
            info.setIndex(i);

            info.setStart(i * block);
            if (i != count - 1) {
                info.setEnd((i + 1) * block - 1);
            } else {
                info.setEnd(fileLength);
            }
            infos.add(info);
        }

    }

    public void startDownload() {
    	int i=0;
        for (DownloadInfo info : infos) {
        	thread[i]=new DownloadThread(info);
        	thread[i].start();
        	i++;
        }
    }

	public int getTotal() {
		// TODO Auto-generated method stub
		int all=0;
		for(int i = 0; i < count; i++){
			all+=thread[i].getThreadTotal();
		}
		int prent=(int)((double)all*100/(double)fileLength);
		//System.out.println("百分比："+prent);
		return prent;
	}

	public void suspend() {
		// TODO Auto-generated method stub
		for(int i = 0; i < count; i++){
			thread[i].setSuspend(true);
			//System.out.println(thread[i].getInfo().getIndex());
		}
	}

	public void resume() {
		// TODO Auto-generated method stub
		for(int i = 0; i < count; i++){
			thread[i].setSuspend(false);
			thread[i].setResume();
		}
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

    // int done=0;
    // public void updateprocess(int index, int len) {
    // int[] threaddone= new int[count];
    // threaddone[index]=len+threaddone[index];
    // done=len+done;
    /*
     * int[] jindu=new int[2]; jindu[0]=done; jindu[1]=fileLength;
     */
    // ui.updateProcess(fileLength);
    // }
}