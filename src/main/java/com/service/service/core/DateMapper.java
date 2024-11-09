
package com.service.service.core;

import org.mapstruct.Named;

import java.time.Instant;

public class DateMapper {

    @Named("longToInstant")
    public static Instant longToInstant(long value) {
        return Instant.ofEpochMilli(value);
    }

    @Named("instantToLong")
    public static long instantToLong(Instant instant) {
        return instant != null ? instant.toEpochMilli() : 0L;
    }
}
