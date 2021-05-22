package coTe.Pro.Kakao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class KaKaoSearchRoute {
	
	public static void main(String[] args) throws Exception {
		
		int[][] nodeinfo = {{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}};
		
		int[][] ans = solution(nodeinfo);
	
		for(int i = 0; i < 2; i++) {
			
			for(int j = 0 ; j < ans[0].length; j++) {
				System.out.print(ans[i][j]);
			}
			System.out.println();
		}
	}
	static int idx = 0;
    public static int[][] solution(int[][] nodeinfo) {
        int[][] answer = {};
        
        List<Node> list = new ArrayList<Node>();
        
        for(int i = 0; i < nodeinfo.length; i++) {
        	
        	list.add(new Node(nodeinfo[i][0], nodeinfo[i][1], i+1));
        	
        }
        
        Collections.sort(list, new Comparator<Node>() { // 노드들을 y가 높은 순으로 정렬, y가 같다면 x가 낮은 순으로 정렬
            public int compare(Node n1, Node n2) {
                if (n1.y > n2.y) {
                    return -1;
                } else if (n1.y < n2.y) {
                    return 1;
                } else {
                    if (n1.x > n2.x) {
                        return 1;
                    } else if (n1.x < n2.x) {
                        return -1;
                    } else {
                        return 0;
                    }
                }
            }
        });

        Node head = list.get(0);
        
        answer = new int[2][list.size()];
        
        for(int i = 1; i < list.size(); i++) {
        	
        	addNode(head, list.get(i));
      
        }
        
        preorder(answer, head);
        idx=0;
        postorder(answer, head);
        
        
        
        return answer;
    }
    
    public static void addNode(Node parent, Node child) {
    	
    	if(parent.x > child.x) {
    		
    		if(parent.left == null) {
    			
    			parent.left = child;
    		
    		} else {
    			
    			addNode(parent.left, child);
    			
    		}
    		
    	} else {
    		
    		if(parent.right == null) {
    			
    			parent.right = child;
    			
    		} else {
    			
    			addNode(parent.right, child);
    			
    		}
    		
    	}
    	
    }
    
    public static void preorder(int[][] answer, Node head) {
    	
    	if(head != null) {
    		
    		answer[0][idx++] = head.idx;
    		preorder(answer, head.left);
        	preorder(answer, head.right);
        	
    	}

    }
    
    public static void postorder(int[][] answer, Node head) {
    	
    	if(head != null) {
    		
        	postorder(answer, head.left);
        	postorder(answer, head.right);
        	answer[1][idx++] = head.idx;
        	
    	}
    	
    }
    
}

class Node{
	
	int x;
	int y;
	int idx;
	Node left;
	Node right;
	
	Node(int x, int y, int idx) {
		
		this.x = x;
		this.y = y;
		this.idx = idx;
		
	}
	
}