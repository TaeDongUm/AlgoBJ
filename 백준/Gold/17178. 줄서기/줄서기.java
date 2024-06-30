import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        String[] TicketOrder = new String[N*5];
        String tmp="";
        for (int i = 0; i < N; i++) {
            tmp += br.readLine();
            tmp +=" ";
        }
        TicketOrder = tmp.split(" ");

        ItemSorted[] itemsorted = new ItemSorted[TicketOrder.length];
        for (int i = 0; i < TicketOrder.length; i++) {
            itemsorted[i] = new ItemSorted(i, TicketOrder[i]);
        }

        Arrays.sort(itemsorted, new Comparator<ItemSorted>() {
            @Override
            public int compare(ItemSorted o1, ItemSorted o2) {
                char alpha1 = o1.value.charAt(0);
                char alpha2 = o2.value.charAt(0);

                if (alpha1 != alpha2) {
                    return Character.compare(alpha1, alpha2);
                } else {
                    int num1 = Integer.parseInt(o1.value.substring(2));
                    int num2 = Integer.parseInt(o2.value.substring(2));
                    return Integer.compare(num1, num2);
                }
            }
        });

        int[] sortedIndices = new int[TicketOrder.length];
        for (int i = 0; i < itemsorted.length; i++) {
            sortedIndices[itemsorted[i].Index] = i;
        }
        

        int order = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < sortedIndices.length; i++) {
            while (!stack.isEmpty() && stack.peek() == order) {
                stack.pop();
                order++;
            }
            if (order == sortedIndices[i]) {
                order++;
            } else {
                stack.push(sortedIndices[i]);
            }
        }

        // 마지막 원소들을 처리
        while (!stack.isEmpty() && stack.peek() == order) {
            stack.pop();
            order++;
        }

        if (order == sortedIndices.length) {
            System.out.println("GOOD");
        } else {
            System.out.println("BAD");
        }
    }
}

class ItemSorted {
    int Index;
    String value;

    ItemSorted(int Index, String value) {
        this.Index = Index;
        this.value = value;
    }
}
