package states;

import java.util.*;
import java.io.*;
import java.net.URL;

public class beats {
    
    static class beat implements Comparable<beat>, Cloneable{
        int index, val;
        public beat(int i, int v){
            index = i;
            val = v;
        }
        @Override
        public int compareTo(beat o){
            return this.val-o.val;
            //decreasing
        }
        @Override
        public String toString(){
            return this.index+" "+this.val;
        }
        @Override
        public Object clone()throws CloneNotSupportedException{  
            return super.clone();  
        }  
    }
    
    static class strongbeat implements Comparable<strongbeat>, Cloneable{
        double index;
        int val;
        public strongbeat(beat b){
            index = b.index/indpersec/3;
            val = b.val;
        }
        @Override
        public int compareTo(strongbeat o){
            return (int)(this.index-o.index);
            //increasing
        }
        
        @Override
        public String toString(){
            return this.index+" "+this.val;
        }
        @Override
        public Object clone()throws CloneNotSupportedException{  
            return super.clone();  
        }  
    }
    static public byte[] recoverFromUrl(String urlText) throws Exception {
        URL url = new URL(urlText);
        ByteArrayOutputStream output = new ByteArrayOutputStream();
         
        try (InputStream inputStream = url.openStream()) {
            int n = 0;
            byte [] buffer = new byte[ 1024 ];
            while (-1 != (n = inputStream.read(buffer))) {
                output.write(buffer, 0, n);
            }
        }
     
        return output.toByteArray();
    }
    static double indpersec = 518;
    
    public static int[] getarray() throws Exception {
        int secpermove = 6;
        double movepersec = 1/(double)secpermove;
            // convert file to byte[]
        byte[] bFile = readBytesFromFile("C:\\temp\\testing1.txt");
        beat[] graphData = getUnscaledAmplitude(bFile);
        Arrays.sort(graphData);
        
        
        double sec = graphData.length/indpersec;
        double estmoves = sec*movepersec;
        //first colomn time, second colomn val
        ArrayList<strongbeat>lowpass = new ArrayList();
        
        //every 10 seconds must have a move, mark those as used
        //then check from lowest up
        int musthaveinterval = 10;
        ArrayList<Integer> used = new ArrayList();
        boolean[]cover = new boolean[(int)(sec/10)+1];
        int count = (int)(sec/musthaveinterval);
        int index = 0;
        while(count!=0&&index<graphData.length){
            beat b = graphData[index];
            if(!cover[(int)(b.index/3/indpersec/musthaveinterval)]){
                count++;
                cover[(int)(b.index/3/indpersec/musthaveinterval)]=true;
                used.add(b.index);
                lowpass.add(new strongbeat(b));
            }
            index++;
        }
        index = 1;
        for(int i = 0; i<estmoves-(int)(sec/musthaveinterval)+count;i++){
            if(!used.contains(lowpass.get(i).index)){
                lowpass.add(new strongbeat(graphData[i]));
            }else{
                i--;
            }
            index++;
        }
        Collections.sort(lowpass);

        //System.out.println(lowpass);
        int [] res = new int [(int)(sec*10)];
        for(int i = 0; i<lowpass.size(); i++){
        	//System.out.println((int)lowpass.get(i).index*10);
            res[(int)lowpass.get(i).index*10] = (int)(Math.random()*4)+1;
        }
        return res;
    }
   
    public static beat[] getUnscaledAmplitude(byte[] eightBitByteArray){
        beat[]toReturn = new beat[eightBitByteArray.length /2];

        for (int audioByte = 0; audioByte < eightBitByteArray.length/2-2; audioByte++)
        {
            // Do the byte to sample conversion.
            int low = (int) eightBitByteArray[audioByte];
            audioByte++;
            int high = (int) eightBitByteArray[audioByte];
            audioByte++;
            int sample = (high << 8) + (low & 0x00ff);
//            System.out.println(audioByte+" "+sample);
            toReturn[audioByte]= new beat(audioByte,sample);
            if(audioByte==100){
                //System.out.println("aa"+sample);
            }
        }
        
        beat[] re = new beat[toReturn.length/3];
        for(int i = 0; i<re.length; i++){
            re[i]=toReturn[3*i+2];
        }
        return re;
    }
   
    private static byte[] readBytesFromFile(String filePath) {

        FileInputStream fileInputStream = null;
        byte[] bytesArray = null;

        try {

            File file = new File(filePath);
            bytesArray = new byte[(int) file.length()];

            //read file into bytes[]
            fileInputStream = new FileInputStream(file);
            fileInputStream.read(bytesArray);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

        return bytesArray;

    }    
}
