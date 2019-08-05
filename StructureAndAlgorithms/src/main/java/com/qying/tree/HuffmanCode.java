package com.qying.tree;

import java.io.*;
import java.util.*;

public class HuffmanCode {

    public static void main(String[] args) {
        String zipFile = "";
        String dstFile = "";
        unZipFile(zipFile,dstFile);
        System.out.println("解压");

        String context = "i like like like java do you like a java";
        byte[] contentBytes = context.getBytes();
        System.out.println(contentBytes.length);

        byte[] huffmanCodesBytes = huffmanZip(contentBytes);
        System.out.println("压缩后的结果是:"+ Arrays.toString(huffmanCodesBytes)+
                "压缩后的长度是:"+huffmanCodesBytes.length);

//        byte[] sourceBytes = decode(huffmanCodes,huffmanCodesBytes);

    }


    public static void unZipFile(String zipFile, String dstFile){
        InputStream is = null;
        ObjectInputStream ois = null;
        OutputStream os = null;

        try {
            is = new FileInputStream(zipFile);
            ois = new ObjectInputStream(is);
            byte[] huffmanBytes = (byte[])ois.readObject();
            Map<Byte,String> huffmanCodes = (Map<Byte, String>)ois.readObject();

            byte[] bytes = decode(huffmanCodes,huffmanBytes);
            os = new FileOutputStream(dstFile);
            os.write(bytes);
        }catch (Exception e){
            e.printStackTrace();
        }finally {

           try {
               os.close();
               ois.close();
               is.close();
           }catch (Exception e){
               e.printStackTrace();
           }

        }
    }


    public static void zipFile(String srcFile, String dstFile){
        OutputStream os = null;
        ObjectOutputStream oos = null;
        FileInputStream is = null;
        try {
            is = new FileInputStream(srcFile);
            byte[] b = new byte[is.available()];
            is.read(b);
            byte[] huffmanBytes = huffmanZip(b);
            os = new FileOutputStream(dstFile);
            oos.writeObject(huffmanBytes);
            oos.writeObject(huffmanCodes);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                is.close();
                oos.close();
                os.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    private static byte[]  decode(Map<Byte,String> huffmancodes,byte[] huffmanBytes){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0;i< huffmanBytes.length;i++){
            byte b = huffmanBytes[i];
            boolean flag = (i==huffmanBytes.length -1);
            stringBuilder.append(byteToBitString(!flag,b));
        }

        Map<String,Byte> map = new HashMap<String, Byte>();
        for (Map.Entry<Byte,String> entry : huffmancodes.entrySet()){
            map.put(entry.getValue(),entry.getKey());
        }

        List<Byte> list = new ArrayList<Byte>();

        for (int i = 0; i<stringBuilder.length();){
            int count =1 ;
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

        byte[] b = new byte[list.size()];
        for (int i = 0;i<b.length;i++){
            b[i] = list.get(i);
        }
        return b;

    }

    private static String  byteToBitString(boolean flag, byte b){
        int temp = b;
        if (flag){
            temp |=256;
        }
        String str = Integer.toBinaryString(temp);
        if (flag){
            return str.substring(str.length()-8);
        }else {
            return str;
        }
    }

    private static byte[] huffmanZip(byte[] bytes){
        List<Node> nodes = getNodes(bytes);
        Node huffmanTreeRoot = createHuffmanTree(nodes);
        Map<Byte,String> humffmanCodes = getCodes(huffmanTreeRoot);
        byte[] huffmanCodeBytes = zip(bytes,humffmanCodes);
        return huffmanCodeBytes;
    }


    private static byte[] zip(byte[] bytes,Map<Byte,String> huffmanCodes){
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : bytes){
            stringBuilder.append(huffmanCodes.get(b));
        }

        int len;
        if (stringBuilder.length()%8 == 0){
            len = stringBuilder.length()/8;
        }else {
            len = stringBuilder.length()/8+1;
        }

        byte[] huffmanCodeBytes = new byte[len];
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
    static Map<Byte,String> huffmanCodes = new HashMap<Byte, String>();

    public static Map<Byte,String> getCodes(Node root){
        if (root == null){
            return null;
        }
        getCodes(root.left,"0",stringBuilder);
        getCodes(root.right,"0",stringBuilder);
        return huffmanCodes;
    }

    private static void getCodes(Node node,String code, StringBuilder stringBuilder){
        StringBuilder stringBuilder2 = new StringBuilder(stringBuilder);
        stringBuilder2.append(code);
        if (node != null){
            if (node.data == null){
                getCodes(node.left,"0",stringBuilder2);
                getCodes(node.right,"1",stringBuilder2);
            }else {
                huffmanCodes.put(node.data,stringBuilder2.toString());
            }
        }
    }

    private static void preOrder(Node root){
        if (root != null){
            root.preOrder();
        }else {
            System.out.println("数为空");
        }
    }

    private static List<Node> getNodes(byte[] bytes){
        ArrayList<Node> nodes = new ArrayList<Node>();
        Map<Byte,Integer> counts = new HashMap<Byte, Integer>();
        for (byte b : bytes){
            Integer count = counts.get(b);
            if (count == null){
                counts.put(b,1);
            }else {
                counts.put(b,count+1);
            }
        }

        for (Map.Entry<Byte,Integer> entry : counts.entrySet()){
            nodes.add(new Node(entry.getKey(),entry.getValue()));
        }
        return nodes;
    }

    private static Node createHuffmanTree(List<Node> nodes){
        while (nodes.size() > 1){
            Collections.sort(nodes);
            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);
            Node parent = new Node(null,leftNode.weight + rightNode.weight);
            parent.left = leftNode;
            parent.right = rightNode;
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            nodes.add(parent);
        }
        return nodes.get(0);
    }

 }
