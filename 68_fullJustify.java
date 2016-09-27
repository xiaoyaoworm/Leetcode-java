public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<List<String>> res = new ArrayList<List<String>>();
        List<Integer> occupied = new ArrayList<Integer>();
        List<String> list = new ArrayList<String>();
        int num = 0;
        for (String word : words) {
            if (num == 0 && word.length() <= maxWidth) {
                list.add(word);
                num = word.length();
            } else if (num + word.length() + 1 <= maxWidth) {
                list.add(word);
                num += word.length() + 1;
            } else {
                res.add(list);
                occupied.add(num);
                list = new ArrayList<String>();
                if (word.length() <= maxWidth) {
                    list.add(word);
                    num = word.length();
                }
            }
        }
        res.add(list);
        occupied.add(num);

        return convert(res, occupied, maxWidth);
    }


    private List<String> convert(List<List<String>> list, List<Integer> occupied, int maxWidth) {
        List<String> res = new ArrayList<String>();
        StringBuffer sb = null;

        for (int i = 0; i < list.size() - 1; i++) {
            sb = new StringBuffer();

            List<String> current = list.get(i);
            int num = current.size();
            int extraSpace = maxWidth-occupied.get(i);
            int averageExtra = 0;
            int moreExtra = 0;
            if(num!=1){
                averageExtra = extraSpace/(num-1);
                moreExtra = extraSpace%(num-1);
            }


            sb.append(current.get(0));
            for (int j = 1; j < num; j++) {
                sb.append(" ");
                int k = 0;
                while (k < averageExtra) {
                    sb.append(" ");
                    k++;
                }
                if (moreExtra > 0) {
                    sb.append(" ");
                    moreExtra--;
                }
                sb.append(current.get(j));
            }
            while (sb.length() < maxWidth) {
                sb.append(" ");
            }
            res.add(sb.toString());
        }
        if (list.size() > 0) {
            List<String> lastLine = list.get(list.size() - 1);
            sb = new StringBuffer();
            for (String str : lastLine) {
                if (sb.length() != 0) sb.append(" ");
                sb.append(str);
            }
            while (sb.length() < maxWidth) {
                sb.append(" ");
            }
            res.add(sb.toString());
        }
        return res;
    }
}