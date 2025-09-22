package ru.ac.uniyar.kuznetsov;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private int id;
    private String name;
    private final List<Node> children = new ArrayList<>();
    private Node parent;

    public Node(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public Node getParent() {
        return this.parent;
    }

    public int getId() {
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addChild(Node child) {
        this.children.add(child);
    }

    public List<Node> getChildren() {
        return this.children;
    }

    public Node getChildByName(String name) {
        return null;
    }

    public Node getChildById(int id) {
        return null;
    }

    public void removeChildByName(String name) {

    }

    public void removeChildById(int id) {

    }

    public void removeChildren() {
        if (this.children.isEmpty()) {
            return;
        }
        for (Node child : this.children) {
            child.removeChildren();
        }
        this.children.clear();
    }
}
