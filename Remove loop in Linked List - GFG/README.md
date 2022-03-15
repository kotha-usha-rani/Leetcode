# Remove loop in Linked List
## Medium 
<div class="problem-statement" style="user-select: auto;">
                <p style="user-select: auto;"></p><p style="user-select: auto;"><span style="font-size: 18px; user-select: auto;">Given a linked list of <strong style="user-select: auto;">N</strong> nodes such that it may contain a loop. </span></p>

<blockquote style="user-select: auto;">
<p style="user-select: auto;"><span style="font-size: 18px; user-select: auto;">A loop here means that the last node of the link list is connected to the node at position X. If the link list does not have any loop, X=0.</span></p>
</blockquote>

<p style="user-select: auto;"><span style="font-size: 18px; user-select: auto;">Remove the loop from the linked list, if it is present. </span>&nbsp;</p>

<p style="user-select: auto;"><br style="user-select: auto;">
<strong style="user-select: auto;"><span style="font-size: 18px; user-select: auto;">Example 1:</span></strong></p>

<pre style="user-select: auto;"><strong style="user-select: auto;"><span style="font-size: 18px; user-select: auto;">Input:
</span></strong><span style="font-size: 18px; user-select: auto;">N = 3
value[] = {1,3,4}
X = 2
<strong style="user-select: auto;">Output: </strong>1<strong style="user-select: auto;">
Explanation: </strong>The link list looks like<strong style="user-select: auto;">
</strong>1 -&gt; 3 -&gt; 4
     ^    |
     |____|    
A loop is present. If you remove it 
successfully, the answer will be 1. </span>
</pre>

<p style="user-select: auto;"><br style="user-select: auto;">
<strong style="user-select: auto;"><span style="font-size: 18px; user-select: auto;">Example 2:</span></strong></p>

<pre style="user-select: auto;"><strong style="user-select: auto;"><span style="font-size: 18px; user-select: auto;">Input:
</span></strong><span style="font-size: 18px; user-select: auto;">N = 4
value[] = {1,8,3,4}
X = 0
<strong style="user-select: auto;">Output: </strong>1<strong style="user-select: auto;">
Explanation: </strong>The&nbsp;Linked list does not 
contains any loop. </span></pre>

<p style="user-select: auto;"><br style="user-select: auto;">
<strong style="user-select: auto;"><span style="font-size: 18px; user-select: auto;">Example 3:</span></strong></p>

<pre style="user-select: auto;"><strong style="user-select: auto;"><span style="font-size: 18px; user-select: auto;">Input:
</span></strong><span style="font-size: 18px; user-select: auto;">N = 4
value[] = {1,2,3,4}
X = 1
<strong style="user-select: auto;">Output: </strong>1<strong style="user-select: auto;">
Explanation: </strong>The link list looks like<strong style="user-select: auto;"> 
</strong>1 -&gt; 2 -&gt; 3 -&gt; 4
|______________|
A loop is present. 
If you remove it successfully, 
the answer will be 1. </span></pre>

<p style="user-select: auto;"><br style="user-select: auto;">
<span style="font-size: 18px; user-select: auto;"><strong style="user-select: auto;">Your&nbsp;Task:</strong><br style="user-select: auto;">
You don't need to read input or print anything.&nbsp;Your task is to&nbsp;complete the function <strong style="user-select: auto;">removeLoop</strong>() which takes the&nbsp;head of the linked list as the input parameter. Simply remove the loop in the list (if present) without disconnecting any nodes from the list.<br style="user-select: auto;">
<strong style="user-select: auto;">Note: </strong>The generated output&nbsp;will be&nbsp;<strong style="user-select: auto;">1&nbsp;</strong>if your submitted code is correct.</span></p>

<p style="user-select: auto;"><br style="user-select: auto;">
<span style="font-size: 18px; user-select: auto;"><strong style="user-select: auto;">Expected time complexity:</strong> O(N)</span><br style="user-select: auto;">
<span style="font-size: 18px; user-select: auto;"><strong style="user-select: auto;">Expected auxiliary space:&nbsp;</strong>O(1)</span></p>

<p style="user-select: auto;"><br style="user-select: auto;">
<span style="font-size: 18px; user-select: auto;"><strong style="user-select: auto;">Constraints:</strong><br style="user-select: auto;">
1 ≤ N ≤ 10<sup style="user-select: auto;">4</sup></span></p>
 <p style="user-select: auto;"></p>
            </div>