package nus.com.devlibs.tree.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sun on 2016/7/13.
 */
public class Node {
    private int id;
    private String name;

    private int pid;
    private String label;
    public Node() {

    }

    public Node(int id,int pid, String label) {
        this.id = id;
        this.label = label;
        this.pid = pid;
    }

    /**
     * 树的等级
     */
    private int level;

    private boolean isExpand = false;
    private int ico;

    private Node parent;
    private List<Node> children = new ArrayList<Node>();


    public List<Node> getChildren() {
        return children;
    }

    public void setChildren(List<Node> children) {
        this.children = children;
    }

    public int getIcon() {
        return ico;
    }

    public void setIco(int ico) {
        this.ico = ico;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isExpand() {
        return isExpand;
    }

    public void setExpand(boolean expand) {
        isExpand = expand;
        if (!isExpand){
            for (Node node:children){
                node.setExpand(false);
            }
        }
    }

    public int getLevel() {
        return parent==null?0:parent.getLevel()+1;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public boolean isRoot(){
        return parent== null;
    }

    public boolean isParentExpand(){
        if (parent == null){
            return false;
        }else {
            return  parent.isExpand;
        }
    }

    public boolean isLeaf(){
        return children.size() == 0;
    }


    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }
}
