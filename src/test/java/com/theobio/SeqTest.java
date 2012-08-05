/**
 * Copyright (C) 2012 Stuart R. Jefferys (All rights reserved.)
 *
 * This file may be used under the terms of the acompanying
 * licence (GNU v3 or later), as long as this header is included.
 *
 * For other licensing terms, including LGPL or commercial use, contact
 *   Stuart R. Jefferys
 *   srjefferys@gmail.com
 */
package com.theobio;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * A SeqTest object represents a suite of tests for a Seq object.
 * 
 * @author Stuart R. Jefferys
 * @see Seq
 */
public final class SeqTest {

    /** Named empty string. */
    public static final String EMPTY_STRING =  "";

    /**
     * Data method to provide a list of names to use when creating
     * Seq objects for testing. All names should work.
     * @return Valid sequence names.
     */
    public static List<String> makeExampleNames() {
        List<String> names = new ArrayList<String>();
        names.add( "SimpleName" );
        names.add( "Name with space" );
        names.add( "Name with line\nbreak" );
        names.add( ">Whole fasta line name\n" );
        names.add( "Unicode name · (sum), Ã (sqr_rt)" );
        names.add( EMPTY_STRING );
        names.add( "12345" );
        names.add(
                "(01) 70 characters - repeated enough times to have > 1024 characters. "
              + "(02) 70 characters - repeated enough times to have > 1024 characters. "
              + "(03) 70 characters - repeated enough times to have > 1024 characters. "
              + "(04) 70 characters - repeated enough times to have > 1024 characters. "
              + "(05) 70 characters - repeated enough times to have > 1024 characters. "
              + "(06) 70 characters - repeated enough times to have > 1024 characters. "
              + "(07) 70 characters - repeated enough times to have > 1024 characters. "
              + "(08) 70 characters - repeated enough times to have > 1024 characters. "
              + "(09) 70 characters - repeated enough times to have > 1024 characters. "
              + "(10) 70 characters - repeated enough times to have > 1024 characters. "
              + "(11) 70 characters - repeated enough times to have > 1024 characters. "
              + "(12) 70 characters - repeated enough times to have > 1024 characters. "
              + "(13) 70 characters - repeated enough times to have > 1024 characters. "
              + "(14) 70 characters - repeated enough times to have > 1024 characters. "
              + "(15) 70 characters - repeated enough times to have > 1024 characters. "
        );

        return names;
    }

    /**
     * Data method to provide a list of sequence to use when creating
     * Seq objects for testing. All sequences should work.
     * @return Valid sequences.
     */
    public static List<String> makeExampleSequences() {
        List<String> seqs = new ArrayList<String>();
        seqs.add( "ELVISLIVES" );
        seqs.add( "SequenceWithLineBreaks\nSequenceWithLineBreaks\nSequenceWithLineBreaks" );
        seqs.add( EMPTY_STRING );
        seqs.add(
                "(01)SEQUENCEwith70charactersRepeatedTOgiveGREATERthan1024charactersAND"
              + "(02)SEQUENCEwith70charactersRepeatedTOgiveGREATERthan1024charactersAND"
              + "(03)SEQUENCEwith70charactersRepeatedTOgiveGREATERthan1024charactersAND"
              + "(04)SEQUENCEwith70charactersRepeatedTOgiveGREATERthan1024charactersAND"
              + "(05)SEQUENCEwith70charactersRepeatedTOgiveGREATERthan1024charactersAND"
              + "(06)SEQUENCEwith70charactersRepeatedTOgiveGREATERthan1024charactersAND"
              + "(07)SEQUENCEwith70charactersRepeatedTOgiveGREATERthan1024charactersAND"
              + "(08)SEQUENCEwith70charactersRepeatedTOgiveGREATERthan1024charactersAND"
              + "(09)SEQUENCEwith70charactersRepeatedTOgiveGREATERthan1024charactersAND"
              + "(10)SEQUENCEwith70charactersRepeatedTOgiveGREATERthan1024charactersAND"
              + "(11)SEQUENCEwith70charactersRepeatedTOgiveGREATERthan1024charactersAND"
              + "(12)SEQUENCEwith70charactersRepeatedTOgiveGREATERthan1024charactersAND"
              + "(13)SEQUENCEwith70charactersRepeatedTOgiveGREATERthan1024charactersAND"
              + "(14)SEQUENCEwith70charactersRepeatedTOgiveGREATERthan1024charactersAND"
              + "(15)SEQUENCEwith70charactersRepeatedTOgiveGREATERthan1024charactersAND"
        );

        return seqs;
    }

    /**
     * Default public constructor.
     */
    public SeqTest() {
        // Nothing to do
    }

    /**
     * Test method for constructor, includes simple test for getters.
     * {@link com.theobio.Seq#Seq(java.lang.String, java.lang.String)}.
     */
    @Test
    public void testSeq() {
        String name = makeExampleNames().get( 0 );
        String sequence = makeExampleSequences().get( 0 );
        Seq aSeq = new Seq(name, sequence);
        assertNotNull( aSeq );
        assertEquals( name, aSeq.getName() );
        assertEquals( sequence, aSeq.getSeq() );

        name = null;
        sequence = makeExampleSequences().get( 0 );
        try {
            aSeq = new Seq(name, sequence);
            fail( "Expected exception for null name parameter not thrown!" );
        }
        catch (NullPointerException npEx) {
            assertEquals( String.format( Seq.ERR_NULL_PARAM_S, "name" ), npEx.getMessage() );
        }

        name = makeExampleNames().get( 0 );
        sequence = null;
        try {
            aSeq = new Seq(name, sequence);
            fail( "Expected exception for null sequence parameter not thrown!" );
        }
        catch (NullPointerException npEx) {
            assertEquals( String.format( Seq.ERR_NULL_PARAM_S, "sequence" ), npEx.getMessage() );
        }
    }

    /**
     * Test method for {@link com.theobio.Seq#getName()}.
     */
    @Test
    public void testGetName() {
        String seqeuence = makeExampleSequences().get( 0 );
        List<String> names = makeExampleNames();
        for ( String name : names ) {
            Seq aSeq = new Seq(name, seqeuence);
            assertNotNull( aSeq );
            assertEquals( name, aSeq.getName() );
        }
    }

    /**
     * Test method for {@link com.theobio.Seq#getSeq()}.
     */
    @Test
    public void testGetSeq() {
        String name = makeExampleNames().get( 0 );
        List<String> seqs = makeExampleSequences();
        for ( String seq : seqs ) {
            Seq aSeq = new Seq(name, seq);
            assertNotNull( aSeq );
            assertEquals( seq, aSeq.getSeq() );
        }
    }

    /**
     * Helper method to support {@link com.theobio.testEqualsAndHashCode()}.
     * Tests objects varying by name property.
     */
    private void testEqualsAndHashCodeOnNames() {

        List<String> names = makeExampleNames();
        List<String> seqs = makeExampleNames();

        for ( String name1 : names ) {
            Seq seq1 = new Seq( name1, seqs.get( 0 ));
            assertTrue( seq1.equals( seq1 ));
            assertEquals( seq1.hashCode(), seq1.hashCode() );
            for ( String name2 : names ) {
                Seq seq2 = new Seq( name2, seqs.get( 0 ));
                if ( name1.equals( name2 )) {
                    assertTrue( seq1.equals( seq2 ));
                    assertTrue( seq2.equals( seq1 ));
                    assertTrue( seq1.hashCode() == seq2.hashCode() );
                    assertTrue( seq2.hashCode() == seq1.hashCode() );
                }
                else {
                    assertFalse( seq1.equals( seq2 ));
                    assertFalse( seq2.equals( seq1 ));
                    assertFalse( seq1.hashCode() == seq2.hashCode() );
                    assertFalse( seq2.hashCode() == seq1.hashCode() );
                }
            } // END loop over name 2
        } // END loop over name 1
    }

    /**
     * Helper method to support {@link com.theobio.testEqualsAndHashCode()}.
     * Tests objects varying by name property.
     */
    private void testEqualsAndHashCodeOnSequences() {

        List<String> names = makeExampleNames();
        List<String> seqs = makeExampleNames();

        for ( String sequence1 : seqs ) {
            Seq seq1 = new Seq( names.get( 0 ), sequence1 );
            assertTrue( seq1.equals( seq1 ));
            assertEquals( seq1.hashCode(), seq1.hashCode() );
            for ( String sequence2 : seqs ) {
                Seq seq2 = new Seq( names.get( 0 ), sequence2 );
                if ( sequence1.equals( sequence2 )) {
                    assertTrue( seq1.equals( seq2 ));
                    assertTrue( seq2.equals( seq1 ));
                    assertTrue( seq1.hashCode() == seq2.hashCode() );
                    assertTrue( seq2.hashCode() == seq1.hashCode() );
                }
                else {
                    assertFalse( seq1.equals( seq2 ));
                    assertFalse( seq2.equals( seq1 ));
                    assertFalse( seq1.hashCode() == seq2.hashCode() );
                    assertFalse( seq2.hashCode() == seq1.hashCode() );
                }
            } // END loop over name 2
        } // END loop over name 1
    }

    /**
     * Tests data equality/difference and hash code equality and difference.
     * Note- Difference has a small chance of failing for hash code even
     * when different objects are chosen, but that should be very rare.
     * Test method for {@link com.theobio.Seq#equals(java.lang.Object)}.
     * Test method for {@link com.theobio.Seq#hashCode()}.
     */
    @Test
    public void testEqualsAndHashCode() {

        this.testEqualsAndHashCodeOnNames();
        this.testEqualsAndHashCodeOnSequences();
    }

    /**
     * Test method for {@link com.theobio.Seq#toString()}.
     */
    @Test
    public void testToString() {

        String templateSS = "Seq [name=%s, seq=%s]";

        for ( String name : makeExampleNames() ) {
            for ( String sequence : makeExampleSequences() ) {
                Seq aSeq = new Seq( name, sequence );
                assertEquals( String.format( templateSS, name, sequence ), aSeq.toString() );
            }
        }
    }

}
