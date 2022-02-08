package study.myself;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class B_13335_truck {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int n = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		Queue<Integer> trucks = new LinkedList<Integer>();
		st = new StringTokenizer(br.readLine()," ");
		for(int i =0;i<n;i++) {
			trucks.offer(Integer.parseInt(st.nextToken()));
		}
		
		int time = 0;
		Queue<Integer>bridge = new LinkedList<Integer>();
		for(int i =0;i<w;i++) {
			bridge.offer(0);
		}
		int sum = 0;
		
		while(!(trucks.isEmpty()&&sum==0)) {
			time++;
			if(!trucks.isEmpty()) {
				sum-=bridge.poll();
				if((trucks.peek() + sum)>L) {
					bridge.offer(0);
				}else {
					int now = trucks.poll();
					bridge.offer(now);
					sum+=now;
				}
			}else {
				sum-=bridge.poll();
			}	
		}
		bw.write(""+time);
		bw.flush();
		br.close();
		bw.close();
	}

}
