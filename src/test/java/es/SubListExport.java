package es;



import java.util.ArrayList;
import java.util.Scanner;

/**
 * 输入一个集合，输出这个集合的所有子集
 * 
 * @author liangyongxing
 * @time 2017-02-06
 */
public class SubListExport {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		System.out.println("请输入一串整数并在输入时用英文逗号隔开：");
		String inputString = new Scanner(System.in).next().toString();
		if (inputString != null && !inputString.isEmpty()) {
			String[] strArray = inputString.split(",");
			for (String str : strArray) {
				list.add(Integer.parseInt(str));
			}
			ArrayList<ArrayList<Integer>> allsubsets = getSubsets2(list);
			for (ArrayList<Integer> subList : allsubsets) {
				System.out.println(subList);
			}
		}
	}

	/**
	 * 
	 * auth:cjt
	 * date:2017年2月7日 下午3:31:58
	 * declaration:把所有的可能全部用进制表示，二进制中，只要是1的位，就把哪一位获取到
	 * 	    0(000)：{}
	
			1(001)：{a}
			
			2(010)：{b}
			
			3(011)：{ab}
			
			4(100)：{c}
			
			5(101)：{a,c}
			
			6(110)：{b,c}
			
			7(111)：{a,b,c}
	 */
	public static ArrayList<ArrayList<Integer>> getSubsets2(ArrayList<Integer> subList) {
		ArrayList<ArrayList<Integer>> allsubsets = new ArrayList<ArrayList<Integer>>();
		int max = 1 << subList.size();//将1 * 2 的size()倍，意思是有多少种情况
		for (int i = 0; i < max; i++) {
			int index = 0;
			//{a,b,c}
			int k = i;//k表示总共多少种可能的第多少种可能， 例如，K=5
			ArrayList<Integer> s = new ArrayList<Integer>();
			while (k > 0) {//只要二进制的位上数是1，就把它对应的获取到
				if ((k & 1) ==1 ) {   //判断k的最后一位是否为1
					s.add(subList.get(index));
				}
				k >>= 1; //将这个数向右移动一位，判断这个位是否为1，代表，最右边一位，已经获取过了
				index++;
			}
			allsubsets.add(s);
		}
		return allsubsets;
	}
}