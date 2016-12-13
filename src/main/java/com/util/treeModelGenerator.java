package com.util;

import com.model.Department;
import com.model.TreeModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ma on 2016/10/19.
 */
public class treeModelGenerator {
    public static List<TreeModel> GetDepartmentList(List<Department> dep)
    {
        ArrayList<TreeModel> result = new ArrayList<TreeModel>();
        for (Department temp:dep)
        {
            TreeModel tm = new TreeModel();
            tm.setId(temp.getDepDdId());
            tm.setName(temp.getDepName());
            tm.setText(temp.getDepName());
            String pid = temp.getDepParentid();
            if (pid.equals("1"))
            {
                result.add(tm);
            }
            else
            {
                TreeModel parent = FindClassParent(result,pid);
                if (parent != null) {
                    tm.setName(parent.getName() + '-' +temp.getDepName());
                    parent.nodes.add(tm);
                }
            }
        }
        return result;
    }
    static public TreeModel FindClassParent(List<TreeModel> rootList, String pid)
    {
        TreeModel ans = null;
        for (TreeModel ch:rootList)
        {
            if (pid.equals(ch.getId()) )
            {
                ans = ch;
                break;
            }
            if (ch.nodes.size() > 0)
            {
                ans = FindClassParent(ch.nodes, pid);
                if (ans != null) break;
            }
        }
        return ans;
    }
}
