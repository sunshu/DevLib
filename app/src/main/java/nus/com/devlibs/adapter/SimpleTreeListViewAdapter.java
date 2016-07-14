package nus.com.devlibs.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import nus.com.devlibs.R;
import nus.com.devlibs.treeView.bean.utils.Node;

/**
 * Created by sun on 2016/7/14.
 */
public class SimpleTreeListViewAdapter<T> extends TreeListViewAdapter<T> {
    public SimpleTreeListViewAdapter(ListView tree, Context mContext, List<T> datas, int defaultExpandLevel) throws IllegalAccessException {
        super(tree, mContext, datas, defaultExpandLevel);
    }

    private class ViewHolder{
        ImageView iv_icon;
        TextView tv_item;

    }

    @Override
    public View getConvertView(Node node, int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null){
           convertView = mInflater.inflate(R.layout.list_item,parent,false);
            viewHolder = new ViewHolder();
            viewHolder.tv_item = (TextView) convertView.findViewById(R.id.id_item_text);
            viewHolder.iv_icon = (ImageView) convertView.findViewById(R.id.id_item_icon);


        }

        return null;
    }
}
