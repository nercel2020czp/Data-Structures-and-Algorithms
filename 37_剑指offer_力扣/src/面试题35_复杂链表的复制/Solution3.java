package 面试题35_复杂链表的复制;
//算法(bfs)
public class Solution3 {

}
/*class Solution {
public:
    Node* copyRandomList(Node* head) {
        return bfs(head);
    }
    
    Node* bfs(Node* head) {
        if (!head) return nullptr;
        unordered_map<Node*, Node*> used;
        used[head] = new Node(head->val);
        queue<Node*> q;
        q.push(head);
        while (!q.empty()) {
            int siz = q.size();
            for (int i = 0; i < siz; i++) {
                Node *t = q.front(); q.pop();
                if (t->next) {
                    if (!used[t->next]) {
                        used[t->next] = new Node(t->next->val);
                        q.push(t->next);
                    }
                    used[t]->next = used[t->next];
                }
                if (t->random) {
                    if (!used[t->random]) {
                        used[t->random] = new Node(t->random->val);
                        q.push(t->random);
                    }
                    used[t]->random = used[t->random];
                }
            }
        }
        return used[head];
    }
};

作者：happy_yuxuan
链接：https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof/solution/mian-shi-ti-35-fu-za-lian-biao-de-fu-zhi-san-chong/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/