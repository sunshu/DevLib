package nus.com.devlibs.tree.utils;

import android.util.Log;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import nus.com.devlibs.R;
import nus.com.devlibs.tree.utils.annotation.TreeNodeId;
import nus.com.devlibs.tree.utils.annotation.TreeNodeLabel;
import nus.com.devlibs.tree.utils.annotation.TreeNodePid;

/**
 * Created by sun on 2016/7/13.
 */
public class TreeHelper {
    /**
     * 将用户数据转化成树形结构
     * @param datas
     * @param <T>
     * @return
     * @throws IllegalAccessException
     */
    public static <T> List<Node> converDatasNodes(List<T> datas) throws IllegalAccessException {
        List<Node> nodes = new ArrayList<Node>();
        Node node = null;
        for (T t : datas){
            int id = -1;
            int pid = -1;
            String label = null;
            node = new Node();

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

            }
             node = new Node(id,pid,label);
            nodes.add(node);
        }

        /**
         * 设置Node 间的结点关系
         */
        for (int i=0;i<nodes.size();i++){
            Node n = nodes.get(i);
            for (int j=i+1;j<nodes.size();j++){
                Node m = nodes.get(j);
                if (m.getPid() == n.getId()){
                    n.getChildren().add(m);
                    m.setParent(n);
                }else if (m.getId() == n.getPid())
                {
                    m.getChildren().add(n);
                    n.setParent(m);
                }


            }
        }

        for (Node n : nodes){
            setNodeIcon(n);
        }


        return nodes;
    }

    /**
     * 为Node设置图标
     */
    private static void setNodeIcon(Node n) {
        if (n.getChildren().size()>0 && n.isExpand()){
            n.setIco(R.drawable.tree_ex);
        }else
            if(n.getChildren().size() >0 && !n.isExpand() ){
            n.setIco(R.drawable.tree_ec);
            }
        else{
                n.setIco(-1);
            }

    }


    public static <T> List<Node> getSortedNodes(List<T> datas,int defaultExpandLevel) throws IllegalAccessException {

        List<Node> result = new ArrayList<Node>();
        List<Node> nodes = converDatasNodes(datas);

        // 获得树的根结点
        List<Node> rootNodes = getRootNodes(nodes);

        for (Node node :rootNodes){
            Log.e("node",node.getName());
            addNodes(result,node,defaultExpandLevel,1);
        }


        return result;
    }

    /**
     * 把一个节点的所有孩子节点都放到result中
     * @param result
     * @param node
     * @param defaultExpandLevel
     * @param   currentLevel
     */
    private static void addNodes(List<Node> result, Node node, int defaultExpandLevel, int currentLevel) {
        result.add(node);
        if (defaultExpandLevel>=currentLevel){
            node.setExpand(true);
        }
        if (node.isLeaf()){
            return;

        }

        for (int i=0;i<node.getChildren().size();i++){
            addNodes(result,node.getChildren().get(i),defaultExpandLevel,currentLevel+1);

        }

    }

    /**
     * 过滤出可见的节点
     * @param nodes
     * @return
     */
    public static  List<Node> filterVisibleNodes(List<Node> nodes){
        List<Node> result = new ArrayList<Node>();
        for (Node node :nodes){
            if (node.isRoot() || node.isParentExpand()){
                setNodeIcon(node);
                result.add(node);
            }
        }


        return result;
    }





    private static List<Node> getRootNodes(List<Node> nodes) {

        List<Node> root = new ArrayList<>();
        for (Node node :nodes){
            if (node.isRoot()){
                root.add(node);
            }
        }
        return root;
    }

}
