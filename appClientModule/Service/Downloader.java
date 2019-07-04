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

    public Downloader(String url, String local, int count, MainFrame ui) {
        this.url = url;
        this.local = local;
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
            RandomAccessFile raf = new RandomAccessFile(local, "rw");
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
            info.setLocal(local);
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
        for (DownloadInfo info : infos) {
            new DownloadThread(info).start();
        }
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