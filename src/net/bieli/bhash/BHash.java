package net.bieli.bhash;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;

//TODO: add validator  only for ASCII input text for encode method
//TODO: use basePositions in next version for mutation tests explorations

public class BHash {

    private static int base_position = 65;
    private static ArrayList<Integer> positions = null;

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

        for (Integer i : positions) {
            hash += text.charAt(i);
            hash += (char) (i + base_position);
        }

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
