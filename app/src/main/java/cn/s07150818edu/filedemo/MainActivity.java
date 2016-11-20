package cn.s07150818edu.filedemo;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {
        private TextView tv1;
    private File fPhoned;
    private File fESPD;
    private File fESD;
    private File fDS;
    private File fDCD;
    private File fRD;
    private String name,path;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fPhoned=this.getFilesDir();
        fESPD= Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC);
        fESD=Environment.getExternalStorageDirectory();
        fDS=Environment.getDataDirectory();
        fDCD=Environment.getDownloadCacheDirectory();
        fRD=Environment.getRootDirectory();

        if(Environment.getExternalStorageState().equals(Environment.MEDIA_REMOVED)){
            Button btn= (Button) findViewById(R.id.externalStorageD);
            btn.setEnabled(false);
        }


    }
    public void phoneDicectory(View v){
        path=fPhoned.getPath();
        try {


            FileOutputStream fos=openFileOutput("test.txt",MODE_PRIVATE);
            fos.write("hello".getBytes());
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        listFiles(path);


    }

    public  void externalStoragePD(View v){
        path=fESPD.getAbsolutePath();
        listFiles(path);
    }

    public  void externalStorageD(View v){
        path=fESD.getAbsolutePath();
        listFiles(path);
    }
    public  void dataStorage(View v){
        path=fDS.getAbsolutePath();
        listFiles(path);
    }
    public  void downloadCD(View v){
        path=fDCD.getAbsolutePath();
        listFiles(path);
    }
    public  void rootD(View v){
        path=fRD.getAbsolutePath();
        listFiles(path);
    }
    private boolean listFiles(String path){
        name="路径："+path+"\n文件清单：\n";
        File file=new File(path);
        if (file.listFiles()!=null&&file.listFiles().length>0){
            for (File f:file.listFiles()){
                path=f.getAbsolutePath();
                name=name+f.getName()+"\n";
            }
        }
        tv1.setText(name);
        return  true;
    }
}
