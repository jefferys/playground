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

/**
 * A Seq object represents a simple named sequence. Once this object is built
 * it can not be modified.
 * @author Stuart R. Jefferys
 *
 */
public class Seq {

    /** Generic error message for null parameter. */
    public static final String ERR_NULL_PARAM_S = "Seq parameter %s may not be null!";

    /** The name of a sequence. */
    private final String _name;

    /** The string of single character codes that makes up the sequence.*/
    private final String _seq;

    /**
     * Constructor.
     * @param name The name of this sequence
     * @param sequence The string of single character codes that makes up this sequence
     */
    public Seq(final String name, final String sequence) {
        if (name == null) {
            throw new NullPointerException( String.format( ERR_NULL_PARAM_S, "name" ));
        }
        if (sequence == null) {
            throw new NullPointerException( String.format( ERR_NULL_PARAM_S, "sequence" ));
        }
        this._name = name;
        this._seq = sequence;
    }

    /**
     * Getter for the value of property name.
     * @return the value of property name
     */
    public final String getName() {
        return this._name;
    }

    /**
     * Getter for the value of property seq.
     * @return the value of property seq
     */
    public final String getSeq() {
        return this._seq;
    }

    /**
     * Data based hash code. Two Seq objects have the same hash code if
     * if they have the same name and the same sequence.
     * @return The hashcode (integer) for this object.
     * @see java.lang.Object#hashCode()
     */
    @Override
    public final int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this._name == null) ? 0 : this._name.hashCode());
        result = prime * result + ((this._seq == null)  ? 0 : this._seq.hashCode());
        return result;
    }

    /**
     * Data equality method. Two Seq objects are the same only
     * if they have the same name and the same sequence.
     * @param obj The other object to compare to this one.
     * @return True if two Seq objects represent the same sequence,
     * false otherwise.
     */
    @Override
    public final boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Seq other = (Seq) obj;
        if (this._name == null) {
            if (other._name != null) {
                return false;
            }
        }
        else if (! this._name.equals( other._name )) {
            return false;
        }
        if (this._seq == null) {
            if (other._seq != null) {
                return false;
            }
        }
        else if (! this._seq.equals( other._seq )) {
            return false;
        }
        return true;
    }

    /**
     * Returns a string view of the data in this object for human reading.
     * Includes the contents of this object.
     * @see java.lang.Object#toString()
     * @return A (non eol terminated) string describing this object.
     */
    @Override
    public final String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append( "Seq [name=" );
        builder.append( this._name );
        builder.append( ", seq=" );
        builder.append( this._seq );
        builder.append( "]" );
        return builder.toString();
    }

}
