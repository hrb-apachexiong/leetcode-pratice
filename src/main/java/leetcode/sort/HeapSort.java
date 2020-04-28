package leetcode.sort;

// --------------------- Change Logs----------------------
// <p>@author bjhexiong Initial Created at 2020-04-16<p>
// 注释说明
// -------------------------------------------------------
public class HeapSort {
    public static void main(String[] args) {
        int[] data = new int[]{10, 3, 4, 5, 71, 3, 1};
        new HeapSort().sort(data);
        System.out.println(data);

    }

    public void sort(int[] data) {
        buildHeap(data);

        //大顶堆，移动到末尾，正序
        for (int i = data.length - 1; i > 0; i--) {
            //swap
            int temp = data[i];
            data[i] = data[0];
            data[0] = temp;

            //heapsort
            heapsort(data, 0, i);
        }
    }

    /**
     * heap是一个满二叉树
     * @param data
     */
    private void buildHeap(int[] data) {
        for (int i = (data.length - 1) / 2; i >= 0; i--) {
            heapsort(data, i, data.length);
        }
    }

    public void heapsort(int[] data, int idx, int size) {
        int left = idx * 2 + 1;
        int right = idx * 2 + 2;
        int maxIdx = idx;
        if (left < size && data[left] > data[maxIdx]) {
            maxIdx = left;
        }
        if (right < size && data[right] > data[maxIdx]) {
            maxIdx = right;
        }

        //swap
        if (maxIdx != idx) {
            int temp = data[idx];
            data[idx] = data[maxIdx];
            data[maxIdx] = temp;

            heapsort(data, maxIdx, size);
        }
    }


}
