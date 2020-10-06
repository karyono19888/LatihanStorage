package www.kayono.latihanstorage;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class InternalActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String FILENAME="namafile.txt";
    Button buatfile, ubahfile, bacafile, deletefile;
    TextView textBaca;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_internal);
       buatfile=findViewById(R.id.buttonBuatFile);
       ubahfile=findViewById(R.id.buttonUbahFile);
       bacafile=findViewById(R.id.buttonBacaFile);
       deletefile=findViewById(R.id.buttonHapusFile);
       textBaca=findViewById(R.id.textBaca);

       buatfile.setOnClickListener(this);
       ubahfile.setOnClickListener(this);
       bacafile.setOnClickListener(this);
       deletefile.setOnClickListener(this);
    }
    void buatFile(){
        String isiFile="Coba Isi Data File Text";
        File file = new File(getFilesDir(),FILENAME);

        FileOutputStream outputStream= null;
        try {
            file.createNewFile();
            outputStream= new FileOutputStream(file,true);
            outputStream.write(isiFile.getBytes());
            outputStream.flush();
            outputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    void ubahfile(){
        String ubah="Update Isi Data File Text";

        File file=new File(getFilesDir(),FILENAME);

        FileOutputStream outputStream=null;
        try {
            file.createNewFile();
            outputStream=new FileOutputStream(file,false);
            outputStream.write(ubah.getBytes());
            outputStream.flush();
            outputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    void bacafile(){
        File sdcard=getFilesDir();
        File file=new File(sdcard,FILENAME);

        if (file.exists()){
            StringBuilder text=new StringBuilder();
            try {
                BufferedReader br= new BufferedReader(new FileReader(file));

                String line=br.readLine();

                while (line!=null){
                    text.append(line);
                    line=br.readLine();
                }
                br.close();
            }catch (IOException e){
                System.out.println("Error"+e.getMessage());
            }
            textBaca.setText(text.toString());
        }
    }

    void hapusFile(){
        File file=new File(getFilesDir(),FILENAME);
        if (file.exists()){
            file.delete();
        }
    }
    @Override
    public void onClick(View v){jalankanPerintah(v.getId());}
    public void jalankanPerintah(int id){
        switch (id){
            case R.id.buttonBuatFile:
                buatFile();
                break;
            case R.id.buttonBacaFile:
                bacafile();
                break;
            case R.id.buttonUbahFile:
                ubahfile();
                break;
            case R.id.buttonHapusFile:
                hapusFile();
                break;
        }
    }
}