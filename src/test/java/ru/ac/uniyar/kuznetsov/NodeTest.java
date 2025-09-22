package ru.ac.uniyar.kuznetsov;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NodeTest {
    /**
     * Создание дерева
     */
    @Test
    void createNode() {
        Node node = new Node("root");
        assertEquals("root", node.getName());
    }

    /**
     * Добавление дочернего узла
     */
    @Test
    void addChild() {
        Node root = new Node("root");
        root.addChild(new Node("child1"));
        assertEquals(1, root.getChildren().size());
        assertEquals("child1", root.getChildren().get(0).getName());
    }

    /**
     * Получить родителя по дочернему узлу
     */
    @Test
    void getParent() {
        Node root = new Node("root");
        Node child = new Node("child");

        assertEquals(root, child.getParent());
    }

    /**
     * Поиск дочернего узла по имени
     */
    @Test
    void getChildByName() {
        Node root = new Node("root");
        Node child1 = new Node("child1");
        Node child2 = new Node("child2");
        root.addChild(child1);
        root.addChild(child2);

        assertEquals(child2, root.getChildByName("child2"));
    }

    /**
     * Поиск дочернего узла при совпадающих именах
     */
    @Test
    void getDuplicateChildrenByName() {
        Node root = new Node("root");
        Node child1 = new Node("child");
        Node child2 = new Node("child");
        root.addChild(child1);
        root.addChild(child2);

        assertEquals(child1, root.getChildByName("child"));

    }

    /**
     * Поиск дочернего узла по несуществующему имени
     */
    @Test
    void getNonExistentChildByName() {
        Node root = new Node("root");
        assertNull(root.getChildByName("child"));
    }

    /**
     * Удаление дочернего узла по имени
     */
    @Test
    void removeChildByName() {
        Node root = new Node("root");
        Node child1 = new Node("child1");
        Node child2 = new Node("child2");
        root.addChild(child1);
        root.addChild(child2);

        root.removeChildByName("child1");
        assertEquals(1, root.getChildren().size());
        assertNotNull(root.getChildByName("child2"));
    }

    /**
     * Удаление узлов с одинаковыми именами
     */
    @Test
    void removeDuplicateChildrenByName() {
        Node root = new Node("a");
        Node child1 = new Node("b");
        Node child2 = new Node("a");
        Node child3 = new Node("a");
        Node child4 = new Node("b");

        root.addChild(child1);
        child1.addChild(child2);
        child1.addChild(child3);
        child1.addChild(child4);

        root.removeChildByName("a");

        assertEquals(2, child1.getChildren().size());
    }

    /**
     * Удаление несуществующего дочернего узла по имени
     */
    @Test
    void removeNonExistentChildByName() {
        Node root = new Node("root");
        Node child = new Node("child");
        root.addChild(child);

        root.removeChildByName("superChild");
        assertEquals(1, root.getChildren().size());
    }

    /**
     * Удаление дочернего узла по идентификатору
     */
    @Test
    void removeChildById() {
        Node root = new Node("root");
        Node child1 = new Node("child1");
        Node child2 = new Node("child2");
        root.addChild(child1);
        root.addChild(child2);

        root.removeChildById(child1.getId());
        assertEquals(1, root.getChildren().size());
        assertNotNull(root.getChildById(child2.getId()));
    }

    /**
     * Удаление несуществующего дочернего узла по имени
     */
    @Test
    void removeNonExistentChildById() {
        Node root = new Node("root");
        Node child = new Node("child");
        Node fakeChild = new Node("fakeChild");

        root.addChild(child);

        root.removeChildById(fakeChild.getId());
        assertEquals(1, root.getChildren().size());
    }

    /**
     * Удаление всех дочерних узлов
     */
    @Test
    void removeChildren() {
        Node root = new Node("root");
        Node child1 = new Node("child1");
        Node child2 = new Node("child2");

        root.addChild(child1);
        root.addChild(child2);

        root.removeChildren();
        assertEquals(0, root.getChildren().size());
    }

    /**
     * Изменение имени узла
     */
    @Test
    void setName() {
        Node root = new Node("root");
        root.setName("superRoot");

        assertEquals("superRoot", root.getName());
    }
}
