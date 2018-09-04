package com.others.count_3_quit;

/**
 * 小孩围成的圈类
 *
 * @author ZhouXu
 * @version v1.0 2018-09-04
 */
public class KidCircle {
    int count;
    KidNode first;
    KidNode last;

    public KidCircle(int num) {
        count = 0;
        for (int i = 0; i < num; i++) {
            addKid();
        }
    }

    public void addKid() {
        KidNode k = new KidNode(count);
        if (count <= 0) {
            first = k;
            last = k;
            k.left = k;
            k.right = k;
        } else {
            first.left = k;
            last.right = k;
            k.left = last;
            k.right = first;
            last = k;
        }
        count++;
    }

    public void deleteKid(KidNode k) {
        if (count <= 0) {
            return;
        } else if (count == 1) {
            k.left = null;
            k.right = null;
        } else {
            k.right.left = k.left;
            k.left.right = k.right;
            if (k == first) {
                first = k.right;
            } else if (k == last) {
                last = k.left;
            }
        }
        count--;
    }
}
