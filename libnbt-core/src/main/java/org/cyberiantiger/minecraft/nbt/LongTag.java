/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cyberiantiger.minecraft.nbt;

/**
 *
 * @author antony
 */
public final class LongTag extends Tag<Long> {
    private final long value;

    public LongTag(String name, long value) {
        super(name);
        this.value = value;
    }

    @Override
    public Long getValue() {
        return getRawValue();
    }

    public long getRawValue() {
        return value;
    }

    @Override
    public TagType getType() {
        return TagType.LONG;
    }
}
