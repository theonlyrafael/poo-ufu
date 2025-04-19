package BuscaBinariaTest;

import BuscaBinaria.ArvoreBinaria;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ArvoreBinariaTeste{

    @Test
    void testIntegerOperations() {
        ArvoreBinaria<Integer> tree = new ArvoreBinaria<>();
        tree.insert(5);
        tree.insert(3);
        tree.insert(7);

        assertTrue(tree.search(5));
        assertTrue(tree.search(3));
        assertTrue(tree.search(7));

        tree.remove(3);
        assertFalse(tree.search(3));
    }

    @Test
    void testFloatOperations() {
        ArvoreBinaria<Float> tree = new ArvoreBinaria<>();
        tree.insert(5.5f);
        tree.insert(3.3f);
        tree.insert(7.7f);

        assertTrue(tree.search(5.5f));
        assertTrue(tree.search(3.3f));
        assertTrue(tree.search(7.7f));

        tree.remove(3.3f);
        assertFalse(tree.search(3.3f));
    }

    @Test
    void testCharacterOperations() {
        ArvoreBinaria<Character> tree = new ArvoreBinaria<>();
        tree.insert('a');
        tree.insert('b');
        tree.insert('c');

        assertTrue(tree.search('a'));
        assertTrue(tree.search('b'));
        assertTrue(tree.search('c'));

        tree.remove('b');
        assertFalse(tree.search('b'));
    }

    @Test
    void testStringOperations() {
        ArvoreBinaria<String> tree = new ArvoreBinaria<>();
        tree.insert("apple");
        tree.insert("banana");
        tree.insert("cherry");

        assertTrue(tree.search("apple"));
        assertTrue(tree.search("banana"));
        assertTrue(tree.search("cherry"));

        tree.remove("banana");
        assertFalse(tree.search("banana"));
    }
}
