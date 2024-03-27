package com.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 
 *  bfs
 *
 */
public class Bfs {

	
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int nodeCount = Integer.parseInt(st.nextToken());
    	//부모 노드 저장 배열
    	int[] parent = new int[nodeCount+1];
    	
    	List<Integer>[] list = new ArrayList[nodeCount+1];
    	for(int i = 1; i <= nodeCount; i++) {
    		list[i] = new ArrayList<>();
    	}
    	
    	boolean[] visited = new boolean[nodeCount+1];
    	
    	for(int i = 1; i < nodeCount; i++) {
    		st = new StringTokenizer(br.readLine(), " ");
    		int a = Integer.parseInt(st.nextToken());
    		int b = Integer.parseInt(st.nextToken());
    		
    		list[a].add(b);
    		list[b].add(a);
    	}
    	
    	//bfs 한놈만 팬다
    	//1부터 시작하여 parent 배열에 해당 번호의 부모배열을 담는다
    	//1로 시작하는 이유는 1루트로 시작해서다
    	//1의 연결된 노드를 찾아 parent값에 부모값을 담는다
    	Queue<Integer> queue = new LinkedList<>();
    	queue.offer(1);
    	visited[1] = true;
    	
    	while(!queue.isEmpty()) {
    		int temp = queue.poll();
    		for(int i : list[temp]) { // for문을 돌리는 이유, 예) 1의 자식노드를 찾을때 하나만이 아닌 4와 6같이 2개 있을수도 있기 때문
    			//방문한 노드 건너뛰기
    			//System.out.println("temp : " + temp + "의 배열 안의 리스트 값 확인 : " + i);
    			if(visited[i]) {
    				continue;
    			}
    			
    			visited[i] = true;
    			queue.offer(i);
    			parent[i] = temp;
    		}
    	}
    	
    	for(int i = 2; i <= nodeCount; i++) {
    		System.out.println(parent[i]);
    	}
    	
    	
    	
    }
    
  
}