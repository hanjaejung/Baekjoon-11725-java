package com.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 
 *  dfs
 *
 */
public class Dfs {
	
	static List<Integer>[] list;
	static boolean[] visited;
	static int[] parent;
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int nodeCount = Integer.parseInt(st.nextToken());
    	//부모 노드 저장 배열
    	parent = new int[nodeCount+1]; //1부터 세기 위해 7에서 카운트 1을 늘린다    기존 7로 그대로 두면 0 ~ 6의 인덱스 값을 쓰므로 1 ~7의 값을 쓰기 위해 7 + 1 이건 사실 답들을 참고할떄 이렇게 되어있어서 그냥 그대로 이거를 썼다
    	
    	list = new ArrayList[nodeCount+1]; //1부터 세기 위해 7에서 카운트 1을 늘린다    기존 7로 그대로 두면 0 ~ 6의 인덱스 값을 쓰므로 1 ~7의 값을 쓰기 위해 7 + 1 이건 사실 답들을 참고할떄 이렇게 되어있어서 그냥 그대로 이거를 썼다
    	for(int i = 1; i <= nodeCount; i++) {
    		list[i] = new ArrayList<>();
    	}
    	
    	visited = new boolean[nodeCount+1]; //1부터 세기 위해 7에서 카운트 1을 늘린다    기존 7로 그대로 두면 0 ~ 6의 인덱스 값을 쓰므로 1 ~7의 값을 쓰기 위해 7 + 1 이건 사실 답들을 참고할떄 이렇게 되어있어서 그냥 그대로 이거를 썼다
    	
    	for(int i = 1; i < nodeCount; i++) {
    		st = new StringTokenizer(br.readLine(), " ");
    		int a = Integer.parseInt(st.nextToken());
    		int b = Integer.parseInt(st.nextToken());
    		
    		list[a].add(b);
    		list[b].add(a);
    	}
    	
    	//dfs 한깊이를 쭉 파고 다음으로 이동하는 알고리즘
    	//1부터 시작하여 parent 배열에 해당 번호의 부모배열을 담는다
    	//1로 시작하는 이유는 1루트로 시작해서다
    	//1의 연결된 노드를 찾아 parent값에 부모값을 담는다
    	dfs(1);

    	for(int i = 2; i <= nodeCount; i++) {
    		System.out.println(parent[i]);
    	}
    	
    	
    	
    }
    
    static void dfs(int start) {
    	visited[start] = true;
    	
    	for(int i : list[start]) { // for문을 돌리는 이유, 예) 1의 자식노드를 찾을때 하나만이 아닌 4와 6같이 2개 있을수도 있기 때문
			//방문한 노드 건너뛰기
			//System.out.println("temp : " + temp + "의 배열 안의 리스트 값 확인 : " + i);
			if(visited[i]) {
				continue;
			}
			parent[i] = start;
			dfs(i);
		}
    	
    }
    
  
}