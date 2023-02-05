import java.io.*;
import java.util.zip.*;

class Zipper{
    public void zip(File folder){
        File [] files=folder.listFiles();
        if(files.length==0){
            throw new IllegalArgumentException("Folder is empty");
        }
        try{
            FileOutputStream fos=new FileOutputStream("myzip.zip");
            ZipOutputStream zos=new ZipOutputStream(fos);
            for(File file:files)
            {
                FileInputStream fis=new FileInputStream(file);
                ZipEntry ze=new ZipEntry(file.getName());
                zos.putNextEntry(ze);
                int data;
                while((data=fis.read())!=-1)
                {
                    zos.write(data);
                }
                fis.close();
            }
            zos.closeEntry();
            zos.close();
            fos.close();
        }
        catch(IOException e){
            System.err.println(e.getMessage());
        }
    }
    public static void main(String[] args){
        try{
            new Zipper().zip(new File("Lab-1"));
            new Zipper().unzip(new File("myzip.zip"));

        }catch(IllegalArgumentException e){
            System.err.println(e.getLocalizedMessage());
        }
    }
    public void unzip(File filetounzip){
        try{
            FileInputStream fis=new FileInputStream(filetounzip);
            ZipInputStream zis=new ZipInputStream(fis);
            ZipEntry ze=zis.getNextEntry();
            while(ze!=null){
                File file=new File("Files/"+ze.getName());
                FileOutputStream fout=new FileOutputStream(file);
                int data;
                while((data=zis.read())!=-1){
                    fout.write(data);
                }
                fout.close();
                ze=zis.getNextEntry();
            }
            zis.close();
            fis.close();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}
