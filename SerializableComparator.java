// **********************************************************************************
// Title: Serializable Comparator
// Author: Autumn Horn
// File: SerializableComparator.java
// Description: Defines a SerializableComparator interface for making Comparators that
//    are Serializable
// **********************************************************************************
import java.io.Serializable;
import java.util.Comparator;

public interface SerializableComparator<T> extends Comparator<T>, Serializable {
}
