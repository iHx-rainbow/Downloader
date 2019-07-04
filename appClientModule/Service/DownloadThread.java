package Service;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;

import Model.DownloadInfo;

public class DownloadThread extends Thread{

    private DownloadInfo info;
    //private Downloader dl;
    public DownloadThread(DownloadInfo info){
        this.info = info;
    }

    @Override
    public void run() {
        try {
            URL url = new URL(info.getURL());
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestProperty("Range", "bytes=" + info.getStart() + "-" + info.getEnd());
            InputStream is = conn.getInputStream();

            RandomAccessFile raf = new RandomAccessFile(info.getLocal(), "rw");
            raf.seek(info.getStart());
            byte[] buffer = new byte[1024];
            int len = -1;
            while ((len = is.read(buffer)) != -1){
                raf.write(buffer, 0 , len);
                //ui.updateBar(info.getIndex(), len,fileLength);
                //dl.updateprocess(info.getIndex(), len);
            }
            raf.close();
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    

}
