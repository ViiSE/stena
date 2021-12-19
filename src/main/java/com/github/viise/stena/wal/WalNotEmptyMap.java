package com.github.viise.stena.wal;

import com.github.viise.stena.ProtectException;
import com.github.viise.stena.Wall;

import java.util.Map;

/**
 * Not empty map protection.
 */
public final class WalNotEmptyMap implements Wall<Map<?, ?>> {

    private final Wall<Object> walNotNull;

    public WalNotEmptyMap() {
        this.walNotNull = new WalNotNull();
    }

    /**
     * Protect map.
     *
     * @param mapName Protected map name.
     * @param map     Protected map.
     * @throws ProtectException If map is null or empty.
     */
    @Override
    public void protect(final String mapName, final Map<?, ?> map) throws ProtectException {
        String _mapName = mapName == null ? "map" : mapName;
        walNotNull.protect(_mapName, map);
        if (map.isEmpty()) {
            throw new ProtectException(String.format(
                    "%s is empty.",
                    _mapName
            ));
        }
    }

    /**
     * Protect map. {@code "mapName"} is {@code "map"}.
     *
     * @param map Protected map.
     * @throws ProtectException If map is null or empty.
     */
    @Override
    public void protect(final Map<?, ?> map) throws ProtectException {
        protect("map", map);
    }
}
