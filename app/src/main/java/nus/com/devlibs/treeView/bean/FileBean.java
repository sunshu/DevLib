package nus.com.devlibs.treeView.bean;

import nus.com.devlibs.treeView.bean.utils.annotation.TreeNodeId;
import nus.com.devlibs.treeView.bean.utils.annotation.TreeNodeLabel;
import nus.com.devlibs.treeView.bean.utils.annotation.TreeNodePid;

/**
 * Created by sun on 2016/7/13.
 */
public class FileBean {
    @TreeNodeId
    private int id;
    @TreeNodePid
    private int pId;
    @TreeNodePid
    private String label;

    private String desc;


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
