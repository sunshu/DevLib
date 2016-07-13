package nus.com.devlibs.treeView.bean.utils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import nus.com.devlibs.treeView.bean.utils.annotation.TreeNodeId;
import nus.com.devlibs.treeView.bean.utils.annotation.TreeNodeLabel;
import nus.com.devlibs.treeView.bean.utils.annotation.TreeNodePid;

/**
 * Created by sun on 2016/7/13.
 */
public class TreeHelper {
    public static <T> List<Node> converDatasNodes(List<T> datas) throws IllegalAccessException {
        List<Node> nodes = new ArrayList<Node>();

        for (T t : datas){
            int id = -1;
            int pid = -1;
            String label = null;


            Class<?> clazz = t.getClass();
            Field[] fields = clazz.getDeclaredFields();
            for (Field field:fields){
                if (field.getAnnotation(TreeNodeId.class)!=null){
                    field.setAccessible(true);
                    id = field.getInt(t);
                }
                if (field.getAnnotation(TreeNodePid.class)!=null){
                    field.setAccessible(true);
                    pid = field.getInt(t);
                }

                if (field.getAnnotation(TreeNodeLabel.class)!=null){
                    field.setAccessible(true);
                    label = (String) field.get(t);
                }
                Node node = new Node(id,pid,label);
                nodes.add(node);


            }
        }

        return nodes;
    }

}
