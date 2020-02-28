package com.crud.entity;

public abstract class EntityImpl implements Entity {

    private static final long serialVersionUID = 1L;

    @Override
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof EntityImpl)) {
            return false;
        }

        EntityImpl other = (EntityImpl) obj;

        Long myId = getId();
        Long otherId = other.getId();

        if (myId == null || otherId == null) {
            return false;
        }

        return myId.longValue() == otherId.longValue();

    }

    @Override
    public int hashCode() {
        Long id = getId();
        return (id == null) ? super.hashCode() : id.hashCode();
    }

}
