/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cyberiantiger.minecraft.nbt;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author antony
 */
public class TagInputStream extends DataInputStream {

    public TagInputStream(InputStream in) {
        super(in);
    }

    public Tag readTag() throws IOException {
        int tagType = readByte() & 0xff;
        if (tagType >= TagType.values().length) {
            throw new IOException("Unknown tag type: " + tagType);
        }
        TagType type = TagType.values()[tagType];
        return type.read(type.readName(this), this);
    }

    public String readMCString() throws IOException {
        int length = readShort() & 0xffff; // unsigned.
        byte[] data = new byte[length];
        readFully(data);
        return new String(data, Tag.CHARSET);
    }
}
