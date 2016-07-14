package nus.com.devlibs.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.util.List;

import nus.com.devlibs.treeView.bean.utils.Node;
import nus.com.devlibs.treeView.bean.utils.TreeHelper;

/**
 * Created by sun on 2016/7/13.
 */
public abstract class TreeListViewAdapter<T> extends BaseAdapter {
    protected Context mContext;
    protected List<Node> mAllNodes;
    protected List<Node> mVisibleNodes;
    protected LayoutInflater mInflater;
    protected ListView mTree;

    /**
     * 设置Node 的点击回调
     */

    private interface  OnTreeNodeClickListener{
        void onClick(Node node,int position);
    }

    private OnTreeNodeClickListener mListener;

    private void setOnTreeNodeClickListener(OnTreeNodeClickListener mListenr){
        this.mListener = mListenr;
    }

    public TreeListViewAdapter(ListView tree, Context mContext, List<T> datas, int defaultExpandLevel) throws IllegalAccessException {

        this.mContext = mContext;
        mInflater = LayoutInflater.from(mContext);
        mAllNodes = TreeHelper.getSortedNodes(datas,defaultExpandLevel);
        mVisibleNodes = TreeHelper.filterVisibleNodes(mAllNodes);
        mTree = tree;

        mTree.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                expandOrCollapse(i);

                if (mListener != null){
                    mListener.onClick(mVisibleNodes.get(i),i);

                }

            }

            /**
             * 点击收缩还是展开
             * @param position
             */
            private void expandOrCollapse(int position) {
                Node n = mVisibleNodes.get(position);
                if (n!=null){
                    if (n.isLeaf())return;
                    n.setExpand(!n.isExpand());
                    mVisibleNodes = TreeHelper.filterVisibleNodes(mAllNodes);
                    notifyDataSetChanged();
                }
            }
        });
    }

    @Override
    public int getCount() {
        return mVisibleNodes.size();
    }

    @Override
    public Object getItem(int position) {
        return mVisibleNodes.get(position);
    }

    @Override
    public long getItemId(int position) {
        // return position;
        return mVisibleNodes.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Node node = mVisibleNodes.get(position);
        convertView =getConvertView(node,position,convertView,parent);
        convertView.setPadding(node.getLevel()*3,3,3,3);


        return null;
    }

    public abstract View getConvertView(Node node, int position, View convertView, ViewGroup parent) ;

}
