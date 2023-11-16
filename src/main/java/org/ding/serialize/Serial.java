package org.ding.serialize;

import java.io.Serializable;

/**
 * @author wangjiansheng
 * @version 1.0.0
 */
public class Serial implements Serializable {
    private static final long serialVersionUID = -2268572983612122674L;

    int id;
    String name;
    public Serial(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Serial{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
