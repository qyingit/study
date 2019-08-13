/*
package com.qying.tree;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HuffmanCode1 {

    public static void main(String[] args) {


    }
    static Map<Byte,String> huffmanCodes = new HashMap<Byte, String>();


    public static void zipFile(String srcFile, String dstFile){
        OutputStream os = null;
        ObjectOutputStream oos = null;
        FileInputStream is = null;
        try {
            is = new FileInputStream(srcFile);
            byte[] b = new byte[is.available()];
            is.read(b);
            byte[]  huffmanBytes = huffmanZip(b);
            os = new FileOutputStream(dstFile);
            oos = new ObjectOutputStream(os);
            oos.writeObject(huffmanBytes);
            oos.writeObject(huffmanCodes);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                os.close();
                oos.close();
                is.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }


    public static void unZipFile(String zipFile, String dstFile){
        InputStream is = null;
        ObjectInputStream ois = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(zipFile);
            ois = new ObjectInputStream(is);
            byte[] huffmanBytes = (byte[])ois.readObject();
            Map<Byte,String> huffmanCodes = (Map<Byte, String>) ois.readObject();

            byte[] bytes = decode(huffmanCodes,huffmanBytes);
            os = new FileOutputStream(dstFile);
            os.write(bytes);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                is.close();
                ois.close();
                os.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public static byte[] decode(Map<Byte,String> huffmanCodes,byte[] huffmanBytes){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0;i<huffmanBytes.length;i++){
            byte b = huffmanBytes[i];
            boolean flag = (i==huffmanBytes.length-1);
            stringBuilder.append(byteToBitString(!flag,b));
        }

        Map<String,Byte> map = new HashMap<String, Byte>();
        for (Map.Entry<Byte,String> entry : huffmanCodes.entrySet()){
            map.put(entry.getValue(),entry.getKey());
        }

        List<Byte> list = new ArrayList<Byte>();
        for (int i = 0; i< stringBuilder.length();){
            int count = 1;
            boolean flag = true;
            Byte b = null;
            while (flag){
                String key = stringBuilder.substring(i,i+count);
                b = map.get(key);
                if (b == null){
                    count++;
                }else {
                    flag = false;
                }
            }
            list.add(b);
            i+=count;
        }
        byte[] b= new byte[list.size()];
        for (int i =0;i<b.length;i++){
            b[i] = list.get(i);
        }
        return b;
    }

    private static String byyteToString(boolean flag , byte b){
        int temp = b;
        if (flag){
            temp |= 256;
        }
        String str = Integer.toBinaryString(temp);
        if (flag){
            return str.substring(str.length() -8);
        }else {
            return str;
        }
    }

    private static byte[] huffmanZip(byte[] bytes){
        List<Node> nodes = getNodes(bytes);
        Node huffmanTreeRoot = createHuffmanTree(nodes);
        Map<Byte,String> huffmaCodes = getCodes(huffmanTreeRoot);
        byte[] huffmanCodeBytes = zip(bytes,huffmaCodes);
        return huffmanCodeBytes;
    }

    private static byte[] zip(byte[] bytes,Map<Byte,String> huffmanCodes){
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b :bytes){
            stringBuilder.append(huffmanCodes.get(b));
        }

        int len;
        if (stringBuilder.length() % 8 == 0){
            len = stringBuilder.length()/8;
        }else {
            len = stringBuilder.length()/8+1;
        }

        byte[] huffmanCodeBytes =new byte[len];

        int index = 0;
        for (int i = 0;i<stringBuilder.length();i+=8){
            String strByte;
            if (i+8>stringBuilder.length()){
                strByte = stringBuilder.substring(i);
            }else {
                strByte = stringBuilder.substring(i,i+8);
            }
            huffmanCodeBytes[index] = (byte)Integer.parseInt(strByte,2);
            index++;
        }
        return huffmanCodeBytes;

    }

    static StringBuilder stringBuilder = new StringBuilder();
}
*/
