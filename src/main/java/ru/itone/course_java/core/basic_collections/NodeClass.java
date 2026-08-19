package ru.itone.course_java.core.basic_collections;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NodeClass<T extends Comparable<T>> {

    private T item;

    private NodeClass<T> left;

    private NodeClass<T> right;

    public NodeClass(T item) {
        this.item = item;
    }
}
