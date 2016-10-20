package com.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ma on 2016/10/19.
 */
public class TreeModel {
    private String text;
    private String id;
    private String name;

    public ArrayList<TreeModel> nodes;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<TreeModel> getNodes() {
        return nodes;
    }

    public void setNodes(ArrayList<TreeModel> nodes) {
        this.nodes = nodes;
    }


    public TreeModel()
    {
        this.nodes = new ArrayList<com.model.TreeModel>();
    }

    public TreeModel(TreeModel tm)
    {
        this.text = tm.text;
        this.id = tm.id;
        this.name = tm.name;
        this.nodes = new ArrayList<TreeModel>();
        this.nodes.addAll(tm.nodes);

    }

}
