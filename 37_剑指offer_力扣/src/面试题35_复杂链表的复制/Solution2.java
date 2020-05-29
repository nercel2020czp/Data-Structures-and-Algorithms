package 面试题35_复杂链表的复制;
//算法(dfs)
public class Solution2 {

}
/*class Solution {
public:
    Node* copyRandomList(Node* head) {
        unordered_map<Node*, Node*> used;
        return dfs(head, used);
    }
    
    Node* dfs(Node* head, unordered_map<Node*, Node*>& used) {
        if (!head) return nullptr;
        if (used.count(head)) return used[head];
        Node *res = new Node(head->val);
        used[head] = res;
        res->next = dfs(head->next, used);
        res->random = dfs(head->random, used);    
        return res;
    }
};

作者：happy_yuxuan
链接：https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof/solution/mian-shi-ti-35-fu-za-lian-biao-de-fu-zhi-san-chong/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/