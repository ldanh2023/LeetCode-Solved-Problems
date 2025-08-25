# Solved Solution

**My Solution:** O(n) for space and time complexity

### Solution summary: Inspired by ripple-carry from my experience working with digital logic circuit design (FPGA)

### ListNode operations
```
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
```

### Pseudocode:
```
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        set head to be nullptr (or you could use an arbitrary node)
        create "current" pointer, points to current position in ListNode output
        carry = 0;

        while (l1 != nullptr || l2 != nullptr || carry > 0) { //as long as nodes exist or carry is not 0
            value_a = value of l1 if not null
            value_b = value of l2 if not null

            sum = value_a + value_b + carry;
            carry is 1 if it is greater than 10

            create new node with value = sum % 10

            if (head == nullptr) { //if head == nullptr, then no nodes have been initialized therefore we set it to be first node
                head = newNode;
                current = newNode;
            } else { //if head != nullptr, nodes have been initialized therefore, we set next pointer in linked list to be node created
                current->next = newNode;
                current = current->next;
            }

            iterate to next l1 and l2 if not null
        }

        return head;
    }
```
