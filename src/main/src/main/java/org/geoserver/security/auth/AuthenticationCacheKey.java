/* (c) 2014 Open Source Geospatial Foundation - all rights reserved
 * (c) 2001 - 2013 OpenPlans
 * This code is licensed under the GPL 2.0 license, available at the root
 * application directory.
 */

package org.geoserver.security.auth;

/**
 * Composite key implementation for filter name and cache key
 *
 * @author christian
 */
public class AuthenticationCacheKey {
    private String filterName, cacheKey;

    public AuthenticationCacheKey(String filterName, String cacheKey) {
        this.filterName = filterName;
        this.cacheKey = cacheKey;
    }

    public String getFilterName() {
        return filterName;
    }

    public String getCacheKey() {
        return cacheKey;
    }

    public boolean equals(Object other) {
        if (other == this) return true;
        if (!(other instanceof AuthenticationCacheKey)) return false;

        AuthenticationCacheKey otherKey = (AuthenticationCacheKey) other;
        return (filterName == otherKey.filterName
                        || (filterName != null && filterName.equals(otherKey.filterName)))
                && (cacheKey == otherKey.cacheKey
                        || (cacheKey != null && cacheKey.equals(otherKey.cacheKey)));
    }

    public int hashCode() {
        return ((filterName == null) ? 0 : filterName.hashCode())
                ^ ((cacheKey == null) ? 0 : cacheKey.hashCode());
    }

    public String toString() {
        return filterName + ":" + cacheKey;
    }
}
