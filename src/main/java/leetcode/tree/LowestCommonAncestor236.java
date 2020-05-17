package leetcode.tree;// --------------------- Change Logs----------------------

import apple.laf.JRSUIUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// <p>@author bjhexiong Initial Created at 2020-05-10<p>
// 注释说明
// -------------------------------------------------------
public class LowestCommonAncestor236 {

    public static void main(String[] args) {

    }
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        tracePQ(new LinkedList<>(), root, p, q);

        //comm
        TreeNode result = root;
        for (int i = 1; i < pTrace.size() && i < qTrace.size(); i++) {
            if (pTrace.get(i).val == qTrace.get(i).val) {
                result = pTrace.get(i);
            } else {
                break;
            }
        }
        return result;
    }

    List<TreeNode> pTrace = new ArrayList<>();
    List<TreeNode> qTrace = new ArrayList<>();
    int searchEnd = 0;

    private void tracePQ(LinkedList<TreeNode> tracer, TreeNode root, TreeNode p, TreeNode q) {
        if (root.val == p.val) {
            pTrace = new ArrayList<>(tracer);
            pTrace.add(p);
            searchEnd++;
        }
        if (root.val == q.val) {
            qTrace = new ArrayList<>(tracer);
            qTrace.add(q);
            searchEnd++;
        }
        if (searchEnd == 2) {
            return;
        }

        tracer.add(root);
        //left
        if (root.left != null) {
            tracePQ(tracer, root.left, p, q);
        }

        //right
        if (root.right != null) {
            tracePQ(tracer, root.right, p, q);
        }
        tracer.removeLast();
    }
}
