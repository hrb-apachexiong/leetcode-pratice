package leetcode.linkedlist;// --------------------- Change Logs----------------------

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.checkerframework.common.value.qual.IntRange;
import sun.awt.IconInfo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

// <p>@author bjhexiong Initial Created at 2020-05-17<p>
// 注释说明
// -------------------------------------------------------
public class SkipList1206 {

    public static void main(String[] args) {
        SkipList1206 list = new SkipList1206();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(6);
        prinitSkipList(list);
        System.out.println(list.search(1));
        System.out.println(list.search(2));
        System.out.println(list.search(5));
        System.out.println(list.search(100));
        System.out.println(list.search(-1));
        System.out.println(list.erase(1));
        prinitSkipList(list);
        System.out.println(list.search(6));


    }

    private static void prinitSkipList(SkipList1206 skipList1206) {
        for (int depth = skipList1206.head.depth - 1; depth >= 0; depth--) {
            SkipNode node = skipList1206.head.next[depth];
            System.out.print("head->");
            while (node != null) {
                System.out.print(node.value + "-->");
                node = node.next[depth];
            }
            System.out.println("");
        }
    }

    private static final Random RANDOM = new Random();

    class SkipNode {
        int value;
        SkipNode[] next;
        int depth;
    }

    private SkipNode head;

    public SkipList1206() {
        head = new SkipNode();
        head.next = new SkipNode[1];
        head.depth = 1;
    }

    public boolean search(int target) {
        return search(head.next, target);
    }

    private boolean search(SkipNode[] nextNodes, int target) {
        if (nextNodes == null) {
            return false;
        }
        for (int level = nextNodes.length - 1; level >= 0; level--) {
            SkipNode next = nextNodes[level];
            if (next == null) {
                continue;
            }
            if (target == next.value) {
                return true;
            }
            if (target > next.value) {
                return search(next.next, target);
            }
        }
        return false;
    }

    public void add(int num) {
        SkipNode node = newSkipNode(num);

        //
        addNew(head.next, node);

        //修正head,补齐
        if (node.depth > head.depth) {
            SkipNode[] headNexts = new SkipNode[node.depth];
            System.arraycopy(head.next, 0, headNexts, 0, head.next.length);
            for (int i = head.next.length; i < node.depth; i++) {
                headNexts[i] = node;
            }
            head.next = headNexts;
            head.depth = node.depth;
        }
    }

    private void addNew(SkipNode[] nextNodes, SkipNode node) {
        if (nextNodes == null) {
            return;
        }

        for (int level = nextNodes.length - 1; level >= 0; level--) {
            SkipNode next = nextNodes[level];
            if (next == null && level != 0) {
                continue;
            }

            // 最底层，终止条件.
            if (level == 0 && next == null) {
                nextNodes[level] = node;
                return;
            }

            if (level == 0
                    && node.value <= next.value) {
                nextNodes[level] = node;
                node.next[level] = next;
                return;
            }
            //向right方向查找
            if (node.value > next.value) {
                addNew(next.next, node);
                if (next.next[level] == null && next.depth <= node.depth) {
                    next.next[level] = node;
                }
                return;
            }

            //降层了，插入.
            if (node.depth == nextNodes.length) {
                nextNodes[level] = node;
                node.next[level] = next;
            }
        }
        return;
    }

    private SkipNode newSkipNode(int num) {
        int level = 1;
        while (RANDOM.nextInt(10) >= 5) {
            level++;
        }

        SkipNode node = new SkipNode();
        node.value = num;
        node.next = new SkipNode[level];
        node.depth = level;
        return node;
    }

    public boolean erase(int num) {
        boolean suc = delete(head.next, num);

        //修整head.
        if (suc) {
            SkipNode node = head;
            int depth = head.depth;
            while (node.next[depth - 1] == null && --depth > 0) ;
            depth = Math.max(1, depth);
            if (depth < head.depth) {
                SkipNode[] headNexts = new SkipNode[depth];
                System.arraycopy(head.next, 0, headNexts, 0, depth);

                head.depth = depth;
                head.next = headNexts;
            }
        }
        return suc;
    }

    private boolean delete(SkipNode[] nextNodes, int target) {
        if (nextNodes == null) {
            return false;
        }

        boolean deleted = false;
        for (int level = nextNodes.length - 1; level >= 0; level--) {
            SkipNode next = nextNodes[level];
            if (next == null || next.value > target) {
                continue;
            }

            if (next.value == target) {
                nextNodes[level] = next.next[level];
                deleted = true;
            } else {
                SkipNode levelNode = next;
                while (null != levelNode.next[level] && levelNode.next[level].value < target) {
                    levelNode = levelNode.next[level];
                }
                if (null != levelNode.next[level]) {
                    if (levelNode.next[level].value == target) {
                        levelNode.next[level] = levelNode.next[level].next[level];
                        deleted = true;
                    }
                }
            }
        }
        return deleted;
    }
}
