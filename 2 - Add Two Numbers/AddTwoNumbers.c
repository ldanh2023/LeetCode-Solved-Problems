/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
    public:
        ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        ListNode* head = nullptr;
        ListNode* current = nullptr;
        int carry = 0;

        while (l1 != nullptr || l2 != nullptr || carry > 0) {
            int value_a = (l1 != nullptr) ? l1->val : 0;
            int value_b = (l2 != nullptr) ? l2->val : 0;

            int sum = value_a + value_b + carry;
            carry = sum / 10;

            ListNode* newNode = new ListNode(sum % 10);

            if (head == nullptr) {
                head = newNode;
                current = newNode;
            } else {
                current->next = newNode;
                current = current->next;
            }

            if (l1 != nullptr) {
                l1 = l1->next;
            }
            if (l2 != nullptr) {
                l2 = l2->next;
            }
        }

        return head;
    } 
};