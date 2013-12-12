package net.bieli.bhash;

import junit.framework.TestCase;

import java.nio.charset.Charset;
import java.util.ArrayList;

public class BHashTest extends TestCase {
    public void testShouldEncodeStringWithSuccess() throws Exception {
        // given
        String expected = "RDWBECQA";
        String text = "QWER";
        BHash bhash = new BHash();

        Integer base_position = 65;
        ArrayList<Integer> positions = new ArrayList<Integer>(4);
        positions.add(3);
        positions.add(1);
        positions.add(2);
        positions.add(0);

        bhash.setPositions(positions, base_position);

        // when
        String encoded = bhash.encode(text);

        // then
        assertEquals(expected, encoded);
    }

    public void testShouldEncodeStringWithOneCharacterWithSuccess() throws Exception {
        // given
        String expected = "AA";
        String text = "A";
        BHash bhash = new BHash();

        Integer base_position = 65;
        ArrayList<Integer> positions = new ArrayList<Integer>(1);
        positions.add(0);

        bhash.setPositions(positions, base_position);

        // when
        String encoded = bhash.encode(text);

        // then
        assertEquals(expected, encoded);
    }

    public void testShouldDecodeStringWithSuccess() throws Exception {
        // given
        String expected = "QWER";
        String bhashedText = "RDWBECQA";
        BHash bhash = new BHash();

        // when
        String decoded = bhash.decode(bhashedText);

        // then
        assertEquals(expected, decoded);
    }

    /**
     * @Test(expected = StringIndexOutOfBoundsException.class)
     */
    public void testExpectedExceptionForNonAsciiBhashString() throws Exception
    {
        // given
        String myString = "™œŸ";
        byte ptext[] = myString.getBytes();
        String badBhash = new String(ptext, "UTF-8");
        BHash bhash = new BHash();

        // when

        try {
            bhash.decode(badBhash);

            fail("Missing index in string exception");
        } catch( StringIndexOutOfBoundsException e ) {
            // then
            //expected exception

            assertEquals("String index out of range: 3", e.getMessage());
        }
    }
}
