package net.bieli.bhash;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;

//TODO: add validator  only for ASCII input text for encode method
//TODO: use basePositions in next version for mutation tests explorations

public class BHash {

    private static int base_position = 65;
    private static ArrayList<Integer> positions = null;

    /*
            private static final int base_position = 65;Integer[] basePositions = {
               842, 4, 9393, 134,
               464, 35, 3884, 234,
               24, 321, 3456, 734,
               345, 2345, 34, 16,
               4564, 3243, 234, 42,
               2534, 63, 232, 234
            };
        */
    public String encode(String text)
    {
        if (positions == null) {
            positions = shufflePositions(text.length());
        }

        String textHashed = encodeAsciiText(positions, text);

        return textHashed;
    }

    public String decode(String bhash) throws StringIndexOutOfBoundsException
    {
        return decodeBHash(bhash);
    }

    private ArrayList<Integer> shufflePositions(Integer length)
    {
        ArrayList<Integer> list = new ArrayList<Integer>(length);

        for (int i = 0; i < length; i++) {
            list.add(i);
        }

        Collections.shuffle(list);

        return list;
    }

    private String encodeAsciiText(ArrayList<Integer> positions, String text)
    {
        String hash = "";
/*
    public static void main(String[] args)
            throws java.io.UnsupportedEncodingException {
        String s = "Hola, señor!";
        System.out.println(s);
        byte[] b = new byte[s.length()];
        for (int i = 0; i < b.length; i++) {
            int cp = s.codePointAt(i);
            b[i] = (byte) cp;
            System.out.print((byte) cp + " ");
        }
*/

        for (Integer i : positions) {
            hash += text.charAt(i);
            //hash += String.format("%02d", Character.toChars(i + 26));
            //hash += Integer.toString(i + 32);
            //basePositions
            //hash += String.valueOf(i + 32);
            hash += (char) (i + base_position);
        }

/*
        byte [] key = "MYVERYINSECUREKEY".getBytes("ASCII");

        for (int i = 0; i < text.length(); i++) {
            int charAsInt = Character.getNumericValue(text.charAt(i));
            list.add(charAsInt);
        }
*/

        return hash;
    }

    private String decodeBHash(String text) throws StringIndexOutOfBoundsException
    {
        String outputText = "";
        int len = (text.length() / 2) + 1;

        for (int n = 0; n < len; n++) {
            outputText += " ";
        }

        for (byte i = 0; i < text.length(); i++) {
            char ascii = (char) text.charAt(i);

            byte position = (byte) text.charAt(i + 1);
            outputText = BHashTools.replace(outputText,
                    position - base_position,
                    ascii);
            i++;
        }

        //TODO: possible bug for non A-Za-z0-9 characters like space char.
        return outputText.trim();
    }

    public void setPositions(ArrayList<Integer> positions, Integer base_position)
    {
        this.positions = positions;
        this.base_position = base_position;
    }
}

