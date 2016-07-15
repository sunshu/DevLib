package nus.com.devlibs.tree;

import nus.com.devlibs.tree.utils.annotation.TreeNodeId;
import nus.com.devlibs.tree.utils.annotation.TreeNodeLabel;
import nus.com.devlibs.tree.utils.annotation.TreeNodePid;

/**
 * Created by sun on 2016/7/13.
 */
public class FileBean {
    @TreeNodeId
    private int id;
    @TreeNodePid
    private int pId;
    @TreeNodeLabel
    private String label;

    private String desc;

    public FileBean(int id,  int pId,String label) {
        this.id = id;
        this.label = label;
        this.pId = pId;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }
}
