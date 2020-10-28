import java.io.*;

public class test1 {

    public static void main(String[] args) {
        //File file = new File();
    }


    public void testFileInputStream() throws FileNotFoundException {
        InputStream is = null;
        try{
            File file = new File("C:\\Users\\bang\\Desktop\\资料\\001.个人资料\\电影.txt");
            is = new FileInputStream(file);

            byte[] b = new byte[1024];
            int len;
            while((len = is.read(b)) != -1){
                System.out.println(new String(b,0,len));
            }
        }catch(IOException e){
            e.printStackTrace();
        }finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void testReaderWriter() throws IOException{
        Reader reader = new FileReader("dbcp.txt");
        Writer writer = new FileWriter("dbcp1.txt");
        char[] c = new char[1024];
        int len = 0;
        while((len = reader.read(c))!= -1){
            writer.write(new String(c,0,len));
            writer.flush();
        }
        writer.close();
        reader.close();
    }



}
