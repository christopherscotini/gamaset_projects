package br.com.gamaset.tradeline.model;

import java.io.Serializable;
import java.util.Objects;

public abstract class AbstractEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    public abstract Object getId();

    @Override
    public boolean equals(Object object) {
        if ((object != null) && this.getClass().isInstance(object)) {
            AbstractEntity other = this.getClass().cast(object);
            if (this.getId() == null) {
                return (other.getId() == null);
            } else {
                return this.getId().equals(other.getId());
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = Objects.hashCode(this.getClass());
        hash = 23 * hash + Objects.hashCode(this.getId());
        return hash;
    }
}
