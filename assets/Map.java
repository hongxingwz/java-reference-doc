package com.jianglei.innerInterface;

/**
 * Created by jianglei on 2017/7/31.
 */
public interface Map<K, V> {
    public void say();

    interface Entry<K, V> {

        public K getKey();

        public V getValue();
    }

    static class Node<K, V> implements Map.Entry<K, V> {
        @Override
        public K getKey() {
            return null;
        }

        @Override
        public V getValue() {
            return null;
        }
    }


}
